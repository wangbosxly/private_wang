package com.thinkgem.jeesite.modules.sybx.syryxbdj.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.sy.DateUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AB01View;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.ParamView;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sybx.syryxbdj.service.SyRyxbdjService;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 失业人员续保登记控制器
 *
 * @author njx
 * @version 1.0
 * @description
 * @since 20170614
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syryxbdj/web_syryxbdj")
public class SyRyxbdjController extends BaseController {
    // 支持的文件类型
    private String[] errorType = {"xls"};

    protected String[] parmidsStr = null;

    @Autowired
    private SyRyxbdjService syryxbdjservice;

    @RequestMapping(value = {"list", ""})
    public String list(PM_AC01View pm_ac01view, HttpServletRequest request, HttpServletResponse response, Model model, String ids, String nowPage, String pageNo) {
        //获取系统信息
       /* List officeList = UserUtils.getOfficeList();
        Office office = (Office) officeList.get(0);
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();


        //创建对象
        UserView userView = null;
        PM_AC01View ac01view = new PM_AC01View();
        UserView userView1 = new UserView();
        PM_AB01View ab01View = new PM_AB01View();

        //设置接口查询条件
        ac01view.setAAB001(user.getAab001());
        ac01view.setSAA015(CodeConstant.SAA015_SAA015_M4005);// 功能id
        ac01view.setAAE140(CodeConstant.AAE140_AAE140_2);// 险种
        ac01view.setAAC031(CodeConstant.AAC031_AAC031_2);//参保状态

        if (pageNo == null) {
            ac01view.setBAC809("1");
        } else {
            ac01view.setBAC809(pageNo);
        }

        ab01View.setAAB001(user.getAab001());
        ab01View.setAAE140(CodeConstant.AAE140_AAE140_2);// 险种
        ab01View.setAAB001(user.getAab001());
        ab01View.setBAB808("9");//9-查询缴费基数
        ab01View.setAAE140(CodeConstant.AAE140_AAE140_2);// 险种

        userView1.setAAB001(user.getAab001());//
        userView1.setAAE170(user.getAae170());//
        userView1.setBAA001(user.getBaa001());

        String BAA001 = null;

        //操作人
        jsonObject.put("AAE170", user.getAae170());
        jsonObject.put("AAB001", user.getAab001());
        jsonObject.put("BAA001", user.getBaa001());
        jsonObject.put("AAE140", CodeConstant.AAE140_AAE140_2);
        jsonObject.put("AAC031", CodeConstant.AAC031_AAC031_2);
        try {
            System.out.println("******1.控制层开始调用mod接口.******");
            PM_AB01View ab01 = syryxbdjservice.mod(jsonObject);
            if (ab01 != null) {
                System.out.println("******2.控制层调用mod接口成功，数据返回成功." + ab01.toString());
                userView = new UserView();
                BAA001 = ab01.getBAA001();
                ac01view.setBAA001(BAA001);

                userView.setAAB001(ab01.getAAB001());
                userView.setAAE170(user.getAae170());
                userView.setBAA001(BAA001);

                //控制页面在不同情况下显示不同的信息和按钮
                pm_ac01view.setAAC058("displayInfo");    //不显"暂无记录，请联系系统维护人员."
                pm_ac01view.setAAE011("noDisplayInfo");//如果没有数据就显示"未查询到符合条件的记录，请确认您输入的查询条件."
                pm_ac01view.setBAC801("displayButton");//如果有数据，显示【确认续保】按钮
            } else {
                System.out.println("******3.控制层调用mod接口失败！没有数据返回，请检查原因。所在：SyRyxbdjController  类中******");
                //控制页面在不同情况下显示不同的信息和按钮
                pm_ac01view.setAAC058("noDataDisplayInfo");    //显示暂无记录，请联系系统维护人员.
                pm_ac01view.setAAE011("displayInfo");//如果没有数据就显示"未查询到符合条件的记录，请确认您输入的查询条件."
                pm_ac01view.setBAC801("nodisplayButton");//如果没有数据，不显示【确认续保】按钮
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        System.out.println("******1.控制层开始调用nwws2102_page接口******");*/
//		Pagination p  = syryxbdjservice.nwws2102_page(ac01view, pageNum,CodeConstant.SY_PAGE_SIZE,userView);
        //Page<PM_AC01View> p = syryxbdjservice.nwws2102_page1(new Page<PM_AC01View>(request, response),ac01view,userView);
        // Page<PM_AC01View> p = syryxbdjservice.nwws2102_page(new Page<PM_AC01View>(request, response), jsonObject);
       /* if (p != null) {
            System.out.println("******2.控制层调用nwws2102_page接口结束，调用成功，数据返回成功******");
            String bac504 = ((PM_AC01View) (p.getList().get(0))).getBAC504();
            if (nowPage == null || "".equals(nowPage)) {
                parmidsStr = new String[p.getTotalPage()];
            } else {
                int parm = Integer.parseInt(nowPage);
                parmidsStr[parm - 1] = ids;
            }
            model.addAttribute("pagination", p);
            model.addAttribute("rmb", bac504);
            //控制页面在不同情况下显示不同的信息和按钮
            pm_ac01view.setAAC058("displayInfo");    //不显"暂无记录，请联系系统维护人员."
            pm_ac01view.setAAE011("noDisplayInfo");//如果没有数据就显示"未查询到符合条件的记录，请确认您输入的查询条件."
            pm_ac01view.setBAC801("displayButton");//如果有数据，显示【确认续保】按钮
            pm_ac01view.setBAC808("displayPageInfo");//显示分页.
        } else {
            System.out.println("******3.控制层调用nwws2102_page接口失败！没有数据返回，请检查原因，所在：SyRyxbdjController  类中******");
            //控制页面在不同情况下显示不同的信息和按钮*/
        // pm_ac01view.setAAC058("noDataDisplayInfo");    //显示暂无记录，请联系系统维护人员.
        pm_ac01view.setAAE011("displayInfo");//如果没有数据就显示"未查询到符合条件的记录，请确认您输入的查询条件."
        pm_ac01view.setBAC801("nodisplayButton");//如果没有数据，不显示【确认续保】按钮
        //}
        //查询完直接到页面展示.
//		addMessage(model,"数据保存成功！");
        model.addAttribute("pm_ac01view", pm_ac01view);
        return "modules/sybx/syryxbdj/sy_ryxbdjList";
    }

    @RequestMapping(value = "searchXbInfo")
    public String searchXbInfo(PM_AC01View pm_ac01view, HttpServletRequest request, HttpServletResponse response, Model model, String pageNo) {
        //获取系统信息
        List officeList = UserUtils.getOfficeList();
        Office office = (Office) officeList.get(0);
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();

//		//创建对象
        UserView userView = null;
        PM_AC01View ac01view = new PM_AC01View();

        if (pageNo == null) {
            ac01view.setBAC809("1");
        } else {
            ac01view.setBAC809(pageNo);
        }

        String BAA001 = null;
        jsonObject.put("AAE170", user.getAae170());
        jsonObject.put("AAE140", CodeConstant.AAE140_AAE140_2);
        jsonObject.put("BAA001", user.getBaa001());
        jsonObject.put("AAB001", user.getAab001());
        jsonObject.put("AAC031", CodeConstant.AAC031_AAC031_2);

        PM_AB01View pm_ab01view = null;
        try {
            System.out.println("******1.控制层开始调用mod接口.******");
            pm_ab01view = syryxbdjservice.mod(jsonObject);
            if (pm_ab01view != null) {
                userView = new UserView();
                System.out.println("******2.控制层调用mod接口成功，数据返回成功.");
                userView = new UserView();
                BAA001 = pm_ab01view.getBAA001();
                ac01view.setBAA001(BAA001);

                BAA001 = pm_ab01view.getBAA001();
                ac01view.setBAA001(BAA001);
                userView.setAAB001(pm_ab01view.getAAB001());
                userView.setAAE170(user.getAae170());
                userView.setBAA001(BAA001);

                String AAC003 = pm_ac01view.getAAC003();
                String AAC002 = pm_ac01view.getAAC002();
                String AAC001 = pm_ac01view.getAAC001();
                if ((!AAC003.equalsIgnoreCase("")) && AAC003 != null) {
                    jsonObject.put("AAC003", "'" + AAC003 + "'");
                }
                if ((!AAC002.equalsIgnoreCase("")) && AAC002 != null) {
                    jsonObject.put("AAC002", "'" + AAC002 + "'");
                }
                if ((!AAC001.equalsIgnoreCase("")) && AAC001 != null) {
                    jsonObject.put("AAC001", "'" + AAC001 + "'");
                }
            } else {
                addMessage(model, "查询单位信息失败！");
                System.out.println("******3.控制层调用mod接口失败！没有数据返回，请检查原因。所在：SyRytbdjController  类中******");
//				model.addAttribute("message", "控制层调用mod接口失败！没有数据返回，请检查原因。");
//				return "modules/sybx/syryxbdj/sy_ryxbdjList";
            }


            System.out.println("******1.控制层开始调用控制层SyRyxbdjController的nwws2102_page接口******");
            //Page<PM_AC01View> returnInfo = syryxbdjservice.nwws2102_page1(new Page<PM_AC01View>(request, response), ac01view,userView);
            // 此处调用webservice
            jsonObject.put("TAE100", "1");
            Page<PM_AC01View> returnInfo = syryxbdjservice.nwws2102_page(new Page<PM_AC01View>(request, response), jsonObject);
            List<PM_AC01View> list = returnInfo.getList();
            //存入session，保存时使用
            request.getSession().setAttribute("XbInfo",list.get(0));
            if (returnInfo != null) {
                System.out.println("******2.控制层SyRyxbdjController调用nwws2102_page接口结束，调用成功，数据返回成功******");
                pm_ac01view.setAAC058("dataDisplayInfo");//不显示"暂无记录，请联系系统维护人员."
                pm_ac01view.setAAE011("noDisplayInfo");//如果没有数据就显示"未查询到符合条件的记录，请确认您输入的查询条件."
                pm_ac01view.setBAC801("displayButton");//如果没有数据，不显示【确认续保】按钮
                pm_ac01view.setBAC808("noDisplayPageInfo");//不显示分页.
                model.addAttribute("pagination", returnInfo);
            } else {
                addMessage(model, "信息不存在，请确认您输入的查询条件！");
                pm_ac01view.setAAC058("dataDisplayInfo");//不显示"暂无记录，请联系系统维护人员."
                pm_ac01view.setAAE011("displayInfo");//如果没有数据就显示"未查询到符合条件的记录，请确认您输入的查询条件."
                pm_ac01view.setBAC801("nodisplayButton");//如果没有数据，不显示【确认续保】按钮
                System.out.println("******3.控制层SyRyxbdjController调用nwws2102_page接口失败！没有数据返回，请检查原因，所在：SyRyxbdjController  类中******");
            }
        } catch (Exception e) {
            addMessage(model, "信息不存在，请确认您输入的查询条件！");
            pm_ac01view.setAAC058("dataDisplayInfo");//不显示"暂无记录，请联系系统维护人员."
            pm_ac01view.setAAE011("displayInfo");//如果没有数据就显示"未查询到符合条件的记录，请确认您输入的查询条件."
            pm_ac01view.setBAC801("nodisplayButton");//如果没有数据，不显示【确认续保】按钮
            e.printStackTrace();
        }

        model.addAttribute("pm_ac01view", pm_ac01view);
        return "modules/sybx/syryxbdj/sy_ryxbdjList";
    }

    /**
     * 确认续保
     *
     * @throws IOException sy:syxb:submit
     */
    @RequestMapping(value = "submit")
    public String submit(RedirectAttributes redirectAttributes, String cdate, String AAE160, String AAC001
            , String AAC012, String AAC040, HttpServletRequest request) throws IOException {

        //获取系统信息
        User user = UserUtils.getUser();
        //生成流水号
        GenerateSequenceUtil gsu = new GenerateSequenceUtil();
        String saa036 = "XY" + gsu.generateSequenceNo();// 受理单ID

        String date = DateUtils.format5.format(new Date());
        String month = date.substring(4, 6);
        String aae030 = "";
        if ("12".equals(month)) {
            aae030 = Integer.parseInt(date.substring(0, 4)) + 1 + "01";
        } else {
            aae030 = Integer.parseInt(date.substring(0, 4)) + "01";
        }

        //获取个人编号
        String[] parmidsStr = AAC001.split(",");

        PM_AC01View[] pm_ac01view = new PM_AC01View[parmidsStr.length];
        List paramList = new ArrayList();
        if (pm_ac01view.length >= 1) {
            for (int i = 0; i < parmidsStr.length; i++) {
                JSONObject jsonObject = new JSONObject();
                PM_AC01View xbInfo = (PM_AC01View) request.getSession().getAttribute("XbInfo");
                if(StringUtils.isEmpty(xbInfo.getBAC504())||"0.00".equals(xbInfo.getBAC504())||"0".equals(xbInfo.getBAC504())){
                    double min = Double.parseDouble(xbInfo.getAAC040()) * 0.6;
                    jsonObject.put("BAC504", min);//如果缴费基数没有则设置为基数下限
                }else{
                    jsonObject.put("BAC504", xbInfo.getBAC504());//如果缴费基数有则设置为缴费基数
                }
                String BAE941 = "XY" + gsu.generateSequenceNo();
                jsonObject.put("AAB001", user.getAab001());
                jsonObject.put("AAE170", user.getAae170());
                jsonObject.put("BAA001", user.getBaa001());
                jsonObject.put("SZZ003", "");
                jsonObject.put("SAA036", saa036);
                jsonObject.put("SAA015", CodeConstant.SAA015_SAA015_M4005);
                jsonObject.put("BAE702", CodeConstant.BAE702_BAE702_1);
                jsonObject.put("SAA004", " ");
                jsonObject.put("BAE703", user.getAab001());
                jsonObject.put("SAA043", CodeConstant.SAA043_SAA043_3);
                jsonObject.put("SAA037", user.getLoginName());
                jsonObject.put("SAA038", CommonUtility.get19BitCurTimeAPP());
                jsonObject.put("BUS_ID", "1");
                jsonObject.put("BAE941", BAE941);
                jsonObject.put("AAC001", parmidsStr[i].substring(0, parmidsStr[i].indexOf('#')));// 组织人员编号
                jsonObject.put("AAA040", parmidsStr[i].substring(parmidsStr[i].indexOf('#') + 1, 14));// 缴费比例类别
                jsonObject.put("AAE160", AAE160);// 组织暂停原因AC05
                jsonObject.put("BAC510", cdate);// 组织最近参保时间-对应最近参保时间BAC510---AC02 待上线前与客户确认是否手动输入.！！！！！！！
                jsonObject.put("AAE035", cdate);// 组织暂停时间对应aae035变更时间AC05
                jsonObject.put("AAE140", CodeConstant.AAE140_AAE140_2);// 组织险种
                jsonObject.put("AAC031", CodeConstant.AAC031_AAC031_1);// 组织参保状态为参保缴费
                jsonObject.put("AAC050", CodeConstant.AAC050_AAC050_12);// 组织变更类型为续保‘22’--‘12’为续保
                jsonObject.put("AAE102", CodeConstant.AAE102_AAE102_4);// 组织办理状态为办理完毕
                jsonObject.put("AAE003", CommonUtility.get6BitCurTimeAPP());// 对应费款所属期

                if (!(AAC012 == null || AAC012.equalsIgnoreCase(""))) {
                    jsonObject.put("AAC012", AAC012);
                }

                if (!(AAC040 == null || AAC040.equalsIgnoreCase("") || AAC040 == "0" || AAC040 == "0.00")) {
                    jsonObject.put("AAC040", AAC040);
                }

                jsonObject.put("AAE011", user.getLoginName());// 经办人
                jsonObject.put("AAE036", CommonUtility.get19BitCurTimeAPP());// 经办人
                jsonObject.put("AAE030", aae030);//开始年月
                jsonObject.put("SAA015", CodeConstant.SAA015_SAA015_M4005);// 功能id
                jsonObject.put("TAA101", CommonUtility.get19BitCurTimeAPP());// ★申报时间
                jsonObject.put("TAA103", CodeConstant.TAA103_TAA103_0);// 审核结果,0待审核,1审核通过,2审核不通过
                jsonObject.put("TAA105", CodeConstant.TAA105_TAA105_1);// 申报来源,1网上大厅
                jsonObject.put("AAC002", parmidsStr[i].substring(parmidsStr[i].indexOf('*') + 1));
                paramList.add(jsonObject);
            }

        } else {
            System.out.println("******控制层SyRyxbdjController 获取选中列表人员信息为空，无需办理此业务.******");
        }

        if (paramList != null && paramList.size() > 0) {
            System.out.println("******1.控制层SyRyxbdjController开始调用confirmSyXb方法保存数据接口.******");
            syryxbdjservice.confirmSyXb(paramList);
            System.out.println("******6.控制层SyRyxbdjController调用confirmSyXb方法执行完毕.******");
            addMessage(redirectAttributes, "人员续保业务办理成功.");
        } else {
            addMessage(redirectAttributes, "人员续保业务办理失败.");
        }
        return "redirect:" + adminPath + "/sybx/syryxbdj/web_syryxbdj/list?repage";
    }

    /**
     * 批量导入续保
     *
     * @param request
     * @param AAC012
     * @param AAA040
     * @param AAC040
     * @return
     */
    @RequestMapping(value = "importExcel")
    public String importExcel(HttpServletRequest request, RedirectAttributes redirectAttributes,
                              String AAE160, String cdate, String AAC012, String AAA040, String AAC040) {
        //创建系统信息
        User user = UserUtils.getUser();
        JSONObject paramJson = new JSONObject();
        //开始调用参数校验接口
        System.out.println("*******1.控制层SyRyxbdjController开始调用校验参数接口.*******");
        ParamView param;
        try {
            paramJson.put("AAB034", user.getAab034());
            paramJson.put("PARAM_TYPE", 2);
            param = syryxbdjservice.check(paramJson);
            if (param != null) {
                System.out.println("*******6.控制层SyRyxbdjController开始调用校验参数接口.*******");
                String deadline = param.getVALUE();
                DateFormat df_D = new SimpleDateFormat("yyyyMMdd");
                Date date_D = new Date();
                String now_D = df_D.format(date_D);
                String tb_d = cdate.substring(0, 4) + cdate.substring(5, 7) + cdate.substring(8, 10);
                if (deadline != null) {
                    deadline = now_D.substring(0, 6) + deadline;
                    //判断办理业务日期是否大于截止日
                    if (Integer.parseInt(now_D) > Integer.parseInt(deadline)) {
                        System.out.println("该业务在本月已截止网上办理，如需办理请前往经办机构。");
                    }
                } else {
                    if (!now_D.substring(0, 6).equals(tb_d.substring(0, 6))) {
                        System.out.println("续保时间仅限当月！");
                    }
                }
            } else {
                System.out.println("*******7.控制层SyRyxbdjController调用校验参数接口失败，没有数据返回.请检查.*******");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        Iterator<String> iterator = req.getFileNames();
        while (iterator.hasNext()) {
            MultipartFile multipartFile = req.getFile(iterator.next());
            String fileNames = multipartFile.getOriginalFilename();
            int split = fileNames.lastIndexOf(".");

            //判断是否是支持的文件格式
            if (errorType[0].equals(fileNames.substring(split + 1, fileNames.length()))) {
            } else {
                System.out.println("不是支持的文件格式，请使用.xls文件做批量上传！");
            }

            File file = new File(user.getAab001() + "." + fileNames.substring(split + 1, fileNames.length()));
            try {
                fos = new FileOutputStream(file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            bos = new BufferedOutputStream(fos);
            try {
                bos.write(multipartFile.getBytes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
                HSSFSheet hssfSheet = workbook.getSheetAt(0);
                ArrayList personInfoList = new ArrayList();
                if (hssfSheet.getLastRowNum() > 5000) {
                    addMessage(redirectAttributes, "批量上传不能超过5000条记录.");
                    return "redirect:" + adminPath + "/sybx/syryxbdj/web_syryxbdj/list?repage";
                }
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    PM_AC01View pm_ac01View = new PM_AC01View();
                    if (hssfRow == null) {
                        continue;
                    }
                    HSSFCell cell_1 = hssfRow.getCell(1);
                    if (cell_1 != null) {
                        String aac001 = cell_1.getStringCellValue();
                        if (cell_1 != null && !"".equals(cell_1)) {
                            pm_ac01View.setAAC001(aac001);
                        }
                    }
                    HSSFCell cell_2 = hssfRow.getCell(2);
                    if (cell_2 != null) {
                        String aac003 = cell_2.getStringCellValue();
                        if (cell_2 != null && !"".equals(cell_2)) {
                            pm_ac01View.setAAC003(aac003);
                        }
                    }
                    HSSFCell cell_3 = hssfRow.getCell(3);
                    if (cell_3 != null) {
                        String aac002 = cell_3.getStringCellValue();
                        if (aac002 != null && !"".equals(aac002)) {
                            pm_ac01View.setAAC002(aac002);
                        }
                    }
                    personInfoList.add(pm_ac01View);
                }
                //****************************************************************开始执行批量保存操作
                //生成流水号
                GenerateSequenceUtil gsu = new GenerateSequenceUtil();
                String saa036 = "XY" + gsu.generateSequenceNo();// 受理单ID

                // 处理前台数据向后台组织数据
                String date = DateUtils.format5.format(new Date());
                String month = date.substring(4, 6);
                String aae030 = "";
                if ("12".equals(month)) {
                    aae030 = Integer.parseInt(date.substring(0, 4)) + 1 + "01";
                } else {
                    aae030 = Integer.parseInt(date.substring(0, 4)) + "01";
                }
                PM_AC01View[] pram_ac02 = new PM_AC01View[personInfoList.size()];
                List paramList = new ArrayList();
                for (int j = 0; j < personInfoList.size(); j++) {
                    //生成流水号
                    GenerateSequenceUtil gsu_bae941 = new GenerateSequenceUtil();
                    JSONObject userJson = new JSONObject();
                    userJson.put("AAB001", user.getAab001());
                    userJson.put("AAE170", user.getAae170());
                    userJson.put("BAA001", user.getBaa001());
                    userJson.put("SZZ003", "");
                    userJson.put("BUS_ID", CodeConstant.SY_BUS_ID_1);
                    userJson.put("SAA036", saa036);
                    userJson.put("SAA015", CodeConstant.SAA015_SAA015_M4005);
                    userJson.put("SAA004", " ");
                    userJson.put("BAE702", CodeConstant.BAE702_BAE702_1);
                    userJson.put("BAE703", user.getAab001());
                    userJson.put("SAA043", CodeConstant.SAA043_SAA043_3);
                    userJson.put("SAA037", user.getLoginName());
                    userJson.put("SAA038", CommonUtility.get19BitCurTimeAPP());
                    userJson.put("BAE941", "XY" + gsu_bae941.generateSequenceNo());
                    if("".equals(((PM_AC01View) personInfoList.get(j)).getAAC001())){
                        continue;
                    }
                    userJson.put("AAC001", ((PM_AC01View) personInfoList.get(j)).getAAC001());// 组织人员编号
                    userJson.put("AAC002", ((PM_AC01View) personInfoList.get(j)).getAAC002());//姓名
                    userJson.put("AAE160", AAE160);// 组织暂停原因AC05
                    userJson.put("BAC510", cdate);// 组织最近参保时间-对应最近参保时间BAC510---AC02 待上线前与客户确认是否手动输入.！！！！！！！
                    userJson.put("AAE035", cdate);// 组织暂停时间对应aae035变更时间AC05
                    userJson.put("AAE140", CodeConstant.AAE140_AAE140_2);// 组织险种
                    userJson.put("AAC031", CodeConstant.AAC031_AAC031_1);// 组织参保状态为参保缴费
                    userJson.put("AAC050", CodeConstant.AAC050_AAC050_12);// 组织变更类型为续保‘22’--‘12’为续保
                    userJson.put("AAE102", CodeConstant.AAE102_AAE102_4);// 组织办理状态为办理完毕
                    userJson.put("AAE003", CommonUtility.get6BitCurTimeAPP());// 对应费款所属期

                    if (!(AAC012 == null || AAC012.equalsIgnoreCase(""))) {
                        userJson.put("AAC012", AAC012);
                    }
                    if (!(AAA040 == null || AAA040.equalsIgnoreCase(""))) {
                        userJson.put("AAA040", AAA040);
                    }
                    if (!(AAC040 == null || AAC040.equalsIgnoreCase("") || Objects.equals(AAC040, "0") || Objects.equals(AAC040, "0.00"))) {
                        userJson.put("AAC040", AAC040);
                    }
                    userJson.put("AAE011", user.getLoginName());// 经办人
                    userJson.put("AAE036", CommonUtility.get19BitCurTimeAPP());// 经办人
                    userJson.put("AAE030", aae030);//开始年月
                    userJson.put("SAA015", CodeConstant.SAA015_SAA015_M4005);// 功能id
                    userJson.put("TAA101", CommonUtility.get19BitCurTimeAPP());// ★申报时间
                    userJson.put("TAA103", CodeConstant.TAA103_TAA103_0);// 审核结果,0待审核,1审核通过,2审核不通过
                    userJson.put("TAA105", CodeConstant.TAA105_TAA105_1);// 申报来源,1网上大厅
                    paramList.add(userJson);
                }
                if (pram_ac02 != null && pram_ac02.length > 0) {
                    JSONObject jsonObject = syryxbdjservice.confirmSyXb(paramList);
                    if ("0".equals(jsonObject.getString("code"))) {
                        addMessage(redirectAttributes, "员批量续保提交成功，请在\"受理进度查询\"处查询批量续保结果");
                    } else {
                        addMessage(redirectAttributes, "人员批量续保业务办理失败: " + jsonObject.getString("msg"));
                    }
                } else {
                    addMessage(redirectAttributes, "批量上传失败.");
                }
                bos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //业务执行完毕重新查询列表信息
        return "redirect:" + adminPath + "/sybx/syryxbdj/web_syryxbdj/list?repage";
    }
}
