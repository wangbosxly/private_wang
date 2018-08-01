package com.thinkgem.jeesite.modules.ylbx.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.ylbx.entity.YbPerson;
import com.thinkgem.jeesite.modules.ylbx.entity.YbPersonList;
import com.thinkgem.jeesite.modules.ylbx.service.YbPaymentBaseService;
import com.thinkgem.jeesite.modules.ylbx.service.YbPersonNewService;
import com.thinkgem.jeesite.modules.ylbx.service.YbPersonStopAndContinueService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 医保人员缴费基数申报
 */
@Controller
@RequestMapping("${adminPath}/ylbx/ybPaymentBase")
public class YbPaymentBaseController extends BaseController {

    @Autowired
    private YbPersonStopAndContinueService ybPersonStopAndContinueService;

    @Autowired
    private YbPersonNewService ybPersonNewService;

    @Autowired
    private YbPaymentBaseService ybPaymentBaseService;
    /**
     * 展示基数申报页面
     * @param ybPerson
     * @param model
     * @return
     */
    @RequestMapping(value = {"form",""})
   public String form(YbPerson ybPerson, Model model){
        model.addAttribute("ybPerson", ybPerson);
        return "modules/ylbx/ybPaymentBaseForm";
   }

    /**
     * 查询人员参保信息，以便于填写基数
     * @param ybPerson
     * @param model
     * @param request
     * @param response
     * @return
     */
   @RequestMapping("list")
    public String list(YbPerson ybPerson, Model model, HttpServletRequest request, HttpServletResponse response){
        ybPerson.setAAE140("3");//默认险种为 职工基本医疗保险
       JSONObject json = null;
       try {
           json = ybPersonStopAndContinueService.getPersonList(ybPerson);
       } catch (RemoteException e) {
           e.printStackTrace();
       }
       if (validateYbJSON(json, model, null)) {
           Page page = getPage(json, request, response);
           model.addAttribute("pagination", page);
       }
       model.addAttribute("ybPerson", ybPerson);
       return "modules/ylbx/ybPaymentBaseForm";
   }

    /**
     * 缴费基数申报
     * @param ybPersonList
     * @param model
     * @param AAC001
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("submit")
    public String submit(YbPersonList ybPersonList, Model model, String[] AAC001, HttpServletRequest request, HttpServletResponse response){
        //解析选中的信息
        List<String> AAC001s = Arrays.asList(AAC001);
        List<YbPerson> list = ybPersonList.getList();
        List<YbPerson> ybPersons = new ArrayList<YbPerson>(AAC001s.size());
        for (YbPerson ybPerson : list) {
            for (String aac001 : AAC001s) {
                List<String> strs = Arrays.asList(aac001.split("&"));
                if(strs.contains((ybPerson).getAAC001())&&strs.contains((ybPerson).getAAE140())){
                    ybPersons.add(ybPerson);
                    break;
                }
            }
        }
        JSONObject json = null;
        try {
            json = ybPaymentBaseService.save(ybPersons);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.validateGsJSON(json, model, "人员基数申报成功");
        model.addAttribute("ybPerson", new YbPerson());
        return "modules/ylbx/ybPaymentBaseForm";
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
            salary = ybPersonNewService.getSalary();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(PostHelperUtils.hasInfo(salary)){
            String retlist = salary.getString("RETLIST");
            return JSONObject.parseArray(retlist).getJSONObject(0);
        }
        return null;
    }
    /**
     * 批量申报基数操作
     */
    @RequestMapping("upload")
    public String upload(MultipartFile file, Model model, YbPerson ybPerson){
        String fileName = file.getOriginalFilename();
        String strArr = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        if (!"xls".equals(strArr) && !"xlsx".equals(strArr)) {
            model.addAttribute("msg","不是支持的文件格式请使用excel文件做批量上传!");
            return form(ybPerson, model);
        }
        JSONObject json = null;
        try {
            ImportExcel excel = new ImportExcel(file, 1, 0);
            List<YbPerson> dataList = excel.getDataList(YbPerson.class, 2);
            json = ybPaymentBaseService.save(dataList);
        } catch (InvalidFormatException | IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        super.validateYbJSON(json, model, "人员批量基数申报操作成功,请等待经办机构审核");
        model.addAttribute("ybPerson", ybPerson);
        return "modules/ylbx/ybPaymentBaseForm";
    }
}
