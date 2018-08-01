package com.thinkgem.jeesite.modules.ylbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.ylbx.entity.YbPerson;
import com.thinkgem.jeesite.modules.ylbx.service.YbPersonStopAndContinueService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

@Controller
@RequestMapping("${adminPath}/ylbx/ybPersonContinue")
public class YbPersonContinueController extends BaseController {

    @Autowired
    private YbPersonStopAndContinueService ybPersonStopAndContinueService;

    /**
     * 展示页面
     */
    @RequestMapping(value = {"form", ""})
    public String form(Model model, YbPerson ybPerson) {
        model.addAttribute("ybPerson", ybPerson);
        return "/modules/ylbx/ybPersonContinueForm";
    }

    @RequestMapping("list")
    public String list(Model model, YbPerson ybPerson, HttpServletRequest request, HttpServletResponse response) {
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
        return "/modules/ylbx/ybPersonContinueForm";
    }

    @RequestMapping("submit")
    public String save(Model model, String[] AAC001S, YbPerson ybPerson) {
        JSONObject json = null;
        try {
            json = ybPersonStopAndContinueService.save(AAC001S, ybPerson);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        validateYbJSON(json, model, "人员续保操作成功,请等待经办机构审核");
        return form(model, ybPerson);
    }

    @RequestMapping("fileUpload")
    public String fileUpload(MultipartFile file, Model model, YbPerson ybPerson, HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        String strArr = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        if (!"xls".equals(strArr) && !"xlsx".equals(strArr)) {
            model.addAttribute("msg","不是支持的文件格式请使用excel文件做批量上传!");
            return form(model, ybPerson);
    }
        try {
            ImportExcel excel = new ImportExcel(file, 1, 0);
            List<YbPerson> dataList = excel.getDataList(YbPerson.class, 1);
            JSONObject json = null;
            try {
                json =  ybPersonStopAndContinueService.executeStopAndContinue(dataList, ybPerson);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (super.validateYbJSON(json, model, "人员批量续保操作成功,请等待经办机构审核")) {
                JSONArray array = PostHelperUtils.toJSONArray(json, "errorList");
                List<YbPerson> errorList = JSONObject.parseArray(array.toString(), YbPerson.class);
                request.getSession().setAttribute("errorList", errorList);
                model.addAttribute("errorListShow", "show");
            }
        } catch (InvalidFormatException | IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            model.addAttribute("message", "文件读取失败,请使用模板文件");
            model.addAttribute("ctype", "error");
        }
        model.addAttribute("ybPerson", ybPerson);
        return "/modules/ylbx/ybPersonContinueForm";
    }

    @RequestMapping("eligibleExp")
    public String eligibleExp (Model model, YbPerson ybPerson, HttpServletRequest request, HttpServletResponse response) {
        List<YbPerson> errorList = (List<YbPerson>) request.getSession().getAttribute("errorList");
        if (errorList != null && errorList.size() > 0) {
            String fileName = "批量续保失败人员明细" + ".xlsx";
            try {
                new ExportExcel("批量续保失败人员明细", YbPerson.class, 0, 1).setDataList(errorList).write(response, fileName).dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("ybPerson", ybPerson);
        return "/modules/ylbx/ybPersonContinueForm";
    }

}
