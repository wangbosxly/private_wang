package com.thinkgem.jeesite.modules.sybx.sysycbxx.service;

import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.UneNwwsServicePort;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 失业失业参保信息服务
 * @description 
 * @since 20170614
 * @author njx
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class SySycbxxService {
	/**
	 * 查询失业参保信息
	 * @param userView
	 * @param ac01View
	 * @return
	 */
	public List querySycbxxInfo(UserView userView, PM_AC01View ac01View ){
		UneNwwsServicePort port;
		List list = null;
		try {
			port = MedicalInterfaceUtils.getSyPort();
			PM_AC01View[] pac01View = new PM_AC01View[0];
			pac01View = port.nwwssy2102(userView, ac01View);
			// 返回后台数据
			list = Arrays.asList(pac01View);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(list !=null){
			return list;
		}else{
			return null;
		}
	}
}
