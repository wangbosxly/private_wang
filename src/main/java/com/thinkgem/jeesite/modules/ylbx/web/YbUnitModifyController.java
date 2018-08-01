package com.thinkgem.jeesite.modules.ylbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.ylbx.entity.YbUnit;
import com.thinkgem.jeesite.modules.ylbx.service.YbUnitModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.RemoteException;

/**
 * 描述:
 * 单位基本信息修改
 *
 * @author sl_su
 */
@Controller
@RequestMapping("${adminPath}/ylbx/ybUnitModify")
public class YbUnitModifyController extends BaseController {

    @Autowired
    private YbUnitModifyService ybUnitModifyService;

    /**
     * 查询单位基本信息，并展示在页面。
     * @param model
     * @return
     */
    @RequestMapping("form")
    public String form(Model model, YbUnit ybUnit){
        JSONObject jsonObject = null;
        try {
            jsonObject = ybUnitModifyService.queryUnitInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateYbJSON(jsonObject,model,null)){
            JSONArray array = PostHelperUtils.toJSONArray(jsonObject, "RETLIST");
            JSONObject json = array.getJSONObject(0);
            ybUnit = JSONObject.parseObject(json.toString(), YbUnit.class);
        }
        model.addAttribute("ybUnit", ybUnit);
        return "/modules/ylbx/ybUnitModifyForm";
    }

    /**
     * 查询单位信息变更 保存
     */
    @RequestMapping("save")
    public String save(Model model, YbUnit ybUnit) {
        JSONObject jsonObject = null;
        try {
            jsonObject = ybUnitModifyService.updateUnitInfo(ybUnit);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.validateYbJSON(jsonObject,model,"单位基本信息修改成功");
        model.addAttribute("ybUnit", ybUnit);
        return "/modules/ylbx/ybUnitModifyForm";
    }
}
