package com.thinkgem.jeesite.modules.ylbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.ylbx.entity.YbPerson;
import com.thinkgem.jeesite.modules.ylbx.service.YbPersonInfoModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;
import java.util.List;

@Controller
@RequestMapping("${adminPath}/ylbx/ybPersonInfoModify")
public class YbPersonInfoModifyController extends BaseController {

    @Autowired
    private YbPersonInfoModifyService ybPersonInfoModifyService;

    /**
     * 展示人员信息页面
     */
    @RequestMapping(value = {"", "form"})
    public String form(Model model, YbPerson ybPerson) {
        model.addAttribute("ybPerson", ybPerson);
        return "modules/ylbx/ybPersonInfoModifyList";
    }

    /**
     * 查询人员信息
     */
    @RequestMapping("list")
    public String list(Model model, HttpServletRequest request, HttpServletResponse response, YbPerson ybPerson) {
        Page page = new Page(request, response);
        ybPerson.setBAC809(String.valueOf(page.getPageNo()));
        JSONObject json = null;
        try {
            json = ybPersonInfoModifyService.getPersonList(ybPerson);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (validateYbJSON(json, model, null)) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<YbPerson> ybPersons = JSONObject.parseArray(array.toString(), YbPerson.class);
            String counts = ((JSONObject) array.get(0)).getString("COUNTS");
            page = PostHelperUtils.getPage(page, ybPersons, counts, 20);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("ybPerson", ybPerson);
        return "modules/ylbx/ybPersonInfoModifyList";
    }

    /**
     * 人员基本信息修改页面
     */
    @RequestMapping("update")
    public String update(Model model, YbPerson ybPerson, HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = null;
        try {
            json = ybPersonInfoModifyService.getPersonList(ybPerson);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (validateYbJSON(json, model, null)) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<YbPerson> ybPersons = JSONObject.parseArray(array.toString(), YbPerson.class);
            model.addAttribute("ybPerson", ybPersons.get(0));
        } else {
            model.addAttribute("ybPerson", ybPerson);
        }
        return "modules/ylbx/ybPersonInfoModifyForm";
    }

    /**
     * 人员修改保存
     */
    @RequestMapping("save")
    public String save(Model model, YbPerson ybPerson) {
        JSONObject json = null;
        try {
            json = ybPersonInfoModifyService.save(ybPerson);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (validateYbJSON(json, model, "人员信息修改保存成功,请等待经办机构审核")) {
            return form(model, ybPerson);
        } else {
            model.addAttribute("ybPerson", ybPerson);
        }
        return "modules/ylbx/ybPersonInfoModifyForm";
    }

}
