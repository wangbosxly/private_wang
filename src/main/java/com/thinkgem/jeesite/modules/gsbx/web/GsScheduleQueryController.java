package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsScheduleQuery;
import com.thinkgem.jeesite.modules.gsbx.service.GsScheduleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;

/**
 * 描述:
 * 受理进度查询
 *
 * @author X_P
 * @create 2018-06-12 16:00
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsScheduleQuery")
public class GsScheduleQueryController extends BaseController {

    @Autowired
    private GsScheduleQueryService gsScheduleQueryService;

    @RequestMapping("form")
    public String form (Model model, GsScheduleQuery gsScheduleQuery) {
        model.addAttribute("gsScheduleQuery",gsScheduleQuery);
        return "/modules/gsbx/gsScheduleQueryList";
    }

    @RequestMapping("list")
    public String list(Model model, GsScheduleQuery gsScheduleQuery, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = null;
        try {
            json = gsScheduleQueryService.findSchedule(gsScheduleQuery);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,null)){
            Page page = getPage(json, request, response);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("gsScheduleQuery",gsScheduleQuery);
        return "/modules/gsbx/gsScheduleQueryList";
    }

    /**
     * 受理进度明细查询
     */
    @RequestMapping("queryDetails")
    public String queryDetails(Model model, GsScheduleQuery gsScheduleQuery, HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = null;
        try {
            json = gsScheduleQueryService.findScheduleDetails(gsScheduleQuery);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json, model,null)){
            Page page = getPage(json, request, response);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("gsScheduleQuery",gsScheduleQuery);
        return "/modules/gsbx/gsScheduleQueryForm";
    }

}