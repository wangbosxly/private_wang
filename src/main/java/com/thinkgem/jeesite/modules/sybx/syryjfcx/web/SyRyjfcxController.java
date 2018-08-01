package com.thinkgem.jeesite.modules.sybx.syryjfcx.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.excel.sy.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.sy.StaticCodeConvert;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC88View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sybx.syryjfcx.service.SyRyjfcxService;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * 失业人员缴费查询控制器
 * @description 
 * @since 20170614
 * @author njx
 * @version 1.0
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syryjfcx/web_syryjfcx")
public class SyRyjfcxController extends BaseController {
    @Autowired
    private SyRyjfcxService syryjfcxservice;

    @RequestMapping(value = {"list", ""})
    public String list(PM_AC01View pm_ac01view, HttpServletRequest request, HttpServletResponse response, Model model) {
        //获取单位编号
        List officeList = UserUtils.getOfficeList();
        Office office = (Office) officeList.get(0);

        //创建对象
        UserView userView = new UserView();
        //设置截止费款所属期默认值查询条件为当前月份
        pm_ac01view.setAAE002(CommonUtility.get6BitCurTimeAPP());

        //用空闲字段AAC058、AAE011、BAC801 控制列表、导出按钮是否显示
        pm_ac01view.setAAC058("noQuery");//不显示"未查询到符合条件的记录，请确认您输入的查询条件"
        pm_ac01view.setAAE011("firstDisplayInfo");//显示"暂无数据，请输入查询条件后点击【查询】按钮"
        pm_ac01view.setBAC801("noDisplayButton");//没有数据不显示【确认导出】按钮
        //设置实体属性
        model.addAttribute("pm_ac88view", pm_ac01view);
        return "modules/sybx/syryjfcx/sy_ryjfcxList";
    }

    @RequestMapping(value = "searchAC88Info")
    public String searchAC88Info(PM_AC88View pm_ac88view, Model model, HttpServletRequest request, HttpServletResponse response) {
        //封装前台参数，后台参数service层传递
        JSONObject json = getJsonObject(pm_ac88view);
        //正常应交记录
        json.put("AAE143", CodeConstant.AAE143_AAE143_1);
        json.put("AAE140", CodeConstant.AAE140_AAE140_2);
        //调用接口查询数据
        Page page = new Page<PM_AC88View>(request, response);
        page = syryjfcxservice.getPageList(page, json);
        model.addAttribute("pm_ac88view", pm_ac88view);
        model.addAttribute("page", page);
        return "modules/sybx/syryjfcx/sy_ryjfcxList";
    }

    /**
     * 参数封装方法
     * @param pm_ac88view 前台传递的参数
     * @return
     */
    private JSONObject getJsonObject(PM_AC88View pm_ac88view) {
        JSONObject json = new JSONObject();
        json.put("AAE003", pm_ac88view.getAAE003());
        json.put("AAE002", pm_ac88view.getAAE002());
        json.put("AAC003", pm_ac88view.getAAC003());
        json.put("AAE143", pm_ac88view.getAAE143());
        //身份证号
        json.put("AAC002", pm_ac88view.getAAC002());
        //个人编号
        json.put("AAC001", pm_ac88view.getAAC001());
        return json;
    }

    /**
     * 数据打印
     * @param pm_ac88view
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "export")
    public String export(PM_AC88View pm_ac88view, HttpServletRequest request, HttpServletResponse response) {
        //封装参数
        JSONObject json = getJsonObject(pm_ac88view);
        //调用接口获取数据
        List<PM_AC88View> list = syryjfcxservice.getList(json);
        if (list.size() == 0) {
            String errMsg = "没有可导出的数据";
        }
        //指定下载的文件名
        String fileName = "失业保险人员缴费查询列表.xls";
        // 定义单元格报头
        String worksheetTitle = "失业保险人员缴费查询";

        List<String> columsTitles = new ArrayList<String>();
        columsTitles.add("姓名");
        columsTitles.add("个人编号");
        columsTitles.add("身份证号");
        columsTitles.add("缴费类型");
        columsTitles.add("费款所属期");
        columsTitles.add("个人缴费基数总额");
        columsTitles.add("个人缴费金额");
        columsTitles.add("单位应缴金额");
        columsTitles.add("缴费合计");
        columsTitles.add("缴费标志");
        try {
            fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.reset();
        response.setHeader("Content-Disposition", "attachment;filename="
                + fileName);// 指定下载的文件名
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        OutputStream output = null;
        try {
            output = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建单元格样式
        HSSFCellStyle cellStyleTitle = wb.createCellStyle();
        // 指定单元格居中对齐
        cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 指定单元格垂直居中对齐
        cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 指定当单元格内容显示不下时自动换行
        cellStyleTitle.setWrapText(false);

        //设置单元格格式 begin
        // ①----------------------文本显示格式---------------------------------
        HSSFCellStyle cellStyle = wb.createCellStyle();
        // 指定单元格居中对齐
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //文字居中对齐
        // 指定单元格垂直居中对齐
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 指定当单元格内容显示不下时自动换行
        cellStyle.setWrapText(false);
        //②----------------------数字显示格式---------------------------------
        HSSFCellStyle cellStyle_number = wb.createCellStyle();
        // 指定单元格居中对齐
        cellStyle_number.setAlignment(HSSFCellStyle.ALIGN_RIGHT); //数字具有对齐
        // 指定单元格垂直居中对齐
        cellStyle_number.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 指定当单元格内容显示不下时自动换行
        cellStyle_number.setWrapText(false);
        //设置单元格格式 end
        // ------------------------------------------------------------------

        // 设置单元格字体
        HSSFFont font = wb.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeight((short) 200);
        cellStyleTitle.setFont(font);

        // 工作表名
        HSSFSheet sheet = wb.createSheet();
        ExportExcel exportExcel = new ExportExcel(wb, sheet);
        // 创建报表头部
        exportExcel.createNormalHead(worksheetTitle, columsTitles.size() + 1);
        // 定义第一行
        HSSFRow row1 = sheet.createRow(1);


        //第一行第i列；
        for (int i = 0; i < columsTitles.size(); i++) {
            HSSFCell cell1 = row1.createCell(i);
            cell1.setCellStyle(cellStyleTitle);
            cell1.setCellValue(new HSSFRichTextString(columsTitles.get(i)));
        }

        //定义第二行
        HSSFRow row = sheet.createRow(2);
        HSSFCell cell = row.createCell(1);
        Object[] arrays = list.toArray(new PM_AC88View[0]);
        PM_AC88View[] array = (PM_AC88View[]) arrays;
        float sum1 = 0;
        float sum2 = 0;
        float sum3 = 0;
        for (int i = 0; i < array.length; i++) {
            float a = Float.parseFloat(array[i].getAAC123());
            sum1 = sum1 + a;
            float b = Float.parseFloat(array[i].getAAC127());
            sum2 = sum2 + b;
            float c = Float.parseFloat(array[i].getBAC504_1());
            sum3 = sum3 + c;
            row = sheet.createRow(i + 2);

            cell = row.createCell(0);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new HSSFRichTextString(array[i].getAAC003() + ""));

            cell = row.createCell(1);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new HSSFRichTextString(array[i].getAAC001()));

            cell = row.createCell(2);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new HSSFRichTextString(array[i].getAAC002()));

            cell = row.createCell(3);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new HSSFRichTextString(StaticCodeConvert.returnCodeName_AAE143(array[i].getAAE143())));

            cell = row.createCell(4);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new HSSFRichTextString(array[i].getAAE002()));

            cell = row.createCell(5);
            cell.setCellStyle(cellStyle_number);
            cell.setCellValue(new HSSFRichTextString(array[i].getBAC504()));

            cell = row.createCell(6);
            cell.setCellStyle(cellStyle_number);
            cell.setCellValue(new HSSFRichTextString(array[i].getAAC123()));

            cell = row.createCell(7);
            cell.setCellStyle(cellStyle_number);
            cell.setCellValue(new HSSFRichTextString(array[i].getAAC127()));

            cell = row.createCell(8);
            cell.setCellStyle(cellStyle_number);
            cell.setCellValue(new HSSFRichTextString(array[i].getBAC504_1()));

            cell = row.createCell(9);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new HSSFRichTextString(StaticCodeConvert.returnCodeName_AAE114(array[i].getAAE114())));
        }

        HSSFRow row3 = sheet.createRow(array.length + 2);
        HSSFCell cell3;
        cell3 = row3.createCell(4);
        cell3.setCellStyle(cellStyle);
        cell3.setCellValue(new HSSFRichTextString("合计:"));

        DecimalFormat decimalFormat = new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p1 = decimalFormat.format(sum1);//format 返回的是字符串
        String p2 = decimalFormat.format(sum2);//format 返回的是字符串
        String p3 = decimalFormat.format(sum3);//format 返回的是字符串
        if (".00".equals(p1)) {
            p1 = "0.00";
        }
        if (".00".equals(p2)) {
            p2 = "0.00";
        }
        if (".00".equals(p3)) {
            p2 = "0.00";
        }
        cell3 = row3.createCell(6);
        cell3.setCellStyle(cellStyle);
        cell3.setCellValue(new HSSFRichTextString(p1));
        cell3 = row3.createCell(7);
        cell3.setCellStyle(cellStyle);
        cell3.setCellValue(new HSSFRichTextString(p2));
        cell3 = row3.createCell(8);
        cell3.setCellStyle(cellStyle);
        cell3.setCellValue(new HSSFRichTextString(p3));
        try {
            bufferedOutPut.flush();
            wb.write(bufferedOutPut);
            bufferedOutPut.close();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "modules/sybx/syryjfcx/sy_ryjfcxList";
    }
}
