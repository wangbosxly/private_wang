package com.thinkgem.jeesite.modules.sybx.syryxbdj.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.UneNwwsServicePort;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB01View;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.ParamView;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 失业人员续保登记服务
 * @description 
 * @since 20170614
 * @author njx
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class SyRyxbdjService {
	/**
	 * 查询单位信息

	 * @return
	 */
	public PM_AB01View find(JSONObject jsonObject)
	{

		try{
			JSONObject returnObj = new JSONObject();
			returnObj = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_BASICINFOQUERY, jsonObject.toJSONString());
			System.out.println("return="+returnObj);
			System.out.println("result["+returnObj.get("result").toString()+"]");

			PM_AB01View pm_ab01View = JSONObject.parseObject(returnObj.get("result").toString(),PM_AB01View.class);
			return pm_ab01View;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询单位信息

	 * @return
	 * @throws Exception
	 */
	public PM_AB01View mod(JSONObject jsonObject) throws Exception {
		PM_AB01View pmAB01View= find(jsonObject);
		if(pmAB01View!=null){
			return pmAB01View;
		}else{
			return null;
		}
	}
	
	/**
	 * 续保人员不分页查询
	 * @param pm_ac01view
	 * @param userView
	 * @return
	 */
	public List nwws2102_nopage(PM_AC01View pm_ac01view, UserView userView){
		UneNwwsServicePort port;
		List list = null;
		try {
			port = MedicalInterfaceUtils.getSyPort();
			pm_ac01view.setBAC809("1");// 页数
			PM_AC01View[] pac01ViewArray = port.nwwssy2102(userView, pm_ac01view);
			list = Arrays.asList(pac01ViewArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(list!=null){
			return list;
		}else{
			return null;
		}
	}

	public Page<PM_AC01View> nwws2102_page(Page<PM_AC01View> page, JSONObject jsonObject){
		try {
			List<PM_AC01View> list = new ArrayList<PM_AC01View>();
			JSONObject returnObj = new JSONObject();
			jsonObject.put("BAC809",page.getPageNo() + "");
			System.out.println(jsonObject);
			returnObj = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY, jsonObject.toJSONString());
			JSONArray jsonArray = PostHelperUtils.toParseJSONArray(returnObj);
			int countNum = 0;
			if(jsonArray.size()==0){
				return null;
			}
			for (Object aJsonArray : jsonArray) {
				PM_AC01View pm_ac01View = JSONObject.parseObject(((JSON) aJsonArray).toString(), PM_AC01View.class);
				countNum = Integer.parseInt(pm_ac01View.getAAC002_1());
				list.add(pm_ac01View);

			}

			page.setCount(countNum);
			page.setList(list);
			if(list!=null){
				return page;
			}
		} catch (Exception e) {
				e.printStackTrace();
			}
		return null;

	}


	/**
	 * 确认失业续保操作
	 */
	public JSONObject confirmSyXb(List paramList){
		String str = JSON.toJSONString(paramList);
		JSONObject josn = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_CONTINUE, str);
		return PostHelperUtils.toParseJSONObject(josn);
	}
	
	/**
	 * 参数校验
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public ParamView check(JSONObject jsonObject) throws Exception {
		ParamView param1View = this.findParam(jsonObject);
		if(param1View!=null){
			return param1View;
		}else{
			return null;
		}
	}	
	
	/**
	 * 获取参数vo
	 * jsonObject
	 * @return
	 */
	public static ParamView findParam(JSONObject jsonObject){
		ParamView pv = null;
		try {
			System.out.println("*******2.服务层SyRyxbdjService开始访问失业保险webservic地址.*******");
			//UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			System.out.println("*******3.服务层SyRyxbdjService访问失业保险webservic地址成功,开始调用nwwssy0002接口.*******");
			//pv = port.nwwssy0002(userView, paramView);
			JSONObject returnObj = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_QUERY_PARAMETER_INFO, jsonObject.toJSONString());
			pv = JSONObject.parseObject(((JSON) returnObj).toString(), ParamView.class);
			if(pv!=null){
				System.out.println("*******4.服务层SyRyxbdjService访问失业保险webservic地址成功,调用nwwssy0002接口成功,数据返回成功.*******");
				return pv;
			}else{
				System.out.println("*******5.服务层SyRyxbdjService访问失业保险webservic地址成功,调用nwwssy0002接口失败!!!没有数据返回.*******");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	  
		return null;
	  }
	
	/**
	 * version 1.0  功能可以实现，为了保持分层一致.暂时不用这个方法
	 * @param aae160
	 * @param cdate
	 * @param personInfoList
	 * @param aae140
	 * @param userView
	 * @param AAC012
	 * @param AAA040
	 * @param AAC040
	 * @throws IOException
	 */
/*	public void confimImport_Xb(String aae160, String cdate, ArrayList personInfoList, String aae140, UserView userView,String AAC012,String AAA040,String AAC040) throws IOException {
		//生成流水号
		GenerateSequenceUtil gsu = new GenerateSequenceUtil();
		String saa036 = "hz"+gsu.generateSequenceNo();// 受理单ID
//		String saa036 = IDUtility.getID("SAA036");// 受理单ID
		userView.setSAA036(saa036);// 受理单ID
		userView.setSAA038(CommonUtility.get19BitCurTimeAPP());// 申请时间
		userView.setSAA043(CodeConstant.SAA043_SAA043_3);// 业务状态

		// 处理前台数据向后台组织数据
		if (aae140.equals("3")) {
			aae140 = "3,5,7,9,10";
		}
		String date = DateUtils.format5.format(new Date());
		String month = date.substring(4,6); 
		String aae030 = "";
		if("12".equals(month)){
			aae030 = Integer.parseInt(date.substring(0,4))+1+"01";
		}else{
			aae030 = Integer.parseInt(date.substring(0,4))+"01";
		}
		PM_AC01View[] pram_ac02 = new PM_AC01View[personInfoList.size()];

		for (int j = 0; j < personInfoList.size(); j++) {
			//生成流水号
			GenerateSequenceUtil gsu_bae941 = new GenerateSequenceUtil();
			String BAE941 = "hz"+gsu_bae941.generateSequenceNo();// 受理单ID
//			String BAE941 = IDUtility.getID("BAE941");// 申报流水号pm_ac02
			PM_AC01View ac01View = new PM_AC01View();
			ac01View.setBAE941(BAE941);// 组织申报流水号pm_ac02
			ac01View.setAAB001(userView.getBAE703());// 单位编号

			ac01View.setAAC001(((PM_AC01View)personInfoList.get(j)).getAAC001());// 组织人员编号
			ac01View.setAAE160(aae160);// 组织暂停原因AC05
			ac01View.setBAC510(cdate);// 组织暂停时间-对应最近参保时间BAC510---AC02
			ac01View.setAAE035(cdate);// 组织暂停时间对应aae035变更时间AC05
			ac01View.setAAE140(aae140);// 组织险种
			ac01View.setAAC031(CodeConstant.AAC031_AAC031_1);// 组织参保状态为参保缴费
			ac01View.setAAC050(CodeConstant.AAC050_AAC050_12);// 组织变更类型为停保‘22’--‘12’为续保
			ac01View.setAAE102(CodeConstant.AAE102_AAE102_4);// 组织办理状态为办理完毕
			ac01View.setAAE003(CommonUtility.get6BitCurTimeAPP());// 对应费款所属期
			
			if (!(AAC012==null||AAC012.equalsIgnoreCase(""))) {
				ac01View.setAAC012(AAC012);
			}
			if (!(AAA040==null||AAA040.equalsIgnoreCase(""))) {
				ac01View.setAAA040(AAA040);
			}
			if (!(AAC040==null||AAC040.equalsIgnoreCase("")||AAC040=="0"||AAC040=="0.00")) {
				ac01View.setAAC040(AAC040);
			}
			ac01View.setAAE011(userView.getSAA037());// 经办人
			ac01View.setAAE036(CommonUtility.get19BitCurTimeAPP());// 经办人
			ac01View.setAAE030(aae030);//开始年月
			ac01View.setSAA036(saa036);// 组织受理单ID
			ac01View.setSAA015(userView.getSAA015());// 功能id
			ac01View.setTAA101(CommonUtility.get19BitCurTimeAPP());// ★申报时间
			ac01View.setTAA103("0");// 审核结果,0待审核,1审核通过,2审核不通过
			ac01View.setTAA105("1");// 申报来源,1网上大厅
			pram_ac02[j] = ac01View;
		}

		if (pram_ac02 != null && pram_ac02.length > 0) {
			// 调用后台接口				
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			port.nwwssy2703(userView, pram_ac02);
		}
	}*/	
}
