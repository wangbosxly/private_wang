package com.thinkgem.jeesite.modules.sybx.syUnitPaymentCheck.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.entity.PM_AC01;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB88View;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC88View;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentCheck.service.SyUnitPaymentCheckService;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentQuery.service.SyUnitPaymentQueryService;
import com.thinkgem.jeesite.modules.sybx.syUnitRepairCheck.entity.SyUnitRepairCheck;
import com.thinkgem.jeesite.modules.sybx.syUnitRepairCheck.service.SyUnitRepairCheckService;
import com.thinkgem.jeesite.modules.sybx.syryjfcx.service.SyRyjfcxService;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 单位缴费核定
 *
 * @author X_P
 * @create 2018-03-27 9:18
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syUnitPaymentCheck")
public class SyUnitPaymentCheckController {

    @Autowired
    private SyUnitPaymentCheckService syUnitPaymentCheckService;

    @Autowired
    private SyRyjfcxService syRyjfcxService;

    @Autowired
    private SyUnitPaymentQueryService syUnitPaymentQueryService;

    @Autowired
    private SyUnitRepairCheckService syUnitRepairCheckService;

    /**
     * 显示单位缴费核定页面
     *
     * @param syab88
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = {"form", ""})
    public String form(PM_AB88View syab88, HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) {
        Calendar calendar = Calendar.getInstance();
        int d = calendar.get(Calendar.DATE);
        if (d >= 15) {
            // 增加后台时间校验  允许每月1-15号使用该功能
            model.addAttribute("checkDate","每月1-15号开通该功能");
        }
        //查询单位近半年缴费记录，参数均为后台参数
        Page page = new Page<PM_AB88View>(request, response);
        List<PM_AB88View> resultList = syUnitPaymentCheckService.getList();
        //将list中第一个数据的缴费存入session中,以供后面使用（第一个数据为最后的缴费月份）。
        String lastPaymentMonth = (resultList != null && resultList.size() > 0) ? resultList.get(0).getAAE002() : "";
        session.setAttribute("lastPaymentMonth", lastPaymentMonth);
        //分页每页显示20条数据
        page = PostHelperUtils.getPage(page, resultList, 20);
        model.addAttribute("page", page);
        User user = UserUtils.getUser();
        syab88.setAAB004(user.getAab004());
        syab88.setAAB001(user.getAab001());
        model.addAttribute("syab88", syab88);
        return "modules/sybx/syUnitPaymentCheck/syUnitPaymentCheckList";
    }

    /**
     * 查询本期人员异动详细信息，根据异动类型
     *
     * @return
     */
    @RequestMapping("changeInfo")
    public String getPersonChangeInfo(HttpServletRequest request, Model model) {
        JSONObject json = new JSONObject();
        json.put("AAC050", request.getParameter("bac720"));
        json.put("AAE035", request.getParameter("aae002"));
        json.put("AAE002", request.getParameter("aae002"));
        List<PM_AC01> list = syUnitPaymentCheckService.getPersonChangeInfo(json);
        model.addAttribute("list", list);
        return "modules/sybx/syUnitPaymentCheck/personChangeInfo";
    }

    /**
     * 查询（当期）人员异动信息
     *
     * @param request 传递费款所属期 aae002
     * @param model
     * @return
     */
    @RequestMapping(value = "changeList")
    public String getPersonChangeList(HttpServletRequest request, Model model) {
        //封装数据
        JSONObject json = new JSONObject();
        //费款所属期
        String aae002 = request.getParameter("aae002");
        json.put("AAE002", aae002);
        json.put("AAE035", aae002);
        //正常应交记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        List<PM_AC01> list = syUnitPaymentCheckService.getPersonChangeList(json);
        //接口已经进行了分页，此处数据量少。
        model.addAttribute("list", list);
        model.addAttribute("aae002", aae002);
        return "modules/sybx/syUnitPaymentCheck/personChangeList";
    }

    /**
     * 人员缴费列表
     *
     * @param pm_ac88view
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "personList")
    public String getPersonList(PM_AC88View pm_ac88view, HttpServletRequest request, HttpServletResponse response, Model model) {
        //封装前台参数，后台参数service层传递
        Page page = new Page<PM_AC88View>(request, response);
        JSONObject json = new JSONObject();
        json.put("AAE003", pm_ac88view.getAAE003());
        json.put("AAE002", pm_ac88view.getAAE002());
        //缴费类型
        json.put("AAE143", pm_ac88view.getAAE143());
        //调用接口查询数据
        page = syRyjfcxService.getPageList(page, json);
        model.addAttribute("pm_ac88view", pm_ac88view);
        model.addAttribute("page", page);
        return "modules/sybx/syUnitPaymentCheck/personPaymentList";
    }

    /**
     * 历史征集计划查询
     */
    @RequestMapping("CollectionList")
    public String getCollectionList(String aae063, Model model) {
        JSONObject json = new JSONObject();
        json.put("AAE063", aae063);
        //正常查询缴费记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        List<PM_AB88View> list = syUnitPaymentQueryService.findList(json);
        model.addAttribute("list", list);
        return "modules/sybx/syUnitPaymentCheck/ConllectionList";
    }

    /**
     * 单位缴费审核页面
     */
    @RequestMapping("check")
    public String check(PM_AB88View syab88, HttpServletRequest request, HttpSession session, Model model) {
        //数据验证=========
        User user = UserUtils.getUser();
        if(isNotRight(syab88, session, user)){//判断获取的日期（AAE002）是否正确
            String message = (String) session.getAttribute("monthMessage");
            model.addAttribute("message", message);
            session.removeAttribute("monthMessage");
            return "forward:"+Global.getAdminPath()+"/sybx/syUnitPaymentCheck";
        }
        //准备参数
        JSONObject json = getJson(user, request);
        //计划审核调用接口
        List<PM_AB88View> list = syUnitPaymentQueryService.getCheckInfo(json);
        //将接口调用结果保存进session中，以备后面取用
        session.setAttribute("subList", list);
        //调用接口查询近半年缴费信息
        List<PM_AB88View> resultList = syUnitPaymentCheckService.getList();
        //调用接口查询人员异动信息
        String aae002 = request.getParameter("AAE002");
        json.put("AAE002", aae002);
        json.put("AAE035", aae002);
        List<PM_AC01> personChangeList = syUnitPaymentCheckService.getPersonChangeList(json);
        model.addAttribute("resultList", resultList);
        model.addAttribute("personChangeList", personChangeList);
        model.addAttribute("syab88", syab88);
        model.addAttribute("aae002", aae002);
        model.addAttribute("list", list);
        return "modules/sybx/syUnitPaymentCheck/conllectionCheckList";
    }

    /**
     * 判断缴费核定的日期是否正确，如果错误将错误信息存入session
     * @param syab88
     * @param session
     * @param user
     * @return
     */
    private boolean isNotRight(PM_AB88View syab88, HttpSession session, User user) {
        Date choose = null;
        String message = null;
        //允许缴费的日期
        Date rightMonth;
        //当前的日期
        Date now = new Date();
        try {
            choose = DateUtils.parseDate(syab88.getAAE002(), "yyyyMM");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //获取正确的缴费核定日期
        rightMonth = getRightDate(user, session);
        if (DateUtils.isBigger(choose, now)) {
            message = "不能提前核定下个月或更迟月份缴费";
        }else if(rightMonth==null){
            //如果正确缴费核定日期不存在，表示该单位由于超期限不能在网上办理缴费业务
            message = "超过" + CodeConstant.SY_MAXMONTH + "个月未进行缴费核定，请前往柜台办理业务";
        } else if (DateUtils.isBigger(choose,rightMonth)) {
            //如果选择时间不等于正确的审核缴费日期则提示不能审核
            DateFormat df = new SimpleDateFormat("yyyyMM");
            String format = df.format(rightMonth);
            message = "请核定以前未核定" + format + "月份的单位缴费,不可核定此后的单位缴费！";
        }else if(DateUtils.isBigger(rightMonth,choose)){
            message = "该时期没有可核定的缴费信息或已经完成缴费核定,请重新选择";
        }
        session.setAttribute("monthMessage",message);
        return message!=null;
    }

    /**
     * 获取正确的缴费日期，如果长期未缴费(3个月)，则返回null.
     * @param user
     * @param session
     * @return
     */
    private Date getRightDate(User user, HttpSession session) {
        Date rightMonth = null;
        Date lastMonth = null;
        //获取近半年的最近的缴费日期作为最后的缴费日期
        String lastPaymentMonth = (String) session.getAttribute("lastPaymentMonth");
        try {
            //将字符串转化为Date
            lastMonth =StringUtils.isEmpty(lastPaymentMonth)?null:DateUtils.parseDate(lastPaymentMonth, "yyyyMM");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //如果近半年没有缴费
        if (lastMonth==null){
            //判断是否为新参保单位
            if(isNewUnit(user)) {
                rightMonth = getAAB050Date(user);
            }
        }else if(isGoodMonth(lastMonth)){
            //近半年有缴费则判断是否长期未缴费(是不是一个好单位)
            rightMonth = DateUtils.addMonths(lastMonth, 1);
        }
        return rightMonth;
    }


    /**
     * 判断单位是否为新参保单位，参保时间不超过3个月。前提是没有缴费
     * @param user 用户对象
     * @return 是新参保
     */
    private boolean isNewUnit(User user) {
        String aab036 = getAAB050(user);
        Date lastMonth = null;
        try {
           lastMonth =StringUtils.isEmpty(aab036)?null:DateUtils.parseDate(aab036, "yyyyMM");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isGoodMonth(lastMonth);
    }

    /**
     * 判断月份是否在当前月到过去三个月之间（在近3个月内）
     * @param lastMonth 日期
     * @return boolean
     */
    private boolean isGoodMonth(Date lastMonth) {
        if(lastMonth==null){
            return false;
        }
        int month = DateUtils.getMouthOfTwoDate(lastMonth, new Date());
        return (CodeConstant.SY_MAXMONTH-month)>=0;
    }

    /**
     * 查询单位基本信息接口，获取单位的参保时间
     * @param user 用户对象
     * @return 单位参保时间Date
     */
    private Date getAAB050Date(User user) {
        String aab050 = getAAB050(user);
        Date start = null;
        if(StringUtils.isNotBlank(aab050)) {
            try {
                start = DateUtils.parseDate(aab050, "yyyyMM");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return start;
    }

    /**
     * 获取单位的参保时间
     * @param user 用户对象
     * @return 参保时间 string yyyyMM
     */
    private String getAAB050(User user) {
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());
        json.put("AAB001", user.getAab001());
        json.put("BAA001", user.getBaa001());
        JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_BASICINFOQUERY, json.toString());
        json = PostHelperUtils.toParseJSONObject(jsonInfo);
        return (json != null ? json.getString("AAB050") : null);
    }

    /**
     * 提交缴费核定
     *
     * @param request 请求对象
     * @param model map
     * @return 提交成功后返回list页面，失败则回显当前页面
     */
    @RequestMapping("submit")
    public String submit(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        User user = UserUtils.getUser();
        //从session中获取查询到的缴费信息
        List<PM_AB88View> subList = (List<PM_AB88View>) session.getAttribute("subList");
        //如果session中没有数据的话重新查询
        if (subList == null || subList.size() == 0) {
            JSONObject json = getJson(user, request);
            subList = syUnitPaymentQueryService.getCheckInfo(json);
        }
        //准备参数
        JSONObject json = (JSONObject) JSONObject.toJSON(subList.get(0));
        //添加必要参数
        json.put("SAA015", CodeConstant.SAA015_SAA015_M4007);
        json.put("AAE170", user.getAae170());
        json.put("BAA001", user.getBaa001());
        json.put("AAB001", user.getAab001());
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //主体类别
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
        String message = syUnitPaymentCheckService.submit(json);
        model.addAttribute("message", message);
        //提交完毕后清除session
        session.removeAttribute("subList");
        return "forward:" + Global.getAdminPath() + "/sybx/syUnitPaymentCheck/form";
    }

    /**
     * 封装缴费核定查询信息
     *
     * @return 封装好的查询入参对象
     */
    private JSONObject getJson(User user, HttpServletRequest request) {
        String aae002 = request.getParameter("AAE002");
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());
        json.put("BAA001", user.getBaa001());
        json.put("AAB001", user.getAab001());
        //险种
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //费款所属期
        json.put("StartYM", aae002);
        json.put("EndYM", aae002);
        return json;
    }

    /**
     * 下载明细
     *
     * @param baa005
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("export")
    public String export(String baa005, HttpServletResponse response, Model model) {
        User user = UserUtils.getUser();
        JSONObject json = new JSONObject();
        json.put("BAA005", baa005);
        json.put("AAE170", user.getAae170());
        json.put("AAB001", user.getAab001());
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //设置缴费类别
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        //主体类别
        json.put("BAE702", CodeConstant.BAE702_BAE702_1);
        json.put("BAE703", user.getAab001());
        //SAA037	申请人
        json.put("SAA037", user.getAae011());
        //SAA038	申请时间
        json.put("SAA038", DateUtils.formatDateTime(new Date()));
        json.put("SAA015", "M4007");
        json.put("SAA004", " ");
        //服务机构id
        json.put("SZZ003", " ");
        List<SyUnitRepairCheck> list = syUnitRepairCheckService.export(json);
        try {
            new ExportExcel("单位人员缴费核定信息", SyUnitRepairCheck.class).setDataList(list).write(response, "单位人员缴费核定信息.xlsx").dispose();
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "单位人员缴费核定信息导出失败！失败信息：" + e.getMessage());
        }
        return null;
    }
}