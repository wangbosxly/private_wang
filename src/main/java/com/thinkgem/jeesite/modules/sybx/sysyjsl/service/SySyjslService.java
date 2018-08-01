package com.thinkgem.jeesite.modules.sybx.sysyjsl.service;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.UneNwwsServicePort;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_JC02View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

//import lss.nw_ws.domain.dao.CommonUtility;

/**
 * 失业失业金申领服务
 * @description 
 * @since 20170614
 * @author njx
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class SySyjslService {
	public PM_JC02View searchInfo(PM_AC01View pm_ac01View){
			//失业金申领查询接口
            JSONObject jsonObject = PostHelperUtils.getJSONInfo(LoseJobConstants.MONEY_QUERY, JSONObject.toJSONString(pm_ac01View));
            jsonObject = PostHelperUtils.toParseJSONObject(jsonObject);
            //判断查询是否有数据结果
            if(PostHelperUtils.hasInfo(jsonObject)){
                //控制按钮
                jsonObject.put("AKB020","displayButton");
                //TODO 接口传回的值中没有缴费标志
                //jsonObject.put("AJA004", StaticCodeConvert.returnCodeName_AJA004(jsonObject.getString("AJA004")));
                //AAE011 作为临时显示标记，点击查询按钮后重新给AAE011赋值为displayDetailInfo，显示详细信息
                jsonObject.put("aAE011","displayDetailInfo");
                //不显示提示信息
                jsonObject.put("aAE018","noDisplayInfo");
            }else{
                //接口数据返回不正常
                jsonObject.put("aJA004",CodeConstant.EMPTY_EMPTY);
                //控制按钮
                jsonObject.put("aKB020","noDisplayButton");
                //AAE011 作为临时显示标记，点击查询按钮后重新给AAE011赋值为displayDetailInfo，显示详细信息
                jsonObject.put("aAE011","noDisplayDetailInfo");
                //查询没有结果显示提示信息
                jsonObject.put("aAE018","displayInfo");
            }
            /*pm_jc02view = port.nwwssy2901(userView, pm_ac01view);*/
        PM_JC02View pm_jc02View = JSONObject.toJavaObject(jsonObject, PM_JC02View.class);
        return pm_jc02View;
	}
	
	/**
	 * 登记确认方法
	 * @param userView
	 * @param pm_jc02view
	 */
	public void nwwssy2310(UserView userView, PM_JC02View pm_jc02view){
		// 调用后台接口
		UneNwwsServicePort port;
		try {
			System.out.println("******2.服务层SySyjslService开始获取失业保险webservice地址.******");
			port = MedicalInterfaceUtils.getSyPort();
			System.out.println("******3.服务层SySyjslService获取失业保险webservice地址成功,开始调用nwwssy2310保存数据接口.******");
			port.nwwssy2310(userView, pm_jc02view);
			System.out.println("******4.服务层SySyjslService调用nwwssy2310保存数据接口成功.请检查保存的数据.******");
		} catch (IOException e) {
			System.out.println("******5.服务层SySyjslService调用nwwssy2310接口失败，请检查.");		
			e.printStackTrace();
		}
	}	
}