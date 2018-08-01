package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsUnitPay;
import com.thinkgem.jeesite.modules.gsbx.service.GsUnitPayService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 单位缴费核定
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsUnitPay")
public class GsUnitPayController extends BaseController {

    @Autowired
    GsUnitPayService gsUnitPayService;

    @RequestMapping(value = {"","form"})
    public String form(Model model, GsUnitPay gsUnitPay, HttpServletRequest request, HttpServletResponse response){
        //查询近半年的缴费记录进行展示
        JSONObject json = getHalfYearJson(gsUnitPay);
        if (super.validateGsJSON(json, model, null)) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsUnitPay> gsUnitPays = JSONObject.parseArray(array.toString(), GsUnitPay.class);
            model.addAttribute("list", gsUnitPays);
            //获取最后的核定所属期
            try {
                Date date = DateUtils.parseDate(gsUnitPays.get(0).getAAE002(), "yyyyMM");
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.MONTH,1);
                Date time = c.getTime();
                String yyyyMM = DateUtils.formatDate(time, "yyyyMM");
                gsUnitPay.setAAE002(yyyyMM);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("gsUnitPay", gsUnitPay);
        return "/modules/gsbx/gsUnitPayForm";
    }

    /**
     * 获取近半年的缴费记录
     * @param gsUnitPay
     * @return
     */
    private JSONObject getHalfYearJson(GsUnitPay gsUnitPay) {
        Date date = DateUtils.addMonths(new Date(),-6);
        gsUnitPay.setStartAAE002(DateUtils.formatDate(date,"yyyyMM"));
        gsUnitPay.setEndAAE002(DateUtils.formatDate(new Date(),"yyyyMM"));
        JSONObject json = null;
        try {
            json = gsUnitPayService.getPaymentRecords(gsUnitPay);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 单位缴费核定前的查询
     * @param model
     * @param gsUnitPay
     * @param request
     * @return
     */
    @RequestMapping(value ="info")
    public String info(Model model, GsUnitPay gsUnitPay, HttpServletRequest request){
        // 单位缴费信息
        JSONObject json = null;
        // 单位参保信息
        JSONObject jsonObject = null;
        try {
            json = gsUnitPayService.fingInfo(gsUnitPay);
            jsonObject = gsUnitPayService.fingUnitInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(jsonObject,model,null)) {
            JSONArray array = PostHelperUtils.toJSONArray(jsonObject, "RETLIST");
            List<GsUnitPay> gsUnitPays = JSONObject.parseArray(array.toString(), GsUnitPay.class);
            model.addAttribute("unitInfoList",gsUnitPays);
            model.addAttribute("unitInfo",gsUnitPays.get(0));
            User user = UserUtils.getUser();
            model.addAttribute("userInfo",user);
        }
        if(super.validateGsJSON(json,model,null)) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsUnitPay> gsUnitPays = JSONObject.parseArray(array.toString(), GsUnitPay.class);
            model.addAttribute("infoList",gsUnitPays);
            request.getSession().setAttribute("unitPaysList", gsUnitPays);
        }
        model.addAttribute("gsUnitPay", gsUnitPay);
        return "/modules/gsbx/gsUnitPayForm";
    }

    @RequestMapping(value ="submit")
    public String submit(Model model, GsUnitPay gsUnitPay, HttpServletRequest request,HttpServletResponse response) {
        JSONObject jsonObject = null;
        try {
            List<GsUnitPay> gsUnitPays = (List<GsUnitPay>) request.getSession().getAttribute("unitPaysList");
            jsonObject = gsUnitPayService.save(gsUnitPays);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (super.validateGsJSON(jsonObject, model,"单位缴费核定保存成功，请在打印功能中打印基金表")) {
            form(model, gsUnitPay, request,response);
        }
        model.addAttribute("gsUnitPay", gsUnitPay);
        return "/modules/gsbx/gsUnitPayForm";
    }

    /**
     * 打印pdf工伤生育保险基金报表
     * @param request
     * @param response
     */
    @RequestMapping("printPDF")
    public void printPDF(HttpServletRequest request,HttpServletResponse response){
        JSONObject printInfo = (JSONObject) request.getSession().getAttribute("printJSONInfo");
        try {
            PostHelperUtils.printPDF(printInfo,"/WEB-INF/jasper/reportGSJJHD.jasper",DateUtils.getDate("yyyy-MM-dd")+"GSSY.pdf",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印页面展示
     */
    @RequestMapping("printForm")
    public String printForm(GsUnitPay gsUnitPay,Model model){
        JSONObject json = getHalfYearJson(gsUnitPay);
        if (super.validateGsJSON(json, model, null)) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsUnitPay> gsUnitPays = JSONObject.parseArray(array.toString(), GsUnitPay.class);
            gsUnitPay = gsUnitPays.get(0);
        }
        model.addAttribute("gsUnitPay", gsUnitPay);
        return "/modules/gsbx/gsUnitPayPrintForm";
    }

    /**
     * 打印页面查询信息显示
     */
    @RequestMapping("printInfo")
    public String printInfo(GsUnitPay gsUnitPay,Model model,HttpServletRequest request){
        JSONObject jsonObject = null;
        try {
            jsonObject = gsUnitPayService.getPrintInfo(gsUnitPay);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (super.validateGsJSON(jsonObject, model, null)) {
            JSONObject json = PostHelperUtils.toParseJSONObject(jsonObject, "RETLIST");
            json.put("ZNJGS", "0.00");
            json.put("ZNJSY", "0.00");
            String Bae719GS = StringUtils.isEmpty(json.getString("Bae719GS")) ? "0.00" : json.getString("Bae719GS");//工伤待转基金
            String Bae719SY = StringUtils.isEmpty(json.getString("Bae719SY")) ? "0.00" : json.getString("Bae719SY");//生育待转基金
            double yjgs = Double.parseDouble(StringUtils.isEmpty(json.getString("Aab137GS")) ? "0.00" : json.getString("Aab137GS"))
                            - Double.parseDouble(Bae719GS);
            double yjsy = Double.parseDouble(StringUtils.isEmpty(json.getString("Aab137SY")) ? "0.00" : json.getString("Aab137SY"))
                    - Double.parseDouble(Bae719SY);
            json.put("YJGS", String.valueOf(yjgs));
            json.put("YJSY", String.valueOf(yjsy));
            json.put("Bae719GS", Bae719GS);
            json.put("Bae719SY", Bae719SY);
            json.put("NOW", DateUtils.getDate("yyyy-MM-dd"));
            json.put("AAE041", gsUnitPay.getAAE041());
            json.put("AAE042", gsUnitPay.getAAE042());
            User user = UserUtils.getUser();
            json.put("AAB001", user.getGsAAB001());
            json.put("AAB004", user.getGsAAB004());
            json.put("Aab019", DictUtils.getDictLabel(json.getString("Aab019"),"AAB019_GS",""));
            json.put("Aaa040GS", DictUtils.getDictLabel(json.getString("Aaa040GS"), "BAA104_GS","" ));
            json.put("Aaa040SY", DictUtils.getDictLabel(json.getString("Aaa040SY"), "BAA105_GS","" ));
            model.addAttribute("printInfo",json);
            request.getSession().setAttribute("printJSONInfo", json);
        }
        model.addAttribute("gsUnitPay", gsUnitPay);
        return "/modules/gsbx/gsUnitPayPrintForm";
    }
}
