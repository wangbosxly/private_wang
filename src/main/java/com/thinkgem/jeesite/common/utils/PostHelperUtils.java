package com.thinkgem.jeesite.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.sybx.util.PostHelper;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.vsame.url2sql.utils.PostParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 利用json调用远程服务并对结果集进行操作的的工具类
 *
 * @author X_P
 * @create 2018-03-13 17:44
 */
public class PostHelperUtils {
    private static Map<String, String> BJB003 = new HashMap<>();

    static {
        BJB003.put("01", "A");//兼并重组
        BJB003.put("02", "B");//化解产能过剩
        BJB003.put("03", "C");//淘汰落后产能
        BJB003.put("04", "D");//中小企业
    }

    /**
     * 通过user获取前置json,保存有调用接口必传的字段
     */
    public static JSONObject buildGsJSON(){
        User user = UserUtils.getUser();
        JSONObject json = new JSONObject();
        json.put("AAE170", user.getGsAAE170());
        json.put("AAB001", user.getGsAAB001());
        json.put("BAA001", user.getGsBAA001());
        return json;
    }



    /**
     * 通过接口路径查询信息
     *
     * @param url  接口访问路径
     * @param json 访问参数的json字符串
     * @return json对象
     */
    public static JSONObject getJSONInfo(String url, String json) {
        List<PostParam> params = new ArrayList<PostParam>();
        params.add(new PostParam("params", "string", json));
        JSONObject send = PostHelper.send(url, params);
        System.out.println(send);
        return send;
    }

    /**
     * 判断是否接口调用的结果是否成功 code为0则成功
     *
     * @param jsonObject
     * @return
     */
    public static boolean hasInfo(JSONObject jsonObject) {
        if (jsonObject == null) {
            return false;
        }
        String code = jsonObject.getString("code");
        return "0".equals(code);
    }

    /**
     * 解析嵌套的json
     *
     * @param jsonObject
     * @return
     */
    public static JSONObject toParseJSONObject(JSONObject jsonObject,String info) {
        if (hasInfo(jsonObject)) {
            return JSONObject.parseObject(jsonObject.getString(info));
        } else {
            //如果没有信息
            return null;
        }
    }

    /**
     * 解析为封装result的array
     */
    public static JSONArray toJSONArray(JSONObject jsonObject, String info){
        if (hasInfo(jsonObject)) {
            return JSONArray.parseArray(jsonObject.getString(info));
        } else {
            //如果没有信息
            return null;
        }
    }

    /**
     * 解析嵌套的json
     *
     * @param jsonObject
     * @return
     */
    public static JSONObject toParseJSONObject(JSONObject jsonObject) {
       return toParseJSONObject(jsonObject, "result");
    }

    /**
     * 解析list的方法,info为封装的list的名称，一般默认为“LIST”
     * 有时抽疯会使用其他名称。
     *
     * @param jsonObject 获取的数据
     * @param info       要解析的list的名称
     * @return
     */
    public static JSONArray toParseJSONArray(JSONObject jsonObject, String info) {
        jsonObject = toParseJSONObject(jsonObject);
        if (hasInfo(jsonObject)) {
            return JSONArray.parseArray(jsonObject.getString(info));
        } else {
            //如果没有信息
            return null;
        }
    }

    /**
     * 默认的解析list方法
     *
     * @param jsonObject 获取的数据
     * @return
     */
    public static JSONArray toParseJSONArray(JSONObject jsonObject) {
        return toParseJSONArray(jsonObject, "LIST");
    }

    /**
     * 将调用获取的数据进行page封装
     *
     * @param page 一个page对象
     * @param list 数据
     * @param size 每页显示多少行
     * @return
     */
    public static Page getPage(Page page, List list, Integer size) {
        if (list == null || page == null) {
            return null;
        }
        if (size == null) {
            size = 20;
        }
        int count = list.size();
        List subList = CommonUtility.subPage(page.getPageNo(), count, size, page.getLast(), list);
        page.setCount(count);
        page.setList(subList);
        return page;
    }

    /**
     * 将调用获取的数据进行page封装
     *
     * @param page 一个page对象
     * @param list 数据
     * @param size 每页显示多少行
     * @return
     */
    public static Page getPage(Page page, List list,String countNum, Integer size) {
        if (list == null || page == null) {
            return null;
        }
        if (size == null) {
            size = 20;
        }
        int count = Integer.parseInt(countNum);
        page.setCount(count);
        page.setList(list);
        return page;
    }

/**
 * 打印pdf报表的重载方法，使用默认名称
 */
public static void printPDF(JSONObject json,String filepath,HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
    printPDF(json,filepath,"export.pdf",request,response);
}


    /**
     * 打印pdf报表的重载方法
     */
    public static void printPDF(JSONObject json,String filepath,String filename,HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
        Map<String, String> map = (Map<String, String>) JSONObject.toJSON(json);
        printPDF(map,filepath,filename,request,response);
    }

    /**
     * 打印pdf通用方法
     * @param map 打印报表的对应内容
     * @param filepath 报表模板的路径
     * @param filename 生成的文件名
     * @param request
     * @param response
     */
    public static void printPDF(Map<String,String> map,String filepath,String filename,HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
        String fileName = new String(filename.getBytes("gbk"), "utf-8");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        ServletOutputStream ouputStream = response.getOutputStream();
        //路径
        String realPath = request.getRealPath(filepath);
        File reportFile = new File(realPath);
        Map parameters = map;
        JasperPrint jasperPrint = null;
        try {
            //数据集此处传NULL
            ResultSet rss = null;
            JRDataSource rb = new JRResultSetDataSource(rss);
            //数据填充
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, rb);
        } catch (NullPointerException npe) {
            npe.getLocalizedMessage();
            npe.getMessage();
            npe.toString();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        ouputStream = response.getOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
        exporter.exportReport();
        ouputStream.flush();
        ouputStream.close();
    }





    /**
     * 一次性伤残补助打印
     * @param json
     * @param request
     * @param response
     * @throws IOException
     * @throws JRException
     */
    public static void exportGSSCBZpdf(JSONObject json, HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
        String defaultname = "export.pdf";
        String fileName = new String(defaultname.getBytes("gbk"), "utf-8");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        ServletOutputStream ouputStream = response.getOutputStream();
        //路径
        String realPath = request.getRealPath("/WEB-INF/jasper/reportGSSCBZ.jasper");
        File reportFile = new File(realPath);
        Map parameters = new HashMap();
        JasperPrint jasperPrint = null;
        parameters.put("AAB004", json.getString("AAB004"));
        parameters.put("AAC003", json.getString("AAC003"));
        parameters.put("AAC002", json.getString("AAC002"));
        parameters.put("year", json.getString("year"));
        parameters.put("month", json.getString("month"));
        parameters.put("AAC001", json.getString("AAC001"));
        parameters.put("AAC005", DictUtils.getDictLabels(json.getString("AAC005"),"AAC005_5",""));
        parameters.put("AAC004", DictUtils.getDictLabels(json.getString("AAC004"),"AAC004_5",""));
        parameters.put("AMC032", json.getString("AMC032"));
        parameters.put("ALC020", json.getString("ALC020"));
        parameters.put("ALC031", json.getString("ALC031"));
        parameters.put("ALA040",  DictUtils.getDictLabels(json.getString("ALA040"),"ALA040_GS",""));
        parameters.put("ALC034", json.getString("ALC034"));
        parameters.put("AAA013", json.getString("AAA013"));
        parameters.put("ALA041_020", json.getString("ALA041_020"));
        double aaa013 = Double.parseDouble(json.getString("AAA013"));
        double ala041_020 = Double.parseDouble(json.getString("ALA041_020"));
        double m = aaa013 * ala041_020;
        String s = RMBUtils.number2CNMontrayUnit(new BigDecimal(String.valueOf(m)));
        parameters.put("money", s);
        try {
            //数据集此处传NULL
            ResultSet rss = null;
            JRDataSource rb = new JRResultSetDataSource(rss);
            //数据填充
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, rb);

        } catch (NullPointerException npe) {
            npe.getLocalizedMessage();
            npe.getMessage();
            npe.toString();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        ouputStream = response.getOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
        exporter.exportReport();
        ouputStream.flush();
        ouputStream.close();
    }



    /**
     * 生育卡打印
     * @param json
     * @param request
     * @param response
     * @throws IOException
     * @throws JRException
     */
    public static void exportGSZGSYPdf(JSONObject json, HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
        String defaultname = "export.pdf";
        String fileName = new String(defaultname.getBytes("gbk"), "utf-8");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        ServletOutputStream ouputStream = response.getOutputStream();
        //路径
        String realPath = request.getRealPath("/WEB-INF/jasper/GSZGSY.jasper");
        File reportFile = new File(realPath);
        Map parameters = new HashMap();
        JasperPrint jasperPrint = null;
        parameters.put("AAB004", json.getString("AAB004"));
        parameters.put("AAC003", json.getString("AAC003"));
        parameters.put("year", json.getString("year"));
        parameters.put("month", json.getString("month"));
        parameters.put("AAC001", json.getString("AAC001"));
        parameters.put("AAC005", DictUtils.getDictLabels(json.getString("AAC005"),"AAC005_5",""));
        parameters.put("AMC032", json.getString("AMC032"));
        parameters.put("AAC002", json.getString("AAC002"));
        try {
            //数据集此处传NULL
            ResultSet rss = null;
            JRDataSource rb = new JRResultSetDataSource(rss);
            //数据填充
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, rb);

        } catch (NullPointerException npe) {
            npe.getLocalizedMessage();
            npe.getMessage();
            npe.toString();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        ouputStream = response.getOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
        exporter.exportReport();
        ouputStream.flush();
        ouputStream.close();
    }


    /**
     * 稳岗补贴打印
     * @param json
     * @param request
     * @param response
     * @throws IOException
     * @throws JRException
     */
    public static void exportWGBTPdf(JSONObject json, HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
        String defaultname = "export.pdf";
        String fileName = new String(defaultname.getBytes("gbk"), "utf-8");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        ServletOutputStream ouputStream = response.getOutputStream();
        //路径
        String realPath = request.getRealPath("/static/reportWGBT2.jasper");
        File reportFile = new File(realPath);
        Map parameters = new HashMap();
        JasperPrint jasperPrint = null;
        parameters.put("AAB004", json.getString("AAB004"));//单位名称
        parameters.put("AAB020", json.getString("AAB020"));//注册类型
        parameters.put("AAE006", json.getString("AAE006"));//企业地址
        parameters.put("AAB013", json.getString("AAB013"));//法定代表人
        parameters.put(BJB003.get(json.getString("BJB003")), "√");//补贴类型：BJB003,从缓存中获取数据
        parameters.put("personNum", json.getString("personNum"));//上年末职工人数
        parameters.put("AAB083", json.getString("AAB083"));//参加失业保险人数
        parameters.put("AJC159", json.getString("AJC159"));//合计金额
        parameters.put("BJC408", json.getString("BJC408")==null?"":json.getString("BJC408"));//失业保险金额
        try {
            //数据集此处传NULL
            ResultSet rss = null;
            JRDataSource rb = new JRResultSetDataSource(rss);
            //数据填充
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, rb);

        } catch (NullPointerException npe) {
            npe.getLocalizedMessage();
            npe.getMessage();
            npe.toString();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        ouputStream = response.getOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
        exporter.exportReport();
        ouputStream.flush();
        ouputStream.close();
    }

    /**
     * 失业缴费核定打印
     * @param json
     * @param request
     * @param response
     * @throws IOException
     * @throws JRException
     */
    public static void exportPdf(JSONObject json, HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
        String defaultname = "export.pdf";
        String fileName = new String(defaultname.getBytes("gbk"), "utf-8");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        ServletOutputStream ouputStream = response.getOutputStream();
        //路径
        /*String path = this.getClass().getClassLoader().getResource("/").getPath();
        request.getContextPath();*/
        String realPath = request.getRealPath("/static/payprint.jasper");
        /*path = path.substring(0, path.lastIndexOf("jeesit-tc"));
        String fp = path + "jeesit-tc" + realPath + "/sy/M4008/payprint.jasper";*/
        // fp=fp.replace("/", "\\");
        File reportFile = new File(realPath);
        Map parameters = new HashMap();
        JasperPrint jasperPrint = null;
        //给金额保留两位小数
        DecimalFormat format = new DecimalFormat("0.00");
        //TODO 前人挖坑埋后人，类的成员变量起名请用小写，谢谢。
        //实际应交
        String BAE713 = format.format(new BigDecimal(getString(json, "BAE713")));
        //单位缴费
        String BAB701 = format.format(new BigDecimal(getString(json, "BAB701")));
        //个人缴费
        String AAB122 = format.format(new BigDecimal(getString(json, "AAB122")));
        if ("2".equals(getString(json, "AAB033"))) {
            json.put("AAB033", "税务征收");
        } else {
            json.put("AAB033", "经办机构自收");
        }
        //参数
        parameters.put("BAE703", getString(json, "BAE703")); //主体编号
        parameters.put("AAB004", getString(json, "AAB004")); //主体名称
        parameters.put("AAE003", getString(json, "AAE003")); //对应费款所属期
        parameters.put("AAE063", getString(json, "AAE063")); //征集流水号
        parameters.put("BAE713", BAE713); //应缴金额
        parameters.put("AAB033", getString(json, "AAB033")); //缴费方式
        parameters.put("BAB701", BAB701); //单位缴费
        parameters.put("AAB122", AAB122); //个人缴费
        parameters.put("StartYM", getString(json, "StartYM")); //起止费款所属期
        parameters.put("EndYM", getString(json, "EndYM")); //截止费款所属期
        // parameters.put("SUMAAE002", ab88View1.getSUMAAE002()); //共缴费
        parameters.put("AAB034", getString(json, "AAB034")); //经办机构

        parameters.put("AAE036", getString(json, "AAE036")); //经办日期

        parameters.put("AAE011", getString(json, "AAE011")); //经办人?
        parameters.put("AAB083", getString(json, "AAB083")); //人数


        String strartYm = getString(json, "StartYM");
        String endYm = getString(json, "EndYM");
        int SUM = 1;
        try {
            SUM = DateUtils.getMouthOfTwoDate(DateUtils.parseDate(strartYm, "yyyyMM"), DateUtils.parseDate(endYm, "yyyyMM")) + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        parameters.put("SUM", String.valueOf(SUM)); //月数

        try {
            //数据集此处传NULL
            ResultSet rss = null;
            JRDataSource rb = new JRResultSetDataSource(rss);
            //JasperReport jasperReport = JasperCompileManager.compileReport(reportFile.getPath());
            //数据填充
            // jasperPrint =JasperFillManager.fillReport(jasperReport,parameters,rb);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, rb);

        } catch (NullPointerException npe) {
            npe.getLocalizedMessage();
            npe.getMessage();
            npe.toString();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        ouputStream = response.getOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
        exporter.exportReport();
        ouputStream.flush();
        ouputStream.close();
    }

    /**
     * 从json中获取数据（被坑的方法，正常不用此方法）
     *
     * @param json
     * @param x
     * @return
     */
    private static String getString(JSONObject json, String x) {
        String bae713 = json.getString(x);
        //首字母转换为小写查询
        if (bae713 == null) {
            bae713 = json.getString(StringUtils.uncapitalize(x));
        }
        return bae713;
    }

}