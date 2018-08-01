package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonInfoModify;
import com.thinkgem.jeesite.modules.gsbx.service.GsPersonInfoModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 描述:
 * 人员基本信息修改控制器
 *
 * @author X_P
 * @create 2018-06-07 15:30
 */
@Controller
@RequestMapping("${adminPath}/gsbx/GsPersonInfoModify")
public class GsPersonInfoModifyController extends BaseController {

    @Autowired
    GsPersonInfoModifyService gsPersonInfoModifyService;

    /**
     * 展示人员信息页面
     * @param model
     * @param gsPersonInfoModify
     * @return
     */
    @RequestMapping(value = {"","form"})
    public String form(Model model, GsPersonInfoModify gsPersonInfoModify){
        model.addAttribute("gsPersonInfoModify", gsPersonInfoModify);
        return "modules/gsbx/gsPersonInfoModifyForm";
    }

    /**
     * 查询人员基本信息
     * @param model
     * @param gsPersonInfoModify
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, GsPersonInfoModify gsPersonInfoModify, HttpServletRequest request, HttpServletResponse response){
        //进行参数验证
        if (!beanValidator(model, gsPersonInfoModify)) {
            form(model, gsPersonInfoModify);
        }
        Page page = new Page (request, response);
        JSONObject json = null;
        try {
            json = gsPersonInfoModifyService.getPerson(gsPersonInfoModify,page);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,null)){
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsPersonInfoModify> gsPersonContinues = JSONObject.parseArray(array.toString(), GsPersonInfoModify.class);
            page = PostHelperUtils.getPage(page, gsPersonContinues, 20);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("gsPersonInfoModify", gsPersonInfoModify);
        return "modules/gsbx/gsPersonInfoModifyForm";
    }

    /**
     * 人员基本信息修改
     * @param model
     * @param gsPersonInfoModify
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("update")
    public String update(Model model,GsPersonInfoModify gsPersonInfoModify,
                         HttpServletRequest request, HttpServletResponse response){
        //查询人员参保信息
        Page page = new Page (request, response);
        JSONObject json = null;
        try {
            json = gsPersonInfoModifyService.getPerson(gsPersonInfoModify,page);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,null)) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            gsPersonInfoModify = JSONObject.parseObject(array.getJSONObject(0).toString(), GsPersonInfoModify.class);
            model.addAttribute("gsPersonInfoModify", gsPersonInfoModify);
        }
        return "modules/gsbx/gsPersonInfoModifyList";
    }

    /**
     * 人员修改保存
     * @param model
     * @param gsPersonInfoModify
     * @return
     */
    @RequestMapping("save")
    public String save(Model model,GsPersonInfoModify gsPersonInfoModify){
        JSONObject json = null;
        try {
            json = gsPersonInfoModifyService.savePersonInfo(gsPersonInfoModify);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,"人员基本信息变更成功")){
            form(model, gsPersonInfoModify);
        }else{
            model.addAttribute("gsPersonContinue", gsPersonInfoModify);
        }
        return "modules/gsbx/gsPersonInfoModifyForm";
    }
}