package com.thinkgem.jeesite.modules.sybx.syrytbdj.service;

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
import java.util.List;

/**
 * 失业人员停保登记服务
 * @description
 * @since 20180327
 * @author svnlei
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class SyRytbdjService {

	/**
	 * 查询单位信息
	 */
	public JSONObject find(JSONObject jsonObject){
		jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_BASICINFOQUERY,jsonObject.toJSONString());
		try {
			jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
			return jsonObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 停保人员分页查询
	 */
	public Page<PM_AC01View> findPage(Page<PM_AC01View> page, JSONObject jsonObject){
		JSONObject json = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_INFO_QUERY,jsonObject.toString());
		try {
			JSONObject jsonObj = PostHelperUtils.toParseJSONObject(json);
			JSONArray jsonArray;
			//避免接口调用成功时  数据为空导致页面提醒联系管理员
			if (PostHelperUtils.hasInfo(jsonObj)) {
				jsonArray = JSONArray.parseArray(jsonObj.getString("LIST"));
				List<PM_AC01View> list = JSONObject.parseArray(jsonArray.toString(), PM_AC01View.class);
				if (list.size() > 0) {
					page.setCount(Integer.parseInt(list.get(0).getAAC002_1()));
				} else {
					page.setCount(0);
				}
				page.setList(list);
			}
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 查询单位信息
	 * @param userView
	 * @param ab01View
	 * @return
	 */
	public PM_AB01View find(UserView userView , PM_AB01View ab01View)
	{	  	
		try {
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			return port.nwwssy1101(userView, ab01View);				
		} catch (Exception e) {
			e.printStackTrace();
		}	  
		return null;
	}
	
	/**
	 * 查询单位信息
	 * @param userView
	 * @param pm_ab01View
	 * @return
	 * @throws Exception
	 */
	public PM_AB01View mod(UserView userView, PM_AB01View pm_ab01View){
		PM_AB01View pmAB01View= find(userView, pm_ab01View);
		if(pmAB01View!=null){
			return pmAB01View;
		}else{
			return null;
		}
	}
	
	/**
	 * 确认失业停操作
	 */
	public JSONObject confirmSyTb(String json) {
		JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_PERSON_INSURED_STOP, json);
		return PostHelperUtils.toParseJSONObject(jsonObject);
	}

	/**
	 * 确认失业停操作
	 */
	public void confirmSyTb(UserView userView, PM_AC01View[] ac01ViewArrayy){
		try {
			System.out.println("******2.服务层SyRytbdjService开始获取失业保险webservice地址.******");
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			System.out.println("******3.服务层SyRytbdjService获取失业保险webservice地址成功,开始调用nwwssy2702保存数据接口.******");
			port.nwwssy2702(userView, ac01ViewArrayy);
			System.out.println("******4.服务层SyRytbdjService调用nwwssy2702保存数据接口成功.请检查保存的数据.******");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("******5.服务层SyRytbdjService调用nwwssy2702接口失败，请检查.");
		}
	}
	
	/**
	 * 参数校验
	 * @param userView
	 * @param paramView
	 * @return
	 * @throws Exception
	 */
	public ParamView check(UserView userView, ParamView paramView) throws Exception {
		ParamView param1View = this.find(userView, paramView);
		if(param1View!=null){
			return param1View;
		}else{
			return null;
		}
	}	
	
	/**
	 * 获取参数vo
	 * @param userView
	 * @param paramView
	 * @return
	 */
	public static ParamView find(UserView userView , ParamView paramView){
		ParamView pv = null;
		try {
			System.out.println("*******2.服务层SyRytbdjService开始访问失业保险webservic地址.*******");
			UneNwwsServicePort port = MedicalInterfaceUtils.getSyPort();
			System.out.println("*******3.服务层SyRytbdjService访问失业保险webservic地址成功,开始调用nwwssy0002接口.*******");
			pv = port.nwwssy0002(userView, paramView);
			if(pv!=null){
				System.out.println("*******4.服务层SyRytbdjService访问失业保险webservic地址成功,调用nwwssy0002接口成功,数据返回成功.*******");
				return pv;
			}else{
				System.out.println("*******5.服务层SyRytbdjService访问失业保险webservic地址成功,调用nwwssy0002接口失败!!!没有数据返回.*******");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	  
		return null;
	  }	
}
