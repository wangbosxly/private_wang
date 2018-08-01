package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonContinue;
import com.thinkgem.jeesite.modules.gsbx.service.GsPersonContinueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 描述:
 * 人员参保信息查询
 *
 * @author X_P
 * @create 2018-06-19 16:06
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsPersonInsuredQuery")
public class GsPersonInsuredQueryController extends BaseController{

    @Autowired
    private GsPersonContinueService gsPersonContinueService;

    @RequestMapping(value = {"form",""})
    public String form(GsPersonContinue gsPersonContinue, Model model){
        model.addAttribute("person", gsPersonContinue);
        return "/modules/gsbx/gsPersonInsuredQueryForm";
    }

    @RequestMapping("list")
    public String list(Model model, GsPersonContinue gsPersonContinue, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = null;
        Page page = new Page (request, response);
        try {
            json =  gsPersonContinueService.findUnitPersonInfo(gsPersonContinue,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,null)){
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsPersonContinue> gsPersonContinues = JSONObject.parseArray(array.toString(), GsPersonContinue.class);
            String countNum = gsPersonContinues.get(0).getCountNum();
            request.getSession().setAttribute("CountNum",countNum);
            page = PostHelperUtils.getPage(page, gsPersonContinues,array.getJSONObject(0).getString("countNum"), 20);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("person", gsPersonContinue);
        return "/modules/gsbx/gsPersonInsuredQueryForm";
    }

    /**
     * 下载表格
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("export")
    public JSONObject download(GsPersonContinue gsPersonContinue, HttpServletRequest request, HttpServletResponse response){
        int countNum = Integer.parseInt((String) request.getSession().getAttribute("CountNum"));
        JSONObject json = null;
        Page page = new Page (request, response);
        page.setPageSize(countNum);
        try {
            json = gsPersonContinueService.findUnitPersonInfo(gsPersonContinue, page);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        String fileName = DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
        try {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsPersonContinue> gsPersonContinues = JSONObject.parseArray(array.toString(), GsPersonContinue.class);
            new ExportExcel("人员参保信息", GsPersonContinue.class).setDataList(gsPersonContinues).write(response, fileName).dispose();
        } catch (IOException e) {
            e.printStackTrace();
            json.put("code", "-1");
        }
        json.put("code", "0");
        return null;
    }
}