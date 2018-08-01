package com.thinkgem.jeesite.modules.ylbx.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.ylbx.entity.SpecialBusiness;
import com.thinkgem.jeesite.modules.ylbx.service.YbSpecialPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.RemoteException;

/**
 * 门诊特殊病人员登记
 * @author sl_su
 */
@Controller
@RequestMapping("${adminPath}/ylbx/ybSpecialPatient")
public class YbSpecialPatientController extends BaseController {

    @Autowired
    YbSpecialPatientService ybSpecialPatientService;

    /**
     * 显示门诊特殊病人员登记页面
     */
    @RequestMapping(value = {"form", ""})
    public String form(Model model, SpecialBusiness specialBusiness) {
        // 设置页面参数
        User user = UserUtils.getUser();
        specialBusiness.setAAB004(user.getYbAAB004());
        specialBusiness.setAAE011(user.getYbAAE170());
        model.addAttribute("specialBusiness",specialBusiness);
        return "/modules/ylbx/ybSpecialPatientForm";
    }

    /**
     * 门诊特殊病人员登记保存
     */
    @RequestMapping("save")
    public String save (Model model, SpecialBusiness specialBusiness) {
        // 进行参数验证
        if (DateUtils.isBigger(specialBusiness.getBKE003(), specialBusiness.getBKE004())) {
            model.addAttribute("message", "开始日期要在截至日期之前！");
            model.addAttribute("ctype", "error");
        } else {
            JSONObject json = null;
            try {
                json = ybSpecialPatientService.save(specialBusiness);
            } catch (RemoteException e) {
                e.printStackTrace();
                model.addAttribute("message", "接口调用失败，请联系经办机构");
                model.addAttribute("ctype", "error");
            }
            validateYbJSON(json, model, "门诊特殊病人员登记保存成功,请等待经办机构审核");
        }
        model.addAttribute("specialBusiness", specialBusiness);
        return "/modules/ylbx/ybSpecialPatientForm";
    }

}
