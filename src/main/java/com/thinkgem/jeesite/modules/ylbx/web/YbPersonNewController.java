package com.thinkgem.jeesite.modules.ylbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.ylbx.entity.YbPerson;
import com.thinkgem.jeesite.modules.ylbx.service.YbPersonInfoModifyService;
import com.thinkgem.jeesite.modules.ylbx.service.YbPersonNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.RemoteException;

@Controller
@RequestMapping("${adminPath}/ylbx/ybPersonNew")
public class YbPersonNewController extends BaseController {

    @Autowired
    YbPersonNewService ybPersonNewService;
    @Autowired
    YbPersonInfoModifyService ybPersonInfoModifyService;

    /**
     * 显示人员参保页面
     */
    @RequestMapping(value = {"form", ""})
    public String form(Model model, YbPerson ybPerson) {
        // 设置页面参数
        User user = UserUtils.getUser();
        ybPerson.setAAB001(user.getYbAAB001());
        ybPerson.setAAB004(user.getYbAAB004());
        model.addAttribute("ybPerson", ybPerson);
        //查询社平工资
        model.addAttribute("rmb", getSalary());
        return "/modules/ylbx/ybPersonNewForm";
    }

    /**
     * 新参保人员保存
     */
    @RequestMapping("save")
    public String save(Model model, YbPerson ybPerson) {
        // 进行参数验证
        String message = null;
        String ctype = "error";
        //判断出生日期是否小于工作日期
        if (DateUtils.isBigger(ybPerson.getAAC006(), ybPerson.getAAC007())) {
            message = "出生日期要在工作日期之前！";
            //判断参加工作日期是否小于参保日期
        } else if (DateUtils.isBigger(ybPerson.getAAC007(), ybPerson.getBAC510())) {
            message = "工作日期要在参保日期之前！";
            //判断参保人员是否已经存在
        } else if (!isNotexist(ybPerson)) {
            message = "保存失败，该身份证号已存在或已保存！请核实";
        } else {
            //数据效验合格，调用接口
            JSONObject json = null;
            try {
                json = ybPersonNewService.save(ybPerson);
            } catch (RemoteException e) {
                e.printStackTrace();
                message = "接口调用失败，请联系经办机构";
            }
            validateYbJSON(json, model, "人员新参保保存成功,请等待经办机构审核");
        }
        model.addAttribute("message", message);
        model.addAttribute("ctype", ctype);
        model.addAttribute("ybPerson", ybPerson);
        return "/modules/ylbx/ybPersonNewForm";
    }

    /**
     * 异步验证身份证号是否已经参保
     */
    @RequestMapping("exist")
    @ResponseBody
    public boolean isNotexist(YbPerson ybPerson) {
        try {
            JSONObject json = ybPersonInfoModifyService.getPersonList(ybPerson);
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            if (array == null || array.size() == 0) {
                return true;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            //此处需要抛出全局处理异常
            return true;
        }
        return false;
    }

    /**
     * 获取社会平均工资
     */
    private String getSalary() {
        JSONObject salary = null;
        try {
            salary = ybPersonNewService.getSalary();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (PostHelperUtils.hasInfo(salary)) {
            JSONArray array = PostHelperUtils.toJSONArray(salary, "RETLIST");
            if (array != null) {
                JSONObject json = array.getJSONObject(0);
                // 获取结果为年社评工资 月缴费工资需除以 12
                String str = json.getString("AAA010");
                Double num = Double.parseDouble(str);
                num = num / 12;
                return String.valueOf(num);
            }
        }
        return null;
    }
}
