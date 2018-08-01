package com.thinkgem.jeesite.modules.sybx.syjfjlcx.web;

import com.thinkgem.jeesite.common.utils.excel.sy.ExportExcel;
import com.thinkgem.jeesite.common.utils.excel.sy.StaticCodeConvert;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.page.Pagination;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC88View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sybx.syjfjlcx.service.SyJfjlcxService;
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
 * 失业缴费记录查询控制器
 * @description 
 * @since 20170614
 * @author njx
 * @version 1.0
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syjfjlcx/web_syjfjlcx")
public class SyJfjlcxController extends BaseController {
	@Autowired
	private SyJfjlcxService syjfjlcxservice;
	
	/**
	 * 主方法
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
		//用空闲字段AAC058、AAE011、BAC801 控制列表、导出按钮是否显示
		pm_ac01view.setAAC058("noQuery");//不显示"未查询到符合条件的记录，请确认您输入的查询条件"
		pm_ac01view.setAAE011("firstDisplayInfo");//显示"暂无数据，请输入查询条件后点击【查询】按钮"
		pm_ac01view.setBAC801("noDisplayButton");//没有数据不显示【确认导出】按钮
		//设置实体属性
		pm_ac01view.setAAC002(user.getNo());
		pm_ac01view.setAAC003(user.getName());
		model.addAttribute("pm_ac01view", pm_ac01view);
		return "modules/sybx/syjfjlcx/sy_jfjlcxList";
	}

	/**
	 * 个人缴费查询方法
	 * @param pm_ac88view
	 * @param request
	 * @param response
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "searchInfo"})
	public String searchInfo(PM_AC88View pm_ac88view, HttpServletRequest request, HttpServletResponse response, Integer pageNo, Model model) {
		//获取系统相关信息
		User user =  UserUtils.getUser();
		
		//创建对象
		UserView userView = new UserView();
		PM_AC01View pm_ac01view = new PM_AC01View();

		//设置查询条件，调用缴费记录查询接口
		userView.setBAE702(CodeConstant.BAE702_BAE702_0);//正式上线需要从user中获取 ***************需要设置从user对象中获取
		userView.setSSA004(CodeConstant.SY_SSA004_1);
		pm_ac88view.setAAE143(CodeConstant.AAE143_AAE143_1);
		pm_ac88view.setAAE140(CodeConstant.AAE140_AAE140_2);
		pm_ac88view.setBAA001(user.getBaa001());//设置数据分区  ***************需要设置汉中的数据分区
		
		
		List list = new ArrayList();
		System.out.println("******1.控制层开始调用nwwssy2104接口开始******");
		list = syjfjlcxservice.quertJfjlcx(userView, pm_ac88view);
		Pagination p;
		if(list!=null){
			System.out.println("******2.控制层调用nwwssy2104接口结束，调用成功，数据返回成功******");
			if(pageNo==null){
				pageNo=1;
			}
			p = new Pagination(pageNo, CodeConstant.SY_PAGE_SIZE,  list.size());
			p.setList(pageNo, CodeConstant.SY_PAGE_SIZE, list);
			//设置实体属性
			model.addAttribute("pagination_jfjlcx", p);
			//控制相关信息和按钮显示
			pm_ac01view.setBAC801("displayButton");//显示【确认导出】按钮
			pm_ac01view.setAAC058("noQuery");//不显示"未查询到符合条件的记录，请确认您输入的查询条件"
		}else{
			System.out.println("******3.控制层调用nwwssy2104接口结束，接口没有数据返回，请检查原因，所在：SyJfjlcxController 类中******");
			p = new Pagination();
			p.setList(null);
			//用空闲字段AAC058、BAC801 控制列表、导出按钮是否显示
			pm_ac01view.setBAC801("noDisplayButton");//不显示【确认导出】按钮
			pm_ac01view.setAAC058("query");//显示"未查询到符合条件的记录，请确认您输入的查询条件"
		}
		//用空闲字段AAE011 控制列表、导出按钮是否显示
		pm_ac01view.setAAE011("secondDisplayInfo");//不显示"暂无数据，请输入查询条件后点击【查询】按钮"
		
		pm_ac01view.setAAC003(pm_ac88view.getAAC003().trim());
		pm_ac01view.setAAC002(pm_ac88view.getAAC002().toUpperCase().trim());
		
		model.addAttribute("pm_ac01view", pm_ac01view);
		model.addAttribute("pagination_jfjlcx", p);
		return "modules/sybx/syjfjlcx/sy_jfjlcxList"; 
	}
	
	/**
	 * 导出excel表格
	 * @param pm_ac01view
	 * @param pm_ac88view
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "exportExcel")
	public String exportExcel(PM_AC88View pm_ac88view, HttpServletRequest request, HttpServletResponse response) {
		//创建对象
		UserView userView = new UserView();
		//获取系统相关信息
		User user =  UserUtils.getUser();
		
		//设置查询条件，调用缴费记录查询接口
		userView.setBAE702(CodeConstant.BAE702_BAE702_0);//正式上线需要从user中获取 ***************需要设置从user对象中获取
		userView.setSSA004(CodeConstant.SY_SSA004_1);
		pm_ac88view.setAAE143(CodeConstant.AAE143_AAE143_1);
		pm_ac88view.setAAE140(CodeConstant.AAE140_AAE140_2);
		pm_ac88view.setBAA001(user.getBaa001());//设置数据分区  ***************需要设置汉中的数据分区
		
		
		//获取导出信息
		List list = new ArrayList();
		list =  syjfjlcxservice.quertJfjlcx(userView, pm_ac88view);
		if(list.size()<=0 ){
			String errMsg  = "没有可导出的数据";
		}
		
		 //指定下载的文件名  
	    String fileName="单位"+userView.getAAB001()+"失业保险缴费记录查询列表-"+ CommonUtility.get8BitCurTimeAPP()+".xls";

	    // 定义单元格报头
	    String worksheetTitle = "汉中市网上服务大厅失业保险缴费记录查询";  
	    
	    List<String> columsTitles=new ArrayList<String>();
	    columsTitles.add("姓名");
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
	     // ①----------------------文本显示格式--------------------------------------------------------------------  
	     HSSFCellStyle cellStyle = wb.createCellStyle();
	     // 指定单元格居中对齐
	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //文字居中对齐
	     // 指定单元格垂直居中对齐 
	     cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	     // 指定当单元格内容显示不下时自动换行 
	     cellStyle.setWrapText(false); 
	     //②----------------------数字显示格式---------------------------------------------------------------------   
	     HSSFCellStyle cellStyle_number = wb.createCellStyle();
	     // 指定单元格居中对齐
	     cellStyle_number.setAlignment(HSSFCellStyle.ALIGN_RIGHT); //数字具有对齐
	     // 指定单元格垂直居中对齐 
	     cellStyle_number.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	     // 指定当单元格内容显示不下时自动换行 
	     cellStyle_number.setWrapText(false);
	     //设置单元格格式 end
	     // ---------------------------------------------------------------------------------------------------- 
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
	     Object[] arrays = list.toArray(new PM_AC88View[0] );
	     PM_AC88View[] array = (PM_AC88View[])arrays;
	     float sum1 = 0;
	     float sum2 = 0;
	     float sum3 = 0;
	     for (int i = 0; i < array.length; i++) {  
	    	 float   a =Float.parseFloat(array[i].getAAC123());
	         sum1 = sum1 + a;
	         float   b =Float.parseFloat(array[i].getAAC127());
	         sum2 = sum2 + b;
	         float   c =Float.parseFloat(array[i].getBAC504_1());
	         sum3 = sum3 + c;
	         row = sheet.createRow(i + 2);  
	         
	         cell = row.createCell(0);  
	         cell.setCellStyle(cellStyle);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getAAC003()));
	         
	         cell = row.createCell(1);  
	         cell.setCellStyle(cellStyle);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getAAC002()));
	         
	         cell = row.createCell(2);  
	         cell.setCellStyle(cellStyle);
	         cell.setCellValue(new HSSFRichTextString(StaticCodeConvert.returnCodeName_AAE143(array[i].getAAE143())));
	         
	         cell = row.createCell(3);  
	         cell.setCellStyle(cellStyle);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getAAE002()));
	         
	         cell = row.createCell(4);  
	         cell.setCellStyle(cellStyle_number);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getBAC504()));
	         
	         cell = row.createCell(5);  
	         cell.setCellStyle(cellStyle_number);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getAAC123()));
	        
	         cell = row.createCell(6);  
	         cell.setCellStyle(cellStyle_number);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getAAC127()));
	        
	         cell = row.createCell(7);  
	         cell.setCellStyle(cellStyle_number);  
	         cell.setCellValue(new HSSFRichTextString(array[i].getBAC504_1()));
	         
	         cell = row.createCell(8);  
	         cell.setCellStyle(cellStyle);  
	         cell.setCellValue(new HSSFRichTextString(StaticCodeConvert.returnCodeName_AAE114(array[i].getAAE114())));
	     }
         try {
			bufferedOutPut.flush();
			wb.write(bufferedOutPut);  
			bufferedOutPut.close();  
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
 		return "modules/sybx/syjfjlcx/sy_jfjlcxList";
	}
}
