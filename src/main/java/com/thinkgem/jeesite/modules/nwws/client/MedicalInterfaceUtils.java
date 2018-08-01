package com.thinkgem.jeesite.modules.nwws.client;



import java.io.IOException;

import javax.xml.rpc.ServiceException;

import com.thinkgem.jeesite.modules.nwws.client.port.*;


/**
 * 字典项工具类
 * 
 * @author xp
 * @version 2015-5-19
 */
public class MedicalInterfaceUtils {


	public static NwwsPort getPort() throws IOException {
		NwwsLocator service = new NwwsLocator();
		NwwsPort port = null;
		try {
			port = service.getnwwsPort();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return port;
	}

	/**
	 * 医疗保险 *********************调用接口公用方法
	 * @author njx
	 * @version 2017-06-16
	 */
	public static UneNwwsServicePort getSyPort() throws IOException {
		UneNwwsServiceLocator sy_service = new UneNwwsServiceLocator();
		UneNwwsServicePort sy_port = null;
		try {
			sy_port = sy_service.getUneNwwsServicePort();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return sy_port;
	}

	/**
	 * 社保卡 *********************调用接口公用方法
	 * @author njx
	 * @version 2017-08-26
	 */
	public static SSCWEB12333Port getSbkPort() throws IOException {
		SSCWEB12333Locator sbk_service = new SSCWEB12333Locator();
		SSCWEB12333Port sbk_port = null;
		try {
			sbk_port = sbk_service.getSSCWEB12333Port();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return sbk_port;
	}	
}