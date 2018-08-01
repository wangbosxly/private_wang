package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.RMBUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsDeathSubsidy;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonInfoModify;
import com.thinkgem.jeesite.modules.gsbx.service.GsDeathSubsidyService;
import com.thinkgem.jeesite.modules.gsbx.service.GsPersonInfoModifyService;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.List;

@Controller
@RequestMapping("${adminPath}/gsbx/gsDeathSubsidy")
public class GsDeathSubsidyController extends BaseController {

    @Autowired
    private GsDeathSubsidyService gsDeathSubsidyService;

    @Autowired
    private GsPersonInfoModifyService gsPersonInfoModifyService;

    @Autowired
    private GsPersonNewController gsPersonNewController;

    @RequestMapping(value = "list")
    public String list(Model model, GsDeathSubsidy gsDeathSubsidy,HttpServletRequest request) {
        model.addAttribute("gsDeathSubsidy",gsDeathSubsidy);
        return "/modules/gsbx/gsDeathSubsidyForm";
    }

    @RequestMapping(value = "form")
    public String form(Model model, GsDeathSubsidy gsDeathSubsidy, HttpServletRequest request) {
        JSONObject json = null;
        try {
            json =  gsDeathSubsidyService.findDeathSubsidy(gsDeathSubsidy);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,"一次性工亡补助信息查询成功")) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsDeathSubsidy> gsDeathSubsidys = JSONObject.parseArray(array.toString(), GsDeathSubsidy.class);
            model.addAttribute("infoList",gsDeathSubsidys);
            request.getSession().setAttribute("gsDeathSubsidy",gsDeathSubsidys.get(0));
        }
        model.addAttribute("gsDeathSubsidy",gsDeathSubsidy);
        return "/modules/gsbx/gsDeathSubsidyForm";
    }

    @RequestMapping(value = "submit")
    public String submit(Model model, GsDeathSubsidy gsDeathSubsidy, HttpServletRequest request) {
        JSONObject json = null;
        try {
            gsDeathSubsidy = (GsDeathSubsidy) request.getSession().getAttribute("gsDeathSubsidy");
            json = gsDeathSubsidyService.save(gsDeathSubsidy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,"一次性工亡补助金申报成功")){
            list(model, gsDeathSubsidy, request);
        }
        model.addAttribute("gsDeathSubsidy", gsDeathSubsidy);
        return "/modules/gsbx/gsDeathSubsidyForm";
    }

    /**
     * 工伤伤残报表打印
     * @param request
     */
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response){
        //从session中取出所有的伤残信息，一般只有一条
        GsDeathSubsidy gsDeathSubsidy = (GsDeathSubsidy) request.getSession().getAttribute("gsDeathSubsidy");
        String str = JSONObject.toJSONString(gsDeathSubsidy, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        //查询人员基本信息，查询社平工资
        GsPersonInfoModify gsPersonInfoModify = new GsPersonInfoModify();
        gsPersonInfoModify.setAAC001(gsDeathSubsidy.getAAC001());
        try {
            JSONObject salary = gsPersonNewController.getSalary();
            JSONObject person = gsPersonInfoModifyService.getPerson(gsPersonInfoModify, new Page(request, response));
            JSONArray array = PostHelperUtils.toJSONArray(person, "RETLIST");
            person = JSONObject.parseObject(array.getJSONObject(0).toString());
            jsonObject.putAll(salary);
            jsonObject.putAll(person);
            BigDecimal ALC115_1 = new BigDecimal(jsonObject.getString("ALC115_1"));
            BigDecimal ALC115_0 = new BigDecimal(jsonObject.getString("ALC115_0"));
            BigDecimal add = ALC115_1.add(ALC115_0);
            jsonObject.put("ALC115_1money", RMBUtils.number2CNMontrayUnit(ALC115_1));
            jsonObject.put("ALC115_0money", RMBUtils.number2CNMontrayUnit(ALC115_0));
            jsonObject.put("money", RMBUtils.number2CNMontrayUnit(add));
            jsonObject.put("AAC004", DictUtils.getDictLabels(jsonObject.getString("AAC004"),"AAC004_5",""));
           /* //转换字典对应字段
            jsonObject.put("AAC005", DictUtils.getDictLabels(jsonObject.getString("AAC005"),"AAC005_5",""));
            jsonObject.put("ALA040", DictUtils.getDictLabels(jsonObject.getString("ALA040"),"ALA040_GS",""));
            //计算报表显示的总金额，并转化为大写汉字
            double aaa013 = Double.parseDouble(jsonObject.getString("AAA013"));
            double ala041_020 = Double.parseDouble(jsonObject.getString("ALA041_020"));
            double m = aaa013 * ala041_020;
            String s = RMBUtils.number2CNMontrayUnit(new BigDecimal(String.valueOf(m)));
            jsonObject.put("money", s);*/
            //设置报表模板路径
            String filePath = "/WEB-INF/jasper/reportGSGWBZ.jasper";
            PostHelperUtils.printPDF(jsonObject,filePath,jsonObject.getString("AAC002")+"GW.pdf",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
