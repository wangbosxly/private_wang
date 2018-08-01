package com.thinkgem.jeesite.modules.sybx.syUnitRepairCheck.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB88View;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentCheck.service.SyUnitPaymentCheckService;
import com.thinkgem.jeesite.modules.sybx.syUnitRepairCheck.entity.SyUnitRepairCheck;
import com.thinkgem.jeesite.modules.sybx.syUnitRepairCheck.service.SyUnitRepairCheckService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 单位补基数核定
 *
 * @author X_P
 * @create 2018-04-02 19:03
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syUnitRepairCheck")
public class SyUnitRepairCheckController {

    @Autowired
    private SyUnitPaymentCheckService syUnitPaymentCheckService;

    @Autowired
    private SyUnitRepairCheckService syUnitRepairCheckService;

    /**
     * 显示补缴查询页面，并展示近半年补缴信息
     * @param syab88
     * @param request
     * @param response
     * @param model
     * @return
     */

    @RequestMapping(value = {"form",""})
    public String form(PM_AB88View syab88, HttpServletRequest request, HttpServletResponse response, Model model){
        //查询单位近半年缴费记录，参数均为后台参数
        Page page = new Page<PM_AB88View>(request, response);
        List<PM_AB88View> resultList = syUnitPaymentCheckService.getList();
        page = PostHelperUtils.getPage(page, resultList, 20);
        model.addAttribute("page", page);
        User user = UserUtils.getUser();
        syab88.setAAB004(user.getAab004());
        model.addAttribute("syab88", syab88);
        return "modules/sybx/syUnitRepairCheck/syUnitRepairCheckList";
    }

    /**
     * 根据费款所属期查询补缴信息
     * @param syab88
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(PM_AB88View syab88,HttpServletRequest request,HttpServletResponse response,Model model){
        //参数验证2个费款所属期不能跨年
        String startYM = request.getParameter("StartYM");
        String endYM = request.getParameter("EndYM");
        try {
            Date StartYM = DateUtils.parseDate(startYM, "yyyyMM");
            Date EndYM = DateUtils.parseDate(endYM, "yyyyMM");
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(StartYM);
            c2.setTime(EndYM);
            if(c1.get(Calendar.YEAR)!=c2.get(Calendar.YEAR)){
                model.addAttribute("message", "不能跨年度查询");
                return "forward:"+ Global.getAdminPath()+"/sybx/syUnitRepairCheck/form";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = UserUtils.getUser();
        JSONObject json = getJson(request, user);
        List<PM_AB88View> list = syUnitRepairCheckService.getCheckInfo(json);
        if(list==null){
            model.addAttribute("message", "暂无单位补差缴费核定信息");
            return form(syab88, request, response, model);
        }
        request.getSession().setAttribute("StartYM",list.get(0).getStartYM());
        request.getSession().setAttribute("EndYM",list.get(0).getEndYM());
        //结果保存至session里，方便提交时使用,此处应该使用服务器缓存，使用session会无法预防同时开启2个浏览器导致的数据操作bug
       // request.getSession().setAttribute("subList",list);
        model.addAttribute("list", list);
        syab88.setAAB001(user.getAab001());
        model.addAttribute("syab88", syab88);
        return "modules/sybx/syUnitRepairCheck/conllectionCheckInfo";
    }

    private JSONObject getJson(HttpServletRequest request, User user) {
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());
        json.put("AAB001", user.getAab001());
        json.put("BAA001", user.getBaa001());
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        json.put("StartYM", request.getParameter("StartYM"));
        json.put("EndYM", request.getParameter("EndYM"));
        return json;
    }

    /**
     * 下载明细
     * @param baa005
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("export")
    public String export(String baa005,HttpServletResponse response,Model model ){
        User user = UserUtils.getUser();
        JSONObject json = new JSONObject();
        json.put("BAA005", baa005);
        json.put("AAE170", user.getAae170());
        json.put("BAA001", user.getBaa001());
        json.put("AAB001", user.getAab001());
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //设置缴费类别
        json.put("AAE143", CodeConstant.AAE143_AAE143_13);
        //主体类别
        json.put("BAE702", CodeConstant.BAE702_BAE702_1);
        json.put("BAE703", user.getAab001());
        //SAA037	申请人
        json.put("SAA037",user.getAae011());
        //SAA038	申请时间
        json.put("SAA038", DateUtils.formatDateTime(new Date()));
        json.put("SAA015","M4021");
        json.put("SAA004", " ");
        //服务机构id
        json.put("SZZ003", " ");
        List<SyUnitRepairCheck> list = syUnitRepairCheckService.export(json);
        try {
            new ExportExcel("单位人员补基数缴费核定信息", SyUnitRepairCheck.class).setDataList(list).write(response, "单位人员补基数缴费核定信息.xlsx").dispose();
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "单位人员补基数缴费核定信息导出失败！失败信息：" + e.getMessage());
        }
        return null;
    }

    /**
     * 单位补基数缴费提交
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("submit")
    public String submit(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        //从session中获取查询过的补缴信息,session中获取的不一定是最新的数据，双浏览器提交将导致BUG
        //List<PM_AB88View> subList = (List<PM_AB88View>) session.getAttribute("subList");
        User user = UserUtils.getUser();
        //如果session中没有补缴信息，则重新查询
        //if(subList==null||subList.size()==0){
        JSONObject json = getJson(request, user);
        json.put("EndYM", session.getAttribute("EndYM"));
        json.put("StartYM", session.getAttribute("StartYM"));
        session.removeAttribute("EndYM");
        session.removeAttribute("StartYM");
        List<PM_AB88View> list = syUnitRepairCheckService.getCheckInfo(json);
        if(list!=null) {
            //}
            //准备参数
            json = (JSONObject) JSONObject.toJSON(list.get(0));
            json.put("SAA015", "M4021");
            json.put("AAE170", user.getAae170());
            json.put("BAA001", user.getBaa001());
            json.put("AAB001", user.getAab001());
            json.put("AAE140", CodeConstant.AAE140_AAE140_2);
            json.put("BAE702", CodeConstant.BAE702_BAE702_1);
            json.put("BAE703", user.getAab001());
            //SAA037	申请人
            json.put("SAA037", user.getAae011());
            //SAA038	申请时间
            json.put("SAA038", DateUtils.formatDateTime(new Date()));
            json.put("SAA004", " ");
            //服务机构id
            json.put("SZZ003", " ");
            json.put("SAA043", CodeConstant.SAA043_SAA043_3);
            json.put("SAA036", "XY" + CommonUtility.getSAA036());
            String message = syUnitRepairCheckService.submit(json);
            model.addAttribute("message", message);
            //提交完毕后清除session
            //session.removeAttribute("subList");
        }
        return "forward:"+ Global.getAdminPath()+"/sybx/syUnitRepairCheck/form";
    }
}