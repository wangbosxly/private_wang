package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonContinue;
import com.thinkgem.jeesite.modules.gsbx.service.GsPersonContinueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 描述:
 * 人员续保控制器
 *
 * @author X_P
 * @create 2018-06-06 17:51
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsPersonContinue")
public class GsPersonContinueController extends BaseController{


    @Autowired
    GsPersonContinueService gsPersonContinueService;

    /**
     * 展示页面
     * @param model
     * @param gsPersonContinue
     * @return
     */
    @RequestMapping(value = {"","form"})
    public String form(Model model, GsPersonContinue gsPersonContinue){
        model.addAttribute("gsPersonContinue", gsPersonContinue);
        return "/modules/gsbx/gsPersonContinueForm";
    }

    /**
     * 查询人员显示列表
     * @param model
     * @param gsPersonContinue
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, GsPersonContinue gsPersonContinue, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = null;
        Page page = new Page (request, response);
        try {
            json =  gsPersonContinueService.findUnitPersonInfo(gsPersonContinue,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,null)){
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsPersonContinue> gsPersonContinues = JSONObject.parseArray(array.toString(), GsPersonContinue.class);
             page = PostHelperUtils.getPage(page, gsPersonContinues, 20);
            model.addAttribute("pagination", page);
        }
        return "/modules/gsbx/gsPersonContinueForm";
    }

    @RequestMapping("submit")
    public String submit(Model model,String[] AAC001S,String AAE160){
        JSONObject json = null;
        try {
            json =  gsPersonContinueService.executeContinue(AAC001S,AAE160);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.validateGsJSON(json, model, "人员续保操作成功");
        model.addAttribute("gsPersonContinue",new GsPersonContinue());
        return "/modules/gsbx/gsPersonContinueForm";
    }

    /**
     * 人员续保批量操作
     */
    @RequestMapping("fileUpload")
    public String fileUpload(MultipartFile file, Model model, String AAE160){
        String fileName = file.getOriginalFilename();
        String strArr = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        if (!"xls".equals(strArr) && !"xlsx".equals(strArr)) {
            model.addAttribute("msg","不是支持的文件格式请使用excel文件做批量上传!");
            return form(model,new GsPersonContinue());
        }
        try {
            ImportExcel excel = new ImportExcel(file, 1, 0);
            List<GsPersonContinue> dataList = excel.getDataList(GsPersonContinue.class);
            JSONObject json = null;
            try {
                json =  gsPersonContinueService.executeStop(dataList,AAE160);
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.validateGsJSON(json, model, "人员续保操作成功");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "文件读取失败,请使用模板文件");
        }

        model.addAttribute("gsPersonContinue",new GsPersonContinue());
        return "/modules/gsbx/gsPersonContinueForm";

    }
}