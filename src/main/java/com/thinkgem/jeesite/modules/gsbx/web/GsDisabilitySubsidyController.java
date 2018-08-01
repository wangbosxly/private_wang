package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PascalNameFilter;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.RMBUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsDisabilitySubsidy;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonInfoModify;
import com.thinkgem.jeesite.modules.gsbx.service.GsDisabilitySubsidyService;
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

/**
 * 一次性伤残补助
 * @author sl_su
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsDisabilitySubsidy")
public class GsDisabilitySubsidyController extends BaseController {

    @Autowired
    GsDisabilitySubsidyService gsDisabilitySubsidyService;

    @Autowired
    GsPersonInfoModifyService gsPersonInfoModifyService;

    @RequestMapping(value = "list")
    public String list(Model model, GsDisabilitySubsidy gsDisabilitySubsidy, HttpServletRequest request) {
        model.addAttribute("gsDisabilitySubsidy",gsDisabilitySubsidy);
        return "/modules/gsbx/gsDisabilitySubsidyFormt";
    }

    @RequestMapping(value = "form")
    public String form(Model model, GsDisabilitySubsidy gsDisabilitySubsidy, HttpServletRequest request) {
        JSONObject json = null;
        try {
            json =  gsDisabilitySubsidyService.findDisabilitySubsidy(gsDisabilitySubsidy);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,"一次性工亡补助信息查询成功")) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsDisabilitySubsidy> gsDisabilitySubsidys = JSONObject.parseArray(array.toString(), GsDisabilitySubsidy.class);
            request.getSession().setAttribute("gsDisabilitySubsidys",gsDisabilitySubsidys);
            model.addAttribute("infoList",gsDisabilitySubsidys);
            request.getSession().setAttribute("gsDisabilitySubsidy",gsDisabilitySubsidys.get(0));
        }
        model.addAttribute("gsDisabilitySubsidy",gsDisabilitySubsidy);
        return "/modules/gsbx/gsDisabilitySubsidyFormt";
    }

    @RequestMapping(value = "submit")
    public String submit(Model model, GsDisabilitySubsidy gsDisabilitySubsidy, HttpServletRequest request) {
        JSONObject json = null;
        try {
            gsDisabilitySubsidy = (GsDisabilitySubsidy) request.getSession().getAttribute("gsDisabilitySubsidy");
            json = gsDisabilitySubsidyService.save(gsDisabilitySubsidy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,"一次性伤残补助金申报成功")){
            list(model, gsDisabilitySubsidy, request);
        }else{
            model.addAttribute("gsDisabilitySubsidy", gsDisabilitySubsidy);
        }
        return "/modules/gsbx/gsDisabilitySubsidyFormt";
    }

    /**
     * 工伤伤残报表打印
     * @param request
     */
    @RequestMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response){
        //从session中取出所有的伤残信息，一般只有一条
        List<GsDisabilitySubsidy> gsDisabilitySubsidys = (List<GsDisabilitySubsidy>) request.getSession().getAttribute("gsDisabilitySubsidys");
        GsDisabilitySubsidy gsDisabilitySubsidy = gsDisabilitySubsidys.get(0);
        String str = JSONObject.toJSONString(gsDisabilitySubsidy, new PascalNameFilter());
        JSONObject jsonObject = JSONObject.parseObject(str);
        //查询人员基本信息
        GsPersonInfoModify gsPersonInfoModify = new GsPersonInfoModify();
        gsPersonInfoModify.setAAC001(gsDisabilitySubsidy.getAAC001());
        try {
            JSONObject person = gsPersonInfoModifyService.getPerson(gsPersonInfoModify, new Page(request, response));
            JSONArray array = PostHelperUtils.toJSONArray(person, "RETLIST");
            person = JSONObject.parseObject(array.getJSONObject(0).toString());
            jsonObject.putAll(person);
            //转换字典对应字段
            jsonObject.put("AAC005", DictUtils.getDictLabels(jsonObject.getString("AAC005"),"AAC005_5",""));
            jsonObject.put("AAC004", DictUtils.getDictLabels(jsonObject.getString("AAC004"),"AAC004_5",""));
            jsonObject.put("ALA040", DictUtils.getDictLabels(jsonObject.getString("ALA040"),"ALA040_GS",""));
            //计算报表显示的总金额，并转化为大写汉字
            double aaa013 = Double.parseDouble(jsonObject.getString("AAA013"));
            double ala041_020 = Double.parseDouble(jsonObject.getString("ALA041_020"));
            double m = aaa013 * ala041_020;
            String s = RMBUtils.number2CNMontrayUnit(new BigDecimal(String.valueOf(m)));
            jsonObject.put("money", s);
            //设置报表模板路径
            String filePath = "/WEB-INF/jasper/reportGSSCBZ.jasper";
            PostHelperUtils.printPDF(jsonObject,filePath,jsonObject.getString("AAC002")+"SC.pdf",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
