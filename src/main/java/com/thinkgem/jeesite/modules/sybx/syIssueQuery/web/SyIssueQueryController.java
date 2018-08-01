/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syIssueQuery.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_IssueExportExcel;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_JC02View;
import com.thinkgem.jeesite.modules.sybx.syIssueQuery.service.SyIssueQueryService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 发放记录查询Controller
 * @author wh
 * @version 2017-06-14
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syIssueQuery/person")
public class SyIssueQueryController extends BaseController {

	@Autowired
	private SyIssueQueryService syIssueQueryService;

	@RequestMapping(value = {"form", ""})
	public String form(PM_JC02View syjc02, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		String aab001 = user.getCompany().getId();
		String aab004 = user.getCompany().getName();

		syjc02.setAAC002(user.getAac002());
		syjc02.setAAC003(user.getAac003());//姓名
		
		//获取登录用户信息，自动赋给查询条件
		syjc02.setAAC002(user.getNo());//身份证号
		syjc02.setAAC003(user.getName());//姓名
		
		model.addAttribute("syjc02", syjc02);
		
		return "modules/sybx/syIssueQuery/syIssueQuery";
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(PM_JC02View syjc02, HttpServletRequest request, HttpServletResponse response, Model model) {

		//获取单位编号
//		List officeList = UserUtils.getOfficeList();
//		Office office = (Office)officeList.get(0);
//		syac01.setAab001(office.getCode());
		
		User user = UserUtils.getUser();
		String aab001 = user.getCompany().getId();
		String aab004 = user.getCompany().getName();

		syjc02.setAAC002(user.getAac002());
		syjc02.setAAC003(user.getAac003());//姓名
//		syjc02.setBAA001("610399");
		
		
		
		Page<PM_JC02View> page = syIssueQueryService.findPage(new Page<PM_JC02View>(request, response), syjc02);
		//获取登录用户信息，自动赋给查询条件
		syjc02.setAAC002(user.getNo());//身份证号
		syjc02.setAAC003(user.getName());//姓名
		
		model.addAttribute("page", page);
		model.addAttribute("syjc02", syjc02);
		
		return "modules/sybx/syIssueQuery/syIssueQueryList";
	}

	/**
	 * 导出用户数据
	 * @param user
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
    @RequestMapping(value = "export", method= RequestMethod.POST)
    public String exportFile(PM_JC02View user, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "发放记录数据"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<PM_JC02View> page = syIssueQueryService.findPage(new Page<PM_JC02View>(request, response, -1), user);
    		new ExportExcel("发放记录数据", PM_IssueExportExcel.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出发放记录数据失败！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath + "/sybx/syIssueQuery/person/list?repage";
    }

	
	
}