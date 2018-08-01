/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syUnitPaymentQuery.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB88View;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentQuery.service.SyUnitPaymentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 单位缴费信息查询Controller
 * 
 * @author wh
 * @version 2017-06-14
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Controller
@RequestMapping(value = "${adminPath}/sybx/syUnitPaymentQuery/unit")
public class SyUnitPaymentQueryController extends BaseController {

	@Autowired
	private SyUnitPaymentQueryService syUnitPaymentQueryService;

	@RequestMapping(value = { "form", "" })
	public String form(PM_AB88View syab88, HttpServletRequest request, HttpServletResponse response, Model model) {

		model.addAttribute("syab88", syab88);

		return "modules/sybx/syUnitPaymentQuery/syUnitPaymentQueryList";
	}

	@RequestMapping(value = {"list"})
	public String list(PM_AB88View syab88,HttpServletRequest request, HttpServletResponse response, Model model) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BAE707",syab88.getBAE707());
        jsonObject.put("StartYM", request.getParameter("startYM"));
        jsonObject.put("EndYM", request.getParameter("endYM"));
        //正常应交记录
        jsonObject.put("AAE143", CodeConstant.AAE143_AAE143_1);
        //调用接口查询
        Page<PM_AB88View> page = syUnitPaymentQueryService.findPageList(new Page<PM_AB88View>(request, response), jsonObject);

        model.addAttribute("page", page);
        //????????
        model.addAttribute("syab88", syab88);

		return "modules/sybx/syUnitPaymentQuery/syUnitPaymentQueryList";
	}

	/**
	 * 导出用户数据
	 * 
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "export")
	public String exportFile(PM_AB88View syab88, HttpServletRequest request, HttpServletResponse response,
                             RedirectAttributes redirectAttributes) {
		try {

			/*List<PM_AB88View> resultList = (List<PM_AB88View>) request.getSession().getAttribute("infoList");*/
			String fileName = "单位缴费数据" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            JSONObject jsonObject = new JSONObject();
            // 区别铜川单位缴费查询所传标志
            jsonObject.put("BAB811", "1");
            jsonObject.put("BAE707",syab88.getBAE707());
            jsonObject.put("StartYM", request.getParameter("startYM"));
            jsonObject.put("EndYM", request.getParameter("endYM"));
            //正常应交记录
            jsonObject.put("AAE143", CodeConstant.AAE143_AAE143_1);
            //调用接口查询
            List<PM_AB88View> list = syUnitPaymentQueryService.findList( jsonObject);
            new ExportExcel("单位缴费数据", PM_AB88View.class).setDataList(list).write(response, fileName).dispose();
            return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出单位缴费数据失败！失败信息：" + e.getMessage());
		}
		return "modules/sybx/syUnitPaymentQuery/syUnitPaymentQueryList";

	}

}