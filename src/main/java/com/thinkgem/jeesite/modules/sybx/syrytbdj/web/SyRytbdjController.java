package com.thinkgem.jeesite.modules.sybx.syrytbdj.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.sybx.syrytbdj.service.SyRytbdjService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 失业人员停保登记控制器
 *
 * @author njx
 * @version 1.0
 * @description
 * @since 20170614
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syrytbdj/web_syrytbdj")
public class SyRytbdjController extends BaseController {
    // 支持的文件类型
    private String[] errorType = {"xls"};


    private String[] parmidsStr = null;

    @Autowired
    private SyRytbdjService syrytbdjservice;

    @RequestMapping(value = {"list", ""})
    public String list(PM_AC01View pm_ac01view, HttpServletRequest request, HttpServletResponse response, Model model, String ids, String nowPage, String pageNo) {
       /* //获取系统信息
        User user = UserUtils.getUser();
        //设置接口查询条件
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getAae170()); //AAE170	操作人
        json.put("AAB001", user.getAab001()); //AAB001	单位编号
        json.put("SAA015", CodeConstant.SAA015_SAA015_M4004);
        json.put("BAA001", user.getBaa001());// 数据分区
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);//险种
        json.put("BAC808", CodeConstant.SY_PAGE_SIZE);//每页数据量
        json.put("AAC031", CodeConstant.AAC031_AAC031_1);//参保状态
        if (pageNo == null) {
            json.put("BAC809", "1");
        } else {
            json.put("BAC809", pageNo);
        }
        Page<PM_AC01View> p = syrytbdjservice.findPage(new Page<PM_AC01View>(request, response), json);
        if (p != null) {
            if (nowPage == null || "".equals(nowPage)) {
                parmidsStr = new String[p.getTotalPage()];
            } else {
                int parm = Integer.parseInt(nowPage);
                parmidsStr[parm - 1] = ids;
            }
            model.addAttribute("pagination", p);
        }*/
        Page<PM_AC01View> p = new Page<>();
        p.setList(new ArrayList<PM_AC01View>());
        model.addAttribute("pagination", p);
        model.addAttribute("pm_ac01view", pm_ac01view);
        return "modules/sybx/syrytbdj/sy_rytbdjList";
    }

    @RequestMapping(value = "searchTbInfo")
    public String SertchTbInfo(PM_AC01View pm_ac01view, HttpServletRequest request, HttpServletResponse response, Model model, String pageNo) {
        //获取系统信息
        User user = UserUtils.getUser();
        //设置接口查询条件
        JSONObject json = new JSONObject();
        if (!"".equals(pm_ac01view.getAAC001().trim())) {
            json.put("AAC001", "'" + pm_ac01view.getAAC001() + "'"); //AAC001	个人编号
        }
        if (!"".equals(pm_ac01view.getAAC002().trim())) {
            json.put("AAC002", "'" + pm_ac01view.getAAC002() + "'"); //AAC002	身份证号
        }
        if (!"".equals(pm_ac01view.getAAC003().trim())) {
            json.put("AAC003", "'" + pm_ac01view.getAAC003() + "'"); //AAC003	姓名
        }
        json.put("AAB001", user.getAab001()); //AAB001	单位编号
        json.put("SAA015", CodeConstant.SAA015_SAA015_M4004); //AAB001	功能Id
        json.put("AAE170", user.getAae170()); //AAE170	操作人
        json.put("BAA001", user.getBaa001());// 数据分区
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);//险种
        json.put("AAC031", CodeConstant.AAC031_AAC031_1);//参保状态
        if (pageNo == null) {
            json.put("BAC809", "1");
        } else {
            json.put("BAC809", pageNo);
        }
        try {
            Page<PM_AC01View> p = syrytbdjservice.findPage(new Page<PM_AC01View>(request, response), json);
            if (p != null) {
                model.addAttribute("pagination", p);
            } else {
                addMessage(model, "信息不存在，请确认您输入的查询条件！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            addMessage(model, "信息不存在，请确认您输入的查询条件！");
        }
        model.addAttribute("pm_ac01view", pm_ac01view);
        return "modules/sybx/syrytbdj/sy_rytbdjList";
    }

    /**
     * 获取查询条件
     *
     * @param AAC003 处理传入的姓名字符串
     */
    private String getSearchParam(String AAC003) {
        String instr = "";// SQL查询用字符串，形如:'张娜','吕婷婷','葛胜敏'
        String[] strarray = AAC003.split("\n");
        for (int i = 0; i < strarray.length; i++) {
            strarray[i] = strarray[i].trim();
            if (!strarray[i].equals("")) {
                instr += "'" + strarray[i] + "',";
            }
        }
        // 截去字符串最后面的“,'”
        return instr.substring(0, instr.length() - 1);
    }

    @RequestMapping(value = "submit")
    public String submit(HttpServletRequest request, String AAE160, String cdate, String AAC001, RedirectAttributes redirectAttributes) {
        //获取系统信息
        User user = UserUtils.getUser();
        //生成流水号
        String saa036 = "XY" + GenerateSequenceUtil.generateSequenceNo();// 受理单ID
        //获取个人编号
        String[] parmidsStr = AAC001.split(",");
        if (parmidsStr.length > 0) {
            JSONArray jsonArray = new JSONArray();
            try {
                for (String str : parmidsStr) {
                    JSONObject json = new JSONObject();
                    json.put("AAE170", user.getAae170());//操作人
                    json.put("AAB001", user.getAab001());//单位编号
                    json.put("BAA001", user.getBaa001());//数据分区
                    json.put("SAA036", saa036);//受理单ID
                    json.put("SAA004", " ");
                    json.put("SAA015", CodeConstant.SAA015_SAA015_M4004);//功能id
                    json.put("BAE702", CodeConstant.BAE702_BAE702_1);//主体类型
                    json.put("BAE703", user.getAab001());//主体编号
                    json.put("SAA043", CodeConstant.SAA043_SAA043_3);//业务状态
                    json.put("SAA037", user.getLoginName());//申请人
                    json.put("SAA038", CommonUtility.get19BitCurTimeAPP());//申请时间
                    json.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo());//申报流水号
                    json.put("AAC001", str.substring(0, str.indexOf('#')));//个人编号
                    json.put("AAC002", str.substring(str.indexOf('*') + 1));//身份证
                    //json.put("AAA040", str.substring(str.indexOf('#') + 1, 14));//缴费比例类别
                    json.put("AAE160", AAE160);//组织暂停原因
                    json.put("BAC510", cdate);// 组织最近参保时间-对应最近参保时间BAC510---AC02 待上线前与客户确认是否手动输入.！！！！！！！
                    json.put("AAE035", cdate);//组织暂停时间对应aae035变更时间AC05
                    json.put("AAE140", CodeConstant.AAE140_AAE140_2);//险种
                    json.put("AAC031", request.getParameter("ywlx_p"));//组织参保状态为参保缴费
                    json.put("AAC050", CodeConstant.AAC050_AAC050_22);//组织变更类型为停保‘22’--‘12’为续保
                    json.put("AAE102", CodeConstant.AAE102_AAE102_4);//组织办理状态为办理完毕
                    json.put("AAE003", CommonUtility.get6BitCurTimeAPP());//对应费款所属期
                    json.put("AAE011", user.getLoginName());// 经办人
                    json.put("AAE036", CommonUtility.get19BitCurTimeAPP());//经办时间
                    json.put("TAA101", CommonUtility.get19BitCurTimeAPP());//申报时间
                    json.put("TAA103", CodeConstant.TAA103_TAA103_0);//审核结果,0待审核,1审核通过,2审核不通过
                    json.put("TAA105", CodeConstant.TAA105_TAA105_1);// 申报来源,1网上大厅
                    jsonArray.add(json);
                }
                /*=========开始调用停保接口=========*/
                JSONObject jsonObject = syrytbdjservice.confirmSyTb(jsonArray.toString());
                if ("0".equals(jsonObject.getString("code"))) {
                    addMessage(redirectAttributes, "人员停保业务办理成功");
                } else {
                    addMessage(redirectAttributes, "人员停保业务办理失败: " + jsonObject.getString("msg"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                addMessage(redirectAttributes, "人员停保业务办理失败,请联系系统维护人员");
            }
        } else {
            addMessage(redirectAttributes, "未选择任何人员");
        }
        return "redirect:" + adminPath + "/sybx/syrytbdj/web_syrytbdj/list?repage";
    }

    @RequestMapping(value = "importExcel")
    public String importExcel1(String AAE160, MultipartFile file, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String fileName = file.getOriginalFilename();
        String strArr = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if (!"xls".equals(strArr) && !"xlsx".equals(strArr)) {
            addMessage(redirectAttributes, "不是支持的文件格式请使用excel文件做批量上传!");
            return "redirect:" + adminPath + "/sybx/syrytbdj/web_syrytbdj/list?repage";
        }
        //获取系统信息
        User user = UserUtils.getUser();
        String saa036 = "XY" + GenerateSequenceUtil.generateSequenceNo();// 受理单ID
        //设置接口参数
        try {
            List<PM_AC01View> list = readFile(user.getAab001(), request, redirectAttributes);
            JSONArray jsonArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (PM_AC01View pm_ac01View : list) {
                    JSONObject json = new JSONObject();
                    json.put("AAE170", user.getAae170());//操作人
                    json.put("AAB001", user.getAab001());//单位编号
                    json.put("BAA001", user.getBaa001());//数据分区
                    //生成流水号
                    json.put("SAA036", saa036);//受理单ID
                    json.put("SAA004", " ");
                    json.put("SAA015", CodeConstant.SAA015_SAA015_M4004);//功能id
                    json.put("BAE702", CodeConstant.BAE702_BAE702_1);//主体类型
                    json.put("BAE703", user.getAab001());//主体编号
                    json.put("BUS_ID", CodeConstant.SY_BUS_ID_1);
                    json.put("SAA043", CodeConstant.SAA043_SAA043_3);//业务状态
                    json.put("SAA037", user.getLoginName());//申请人
                    json.put("SAA038", CommonUtility.get19BitCurTimeAPP());//申请时间
                    json.put("BAE941", "XY" + GenerateSequenceUtil.generateSequenceNo());//申报流水号
                    json.put("AAC001", pm_ac01View.getAAC001());//个人编号
                    json.put("AAC002", pm_ac01View.getAAC002());//身份证
                    //json.put("AAA040", str.substring(str.indexOf('#') + 1, 14));//缴费比例类别
                    json.put("AAE160", AAE160);//组织暂停原因
                    json.put("BAC510", CommonUtility.get10BitCurTimeAPP());// 组织最近参保时间-对应最近参保时间BAC510---AC02 待上线前与客户确认是否手动输入.！！！！！！！
                    json.put("AAE035", CommonUtility.get10BitCurTimeAPP());//组织暂停时间对应aae035变更时间AC05
                    json.put("AAE140", CodeConstant.AAE140_AAE140_2);//险种
                    json.put("AAC031", CodeConstant.AAC031_AAC031_2);//组织参保状态为参保缴费，批量不允许选择终止
                    json.put("AAC050", CodeConstant.AAC050_AAC050_22);//组织变更类型为停保‘22’--‘12’为续保
                    json.put("AAE102", CodeConstant.AAE102_AAE102_4);//组织办理状态为办理完毕
                    json.put("AAE003", CommonUtility.get6BitCurTimeAPP());//对应费款所属期
                    json.put("AAE011", user.getLoginName());// 经办人
                    json.put("AAE036", CommonUtility.get19BitCurTimeAPP());//经办时间
                    json.put("TAA101", CommonUtility.get19BitCurTimeAPP());//申报时间
                    json.put("TAA103", CodeConstant.TAA103_TAA103_0);//审核结果,0待审核,1审核通过,2审核不通过
                    json.put("TAA105", CodeConstant.TAA105_TAA105_1);// 申报来源,1网上大厅
                    jsonArray.add(json);
                }
                System.out.println(jsonArray);
                /*=========开始调用停保接口=========*/
                JSONObject jsonObject = syrytbdjservice.confirmSyTb(jsonArray.toString());
                if ("0".equals(jsonObject.getString("code"))) {
                    addMessage(redirectAttributes, "人员批量停保提交成功，请在\"受理进度查询\"处查询批量停保结果");
                } else {
                    addMessage(redirectAttributes, "人员停保业务办理失败: " + jsonObject.getString("msg"));
                }
            } else {
                addMessage(redirectAttributes, "批量上传失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            addMessage(redirectAttributes, "批量停保失败！ ");
        }
        return "redirect:" + adminPath + "/sybx/syrytbdj/web_syrytbdj/list?repage";
    }

    private List<PM_AC01View> readFile(String aab001, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        List<PM_AC01View> personInfoList = null;
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile multipartFile = req.getFile(iterator.next());
                String fileNames = multipartFile.getOriginalFilename();
                int split = fileNames.lastIndexOf(".");
                File file = new File(aab001 + "." + fileNames.substring(split + 1, fileNames.length()));
                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos);
                bos.write(multipartFile.getBytes());
                HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
                HSSFSheet hssfSheet = workbook.getSheetAt(0);
                personInfoList = new ArrayList<>();
                if (hssfSheet.getLastRowNum() > 5000) {
                    addMessage(redirectAttributes, "批量上传不能超过5000条记录.");
                    return personInfoList;
                }
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    PM_AC01View pm_ac01View = new PM_AC01View();
                    if (hssfRow == null) {
                        continue;
                    }
                    HSSFCell cell_1 = hssfRow.getCell(1);
                    cell_1.setCellType(Cell.CELL_TYPE_STRING);
                    if (cell_1 != null) {
                        String aac001 = cell_1.getStringCellValue();
                        if (aac001 == null || "".equals(aac001)) {
                            continue;
                        }
                        pm_ac01View.setAAC001(aac001);
                    }
                    HSSFCell cell_2 = hssfRow.getCell(2);
                    cell_1.setCellType(Cell.CELL_TYPE_STRING);
                    if (cell_2 != null) {
                        String aac003 = cell_2.getStringCellValue();
                        if (aac003 != null && !"".equals(aac003)) {
                            pm_ac01View.setAAC003(aac003);
                        }
                    }
                    HSSFCell cell_3 = hssfRow.getCell(3);
                    cell_1.setCellType(Cell.CELL_TYPE_STRING);
                    if (cell_3 != null) {
                        String aac002 = cell_3.getStringCellValue();
                        if (aac002 != null && !"".equals(aac002)) {
                            pm_ac01View.setAAC002(aac002);
                        }
                    }
                    personInfoList.add(pm_ac01View);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            addMessage(redirectAttributes, "批量上传失败！ ");
        } finally {
            if (fos != null) {
                try {
                    bos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return personInfoList;
    }
}
