/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.common.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.beanvalidator.BeanValidators;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.FileUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.common.utils.SystemPath;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.*;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 控制器支持类
 * @author ThinkGem
 * @version 2013-3-23
 */
public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 管理基础路径
	 */
	@Value("${adminPath}")
	protected String adminPath;
	
	/**
	 * 前端基础路径
	 */
	@Value("${frontPath}")
	protected String frontPath;
	
	/**
	 * 前端URL后缀
	 */
	@Value("${urlSuffix}")
	protected String urlSuffix;
	
	/**
	 * 验证Bean实例对象
	 */
	@Autowired
	protected Validator validator;

	/**
	 * 服务端参数有效性验证
	 * @param object 验证的实体对象
	 * @param groups 验证组
	 * @return 验证成功：返回true；严重失败：将错误信息添加到 message 中
	 */
	protected boolean beanValidator(Model model, Object object, Class<?>... groups) {
		try{
			BeanValidators.validateWithException(validator, object, groups);
		}catch(ConstraintViolationException ex){
			List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
			list.add(0, "数据验证失败：");
			addMessage(model, list.toArray(new String[]{}));
			return false;
		}
		return true;
	}
	
	/**
	 * 服务端参数有效性验证
	 * @param object 验证的实体对象
	 * @param groups 验证组
	 * @return 验证成功：返回true；严重失败：将错误信息添加到 flash message 中
	 */
	protected boolean beanValidator(RedirectAttributes redirectAttributes, Object object, Class<?>... groups) {
		try{
			BeanValidators.validateWithException(validator, object, groups);
		}catch(ConstraintViolationException ex){
			List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
			list.add(0, "数据验证失败：");
			addMessage(redirectAttributes, list.toArray(new String[]{}));
			return false;
		}
		return true;
	}
	
	/**
	 * 服务端参数有效性验证
	 * @param object 验证的实体对象
	 * @param groups 验证组，不传入此参数时，同@Valid注解验证
	 * @return 验证成功：继续执行；验证失败：抛出异常跳转400页面。
	 */
	protected void beanValidator(Object object, Class<?>... groups) {
		BeanValidators.validateWithException(validator, object, groups);
	}
	
	/**
	 * 添加Model消息
	 * @param messages
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		model.addAttribute("message", sb.toString());
	}
	
	/**
	 * 添加Flash消息
	 * @param messages
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}
	
	/**
	 * 客户端返回JSON字符串
	 * @param response
	 * @param object
	 * @return
	 */
	protected String renderString(HttpServletResponse response, Object object) {
		return renderString(response, JsonMapper.toJsonString(object), "application/json");
	}
	
	/**
	 * 客户端返回字符串
	 * @param response
	 * @param string
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
	        response.setContentType(type);
	        response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 参数绑定异常
	 */
	@ExceptionHandler({BindException.class, ConstraintViolationException.class, ValidationException.class})
    public String bindException() {  
        return "error/400";
    }
	
	/**
	 * 授权登录异常
	 */
	@ExceptionHandler({AuthenticationException.class})
    public String authenticationException() {  
        return "error/403";
    }
	
	/**
	 * 初始化数据绑定
	 * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
	 * 2. 将字段中Date类型转换为String类型
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}
			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}
//			@Override
//			public String getAsText() {
//				Object value = getValue();
//				return value != null ? DateUtils.formatDateTime((Date)value) : "";
//			}
		});
	}
	
	
	/**
	 * 打印方法
	 * @param model
	 * @param reportFileName
	 * @param map
	 * @param dataList
	 */
	public void initReportData(Model model, String reportFileName, Map map, List<?> dataList){
		// 报表数据源  
	    JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataList); 
		// 动态指定报表模板url
	    model.addAttribute("format", "pdf"); // 报表格式  
	    model.addAttribute("url", "/WEB-INF/classes/jasper/" + reportFileName); 
	    model.addAttribute("jrMainDataSource", jrDataSource);
	    model.addAttribute("parameterMap", map);
	}
	
	/**
	 * 导出PDF
	 * @param request
	 * @param response
	 * @param reprotfileName	报表文件名称
	 * @param parameters		报表parameter传参map
	 * @param dataList			列表数据传参list	
	 * @param exportfilename	导出文件名称
	 * @throws JRException
	 * @throws IOException
	 */
	public void exportPdf(HttpServletRequest request, HttpServletResponse response, String reprotfileName, 
			Map parameters, List<?> dataList, String exportfilename) throws JRException, IOException{ 
        //String ctxpath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/jasper/MvcIReportExample.jasper");
		//String filePrefix = "D://smis_workspace//smis//src//main//webapp//WEB-INF//classes//jasper//";
		
		String filePrefix = FileUtils.rePath(SystemPath.getClassPath() + "jasper//");
        File reFile = new File(filePrefix + reprotfileName);
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(dataList);  
        JasperPrint jasperPrint = JasperFillManager.fillReport(reFile.getPath(), parameters, ds);             

        response.isCommitted();
        JRPdfExporter exporter = new JRPdfExporter();       
        exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT,jasperPrint);  
        exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM,response.getOutputStream());  
        response.setHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(exportfilename, "utf8") + ".pdf");  
        response.setContentType("application/pdf");  
        response.setCharacterEncoding("utf-8");  
        exporter.exportReport();
        
        response.isCommitted();
	}
	
	/**
	 * 导出HTML格式
	 * @param request
	 * @param response
	 * @param reprotfileName	报表文件名称
	 * @param parameters		报表parameter传参map
	 * @param dataList			列表数据传参list	
	 * @throws IOException
	 * @throws JRException
	 */
	public void exportHtml(HttpServletRequest request,  HttpServletResponse response, String reprotfileName, 
			Map parameters, List<?> dataList)  throws IOException, JRException {  
        //String ctxpath = request.getSession().getServletContext().getRealPath("/report/beandata.jasper");
        //String filePrefix = "D://smis_workspace//smis//src//main//webapp//WEB-INF//classes//jasper//";
		
		String filePrefix = FileUtils.rePath(SystemPath.getClassPath() + "jasper//");
        File reFile = new File(filePrefix + reprotfileName);
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(dataList);  
        JasperPrint jasperPrint = JasperFillManager.fillReport(reFile.getPath(), parameters, ds);  
          
        JRHtmlExporter exporter = new JRHtmlExporter();       
        //输出为html格式的报表文件  
        exporter.setParameter(JRHtmlExporterParameter.JASPER_PRINT, jasperPrint);  
        exporter.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM,response.getOutputStream());
        exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.FALSE);  
        //移除设计报表中的空白行 
        exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);  
        exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING, "utf-8"); 
        
        exporter.exportReport();  
    }
	
	/**
	 * 直接导出execel
	 * @param request
	 * @param response
	 * @param reprotfileName	报表文件名称
	 * @param parameters		报表parameter传参map
	 * @param dataList			列表数据传参list	
	 * @param exportfilename	导出文件名称
	 * @throws IOException
	 * @throws JRException
	 */
	public void exportXls(HttpServletRequest request, HttpServletResponse response, String reprotfileName, 
			Map parameters, List<?> dataList, String exportfilename) throws IOException, JRException {  
        //String ctxpath = request.getSession().getServletContext().getRealPath("/report/beandata.jasper");
		//String filePrefix = "D://smis_workspace//smis//src//main//webapp//WEB-INF//classes//jasper//";
		
		String filePrefix = FileUtils.rePath(SystemPath.getClassPath() + "jasper//");
        File reFile = new File(filePrefix + reprotfileName);  
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(dataList);  
        JasperPrint jasperPrint = JasperFillManager.fillReport(reFile.getPath(), parameters, ds); 
        
        JRXlsExporter exporter=new JRXlsExporter();       
        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);  
        exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, response.getOutputStream());  
        exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);  
        //设置输出的格式  
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(exportfilename, "utf8") + ".xls");  
        response.setContentType("application/vnd_ms-excel");  
        exporter.exportReport();
	}

    /**
     * 解析工伤生育Json,处理结果提示信息
     * @param json
     * @param model
     * @return
     */
    public  boolean validateGsJSON(JSONObject json, Model model,String msg) {
        String message = null;
        String ctype = "error";
        boolean flag = false;
        if(json==null||json.isEmpty()){
            message =  "接口调用失败，请联系经办机构";
        } else
        if ("-1".equals(json.getString("code"))) {
            message = json.getString("msg");
        } else if("0".equals(json.getString("code"))) {
            flag = true;
            if(msg==null){
                msg = (String) model.asMap().get("message");
            }
            message = msg;
            ctype = "success";
        }
        model.addAttribute("message", message);
        model.addAttribute("ctype", ctype);
        return flag;
    }

	/**
	 * 解析医疗保险Json,处理结果提示信息
	 */
	public  boolean validateYbJSON(JSONObject json, Model model,String msg) {
		String message = null;
		String ctype = "error";
		boolean flag = false;
		if(json==null||json.isEmpty()){
			message =  "接口调用失败，请联系经办机构";
		} else if ("-1".equals(json.getString("code"))) {
			message = json.getString("msg");
		} else if("0".equals(json.getString("code"))) {
			flag = true;
			message = msg;
			ctype = "success";
		}
		if (message != null) {
			message = message.replaceAll("\n","").replaceAll("\r","");
			if (message.length() >= 100) {
				message = message.substring(0, 100);
			}
		}
		model.addAttribute("message", message);
		model.addAttribute("ctype", ctype);
		return flag;
	}

	/**
	 * 处理接口返回数据  返回分页对象
	 */
	public Page getPage(JSONObject json, HttpServletRequest request, HttpServletResponse response) {
		JSONArray array = PostHelperUtils.toJSONArray(json, "RETLIST");
		Page page = new Page(request, response);
		List sublist = CommonUtility.subPage(page.getPageNo(), array.size(), 20, page.getLast(), array);
		page.setCount(array.size());
		page.setList(sublist);
		return page;
	}
}
