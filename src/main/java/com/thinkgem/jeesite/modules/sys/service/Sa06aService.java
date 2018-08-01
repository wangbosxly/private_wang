package com.thinkgem.jeesite.modules.sys.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.NwwsPort;


import lss.nw_ws.valueobject.SA06AView;
import lss.nw_ws.valueobject.UserView;

/**
 * 
 * @description sa06a表操作
 * @since 20170601
 * @author njx
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class Sa06aService {
	/**
	 * 保存sa06a
	 * @param userview
	 * @param sa06aView
	 */
	public void saveSa06aInfo(UserView  userview,SA06AView sa06aView){
		NwwsPort port;
		try {
			port = MedicalInterfaceUtils.getPort();
			port.nwws0301(userview,sa06aView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 更新sa06a
	 * @param userview
	 * @param sa06aView
	 */
	public void updateSa06aInfo(UserView  userview,SA06AView sa06aView){
		NwwsPort port;
		try {
			port = MedicalInterfaceUtils.getPort();
			port.nwws0302(userview,sa06aView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * 查询SA06a
	 * @param sa06aView
	 * @return
	 */
	public SA06AView querySa06aInfo(SA06AView sa06aView){
		SA06AView sa06aviewOut = null;
		List sa06aList = new ArrayList();
		SA06AView sa06aview[] = new SA06AView[0];
		NwwsPort port;
		try {
			port = MedicalInterfaceUtils.getPort();
			sa06aview = port.nwws0303(sa06aView);
			//调用公共服务接口
			if (sa06aview.length >=1) {
				//根据传入的SAA043、BAE703、SAA015 保证返回一条记录.
				sa06aList.add(sa06aview[0]);
			}
			if(sa06aList.size()>=1){
				sa06aviewOut = new SA06AView();
				sa06aviewOut = (SA06AView) sa06aList.get(0);
				return sa06aviewOut;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
