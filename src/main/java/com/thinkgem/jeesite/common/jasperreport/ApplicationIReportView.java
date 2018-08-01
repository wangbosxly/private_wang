package com.thinkgem.jeesite.common.jasperreport;

import java.util.Map;  

import net.sf.jasperreports.engine.JasperPrint;  
import net.sf.jasperreports.engine.JasperReport; 

import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;


/** 
 * SpringMVC + IReport整合 视图处理扩展 
 * @Author 华开勇 
 * @Create 2016-10-21 21:38:18 
 */  
public class ApplicationIReportView extends JasperReportsMultiFormatView {  
    private JasperReport jasperReport;  
      
    public ApplicationIReportView() {  
        super();  
    }  
  
    protected JasperPrint fillReport(Map<String, Object> model) throws Exception {  
    	Map parameters = (Map) model.get("parameterMap");
    	if(!parameters.equals(null)){
    		model.putAll(parameters);
    	}
        if (model.containsKey("url")) {
            setUrl(String.valueOf(model.get("url")));  
            this.jasperReport = loadReport();
        }  
        return super.fillReport(model);  
    }  
      
    protected JasperReport getReport() {  
        return this.jasperReport;  
    }  
} 