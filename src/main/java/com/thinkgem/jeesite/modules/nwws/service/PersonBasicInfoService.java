/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.nwws.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;


import lss.nw_ws.valueobject.AB02View;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.nwws.entity.PersonBasicInfo;
import lss.nw_ws.valueobject.PM_AC01View;
import lss.nw_ws.valueobject.UserView;
import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.NwwsPort;

/**
 * 社保人员基本信息管理Service
 * @author xp
 * @version 2016-10-14
 */
@Service
@Transactional(readOnly = true)
public class PersonBasicInfoService {

	public PM_AC01View get(String id) {
		return null;
	}
	
	public List<PM_AC01View> findList(PM_AC01View pm_ac01View) {
		return null;
	}
	
	public Page<PM_AC01View> findPage(Page<PM_AC01View> page, PM_AC01View pm_ac01View) {
		try {
			NwwsPort port = MedicalInterfaceUtils.getPort();
			PM_AC01View ac01View = new PM_AC01View();
			User user = UserUtils.getUser();
			ac01View.setAAB001(user.getCompany().getId());
			ac01View.setAAE140("3");//加入险种
			ac01View.setBAC809(page.getPageNo()+ "");// 页数
			ac01View.setAAC031("1");// 正常参保
			UserView userView = new UserView();
			PM_AC01View[] pac01View = new PM_AC01View[0];
			pac01View = port.nwws2102(userView, ac01View);
			// 返回后台数据
			List list = Arrays.asList(pac01View);
			int countNum = 0;
			if (pac01View.length > 0) {
				// 取得数据总数
				countNum = Integer.parseInt(pac01View[0].getAAC002_1());
			}
			page.setList(list);
			page.setCount(countNum);
		}catch (Exception e) {
				e.printStackTrace();
			}
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(PM_AC01View pm_ac01View) {

	}
	
	@Transactional(readOnly = false)
	public void delete(PM_AC01View pm_ac01View) {

	}
	
}