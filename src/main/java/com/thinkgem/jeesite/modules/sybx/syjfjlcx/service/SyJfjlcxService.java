package com.thinkgem.jeesite.modules.sybx.syjfjlcx.service;

import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.UneNwwsServicePort;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC88View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 失业缴费记录查询服务
 * @description 
 * @since 20170619
 * @author njx
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class SyJfjlcxService {
	public List quertJfjlcx(UserView userView, PM_AC88View pm_ac88view){
		List list = null;
		UneNwwsServicePort port;
		try {
			port = MedicalInterfaceUtils.getSyPort();
			PM_AC88View[] pm_AC88View = new PM_AC88View[0];
			//调用接口
			pm_AC88View = port.nwwssy2104(userView,pm_ac88view);
			list = Arrays.asList(pm_AC88View);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(list!=null){
			return list;
		}else{
			return null;
		}
	}
}
