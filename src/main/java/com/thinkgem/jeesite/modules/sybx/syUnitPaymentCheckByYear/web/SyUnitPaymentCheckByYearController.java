package com.thinkgem.jeesite.modules.sybx.syUnitPaymentCheckByYear.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB88View;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentCheckByYear.entity.SyUnitPaymentCheckByYear;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentCheckByYear.service.SyUnitPaymentCheckByYearService;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentQuery.service.SyUnitPaymentQueryService;
import com.thinkgem.jeesite.modules.sybx.syywsljd.service.SyywsljdService;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 失业保险登记年检申请
 *
 * @author X_P
 * @create 2018-04-23 11:33
 */
@Controller
@RequestMapping("${adminPath}/sybx/syUnitPaymentCheckByYear")
public class SyUnitPaymentCheckByYearController {

    @Autowired
    SyUnitPaymentQueryService syUnitPaymentQueryService;

    @Autowired
    SyUnitPaymentCheckByYearService syUnitPaymentCheckByYearService;

    @Autowired
    SyywsljdService syywsljdService;

    @RequestMapping(value = "form")
    public String form(Model model, HttpServletRequest request, HttpServletResponse response) {
        //获取展示的单位基本数据
        User user = UserUtils.getUser();
        SyUnitPaymentCheckByYear syUnitPaymentCheckByYear = getSyUnitPaymentCheckByYear(user);
        model.addAttribute("syCheckByYear", syUnitPaymentCheckByYear);
        //根据基本数据判断年审是否通过 BAA008=1通过
        if (isPass(syUnitPaymentCheckByYear)) {
            model.addAttribute("msg", "您的年审已经通过了，请在进度查询中查看");
        } else {
            //查询年审进度的最近一条数据
            JSONObject checkForYear = this.findcheckForYear(user);
            //判断这条数据是否为去年提交的数据
            if (isSubmit(checkForYear)) {
                //是去提交的数据则进行状态判断
                if("办结".equals(checkForYear.get("Saa043"))){
                    model.addAttribute("msg", "您上次的申请已经被拒绝,请到经办机构办理");
                }else{
                    //说名已经提交过年审，流程未走完，则直接跳转
                    model.addAttribute("msg", "您已经申请过年审,请到经办机构提交资料完成后续流程");
                    return "modules/sybx/syUnitPaymentCheckByYear/syUnitPaymentCheckByYearList";
                }
            }else {
                //封装参数
                JSONObject json = new JSONObject();
                //获取待转基金数
                Double fund = syUnitPaymentCheckByYearService.findFund();
                //获取上一年的所有缴费信息
                Page page = new Page<PM_AB88View>(request, response);
                //获取上一年的
                Date date = DateUtils.addYears(new Date(), -1);
                json.put("StartYM", DateUtils.formatDate(date, "yyyy") + "01");
                json.put("EndYM", DateUtils.formatDate(date, "yyyy") + "12");
                //正常查询缴费记录
                json.put("AAE143", CodeConstant.AAE143_AAE143_1);
                List<PM_AB88View> paymentInfo = syUnitPaymentQueryService.findList(json);
                //统计所有费用
                BigDecimal sum = new BigDecimal(0.00);
                BigDecimal realysum = new BigDecimal(0.00);
                //根据参保时间获取应该判断的缴费月数
                //Integer num = getNumByUnitInfo(syUnitPaymentCheckByYear);
                for (PM_AB88View pm_ab88View : paymentInfo) {
                    //应缴费用
                    sum = sum.add(BigDecimal.valueOf(Double.parseDouble(pm_ab88View.getAAB137())));
                    if (pm_ab88View.getBAE707().equals("已结算")) {
                        //实缴数据
                        realysum = realysum.add(BigDecimal.valueOf(Double.parseDouble(pm_ab88View.getAAB137())));
                       // if (pm_ab88View.getAAE143().equals("1")) {
                            //统计完成缴费的月数，足够12个月才能提交
                            //num++;
                        //}
                    }
                }
                BigDecimal b = sum.subtract(realysum);
                Double locksum = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                page = PostHelperUtils.getPage(page, paymentInfo, 20);
                model.addAttribute("sum", sum);
                model.addAttribute("fund", fund);
                model.addAttribute("realysum", realysum);
                model.addAttribute("locksum", locksum);
                //model.addAttribute("num", num);
                model.addAttribute("page", page);
            }
        }
        return "modules/sybx/syUnitPaymentCheckByYear/syUnitPaymentCheckByYearList";
    }

    /**
     * 年审申请提交
     * @return
     */
    @RequestMapping("submit")
    public String submit(Model model){
        User user = UserUtils.getUser();
        JSONObject json = new JSONObject();
        // AAE170	操作人	是
        json.put("AAE170", user.getAae170());
        //AAB001	单位编号	是
        json.put("AAB001", user.getAab001());
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //SAA015	功能id	是
        json.put("SAA015", CodeConstant.SAA015_SAA015_M4010);
        //BAE702	主体类别(0个人,1单位)	是
        json.put("BAE702", CodeConstant.BAE702_BAE702_1);
        //        BAE703	主体编号	是
        json.put("BAE703", user.getAab001());
        //        SAA043	业务状态	是
        json.put("SAA043", CodeConstant.SAA043_SAA043_3);
        //SAA004	事项id	是
        json.put("SAA004", " ");
        //        SAA037	申请人	是
        json.put("SAA037", user.getAae170());
        //        SAA038	申请时间	是
        json.put("SAA038", CommonUtility.get19BitCurTimeAPP());
        //BAA001	数据分区	是
        json.put("BAA001", user.getBaa001());
        json.put("AAB034", user.getBaa001());
        //SAA036	受理单ID	是
        json.put("SAA036", "XY" + GenerateSequenceUtil.generateSequenceNo());
        json.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo());
        json.put("SZZ003", " ");
//        SZZ003	服务机构ID	是

        JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.SY_ADD_ACCEPT_INFO, json.toString());
        //获取上年年份
        /*String  year = String.valueOf(Integer.parseInt(DateUtils.getYear())-1);
        json.put("SAA040", year);*/
        model.addAttribute("message", "年审提交成功");
        return "forward:"+ Global.getAdminPath()+"/sybx/syUnitPaymentCheckByYear/form";
    }

    /**
     * 获取年审进度查询到的最近一条信息
     *
     * @param user
     * @return
     */
    private JSONObject findcheckForYear(User user) {
        JSONObject json = new JSONObject();
        //必传字段
        json.put("Action", "3");
        json.put("BAA001", user.getBaa001());
       // json.put("SAA037", user.getLoginName());
        //AAE170	操作人
        //json.put("AAE170", user.getAae170());
        json.put("BAE703", user.getAab001());
        //AAB001	单位编号
        //json.put("AAB001", user.getAab001());
        json.put("SAA043", "");
        // 功能ID
        json.put("SAA015", CodeConstant.SAA015_SAA015_M4010);
        Page schedules = syywsljdService.findList(new Page(), json.toString());
        List list = schedules.getList();
        if (list.size() > 0) {
            //有提交数据则取出最近1条进行年份判断
            return (JSONObject) list.get(0);
        }
        return null;
    }

    /**
     * 判断当前用户是否完成年审
     *
     * @param syUnitPaymentCheckByYear 年审使用的对象，从user中获取数据
     * @return 是否通过年审
     */
    private boolean isPass(SyUnitPaymentCheckByYear syUnitPaymentCheckByYear) {
        String baa008 = syUnitPaymentCheckByYear.getBAA008();
        return "1".equals(baa008);
    }

    /**
     * 通过单位参保时间计算去年应该满足的缴费月数与12个月数的差值。
     *
     * @param syUnitPaymentCheckByYear 单位基本信息的简化版
     * @return
     */
    private Integer getNumByUnitInfo(SyUnitPaymentCheckByYear syUnitPaymentCheckByYear) {
        Integer num = 0;
        Date date = DateUtils.parseDate(syUnitPaymentCheckByYear.getAAB050());
        Date date1 = DateUtils.addYears(new Date(), -1);
        if (DateUtils.formatDate(date, "yyyy").equals(DateUtils.formatDate(date1, "yyyy"))) {
            //上年开始参保的。
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            num = c.get(Calendar.MONTH);
        }
        return num;
    }

    /**
     * 获取前台显示的基本数据
     *
     * @return
     */
    private SyUnitPaymentCheckByYear getSyUnitPaymentCheckByYear(User user) {
        JSONObject jsonObject = getUnitInfo(user);
        SyUnitPaymentCheckByYear syUnitPaymentCheckByYear = JSONObject.parseObject(jsonObject.toString(), SyUnitPaymentCheckByYear.class);
        syUnitPaymentCheckByYear.setAAB001(user.getAab001());
        syUnitPaymentCheckByYear.setAAB004(user.getAab004());
        syUnitPaymentCheckByYear.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - 1));
        return syUnitPaymentCheckByYear;
    }

    /**
     * 根据登录用户获取单位基本信息
     *
     * @param user
     * @return
     */
    private JSONObject getUnitInfo(User user) {
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());
        json.put("AAB001", user.getAab001());
        json.put("BAA001", user.getBaa001());
        JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_BASICINFOQUERY, json.toString());
        json = PostHelperUtils.toParseJSONObject(jsonInfo);
        return json;
    }

    /**
     *  判断是否去年有提交的数据
     * @param json
     * @return
     */
    private boolean isSubmit(JSONObject json) {
        if (json != null) {
            String saa040 = json.getString("Saa040");
            String year = saa040.substring(0, 4);
           /* Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.YEAR,-1);
            Date time = c.getTime();*/
            return DateUtils.formatDate(new Date(), "yyyy").equals(year);
        }
        return false;
    }
}