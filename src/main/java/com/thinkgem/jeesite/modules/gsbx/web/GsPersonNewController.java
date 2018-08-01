package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonNew;
import com.thinkgem.jeesite.modules.gsbx.service.GsPersonNewService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

/**
 * 描述:
 * 工伤生育人员新参保
 *
 * @author X_P
 * @create 2018-06-05 16:33
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsPersonNew")
public class GsPersonNewController extends BaseController {

    @Autowired
    GsPersonNewService gsPersonNewService;

    /**
     * 显示人员参保页面
     *
     * @param model
     * @param gsPersonNew
     * @return
     */
    @RequiresPermissions("gsbx:gsPersonNew:form")
    @RequestMapping(value = {"form", ""})
    public String form(Model model, GsPersonNew gsPersonNew) {
        //封装页面显示参数
        User user = UserUtils.getUser();
        gsPersonNew.setAAB001(user.getGsAAB001());
        gsPersonNew.setAAB004(user.getGsAAB004());
        gsPersonNew.setAAC030(this.getAAC030());
        //查询社平工资
        String salary = getSalary().getString("BAC504");
        model.addAttribute("rmb", salary);
        model.addAttribute("gsPersonNew", gsPersonNew);
        return "/modules/gsbx/gsPersonNewForm";
    }

    /**
     * 获取社平工资
     * @return
     */
    @ResponseBody
    @RequestMapping("salary")
    public  JSONObject getSalary() {
        JSONObject salary = null;
        try {
            salary = gsPersonNewService.getSalary();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(PostHelperUtils.hasInfo(salary)){
            String retlist = salary.getString("RETLIST");
            JSONObject jsonObject = JSONObject.parseObject(retlist);
            return jsonObject;
        }
        return null;
    }

    /**
     * 判断社平工资是否符合要求
     */
    @ResponseBody
    @RequestMapping("isRight")
    public boolean isRight(String list){
        JSONObject salary = getSalary();
        if(salary==null) return false;
        double bac504 = Double.parseDouble(salary.getString("BAC504"));
        double baa151 = Double.parseDouble(salary.getString("BAA151"));
        double v = Double.parseDouble(list);
        return bac504 < v && v < baa151;
    }

    /**
     * 新参保人员保存
     *
     * @param gsPersonNew
     * @param model
     * @return
     */
    @RequestMapping("save")
    public String save(GsPersonNew gsPersonNew, Model model,boolean gender) {
        //设置性别,前台js无敌
        if(gender){gsPersonNew.setAAC004("1");}
        //进行参数验证
        if (!beanValidator(model, gsPersonNew)) {
            form(model, gsPersonNew);
        }
        String message = null;
        String ctype = "error";
        //判断出生日期是否小于工作日期
        if (DateUtils.isBigger(gsPersonNew.getAAC006(), gsPersonNew.getAAC007())) {
            message = "出生日期要在工作日期之前！";
            //判断参加工作日期是否小于参保日期
        } else if (DateUtils.isBigger(gsPersonNew.getAAC007(), gsPersonNew.getAAC030())) {
            message = "工作日期要在参保日期之前！";
            //判断参保人员是否已经存在
        } else if (!isNotexist(gsPersonNew)) {
            message = "保存失败，该身份证号已存在或已保存！请核实";
        } else {
            //数据效验合格，调用接口
            JSONObject s = null;
            try {
                s = gsPersonNewService.save(gsPersonNew);
            } catch (Exception e) {
                e.printStackTrace();
                message = "接口调用失败，请联系经办机构";
            }
            if ("-1".equals(s.getString("code"))) {
                message = s.getString("msg");
            } else if("0".equals(s.getString("code"))) {
                message = "人员参保登记保存成功";
                ctype = "success";
            }
        }
        //查询社平工资
        String salary = getSalary().getString("BAC504");
        model.addAttribute("rmb", salary);
        model.addAttribute("message", message);
        model.addAttribute("ctype", ctype);
        model.addAttribute("gsPersonNew", gsPersonNew);
        return "/modules/gsbx/gsPersonNewForm";
    }

    /**
     * 异步验证身份证号是否已经参保
     *
     * @param gsPersonNew
     * @return
     */
    @RequestMapping("exist")
    @ResponseBody
    public boolean isNotexist(GsPersonNew gsPersonNew) {
        String aac002 = gsPersonNew.getAAC002();
        try {
            return !gsPersonNewService.findInfoByAAC002(aac002);
        } catch (RemoteException e) {
            e.printStackTrace();
            //此处需要抛出全局处理异常
            return false;
        }
    }

    /**
     * 获取参保日期，业务要求当日参保，参保日期为第二天
     *
     * @return
     */
    private String getAAC030() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        Date time = c.getTime();
        String AAC030 = DateUtils.formatDate(time, "yyyy-MM-dd");
        return AAC030;
    }
}