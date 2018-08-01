/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.nwws.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lss.nw_ws.valueobject.PM_AC01View;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.entity.PersonBasicInfo;
import com.thinkgem.jeesite.modules.nwws.service.PersonBasicInfoService;

/**
 * 社保人员基本信息管理Controller
 * 
 * @author xp
 * @version 2016-10-14
 */
@Controller
@RequestMapping(value = "${adminPath}/nwws/personBasicInfo")
public class PersonBasicInfoController extends BaseController {

	@Autowired
	private PersonBasicInfoService personBasicInfoService;

	@ModelAttribute
	public PM_AC01View get(@RequestParam(required = false) String id) {
		PM_AC01View entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = personBasicInfoService.get(id);
		}
		if (entity == null) {
			entity = new PM_AC01View();
		}
		return entity;
	}

	@RequiresPermissions("nwws:personBasicInfo:edit")
	@RequestMapping(value = { "list", "" })
	public String list(PM_AC01View pm_ac01View,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<PM_AC01View> page = personBasicInfoService.findPage(
				new Page<PM_AC01View>(request, response), pm_ac01View);
		model.addAttribute("page", page);
		return "modules/nwws/personBasicInfoList";
	}
	
	@RequiresPermissions("nwws:personBasicInfo:edit")
	@RequestMapping(value = "form")
	public String form(PM_AC01View pm_ac01View, Model model) {
		model.addAttribute("pm_ac01View", pm_ac01View);
		return "modules/nwws/personBasicInfoForm";
	}

	@RequiresPermissions("nwws:personBasicInfo:edit")
	@RequestMapping(value = "save")
	public String save(PM_AC01View pm_ac01View, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {
		if (!beanValidator(model, pm_ac01View)){
			return form(pm_ac01View, model);
		}
		// 返回后台数据
		personBasicInfoService.save(pm_ac01View);
		addMessage(redirectAttributes, "保存人员基本信息成功");
		return "redirect:" + Global.getAdminPath() + "/nwws/personBasicInfo/?repage";
	}

	@RequiresPermissions("nwws:personBasicInfo:edit")
	@RequestMapping(value = { "wage"})
	public String wage(PM_AC01View pm_ac01View,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<PM_AC01View> page = personBasicInfoService.findPage(
				new Page<PM_AC01View>(request, response), pm_ac01View);
		model.addAttribute("page", page);
		model.addAttribute("aae140List", CommonUtility.getAAE140());
		return "modules/nwws/personWageList";
	}
}