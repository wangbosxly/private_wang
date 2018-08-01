package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsUnitModify;
import com.thinkgem.jeesite.modules.gsbx.service.GsUnitModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.rmi.RemoteException;

/**
 * 描述:
 * 单位基本信息修改
 *
 * @author X_P
 * @create 2018-06-11 10:50
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsUnitModify")
public class GsUnitModifyController extends BaseController{


    @Autowired
    private GsUnitModifyService gsUnitModifyService;

    @ModelAttribute("gsUnitModify")
    public GsUnitModify get(@RequestParam(required=false) String id) {
        JSONObject jsonObject = null;
        try {
            jsonObject = gsUnitModifyService.queryUnitInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(jsonObject!=null&&"0".equals(jsonObject.getString("code"))) {
            JSONArray array = PostHelperUtils.toJSONArray(jsonObject, "RETLIST");
            JSONObject json = array.getJSONObject(0);
            return JSONObject.parseObject(json.toString(), GsUnitModify.class);
        }else {
            return new GsUnitModify();
        }
    }
    /**
     * 查询单位基本信息，并展示在页面。
     * @param model
     * @return
     */
    @RequestMapping("form")
    public String form(Model model, HttpServletRequest request){
        JSONObject jsonObject = null;
        try {
            jsonObject = gsUnitModifyService.queryUnitInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(jsonObject,model,null)){
            JSONArray array = PostHelperUtils.toJSONArray(jsonObject, "RETLIST");
            JSONObject json = array.getJSONObject(0);
            GsUnitModify gsUnitModify = JSONObject.parseObject(json.toString(), GsUnitModify.class);
            request.getSession().setAttribute("gsUnitModify",gsUnitModify);
            model.addAttribute("gsUnitModify", gsUnitModify);
        }
        return "/modules/gsbx/gsUnitModifyForm";
    }

    @RequestMapping("save")
    public String save(Model model,GsUnitModify gsUnitModify,HttpServletRequest request){
        GsUnitModify gs = (GsUnitModify) request.getSession().getAttribute("gsUnitModify");
        JSONObject jsonObject = null;
        try {
            jsonObject = gsUnitModifyService.updateUnitInfo(gsUnitModify);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.validateGsJSON(jsonObject, model, "单位基本信息修改成功");
        return "/modules/gsbx/gsUnitModifyForm";
    }
}