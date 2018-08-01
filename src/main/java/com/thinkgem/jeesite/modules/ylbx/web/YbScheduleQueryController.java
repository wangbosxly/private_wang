package com.thinkgem.jeesite.modules.ylbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.ylbx.entity.YbScheduleQuery;
import com.thinkgem.jeesite.modules.ylbx.service.YbScheduleQueryService;
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
@RequestMapping("${adminPath}/ylbx/ylScheduleQuery")
public class YbScheduleQueryController extends BaseController {

    @Autowired
    private YbScheduleQueryService ybScheduleQueryService;

    @RequestMapping(value={"form",""})
    public String form (Model model, YbScheduleQuery ybScheduleQuery) {
        model.addAttribute("ybScheduleQuery",ybScheduleQuery);
        return "/modules/ylbx/ybScheduleQueryList";
    }

    @RequestMapping("list")
    public String list(Model model, YbScheduleQuery ybScheduleQuery, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = null;
        Page page = new Page(request, response);
        ybScheduleQuery.setSAA018(String.valueOf(page.getPageSize()));
        ybScheduleQuery.setSAA024(String.valueOf(page.getPageNo()));
        try {
            json = ybScheduleQueryService.findSchedule(ybScheduleQuery);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateYbJSON(json,model,null)){
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            String counts = array.getJSONObject(0).getString("COUNTS");
            page = PostHelperUtils.getPage(page, array, counts, 20);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("ybScheduleQuery",ybScheduleQuery);
        return "/modules/ylbx/ybScheduleQueryList";
    }

    /**
     * 受理进度明细查询
     */
    @RequestMapping("queryDetails")
    public String queryDetails(Model model, YbScheduleQuery ybScheduleQuery, HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = null;
        try {
            json = ybScheduleQueryService.findScheduleDetails(ybScheduleQuery);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateYbJSON(json, model,null)){
            Page page = getPage(json, request, response);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("ybScheduleQuery",ybScheduleQuery);
        return "/modules/ylbx/ybScheduleQueryForm";
    }

}