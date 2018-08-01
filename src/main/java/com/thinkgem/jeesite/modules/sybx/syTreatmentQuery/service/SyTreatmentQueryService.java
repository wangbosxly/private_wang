/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syTreatmentQuery.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.UneNwwsServicePort;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_JC02View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 人员信息管理Service
 * @author wh
 * @version 2017-06-14
 */
@Service
@Transactional(readOnly = true)
public class SyTreatmentQueryService {

	public Page<PM_JC02View> findPage(Page<PM_JC02View> page, PM_JC02View jc02View) {

		try {

			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();

			//jc02View.setBAC809(page.getPageNo()+ "");// 页数
			//模糊查询时的赋值
			List officeList = UserUtils.getOfficeList();
			Office office = (Office)officeList.get(0);
			User user =  UserUtils.getUser();

			UserView userView = new UserView();
			userView.setAAE170(user.getAae170());
			userView.setBAE702(CodeConstant.BAE702_BAE702_0);// BAE702_个人
			userView.setSSA004("1");
			userView.setBAA001(user.getBaa001());
//			userView.setSAA015(CodeConstant.SAA015_SAA015_M4009);//事功能id
//			userView.setSAA037(user.getLoginName());
//			userView.setSZZ003("");//赋值是什么
			
			
			jc02View.setAAC003(user.getAac003());//("'赵沙沙'")
			jc02View.setAAC002(user.getAac002());//("'610431198406091923'")
			jc02View.setBAA001(user.getBaa001());

			PM_JC02View[] pjc02View = new PM_JC02View[0];
			
			//发放记录信息查询NWWSSY2106
			pjc02View = port.nwwssy2105(userView, jc02View);
			

			
			// 返回后台数据
			List list = Arrays.asList(pjc02View);
			int countNum = 0;
			if (pjc02View.length > 0) {
				// 取得数据总数
				countNum = list.size();//Integer.parseInt(pjc02View[0].getAAC002_1());
			}
			page.setCount(countNum);
			page.setList(list);
			
			
		}catch (Exception e) {
				e.printStackTrace();
			}
		return page;

	}

}