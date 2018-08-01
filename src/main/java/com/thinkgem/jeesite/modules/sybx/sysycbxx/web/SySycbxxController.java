package com.thinkgem.jeesite.modules.sybx.sysycbxx.web;

import com.thinkgem.jeesite.common.utils.excel.sy.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.sy.StaticCodeConvert;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.page.Pagination;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sybx.sysycbxx.service.SySycbxxService;
import com.thinkgem.jeesite.modules.sys.entity.User;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 失业失业参保信息控制器
 * @description 
 * @since 20170614
 * @author njx
 * @version 1.0
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/sysycbxx/web_sysycbxx")
public class SySycbxxController extends BaseController {
	@Autowired
	private SySycbxxService sysycbxxservice;
	
	/**
	 * 失业参保信息主方法
	 * @param pm_ac01view
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	public String list(PM_AC01View pm_ac01view, HttpServletRequest request, HttpServletResponse response, Model model) {
		//获取系统相关信息
		User user =  UserUtils.getUser();
		//根据登录人自动给姓名和身份证号赋值
		pm_ac01view.setAAC003(user.getName());
		pm_ac01view.setAAC002(user.getNo());
		
		//用空闲字段AAC058、AAE011、BAC801 控制列表、导出按钮是否显示
		pm_ac01view.setAAC058("noQuery");//不显示"未查询到符合条件的记录，请确认您输入的查询条件"
		pm_ac01view.setAAE011("firstDisplayInfo");//显示"暂无数据，请输入查询条件后点击【查询】按钮"
		pm_ac01view.setBAC801("noDisplayButton");//没有数据不显示【确认导出】按钮
		//设置实体属性
		model.addAttribute("pm_ac01view", pm_ac01view);
		return "modules/sybx/sysycbxx/sy_sycbxxList";
	}
	
	/**
	 * 失业参保信息查询操作
	 * @param pm_ac01view
	 * @param request
	 * @param response
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "searchInfo"})
	public String searchInfo(PM_AC01View pm_ac01view, HttpServletRequest request, HttpServletResponse response, Integer pageNo, Model model) {
		//获取系统信息
		User user =  UserUtils.getUser();
		
		//创建对象
		UserView userView = new UserView();
		
		//设置查询条件，调用失业参保信息接口
		userView.setBAE702(CodeConstant.BAE702_BAE702_0);
		userView.setSSA004(CodeConstant.SY_SSA004_1);
		pm_ac01view.setAAE140(CodeConstant.AAE140_AAE140_2);
		pm_ac01view.setBAA001(user.getBaa001());
		
		//获取界面输入的值
		String input_aac003 = pm_ac01view.getAAC003().trim();
		String input_aac002 = pm_ac01view.getAAC002().trim();
		
		//临时存储aac003和aac002;确保在页面显示后，输入的查询条件值不变，因为在下边对aac003和aac002做了加单引号处理.
		String temp_aac003="";
		String temp_aac002="";
		
		if(input_aac003.equals("")){
			input_aac003 = null;
			pm_ac01view.setAAC003(input_aac003);
		}else{
			temp_aac003 = input_aac003;
			input_aac003 = "'"+input_aac003+"'";
			pm_ac01view.setAAC003(input_aac003);
		}
		if(input_aac002.equals("")){
			input_aac002 = null;
			pm_ac01view.setAAC002(input_aac002);
		}else{
			temp_aac002 = input_aac002;
			input_aac002 = "'"+input_aac002+"'";
			pm_ac01view.setAAC002(input_aac002);
		}
		
		List list = new ArrayList();
		System.out.println("******1.控制层开始调用nwwssy2102接口开始******");
		list = sysycbxxservice.querySycbxxInfo(userView, pm_ac01view);
		Pagination p;
		if(list!=null){
			System.out.println("******2.控制层调用nwwssy2102接口结束，调用成功，数据返回成功******");
			if(pageNo==null){
				pageNo=1;
			}
			p = new Pagination(pageNo, CodeConstant.SY_PAGE_SIZE,  list.size());
			p.setList(pageNo, CodeConstant.SY_PAGE_SIZE, list);
			//控制相关信息和按钮显示
			pm_ac01view.setBAC801("displayButton");//显示【确认导出】按钮
			pm_ac01view.setAAC058("noQuery");//不显示"未查询到符合条件的记录，请确认您输入的查询条件"
		}else{
			System.out.println("******3.控制层调用nwwssy2102接口结束，接口没有数据返回，请检查原因,所在：SySycbxxController 类中******");
			p = new Pagination();
			p.setList(null);
			//用空闲字段AAC058、BAC801 控制列表、导出按钮是否显示
			pm_ac01view.setBAC801("noDisplayButton");//不显示【确认导出】按钮
			pm_ac01view.setAAC058("query");//显示"未查询到符合条件的记录，请确认您输入的查询条件"
		}
		//用空闲字段AAE011 控制列表、导出按钮是否显示
		pm_ac01view.setAAE011("secondDisplayInfo");//不显示"暂无数据，请输入查询条件后点击【查询】按钮"
		
		
		//查询结果返回后，将查询条件在赋给相应文本框内，保证查询条件不清空.便于用户确认查询的信息
		pm_ac01view.setAAC003(temp_aac003);		
		pm_ac01view.setAAC002(temp_aac002);		
		
		model.addAttribute("pm_ac01view", pm_ac01view);
		model.addAttribute("pagination_sycbxx", p);
		return "modules/sybx/sysycbxx/sy_sycbxxList";
	}
	
	/**
	 * 失业参保信息导出操作
	 * @param pm_ac01view
	 * @param pm_ac88view
	 * @param request
	 * @param response
	 * @param model
	 * @param saa015
	 * @param saa004
	 * @param szz003
	 * @param sza023
	 * @param sza024
	 * @param szz046
	 * @return
	 */
	@RequestMapping(value = "export")
	public String export(PM_AC01View pm_ac01view, HttpServletRequest request, HttpServletResponse response) {
		//创建对象
		UserView userView = new UserView();
		//获取系统信息
		User user =  UserUtils.getUser();
		
		//设置查询条件，调用失业人员缴费查询接口
		userView.setBAE702(CodeConstant.BAE702_BAE702_0);
		userView.setSSA004(CodeConstant.SY_SSA004_1);
		pm_ac01view.setAAE140(CodeConstant.AAE140_AAE140_2);
		pm_ac01view.setBAA001(user.getBaa001());
		
		//获取界面输入的值
		String input_aac003 = pm_ac01view.getAAC003().trim();
		String input_aac002 = pm_ac01view.getAAC002().trim();
		
		if(input_aac003.equals("")){
			input_aac003 = null;
			pm_ac01view.setAAC003(input_aac003);
		}else{
			input_aac003 = "'"+input_aac003+"'";
			pm_ac01view.setAAC003(input_aac003);
		}
		if(input_aac002.equals("")){
			input_aac002 = null;
			pm_ac01view.setAAC002(input_aac002);
		}else{
			input_aac002 = "'"+input_aac002+"'";
			pm_ac01view.setAAC002(input_aac002);
		}
		
		//获取导出信息
		List list = new ArrayList();
		list =  sysycbxxservice.querySycbxxInfo(userView, pm_ac01view);
		if(list.size()<=0 ){
			String errMsg  = "没有可导出的数据";
		}
		
		 //指定下载的文件名  
	    String fileName="单位"+userView.getAAB001()+"失业保险失业参保信息查询列表-"+ CommonUtility.get8BitCurTimeAPP()+".xls";
	    // 定义单元格报头
	    String worksheetTitle = "汉中市网上服务大厅失业保险失业参保信息查询";  
	    
	    List<String> columsTitles=new ArrayList<String>();
	    columsTitles.add("姓名");
	    columsTitles.add("身份证");
	    columsTitles.add("个人缴费基数");
	    columsTitles.add("参保状态");
	    columsTitles.add("参加失业保险时间");
		try {
			fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	     response.reset();  
	     response.setHeader("Content-Disposition", "attachment;filename="+ fileName);// 指定下载的文件名  
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
	     cellStyleTitle.setWrapText(true); 
   // ------------------------------------------------------------------  
	     HSSFCellStyle cellStyle = wb.createCellStyle();
	     // 指定单元格居中对齐
	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	     // 指定单元格垂直居中对齐 
	     cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	     // 指定当单元格内容显示不下时自动换行 
	     cellStyle.setWrapText(true);  
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
	     exportExcel.createNormalHead(worksheetTitle, columsTitles.size() +1); 
	     
	     // 定义第一行
	     HSSFRow row1 = sheet.createRow(1);
	     //第一行第i列；
	     for(int i=0; i< columsTitles.size();i++)
	     {
	    	  HSSFCell cell1 = row1.createCell(i);
	    	  cell1.setCellStyle(cellStyleTitle);  
	    	  cell1.setCellValue(new HSSFRichTextString(columsTitles.get(i)));
	     }
	       
	     //定义第二行 
	     HSSFRow row = sheet.createRow(2);
	     HSSFCell cell = row.createCell(1);
	     Object[] arrays = list.toArray(new PM_AC01View[0] );
	     PM_AC01View[] array = (PM_AC01View[])arrays;
	     float sum1 = 0;
	     for (int i = 0; i < array.length; i++) {  
	    	 float   a =Float.parseFloat(array[i].getBAC504());
	         sum1 = sum1 + a;
	         
	         row = sheet.createRow(i + 2);  
	         
	         cell = row.createCell(0);  
	         cell.setCellStyle(cellStyle);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getAAC003()));
	           
	         cell = row.createCell(1);  
	         cell.setCellStyle(cellStyle);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getAAC002()));
	           
	         cell = row.createCell(2);  
	         cell.setCellStyle(cellStyle);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getAAC030()));
	         
	         cell = row.createCell(3);  
	         cell.setCellStyle(cellStyle);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getBAC504()));
	         
	         cell = row.createCell(4);  
	         cell.setCellStyle(cellStyle);  
	         cell.setCellValue(new HSSFRichTextString(StaticCodeConvert.returnCodeName_AAC031(array[i].getAAC031())));
	     }
	     
	     //定义表格最后行
/*	     HSSFRow row3 = sheet.createRow(array.length+2); 
	     HSSFCell cell3 = row.createCell(array.length+1);
	     cell3 = row3.createCell(2);  
	     cell3.setCellStyle(cellStyle);  
	     cell3.setCellValue(new HSSFRichTextString("合计:"));

	     DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
	     String p1=decimalFormat.format(sum1);//format 返回的是字符串
	     if(".00".equals(p1)){
	    	 p1="0.00";
	     }
	     cell3 = row3.createCell(3); 
	     cell3.setCellStyle(cellStyle);  
	     cell3.setCellValue(new HSSFRichTextString(p1));*/
         try {
			bufferedOutPut.flush();
			wb.write(bufferedOutPut);  
			bufferedOutPut.close();  
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		} 
        return "modules/sybx/sysycbxx/sy_sycbxxList";
	}	
}
