/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syTreatmentQuery.web;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_JC02View;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_TreatmentExportExcel;
import com.thinkgem.jeesite.modules.sybx.syTreatmentQuery.service.SyTreatmentQueryService;
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
 * 失业待遇查询Controller
 * @author wh
 * @version 2017-06-14
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syTreatmentQuery/person")
public class SyTreatmentQueryController extends BaseController {

	@Autowired
	private SyTreatmentQueryService syTreatmentQueryService;

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
		
		syjc02.setBAA001(user.getBaa001());
		
		model.addAttribute("syjc02", syjc02);
		
		return "modules/sybx/syTreatmentQuery/syTreatmentQuery";
	}

	@RequestMapping(value = {"list", ""})
	public String list(PM_JC02View syjc02, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		String aab001 = user.getCompany().getId();
		String aab004 = user.getCompany().getName();

		syjc02.setAAC002(user.getAac002());
		syjc02.setAAC003(user.getAac003());//姓名
		syjc02.setBAA001(user.getBaa001());
		
		Page<PM_JC02View> page = syTreatmentQueryService.findPage(new Page<PM_JC02View>(request, response), syjc02);
		
		//获取登录用户信息，自动赋给查询条件
		syjc02.setAAC002(user.getNo());//身份证号
		syjc02.setAAC003(user.getName());//姓名
		
		model.addAttribute("page", page);
		model.addAttribute("syjc02", syjc02);
		
		return "modules/sybx/syTreatmentQuery/syTreatmentQueryList";
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
            String fileName = "失业待遇数据"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<PM_JC02View> page = syTreatmentQueryService.findPage(new Page<PM_JC02View>(request, response, -1), user);
    		new ExportExcel("失业待遇数据", PM_TreatmentExportExcel.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出失业待遇数据失败！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath + "/sybx/syTreatmentQuery/person/list?repage";
    }

	
	
}