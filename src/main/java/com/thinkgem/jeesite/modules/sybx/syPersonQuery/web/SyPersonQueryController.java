/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syPersonQuery.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.sybx.syPersonQuery.entity.SyPersonQuery;
import com.thinkgem.jeesite.modules.sybx.syPersonQuery.service.SyPersonQueryService;
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
import java.util.List;

/**
 * 人员信息查询列表Controller
 * @author wh
 * @version 2017-06-14
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syPersonQuery/syac01")
public class SyPersonQueryController extends BaseController {

	@Autowired
	private SyPersonQueryService syPersonQueryService;

	@RequestMapping(value = {"form", ""})
	public String form(PM_AC01View syac01, Model model) {

		User user = UserUtils.getUser();
		String aab001 = user.getCompany().getId();
		syac01.setAAB001(aab001);
		syac01.setBAA001(user.getBaa001());
		syac01.setAAE140(CodeConstant.AAE140_AAE140_2);
		
		model.addAttribute("syac01", syac01);
		
		return "modules/sybx/syPersonQuery/syPersonQueryList";
	}
	
//	@RequiresPermissions("syperson:SyPersonQuery:edit")

    /**
     * 根据姓名，身份证号，个人编号查询参保信息
     * @param syac01
     * @param request
     * @param response
     * @param model
     * @return
     */
	@RequestMapping(value = {"list", ""})
	public String list(PM_AC01View syac01, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
        Page<PM_AC01View> page = new Page<>(request, response);
        syac01.setAAB001(user.getAab001());
		syac01.setBAA001(user.getBaa001());
		//TODO 此处被核心接口坑，AAC002_1一个值有三种变化。
		long count = 0;
        JSONObject json = (JSONObject) JSONObject.toJSON(syac01);
        //由于接口的原因姓名，身份证号，个人编号必须多加‘’才能正确使用，真是个大坑。
        if(StringUtils.isNotEmpty(syac01.getAAC003())){
            json.put("aAC003", "'" + syac01.getAAC003() + "'");
            count = 20;
        }
        if(StringUtils.isNotEmpty(syac01.getAAC002())){
            json.put("aAC002", "'" + syac01.getAAC002() + "'");
            count = 1;
        }
        if(StringUtils.isNotEmpty(syac01.getAAC001())){
            json.put("aAC001", "'" + syac01.getAAC001() + "'");
            count = 1;
        }

        json.put("AAE170", user.getAae170());
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //每页数据量
        json.put("BAC808","20");
        //页码
        json.put("BAC809",page.getPageNo());
		page = syPersonQueryService.findPage(page, json);
        if(count==0){
            count = page.getCount();
        }
        model.addAttribute("page", page);
        //获取总条数，保存在session中，方便打印时获取总条数
        request.getSession().setAttribute("count",count);
        model.addAttribute("syac01", syac01);
		return "modules/sybx/syPersonQuery/syPersonQueryList";
	}

	/**
	 * 导出用户数据
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
    @RequestMapping(value = "export", method= RequestMethod.POST)
    public String exportFile(PM_AC01View syac01, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "参保人员数据"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            User user = UserUtils.getUser();
            syac01.setAAB001(user.getAab001());
            syac01.setBAA001(user.getBaa001());
            JSONObject json = (JSONObject) JSONObject.toJSON(syac01);
            json.put("AAE170", user.getAae170());
            json.put("AAE140", CodeConstant.AAE140_AAE140_2);
            if(StringUtils.isNotEmpty(syac01.getAAC003())){
                json.put("aAC003", "'" + syac01.getAAC003() + "'");
            }
            if(StringUtils.isNotEmpty(syac01.getAAC002())){
                json.put("aAC002", "'" + syac01.getAAC002() + "'");
            }
            if(StringUtils.isNotEmpty(syac01.getAAC001())){
                json.put("aAC001", "'" + syac01.getAAC001() + "'");
            }
            //每页数据量,从session中获取总数
            json.put("BAC808",request.getSession().getAttribute("count"));
            //页码
            json.put("BAC809","1");
            List<SyPersonQuery> list = syPersonQueryService.getExportList(json);
    		new ExportExcel("参保人员数据", SyPersonQuery.class).setDataList(list).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出参保人员数据失败！失败信息："+e.getMessage());
		}
		return "modules/sybx/syPersonQuery/syPersonQueryList";
//		return "redirect:" + adminPath + "/sybx/SyPersonQuery/syac01/list?repage";
    }

	
	
}