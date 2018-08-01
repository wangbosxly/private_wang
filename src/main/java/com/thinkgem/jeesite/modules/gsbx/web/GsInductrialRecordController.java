package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsInductrialRecord;
import com.thinkgem.jeesite.modules.gsbx.service.GsInductrialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 工伤信息备案
 *
 * @author sl_su
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsInductrialRecord")
public class GsInductrialRecordController extends BaseController {

    @Autowired
    GsInductrialRecordService gsInductrialRecordService;

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model, GsInductrialRecord gsInductrialRecord) {
        model.addAttribute("gsInductrialRecord", gsInductrialRecord);
        return "/modules/gsbx/gsInductrialRecordForm";
    }

    @RequestMapping(value = "info", method = RequestMethod.POST)
    public String info(Model model, GsInductrialRecord gsInductrialRecord) {
        JSONObject json = null;
        try {
            json = gsInductrialRecordService.findPersonInfo(gsInductrialRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (super.validateGsJSON(json, model, "无人员参加工伤保险信息")) {
            JSONArray infoList = json.getJSONArray("RETLIST");
            for (Object o : infoList) {
                JSONObject jsonObject = (JSONObject) o;
                if ("4".equals(jsonObject.getString("AAE140"))) {
                    model.addAttribute("InfoJson", jsonObject);
                    model.addAttribute("message", "人员参保信息查询成功");
                }
            }
        }
        model.addAttribute("gsInductrialRecord", gsInductrialRecord);
        return "/modules/gsbx/gsInductrialRecordForm";
    }

    @RequestMapping(value = "submit", method = RequestMethod.POST)
    public String submit(Model model, GsInductrialRecord gsInductrialRecord) {
        try {
            JSONObject json = gsInductrialRecordService.save(gsInductrialRecord);
            super.validateGsJSON(json, model, "人员工伤信息备案成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("gsInductrialRecord", gsInductrialRecord);
        return "/modules/gsbx/gsInductrialRecordForm";
    }

}
