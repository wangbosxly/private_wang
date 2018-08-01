package com.thinkgem.jeesite.modules.ylbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.service.DictService;
import com.thinkgem.jeesite.modules.ylbx.entity.SpecialBusiness;
import com.thinkgem.jeesite.modules.ylbx.service.YbRelocatedRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 医保异地安置人员备案
 * @author sl_su
 */
@Controller
@RequestMapping("${adminPath}/ylbx/ybRelocatedRecord")
public class YbRelocatedRecordController extends BaseController {

    @Autowired
    YbRelocatedRecordService ybRelocatedRecordService;

    @Autowired
    private DictService dictService;

    @RequestMapping("form")
    public String form(Model model, SpecialBusiness specialBusiness) {
        model.addAttribute("specialBusiness",specialBusiness);
        return "modules/ylbx/ybRelocatedRecordList";
    }

    @RequestMapping("list")
    public String list(Model model, HttpServletRequest request, HttpServletResponse response, SpecialBusiness specialBusiness) {
        Page page = new Page(request, response);
        specialBusiness.setBAC809(String.valueOf(page.getPageNo()));
        JSONObject json = null;
        try {
            json = ybRelocatedRecordService.queryRelocatedRecord(specialBusiness);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (validateYbJSON(json, model, null)) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<SpecialBusiness> specialBusinessList = JSONObject.parseArray(array.toString(), SpecialBusiness.class);
            String counts = ((JSONObject) array.get(0)).getString("COUNTS");
            page = PostHelperUtils.getPage(page, specialBusinessList, counts, 20);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("specialBusiness",specialBusiness);
        return "modules/ylbx/ybRelocatedRecordList";
    }

    @RequestMapping("info")
    public String info(Model model, SpecialBusiness specialBusiness) {
        JSONObject json = null;
        try {
            json = ybRelocatedRecordService.queryRelocatedRecord(specialBusiness);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (validateYbJSON(json, model, null)) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<SpecialBusiness> specialBusinessList = JSONObject.parseArray(array.toString(), SpecialBusiness.class);
            model.addAttribute("specialBusiness", specialBusinessList.get(0));
        } else {
            model.addAttribute("specialBusiness", specialBusiness);
        }
        return "modules/ylbx/ybRelocatedRecordForm";
    }

    @RequestMapping("save")
    public String save(Model model, SpecialBusiness specialBusiness) {
        // 进行参数验证
        if (DateUtils.isBigger(specialBusiness.getBKE003(), specialBusiness.getBKE004())) {
            model.addAttribute("message", "开始日期要在截至日期之前！");
            model.addAttribute("ctype", "error");
        } else {
            JSONObject json = null;
            try {
                json = ybRelocatedRecordService.save(specialBusiness);
            } catch (RemoteException e) {
                e.printStackTrace();
                model.addAttribute("message", "接口调用失败，请联系经办机构");
                model.addAttribute("ctype", "error");
            }
            validateYbJSON(json, model, "异地安置备案人员信息查询成功");
        }
        model.addAttribute("specialBusiness",specialBusiness);
        return "modules/ylbx/ybRelocatedRecordForm";
    }

    @RequestMapping("getPostTemplateJson")
    @ResponseBody
    public List<Dict> getPostTemplateJson(Dict dict) {
        List<Dict> list;
        if (dict.getValue().endsWith("0000")) {
            // 一级省 根据省查市
            dict.setType("AA26_10_482");
            dict.setValue(dict.getValue().substring(0,2));
            list = dictService.getPostTemplateJson(dict);
        } else {
            // 二级市 根据市查县区
            dict.setType("AA26_10_482_quxian");
            dict.setValue(dict.getValue().substring(0,4));
            list = dictService.getPostTemplateJson(dict);
        }
        return list;
    }

}
