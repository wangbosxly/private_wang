package com.thinkgem.jeesite.modules.sybx.sywgbt.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB88View;
import com.thinkgem.jeesite.modules.sybx.syUnitPaymentQuery.service.SyUnitPaymentQueryService;
import com.thinkgem.jeesite.modules.sybx.sywgbt.entity.SyWgbt;
import com.thinkgem.jeesite.modules.sybx.sywgbt.service.SyWgbtService;
import com.thinkgem.jeesite.modules.sybx.syywsljd.service.SyywsljdService;
import com.thinkgem.jeesite.modules.sybx.util.LoseJobConstants;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import net.sf.jasperreports.engine.JRException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author XuePan
 * @date 2018/4/2
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/sywgbt/web_sywgbt")
public class SyWgbtController extends BaseController {
    static final Map<String, String> symap = new HashMap<>();

    static {
        symap.put("BJC408","AJC093");
        symap.put("BJC409","AJC094");
        symap.put("BJC410","AJC095");
        symap.put("BJC411","AJC092");
        symap.put("BJC403","AJC097");
        symap.put("BJC400","AJC096");
    }
    @Resource
    private SyWgbtService syWgbtService;

    @Autowired
    private SyUnitPaymentQueryService syUnitPaymentQueryService;

    @Autowired
    private SyywsljdService syywsljdService;

    /**
     * 进入稳岗补贴查询，根据不同的阶段显示不同的页面
     * 如果已经开始稳岗申报阶段则不必验证申请阶段，申报的前提是申请已经完成
     */
    @RequestMapping(value = {"list", ""})
    public String list(Model model, HttpSession session,HttpServletRequest request,HttpServletResponse response) {
        //如果页面为空则对稳岗补贴申请阶段进行验证
        String url = validateApply(model, request, response);
        //判断是否进入稳岗补贴申报阶段，如果进入，获取当前阶段的页面,并传递提示信息。
        if("modules/sybx/sywgbt/sy_sywgbtForm".equals(url)) {
            validateSubsidized(model, request, response);
        }
        //准备页面显示的基本数据,获取单位去年缴费信息
        Map<String,String> lastMoney = getLastMoney(session);
        model.addAttribute("lastMoney", lastMoney);
        User user = UserUtils.getUser();
        // 调用接口查询单位基本信息
        JSONObject unit = this.getUnit(user);
        model.addAttribute("user", user);
        model.addAttribute("unit", unit);
        model.addAttribute("syWgbt", new SyWgbt());
        model.addAttribute("AAE002", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-1));
        //设置接口查询条件,查询历史稳岗信息
        JSONArray array = this.getArray(user);
        model.addAttribute("array", array);
        return url;
    }

    /**
     * 验证是否在稳岗补贴申请阶段，如果在则获取申请阶段的页面，提示信息用model传回
     * @param model
     * @param request
     * @param response
     * @return
     */
    private String validateApply(Model model, HttpServletRequest request, HttpServletResponse response) {
        //获取最近的一条稳岗补贴申请记录
        JSONObject info = this.getLastInfo(CodeConstant.SAA015_SAA015_M4022);
        if(info!=null&&isSubmit(info)){
            //申请过，但核心后台还没有处理，不能再次申请，等待处理
            if("预审".equals(info.get("Saa043"))) {
                model.addAttribute("SAA043", "预审");
                model.addAttribute("msg", "稳岗补贴申请已经提交,请等待审核结果");
            }else if("办结".equals(info.get("Saa043"))){
                //如果是办结则查询进度明细，判断是审核通过还是被拒绝
                JSONObject detailInfo = getLastM4022Info(model, request, response, info);
                if("2".equals(detailInfo.getString("TAA103"))){
                    model.addAttribute("message", "审核未通过,请在受理进度页面查询原因,更正后重新申请");
                }else{
                    //审核通过，可以进行申报
                    model.addAttribute("Maxmoney", detailInfo.getString("AAC003"));
                    //存入session,后续验证提交金额时使用
                    request.getSession().setAttribute("Maxmoney",detailInfo.getString("AAC003"));
                    return "modules/sybx/sywgbt/sy_sywgbtForm";
                }
            }
        }
        return "modules/sybx/sywgbt/sy_sywgbtList";
    }

    /**
     * 获取历史稳岗信息
     * @param user
     * @return
     */
    private JSONArray getArray(User user) {
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());
        json.put("AAB001", user.getAab001());
        json.put("BAA001", user.getBaa001());
        jsonArray.add(json);
        return syWgbtService.findList(jsonArray.toString());
    }

    /**
     * 获取单位基本信息,这个方法应该提取到公共父类中。以后注意
     * @param user
     * @return
     */
    private JSONObject getUnit(User user) {
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());
        json.put("AAB001", user.getAab001());
        json.put("BAA001", user.getBaa001());
        JSONObject unit = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_BASICINFOQUERY, json.toString());
        unit = PostHelperUtils.toParseJSONObject(unit);
        return unit;
    }

    /**
     * 异步验证人数
     * @param BJC409
     * @param session
     * @return
     */
   @ResponseBody
    @RequestMapping("validatePerson")
    public  boolean validatePerson(Integer BJC409,HttpSession session){
       Map<String, String> lastMoney = (Map<String, String>) session.getAttribute("lastMoney");
       int personNum = Integer.parseInt(lastMoney.get("personNum"));
       return BJC409<=personNum;
    }

    /**
     * 异步验证补贴金额
     * @param BJC410
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("validateGrant")
    public  boolean validateGrant(Float BJC410,HttpSession session){
        Map<String, String> lastMoney = (Map<String, String>) session.getAttribute("lastMoney");
        float grant = Float.parseFloat(lastMoney.get("grant"));
        return BJC410<=grant;
    }

    /**
     *  判断是否今年有提交的数据
     * @param json
     * @return
     */
    private boolean isSubmit(JSONObject json) {
        if (json != null) {
            String saa040 = json.getString("Saa040");
            String year = saa040.substring(0, 4);
            return DateUtils.formatDate(new Date(), "yyyy").equals(year);
        }
        return false;
    }

    /**
     * 申请稳岗补贴,先根据最后一条申请记录判断是否已经申请过，如果没有申请过
     * 则可以继续执行申请流程，申请过则直接返回页面提示已经申请过
     * 在申请流程执行前需判断 年审是否通过、上年缴费是否满足12个月，
     * @param model
     * @return
     */
    @RequestMapping(value = "form")
    public String form(Model model, HttpServletRequest request,HttpSession session,SyWgbt syWgbt){
        String message = null;
        User user = UserUtils.getUser();
        //检测用户是否满足申请稳岗的要求，如果不满足要求则返回不满足的信息
        message = validateUser(user, session);
        if(message==null){
            //参数封装
            JSONObject json = new JSONObject();
            json.put("AAE170", user.getAae170());
            json.put("AAB001", user.getAab001());
            json.put("AAE140", CodeConstant.AAE140_AAE140_2);
            json.put("SAA015", CodeConstant.SAA015_SAA015_M4022);
            json.put("BAE702", CodeConstant.BAE702_BAE702_1);
            json.put("BAE703", user.getAab001());
            json.put("SAA043", CodeConstant.SAA043_SAA043_3);
            json.put("SAA004", " ");
            json.put("SAA037", user.getAae170());
            json.put("SAA038", CommonUtility.get19BitCurTimeAPP());
            json.put("BAA001", user.getBaa001());
            json.put("AAB034", user.getBaa001());
            json.put("SAA036", "XY" + GenerateSequenceUtil.generateSequenceNo());
            json.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo());
            //获取上年年份
            String  year = String.valueOf(Integer.parseInt(DateUtils.getYear())-1);
            json.put("AAE002", year);
            //稳岗补贴类型TYPE=BJB003
            json.put("BJC003", request.getParameter("BJB003"));
            json.put("BJC408", "0");//养老保险补贴人数
            json.put("AJC093", "0");//养老保险补贴总金额
            json.put("BJC409", "0");//医疗保险补贴人数
            json.put("AJC094", "0");//医疗保险补贴总金额
            json.put("BJC410", "0");//失业保险补贴人数
            json.put("AJC095", "0");//失业保险补贴总金额
            json.put("BJC411", "0");//生活补贴/岗位补贴人数
            json.put("AJC092", "0");//生活补贴/岗位补贴总额
            json.put("BJC403", "0");//技能提升培训人数
            json.put("AJC097", "0");//技能提升培训总额
            json.put("BJC400", "0");//转岗培训补贴人数
            json.put("AJC096", "0");//转岗培训补贴总额
            //借用BJC408字段传递补贴项目类型，BJC409传递人数，BJC410传递金额
            json.put(syWgbt.getBJC408(),syWgbt.getBJC409());//保存人数
            //已经使用缓存map保存人数与总额的对应关系，这里直接获取即可
            json.put(symap.get(syWgbt.getBJC408()), syWgbt.getBJC410());//保存金额
            //补贴比例写死0.5
            json.put("BJC602", "0.5");
            Map<String, String> lastMoney = this.getLastMoney(session);
            //上年企业缴费总额
            json.put("AJC053", lastMoney.get("realysum"));
            //补贴上限
            json.put("AJC159", lastMoney.get("grant"));
            json.put("TAA103", "0");//审核结果
            json.put("TAA105", "1");//申报来源
            JSONObject jsonInfo = PostHelperUtils.getJSONInfo(LoseJobConstants.UNIT_WGBT, json.toString());
            message = "稳岗补贴申请成功";
            if(!PostHelperUtils.hasInfo(PostHelperUtils.toParseJSONObject(jsonInfo))){
                message = "稳岗补贴申请失败";
            }
        }
        model.addAttribute("message",message);
        return "forward:" + Global.getAdminPath() + "/sybx/sywgbt/web_sywgbt/list";
    }

    /**
     * 检测用户状态是否满足申请稳岗的要求
     * @param user
     * @param session
     * @return
     */
    private String validateUser(User user, HttpSession session) {
        String message = null;
        JSONObject unit = this.getUnit(user);
        //获取单位上年缴费信息
        Map<String,String> lastMoney = getLastMoney(session);
        //验证是否允许申请
        JSONObject info = this.getLastInfo(CodeConstant.SAA015_SAA015_M4022);
        if(info!=null&&isSubmit(info)){
            message = "已经申请过稳岗补贴,请在受理进度页面查询申请进度";
        }else if(!"1".equals(unit.getString("BAA008"))){
            message = "年审未通过，不能进行稳岗补贴申请";
        }else if(!"12".equals(lastMoney.get("num"))){
            message = "去年缴费不满12个月不能申请稳岗补贴";
        }
        return message;
    }

    /**
     * 导出人员明细
     */
    @RequestMapping(value = "downloadExcel")
    public String downloadExcel(HttpServletResponse response, RedirectAttributes redirectAttribute, String baz005) {
        //获取系统信息
        User user = UserUtils.getUser();
        //设置接口参数
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());//操作人
        json.put("AAB001", user.getAab001());//单位编号
        json.put("BAA001", user.getBaa001());//数据分区
        json.put("BAZ005", baz005);//批量流水号
        jsonArray.add(json);
        //接受交口调用结果
        List<SyWgbt> list = syWgbtService.downloadExcelFile(jsonArray.toString());
        try {
            if (list != null) {
                String fileName = "稳岗补贴人员明细" + ".xls";
                new ExportExcel("稳岗补贴人员明细", SyWgbt.class).setDataList(list).write(response, fileName).dispose();
            }
        } catch (IOException e) {
            e.printStackTrace();
            addMessage(redirectAttribute, "导出稳岗补贴人员明细失败！失败信息：" + e.getMessage());
        }
        return "modules/sybx/sywgbt/sy_sywgbtList";
    }

    /**
     * 提交审核
     */
    @RequestMapping(value = "examine", method = RequestMethod.POST)
    public String importFile(Model model, MultipartFile file,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
        String fileName = file.getOriginalFilename();
        String strArr = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        if (!"xls".equals(strArr) && !"xlsx".equals(strArr)) {
            model.addAttribute("msg","不是支持的文件格式请使用excel文件做批量上传!");
            list(model,session,request,response);
            return "modules/sybx/sywgbt/sy_sywgbtList";
        }
        //获取第一步稳岗申请的信息
        JSONObject info = this.getLastInfo(CodeConstant.SAA015_SAA015_M4022);
        //获取进度明细
        JSONObject detailInfo = getLastM4022Info(model, request, response, info);
        //获取系统信息
        User user = UserUtils.getUser();
        String saa036 = "XY" + GenerateSequenceUtil.generateSequenceNo();// 受理单ID
        try {
            ImportExcel ei = new ImportExcel(file, 1, 0);
            List<SyWgbt> list = ei.getDataList(SyWgbt.class);
            list.remove(list.size() - 1);
            JSONArray jsonArray = new JSONArray();
            for (SyWgbt syWgbt : list) {
                JSONObject json = new JSONObject();
                // 文件参数
                json.put("BUS_ID",info.getString("Saa036"));
                json.put("AAC001", syWgbt.getAAC001());// 组织人员编号
                if(StringUtils.isEmpty(syWgbt.getAAC001())){
                    continue;
                }
                json.put("AAC002", syWgbt.getAAC002());//身份证
                json.put("AAC003", syWgbt.getAAC003());//姓名
                json.put("AAE030", syWgbt.getAAE030());//培训/申报日期
                json.put("BJC400", syWgbt.getBJC400());//转岗培训补贴
                json.put("BJC403", syWgbt.getBJC403());//技能提升培训补贴
                json.put("BJC408", syWgbt.getBJC408());//养老保险补贴
                json.put("BJC409", syWgbt.getBJC409());//医疗保险补贴
                json.put("BJC410", syWgbt.getBJC410());//失业保险补贴
                json.put("BJC411", syWgbt.getBJC411());//生活补贴/岗位补贴
                // 其他
                json.put("AAB001", user.getAab001());//单位编号
                json.put("AAE170", user.getAae170());//操作人
                json.put("BAA001", user.getBaa001());//数据分区
                json.put("SAA015", "M4020");//功能id
                json.put("SAA004", " ");//事项
                json.put("SZZ003", " ");//服务机构id
                json.put("BAE702", "1");//用户类别
                json.put("BAE703", user.getAab001());//主体编号
                json.put("SAA036", saa036);//受理单id
                json.put("SAA037", user.getLoginName());//申请人
                json.put("SAA038", CommonUtility.get19BitCurTimeAPP());// 申请时间
                json.put("SAA043", "1");//业务状态
                json.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo());//组织申报流水号
                json.put("AAE011", user.getAae170());//经办人
                json.put("AAE036", CommonUtility.get19BitCurTimeAPP());//经办时间
                json.put("AAB004", info.getString("Saa041"));//公司名称
                json.put("AAE002", detailInfo.getString("AAC002"));//申报年份
                json.put("BJB003", detailInfo.getString("AAC001"));//补贴类别
                json.put("TAA101", detailInfo.getString("TAA101"));// ★申报时间
                json.put("TAA103", "0");/// 审核结果,0待审核,1审核通过,2审核不通过
                json.put("TAA105", "1");//申报来源,1网上大厅
                jsonArray.add(json);
            }
            try {
                HashMap bakmap = syWgbtService.examineFile(jsonArray,model);
                if (bakmap != null) {
                    //JSONObject jsonObject = null;
                    JSONObject examineVO = (JSONObject) bakmap.get("examineVO");
                    Page JC20ERR = (Page) bakmap.get("JC20ERR");
                   /* if(!JC20ERR.getList().isEmpty()) {
                        jsonObject = (JSONObject) JC20ERR.getList().get(0);
                    }*/
                    JSONObject unitInfoBack = (JSONObject) bakmap.get("unitInfoBack");
                    model.addAttribute("SAA036",saa036);
                    model.addAttribute("examineVO",examineVO);
                    model.addAttribute("pagination_err",JC20ERR);
                    model.addAttribute("unitInfoBack",unitInfoBack);
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message","稳岗补贴申报业务办理失败");
            }
        } catch ( IOException | IllegalAccessException | InstantiationException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return "modules/sybx/sywgbt/sy_sywgbtResult";
    }

    private JSONObject getLastM4022Info(Model model, HttpServletRequest request, HttpServletResponse response, JSONObject info) {
        Page page = this.getDetailInfo(info.getString("Saa036"), request, response, model);
        List detailInfos = page.getList();
        return (JSONObject) detailInfos.get(0);
    }

    /**
     * 导出成功人员明细
     */
    @RequestMapping(value = "eligibleExp")
    public String eligibleExp (String BAZ005, String SAA036, HttpServletResponse response) {
        List<SyWgbt> list = prepareSyWgbt(BAZ005, SAA036);
        if (list != null) {
            String fileName = "稳岗补贴成功人员明细" + ".xlsx";
            try {
                new ExportExcel("稳岗补贴成功人员明细", SyWgbt.class, 0, 1).setDataList(list).write(response, fileName).dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 准备合格人员数据，通过调用受理单进度接口查询。
     * @param BAZ005    批量流水号
     * @param SAA036    受理单进度
     * @return  所有的合格人员数据
     */
    private List<SyWgbt> prepareSyWgbt(String BAZ005, String SAA036) {
        // 获取系统数据
        User user = UserUtils.getUser();
        //设置接口参数
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());//操作人
        json.put("AAB001", user.getAab001());//单位编号
        json.put("BAA001", user.getBaa001());//数据分区
        json.put("BAZ005", BAZ005);//批量流水号
        json.put("SAA036", SAA036);//受理单号
        json.put("TAA103", "0");// 0 为查询成功人员明细
        json.put("SAA015","M4020"); //功能id
        json.put("SAA004",""); //事项id
        json.put("SZZ003",""); //服务机构id
        json.put("BAE702","1"); //主体类别
        json.put("BAE703",user.getAab001()); //主体编号
        json.put("SAA037", user.getAae170());//申请人
        json.put("SAA038", DateUtils.formatDateTime(new Date()));//SAA038	申请时间
        json.put("BJB003", "");//SAA038	补贴类别
        json.put("AAE030", "");//年份
        //json.put("TAA103", "0");//查失败人员明细
        jsonArray.add(json);
        return syWgbtService.downloadExcelFile(jsonArray.toString());
    }

    /**
     * 导出失败人员明细
     */
    @RequestMapping(value = "failExport")
    public String failExport (String BAZ005, String SAA036, HttpServletResponse response) {
        // 获取系统数据
        User user = UserUtils.getUser();
        //设置接口参数
        JSONArray jsonArray = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170());//操作人
        json.put("AAB001", user.getAab001());//单位编号
        json.put("BAA001", user.getBaa001());//数据分区
        json.put("BAZ005", BAZ005);//批量流水号
        json.put("SAA036", SAA036);//受理单号
        json.put("TAA103", "2");// 2 为查询失败人员明细
        json.put("SAA015","M4020"); //功能id
        json.put("SAA004",""); //事项id
        json.put("SZZ003",""); //服务机构id
        json.put("BAE702","1"); //主体类别
        json.put("BAE703",user.getAab001()); //主体编号
        json.put("SAA037", user.getAae170());//申请人
        json.put("SAA038", DateUtils.formatDateTime(new Date()));//SAA038	申请时间
        json.put("BJB003", "");//SAA038	补贴类别
        json.put("AAE030", "");//年份
        jsonArray.add(json);
        List<SyWgbt> list = syWgbtService.downloadExcelFile(jsonArray.toString());
        if (list != null) {
            String fileName = "稳岗补贴不合格人员明细" + ".xlsx";
            try {
                new ExportExcel("稳岗补贴不合格人员明细", SyWgbt.class,0,2).setDataList(list).write(response, fileName).dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 最终提交申报，提交前验证金额是否正确
     * @param SAA036
     * @param model
     * @return
     */
    @RequestMapping(value = "confirmSubmit")
    public String confirmSubmit(String BAZ005 ,String SAA036, Model model,HttpSession session){
        //获取申报合格人员信息计算金额
        List<SyWgbt> syWgbts = prepareSyWgbt(BAZ005, SAA036);
        float money = 0.00f;
        for (SyWgbt syWgbt : syWgbts) {
            money += countMoney(syWgbt);
        }
        //从session中获取补贴金额上限值
        float maxmoney = Float.parseFloat((String) session.getAttribute("Maxmoney"));
        if(money!=maxmoney){
            model.addAttribute("message", "申请金额不等于补贴金额，请调整申请金额");
        }else {
            //获取系统信息
            User user = UserUtils.getUser();
            // 设置接口参数
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("AAE170", user.getAae170());
            jsonObject.put("AAB001", user.getAab001());
            jsonObject.put("SAA036", SAA036);
            jsonObject.put("SAA015", "M4020");
            jsonObject.put("SAA043", "3");
            jsonObject.put("SAA037", user.getLoginName());
            JSONObject object = syWgbtService.submit(jsonObject.toString());
            if ("0".equals(object.getString("code"))) {
                model.addAttribute("message", "稳岗补贴申报提交成功");
                model.addAttribute("msg", "稳岗补贴申报已经提交，请在受理进度中查看结果");
            } else {
                model.addAttribute("message", object.getString("msg"));
            }
        }
        return "forward:" + Global.getAdminPath() +"/sybx/sywgbt/web_sywgbt/list";
        //return "forward:" + Global.getAdminPath() +"modules/sybx/sywgbt/sy_sywgbtList";
    }

    private float countMoney(SyWgbt syWgbt) {
        return Float.parseFloat(syWgbt.getBJC408()) + Float.parseFloat(syWgbt.getBJC409()) + Float.parseFloat(syWgbt.getBJC410())
                + Float.parseFloat(syWgbt.getBJC411()) + Float.parseFloat(syWgbt.getBJC400()) + Float.parseFloat(syWgbt.getBJC403());
    }

    public BigDecimal getSum() {
        //获取去年的缴费记录
        List<PM_AB88View> paymentInfo = getPaymentInfo();
        BigDecimal sum = new BigDecimal(0.00);
        BigDecimal realysum = new BigDecimal(0.00);
        for (PM_AB88View pm_ab88View : paymentInfo) {
            sum = sum.add(BigDecimal.valueOf(Double.parseDouble(pm_ab88View.getAAB137())));
            if (pm_ab88View.getBAE707().equals("已结算")) {
                realysum = realysum.add(BigDecimal.valueOf(Double.parseDouble(pm_ab88View.getAAB137())));
            }
        }
        return realysum;
    }

    /**
     * 获取稳岗补贴的最新一条进度信息
     * @return
     */
    private JSONObject getLastInfo(String SAA015) {
        List<JSONObject> infos = syywsljdService.getListBySAA015(SAA015);
        if(infos!=null&&infos.size()>0){
            return infos.get(0);
        }
        return null;
    }

    /**
     * 获取去年单位的缴费信息，按照分类统计
     * @return
     */
    private Map<String,String> getLastMoney(HttpSession session) {
        //从session中获取，没有则查询出结果并存入session
        Map<String,String> lastMoney = (Map<String,String>)session.getAttribute("lastMoney");
        if(lastMoney==null) {
            //获取去年的缴费记录
            List<PM_AB88View> paymentInfo = getPaymentInfo();
            //应缴金额
            BigDecimal sum = new BigDecimal("0.00");
            //实缴金额
            BigDecimal realysum = new BigDecimal("0.00");
            //12月缴费人数
            String personNum = null ;
            Integer num = 0;
            for (PM_AB88View pm_ab88View : paymentInfo) {
                sum = sum.add(BigDecimal.valueOf(Double.parseDouble(pm_ab88View.getAAB137())));
                if (pm_ab88View.getBAE707().equals("已结算")) {
                    realysum = realysum.add(BigDecimal.valueOf(Double.parseDouble(pm_ab88View.getAAB137())));
                    if (pm_ab88View.getAAE143().equals("1")) {
                        //统计完成缴费的月数，足够12个月才能提交
                        num++;
                        //获取12月的缴费人数
                        String substring = pm_ab88View.getAAE002().substring(4);
                        if("12".equals(substring)){
                            personNum = pm_ab88View.getAAB083();
                        }
                    }
                }
            }
            BigDecimal b = sum.subtract(realysum);
            //欠缴金额
            Double locksum = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            //申请金额
            BigDecimal grant = realysum.divide(new BigDecimal("2"), 2, BigDecimal.ROUND_HALF_DOWN);
            lastMoney = new HashMap<String, String>();
            lastMoney.put("num", num.toString());
            lastMoney.put("sum", sum.toString());
            lastMoney.put("realysum", realysum.toString());
            lastMoney.put("locksum", locksum.toString());
            lastMoney.put("grant", grant.toString());
            lastMoney.put("personNum", personNum);
            session.setAttribute("lastMoney",lastMoney);
        }
        return lastMoney;
    }

    /**
     * 获取单位去年的缴费信息
     * @return
     */
    private List<PM_AB88View> getPaymentInfo() {
        Date date = DateUtils.addYears(new Date(), -1);
        JSONObject json = new JSONObject();
        json.put("StartYM", DateUtils.formatDate(date, "yyyy") + "01");
        json.put("EndYM", DateUtils.formatDate(date, "yyyy") + "12");
        //查询缴费记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        return syUnitPaymentQueryService.findList(json);
    }

    /**
     * 根据受理单号，查询受理单详细信息
     * @param saa036
     * @param request
     * @param response
     * @param model
     * @return
     */
    private Page getDetailInfo(String saa036,HttpServletRequest request,HttpServletResponse response,Model model) {
        User user = UserUtils.getUser();
        //设置接口查询条件
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170", user.getAae170());
        jsonObject.put("AAB001", user.getAab001());
        jsonObject.put("BAA001", user.getBaa001());
        jsonObject.put("SAA036", saa036);
        //jsonObject.put("TAA103", pm_jc02View.getTAA103());//受理状态
        Page page = syywsljdService.findListDetails(new Page(request, response), jsonObject.toString(), model);
        return page;
    }

    /**
     * 根据对申报信息的判断返回跳转页面，如果没有申报信息，则返回null;
     * 提示信息传入model中
     * @return
     */
    private void validateSubsidized(Model model,HttpServletRequest request,HttpServletResponse response) {
        JSONObject info = this.getLastInfo("M4020");
        //如果数据为空，或者数据不是今年的则表示没有申请过
        if(info!=null&&isSubmit(info)) {
            if("填写资料".equals(info.getString("Saa043"))){
                //表示稳岗补贴已经进行了申报的第一步，页面直接调转至稳岗第一步
            }else if("预审".equals(info.getString("Saa043"))){
                //表示稳岗补贴已经进行了申报第二步，等候最终结果
                model.addAttribute("state", "2-2");
                model.addAttribute("msg", "稳岗补贴申报已经提交，请携带以下资料前往经办机构办理后续流程：");
            }else if("办结".equals(info.getString("Saa043"))){
                //稳岗补贴申报办结，查询明细确认是通过还是被拒绝
                JSONObject detailInfo = getLastM4022Info(model, request, response, info);
                if("审核不通过".equals(detailInfo.getString("TAA103"))){
                    model.addAttribute("message", "审核未通过,请在受理进度页面查询原因,更正后重新申报");
                }else{
                    //审核通过，显示结果
                    model.addAttribute("msg", "稳岗补贴申报已经通过");
                }
            }
        }
    }

    @RequestMapping("pdf")
    public String printPDF(HttpServletRequest request, HttpServletResponse response){
        try {
            PostHelperUtils.exportWGBTPdf(new JSONObject(),request,response);
        } catch (IOException | JRException e) {
            e.printStackTrace();
        }
        return "";
    }



   /* public JSONObject getLastYearPerson() {

        return lastYearInfo;
    }*/
}
