package com.thinkgem.jeesite.modules.sybx.syCollectionQuery.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB88View;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentQuery.service.SyUnitPaymentQueryService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 征缴计划
 *
 * @author X_P
 * @create 2018-03-28 15:37
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syCollectionQuery")
public class SyCollectionQueryController {

    @Autowired
    SyUnitPaymentQueryService syUnitPaymentQueryService;


    /**
     * 查询单位缴费中未做征缴计划的列表作为征缴计划列表
     *
     * @return
     */
    @RequestMapping(value = {"form", ""})
    public String form(Model model,HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        //查询缴费记录
        jsonObject.put("AAE143", CodeConstant.AAE143_AAE143_1);
        //查询未做计划的缴费记录
        jsonObject.put("AAE063", "-1");
        List<PM_AB88View> list = syUnitPaymentQueryService.findList(jsonObject);
        //将信息保存进session中,提交时取出
        request.getSession().setAttribute("formList",list);
        model.addAttribute("list", list);
        return "modules/sybx/syConllectionQuery/syConllectionForm";
    }

    /**
     * 征缴计划确认及打印
     * @param BAA005s
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("formSubmit")
    public String formSubmit(String[] BAA005s,HttpServletRequest request,HttpServletResponse response,Model model){
        //数据验证
        if(BAA005s!=null&&BAA005s.length>0) {
            //将前台选中数据进行解析
            StringBuilder baa005 = getBAA005(BAA005s);
            User user = UserUtils.getUser();
            JSONObject json = new JSONObject();
            json.put("BAA005", baa005.toString());
            json.put("AAE170", user.getAae170());
            json.put("AAB001", user.getAab001());
            json.put("BAA001", user.getBaa001());
            //主体编号
            json.put("BAE703", user.getAab001());
            //单位1，个人0  BAE702	主体类型
            json.put("BAE702", "1");
            List<PM_AB88View> list = syUnitPaymentQueryService.formSubmit(json);
            //打印清单
            printPDF(request, response, list);

        }else{
            model.addAttribute("message", "请在列表中至少选择一条征集计划");
        }
        return "forward:"+ Global.getAdminPath()+"/sybx/syCollectionQuery/form";
    }

    /**
     * 解析Baa005s
     * @param BAA005s
     * @return
     */
    private StringBuilder getBAA005(String[] BAA005s) {
        StringBuilder baa005 = new StringBuilder();
        int i = BAA005s.length;
        for (int j = 0; j < BAA005s.length; j++) {
            baa005.append("'"+BAA005s[j]+"'");
            if(j!=i-1) {
                baa005.append(",");
            }
        }
        return baa005;
    }

    /**
     * 打印 list清单
     * @param request
     * @param response
     * @param list
     */
    private void printPDF(HttpServletRequest request, HttpServletResponse response, List<PM_AB88View> list) {
        JSONObject jsonObject = null;
        if (list != null && list.size() > 0) {
            jsonObject = (JSONObject) JSONObject.toJSON(list.get(0));
            try {
                PostHelperUtils.exportPdf(jsonObject, request, response);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    /**
     * 查询历史征缴计划
     *
     * @param syab88
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "list")
    public String list(PM_AB88View syab88, Model model, HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        //查询征缴计划
        json.put("AAE143", CodeConstant.AAE143_AAE143_2);
        //查询未做计划的缴费记录
        json.put("AAE063", " ");
        //如果年份为空则查询近半年的征缴计划
        String startYm = syab88.getStartYM();
        String endYm = syab88.getEndYM();
        if (startYm == null) {
            Date date = DateUtils.addMonths(new Date(), -6);
            startYm = DateUtils.formatDate(date, "yyyyMM");
            endYm = DateUtils.formatDate(new Date(), "yyyyMM");
        }
        json.put("StartYM", startYm);
        json.put("EndYM", endYm);
        Page<PM_AB88View> page = new Page<PM_AB88View>(request, response);
        page = syUnitPaymentQueryService.findPageList(page, json);
        model.addAttribute("syab88", syab88);
        model.addAttribute("page", page);
        return "modules/sybx/syConllectionQuery/syConllectionList";
    }

    /**
     * 根据征集流水号，查询单位历史缴费核定
     *
     * @param aae063 征集流水号
     * @param model
     * @return
     */
    @RequestMapping("record")
    public String record(String aae063, Model model) {
        JSONObject json = new JSONObject();
        json.put("AAE063", aae063);
        //正常查询缴费记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        List<PM_AB88View> list = syUnitPaymentQueryService.findList(json);
        model.addAttribute("list", list);
        return "modules/sybx/syConllectionQuery/syConllectionRecord";
    }

    /**
     * 打印征集计划
     *
     * @return
     */
    @RequestMapping("exportPdf")
    public String exportPdf(String aae063, String aae003, HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        //补收记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_2);
        //险种失业保险
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //征集流水号
        json.put("AAE063", aae063);
        json.put("StartYM", aae003);
        json.put("EndYM", aae003);
        List<PM_AB88View> list = syUnitPaymentQueryService.findList(json);
        printPDF(request, response, list);
        return null;
    }
}