/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.sySalaryUpdate.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.UneNwwsServicePort;
import com.thinkgem.jeesite.modules.nwws.page.Pagination;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 缴费基数申报Service
 * 
 * @author wh
 * @version 2017-06-14
 */
@Service
@Transactional(readOnly = true)
@SuppressWarnings( { "unchecked", "rawtypes" })
public class SyAc04Service {

	public Pagination getPage(PM_AC01View ac01view, int pageNo, int pageSize, UserView userView) throws IOException {

		UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
		ac01view.setBAC809(pageNo + "");// 页数
		PM_AC01View[] pac01ViewArray = port.nwwssy2103(userView, ac01view);
		List list = Arrays.asList(pac01ViewArray);
		int countNum = 0;
		if (pac01ViewArray.length > 0) {
			// 取得数据总数
			countNum = Integer.parseInt(pac01ViewArray[0].getAAC002_1());
		}
		Pagination p = new Pagination(pageNo, pageSize, countNum);
		p.setList(pageNo, pageSize, list);
		return p;
	}
	
	/**
	 * 获取人员缴费基数列表
	 * @param page
	 * @param ac01View
	 * @return
	 */
	public Page<PM_AC01View> findPage(Page<PM_AC01View> page, PM_AC01View ac01View) {

		try {
			User user = UserUtils.getUser();
			String aab001 = user.getCompany().getId();
			String aab004 = user.getCompany().getName();
			
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			UserView userView = new UserView();

			userView.setAAE170(user.getAae170());
			userView.setAAB001(aab001);
			userView.setBAA001(user.getBaa001());

			PM_AC01View[] pac01View = new PM_AC01View[0];

			// 职工人员参保信息查询
			pac01View = port.nwwssy2103(userView, ac01View);
			// 返回后台数据
			List list = Arrays.asList(pac01View);
			int countNum = 0;
			if (pac01View.length > 0) {
				// 取得数据总数
				countNum = Integer.parseInt(pac01View[0].getAAC002_1());
			}

			page.setCount(countNum);
			page.setList(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * 保存工资申报信息
	 * 
	 * @param userView
	 * @param ac01ViewArray
	 * @return
	 */
	@Transactional(readOnly = false)
	public String saveInfo(UserView userView, PM_AC01View[] ac01ViewArray) {

		try {
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();

			port.nwwssy2302(userView, ac01ViewArray);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return "0";
		}

		return "1";
	}
	
	public String importExcel(UserView userView, ArrayList personInfoList, String sza024) throws IOException {
		
		// 生成流水号
		String saa036 = CommonUtility.getSAA036();
		String bae941 = CommonUtility.getBAE941();//申报流水号
		
		userView.setSAA036(saa036);// 受理单ID
		
		String date = CommonUtility.get6BitCurTimeAPP();
		String month = date.substring(4,6); 
		String aae030 = "";
		if("12".equals(month)){
			aae030 = Integer.parseInt(date.substring(0,4))+1+"01";
		}else{
			aae030 = Integer.parseInt(date.substring(0,4))+"01";
		}
		PM_AC01View[] pm_ac04 = new PM_AC01View[personInfoList.size()];

		for (int j = 0; j < personInfoList.size(); j++) {
			PM_AC01View parm = (PM_AC01View)personInfoList.get(j);
			PM_AC01View ac01View = new PM_AC01View();
			ac01View.setBAE941(bae941);
			ac01View.setAAC001(parm.getAAC001());
			ac01View.setAAC040(parm.getAAC040());
			ac01View.setAAE003(date);
			ac01View.setSAA036(userView.getSAA036());
			ac01View.setSAA015(userView.getSAA015());
			ac01View.setTAA101(date);
			ac01View.setBAA008("3");
			ac01View.setTAA103("0");// 审核结果,0待审核,1审核通过,2审核不通过
			ac01View.setTAA105("1");// 申报来源,1网上大厅
			ac01View.setAAE140(CodeConstant.AAE140_AAE140_2);
			ac01View.setTAE100("3");
			ac01View.setAAE030(aae030);
			ac01View.setAAE011(userView.getSAA037());// 经办人
			ac01View.setAAE036(userView.getSAA038());// 经办时间
			pm_ac04[j] = ac01View;
		}

		if (pm_ac04 != null && pm_ac04.length > 0) {
			try {
				// 调用后台接口
				UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
				port.nwwssy2302(userView, pm_ac04);
			} catch (RemoteException e) {
				e.printStackTrace();
				return "0";
			}

		}
		return "1";
	}

}