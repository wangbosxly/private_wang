package com.thinkgem.jeesite.modules.sybx.syywsljd.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_JC02View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sybx.syywsljd.entity.Sysljd;
import com.thinkgem.jeesite.modules.sybx.syywsljd.service.SyywsljdService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 业务受理进度查询
 *
 * @author svnlei
 * @date 2018/4/9
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syywsljd/web_syywsljd")
public class SyywsljdController extends BaseController {

    @Resource
    private SyywsljdService syywsljdService;

    /**
     * 受理进度查询查询
     */
    /*@RequestMapping(value = {"list", ""})
    public String list () {
        return "modules/sybx/syywsljd/sy_syywsljdList";
    }*/
    @RequestMapping(value = {"query", ""})
    public String query(HttpServletRequest request, HttpServletResponse response, UserView userView, Model model) {
        //获取系统信息
        User user = UserUtils.getUser();
        //设置接口查询条件  查询时间段为一年的数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Action", "3");//3为办件公示，不关心时间段，只查100个记录
//        jsonObject.put("StartDate",lastYear);
//        jsonObject.put("EndDate",thisYear);
        jsonObject.put("BAA001", user.getBaa001());
        //jsonObject.put("SAA037", user.getLoginName());
        jsonObject.put("BAE703", user.getAab001());
        jsonObject.put("SAA043", userView.getSAA043());// 业务状态
        jsonObject.put("SAA015", userView.getSAA015());// 功能ID
        Page page = syywsljdService.findList(new Page(request, response), jsonObject.toString());
        if (page != null) {
            addMessage(model, "无受理进度信息");
        }
        model.addAttribute("page", page);
        model.addAttribute("userView", userView);
        return "modules/sybx/syywsljd/sy_syywsljdList";
    }

    /**
     * 查询进度明细
     * @param request
     * @param pm_jc02View
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "queryDetails")
    public String queryDetails(HttpServletRequest request, PM_JC02View pm_jc02View, HttpServletResponse response, Model model) {
        if (pm_jc02View.getSAA036() == null || "".equals(pm_jc02View.getSAA036())) {
            model.addAttribute("pm_jc02view", pm_jc02View);
            return "modules/sybx/syywsljd/sy_syywsljdQuery";
        }
        //获取系统信息
        User user = UserUtils.getUser();
        //设置接口查询条件
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170", user.getAae170());
        jsonObject.put("AAB001", user.getAab001());
        jsonObject.put("BAA001", user.getBaa001());
        jsonObject.put("SAA036", pm_jc02View.getSAA036());
        jsonObject.put("TAA103", pm_jc02View.getTAA103());//受理状态
        Page page = syywsljdService.findListDetails(new Page(request, response), jsonObject.toString(), model);

        model.addAttribute("page", page);
        model.addAttribute("SAA036", pm_jc02View.getSAA036());
        model.addAttribute("pm_jc02view", pm_jc02View);
        //如果是稳岗补贴需展示另外的页面
        if("单位稳岗补贴申请".equals(pm_jc02View.getSAA015())){
            return "modules/sybx/syywsljd/sy_syywsljdQueryWG";
        }
        return "modules/sybx/syywsljd/sy_syywsljdQuery";
    }

    @RequestMapping(value = "eligibleExp")
    public String eligibleExp(String SAA036, String TAA103, HttpServletResponse response, Model model) {
        // 获取系统数据
        User user = UserUtils.getUser();
        //设置接口查询条件
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170", user.getAae170());
        jsonObject.put("AAB001", user.getAab001());
        jsonObject.put("BAA001", user.getBaa001());
        jsonObject.put("SAA036", SAA036);//受理单号
        jsonObject.put("TAA103", "2");//校验未通过
        List<Sysljd> list = syywsljdService.downloadExcelFile(jsonObject.toString());
        if (list != null && list.size() > 0) {
            String fileName = "批量操作失败人员明细" + ".xls";
            try {
                new ExportExcel("批量操作失败人员明细", Sysljd.class, 0).setDataList(list).write(response, fileName).dispose();
            } catch (IOException e) {
                e.printStackTrace();
                addMessage(model, "导出失败人员明细失败！失败信息：" + e.getMessage());
            }
        } else {
            addMessage(model, "无不合格人员");
        }
        PM_JC02View pm_jc02View = new PM_JC02View();
        pm_jc02View.setSAA036(SAA036);
        model.addAttribute("pm_jc02view", pm_jc02View);
        return "modules/sybx/syywsljd/sy_syywsljdQuery";
    }
}
