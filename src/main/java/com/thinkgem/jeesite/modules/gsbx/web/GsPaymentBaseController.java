package com.thinkgem.jeesite.modules.gsbx.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPaymentBase;
import com.thinkgem.jeesite.modules.gsbx.entity.GsPersonContinue;
import com.thinkgem.jeesite.modules.gsbx.entity.PaymentBaseList;
import com.thinkgem.jeesite.modules.gsbx.service.GsPaymentBaseService;
import com.thinkgem.jeesite.modules.gsbx.service.GsPersonContinueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 人员缴费基数申报和打印
 */
@Controller
@RequestMapping("${adminPath}/gsbx/gsPaymentBase")
public class GsPaymentBaseController extends BaseController {

    @Autowired
    private GsPaymentBaseService gsPaymentBaseService;

    @Autowired
    private GsPersonContinueService gsPersonContinueService;
    /**
     * 人员缴费基数打印页面
     * @param model
     * @param gsPaymentBase
     * @return
     */
    @RequestMapping("form")
    public String form(Model model, GsPaymentBase gsPaymentBase) {
        model.addAttribute("gsPaymentBase", gsPaymentBase);
        return "/modules/gsbx/gsPaymentBaseForm";
    }

    /**
     * 人员缴费基数申报页面
     * @param model
     * @param gsPaymentBase
     * @return
     */
    @RequestMapping("sbform")
    public String sbform(Model model, GsPaymentBase gsPaymentBase){
        model.addAttribute("gsPaymentBase", gsPaymentBase);
        return "/modules/gsbx/gsPaymentBaseList";
    }

    /**
     * 查询人员参保信息
     * @param model
     * @param gsPersonContinue
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("sblist")
    public String sblist(Model model, GsPersonContinue gsPersonContinue, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = null;
        Page page = new Page (request, response);
        try {
            json =  gsPersonContinueService.findUnitPersonInfo(gsPersonContinue,page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,null)){
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsPaymentBase> gsPersonContinues = JSONObject.parseArray(array.toString(), GsPaymentBase.class);
            page = PostHelperUtils.getPage(page, gsPersonContinues,array.getJSONObject(0).getString("countNum"), 20);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("gsPaymentBase", gsPersonContinue);
        return "/modules/gsbx/gsPaymentBaseList";
    }
    /**
     * 查询人员缴费基数列表
     * @param model
     * @param gsPaymentBase
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("list")
    public String list (Model model, GsPaymentBase gsPaymentBase, HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = null;
        Page page = new Page (request, response);
        try {
            json = gsPaymentBaseService.findPaymentBase(gsPaymentBase, page);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(super.validateGsJSON(json,model,null)) {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsPaymentBase> gsPaymentBases = JSONObject.parseArray(array.toString(), GsPaymentBase.class);
            String countNum = array.getJSONObject(0).getString("countNum");
            page = PostHelperUtils.getPage(page, gsPaymentBases, countNum, 20);
            //数据存入session,下载时使用
            request.getSession().setAttribute("countNum",countNum);
            model.addAttribute("pagination", page);
        }
        model.addAttribute("gsPaymentBase", gsPaymentBase);
        return "/modules/gsbx/gsPaymentBaseForm";
    }

    /**
     * 下载表格
      * @param request
     * @param response
     * @return
     */
    @RequestMapping("download")
    public JSONObject download(GsPaymentBase gsPaymentBase,HttpServletRequest request, HttpServletResponse response){
        int countNum = Integer.parseInt((String) request.getSession().getAttribute("countNum"));
        JSONObject json = null;
        Page page = new Page (request, response);
        page.setPageSize(countNum);
        try {
            json = gsPaymentBaseService.findPaymentBase(gsPaymentBase, page);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        String fileName = "人员缴费基数信息"+ DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
        try {
            JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
            List<GsPaymentBase> gsPaymentBases = JSONObject.parseArray(array.toString(), GsPaymentBase.class);
            new ExportExcel("人员缴费基数信息", GsPaymentBase.class).setDataList(gsPaymentBases).write(response, fileName).dispose();
        } catch (IOException e) {
            e.printStackTrace();
            json.put("code", "-1");
        }
        json.put("code", "0");
        return null;
    }

    /**
     * 缴费基数申报
     * @param paymentBaseList
     * @param model
     * @param AAC001
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("submit")
    public String submit(PaymentBaseList paymentBaseList, Model model, String[] AAC001,HttpServletRequest request, HttpServletResponse response){
        //解析选中的信息
        List<String> AAC001s = Arrays.asList(AAC001);
        List<GsPaymentBase> list = paymentBaseList.getList();
        List<GsPaymentBase> gsPaymentBases = new ArrayList<GsPaymentBase>(AAC001s.size());
        for (GsPaymentBase gsPaymentBase : list) {
            for (String aac001 : AAC001s) {
                List<String> strs = Arrays.asList(aac001.split("&"));
                if(strs.contains((gsPaymentBase).getAAC001())&&strs.contains((gsPaymentBase).getAAE140())){
                    gsPaymentBases.add(gsPaymentBase);
                    break;
                }
            }
        }
        JSONObject json = null;
        try {
            json = gsPaymentBaseService.save(gsPaymentBases);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        super.validateGsJSON(json, model, "人员基数申报成功");
        model.addAttribute("gsPaymentBase", new GsPaymentBase());
        return "/modules/gsbx/gsPaymentBaseList";
    }

    /**
     * 批量申报基数操作
     * @return
     */
    @RequestMapping("upload")
    public String upload(MultipartFile file, Model model){
        String fileName = file.getOriginalFilename();
        String strArr = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        if (!"xls".equals(strArr) && !"xlsx".equals(strArr)) {
            model.addAttribute("msg","不是支持的文件格式请使用excel文件做批量上传!");
            return sbform(model,new GsPaymentBase());
        }
        try {
            ImportExcel excel = new ImportExcel(file, 1, 0);
            List<GsPaymentBase> dataList = excel.getDataList(GsPaymentBase.class);
            JSONObject json = null;
            try {
                json = gsPaymentBaseService.save(dataList);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            super.validateGsJSON(json, model, "人员基数申报成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "文件读取失败,请使用模板文件");
            model.addAttribute("ctype", "error");
        }
        model.addAttribute("gsPaymentBase", new GsPaymentBase());
        return "/modules/gsbx/gsPaymentBaseList";
    }
}
