/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.sySalaryUpdate.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sybx.sySalaryUpdate.service.SyAc04Service;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.apache.commons.lang3.ArrayUtils;
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
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 缴费基数申报Controller
 * 
 * @author wh
 * @version 2017-06-14
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/sySalaryUpdate/syac04")
@SuppressWarnings( { "unchecked", "rawtypes" })
public class SyAc04Controller extends BaseController {

	// 支持的文件类型
	private String[] errorType = { "xls" };
		
	@Autowired
	private SyAc04Service syac04Service;

	@RequestMapping(value = { "list", "" })
	public String list(PM_AC01View ac01_view, HttpServletRequest request, HttpServletResponse response, Model model,
                       Integer pageNo) throws IOException {

		if (pageNo == null || pageNo < 1) {
			ac01_view.setBAC809("1");
			pageNo = 1;
		} else {
			ac01_view.setBAC809(pageNo.toString());
		}
		
		User user = UserUtils.getUser();
		String aab001 = user.getCompany().getId();
		String aab004 = user.getCompany().getName();
//		UserView userView = new UserView();
//		userView.setAAB001(CodeConstant.SY_AAB001_AAB001);// 
//		userView.setAAE170("SY00000015");// 
//		userView.setBAA001("610399");
		
		ac01_view.setAAB001(aab001);
		ac01_view.setAAE140(CodeConstant.AAE140_AAE140_2);// 设置险种
		ac01_view.setSAA015(CodeConstant.SAA015_SAA015_M4006);// 事功能id:人员缴费基数申报

//		Pagination p = syac04Service.getPage(ac01_view, pageNo, 20, userView);
//		String bac504 = ((PM_AC01View)(p.getList().get(0))).getBAC504();

//		User user = UserUtils.getUser();
//		String aab001 = user.getCompany().getId();
//		String aab004 = user.getCompany().getName();

		Page<PM_AC01View> page = syac04Service.findPage(new Page<PM_AC01View>(request, response), ac01_view);

		Double bac504 = 0.00;
		
		if(page.getList() == null || page.getList().size() == 0){
			bac504 = 0.00;
		}else{
			bac504 = Double.valueOf(((PM_AC01View)(page.getList().get(0))).getBAC504());
		}

		model.addAttribute("page", page);
		model.addAttribute("syac04", ac01_view);
		model.addAttribute("rmb", bac504);
		
		return "modules/sybx/sySalaryUpdate/syAc04List";
	}

	@RequestMapping(value = "save")
	public String submit(UserView userView, String ids, String AAC001, String AAC040, Model model,
                         HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {

		User user = UserUtils.getUser();
		String aab001 = user.getCompany().getId();
		String aab004 = user.getCompany().getName();
		// 初始化对象
		PM_AC01View[] pm_ac01view = null;

		// 生成流水号
		String saa036 = CommonUtility.getSAA036();
		String bae941 = CommonUtility.getBAE941();

		String aae036 = CommonUtility.get19BitCurTimeAPP();

		userView.setSAA036(saa036);// 受理单ID

		int index = ids.indexOf(",");
		if(0 == index){
			ids = ids.substring(1);
		}
		
		// 组装选中的值
		String[] parmidsStr = ids.split(",");	
		String[] parmAAC001Str = AAC001.split(",");
		String[] parmAAC040Str = AAC040.split(",");
		
		// 封装受理单(SA06A)的信息到userview
		userView.setSAA036(userView.getSAA036());// 受理单ID
		userView.setSAA015(CodeConstant.SAA015_SAA015_M4006);// 功能id
		userView.setSAA004("00000333");// 事项id
		userView.setSZZ003("00000363");// 服务机构ID
		userView.setSAA031(" ");// 表单模板ID
		userView.setBAE702("1");// 主体类别(单位、个人)
		userView.setBAE703(aab001);// 主体编号
		userView.setSAA037(user.getLoginName());// 申请人
		userView.setSAA043(CodeConstant.SAA043_SAA043_3);// 业务状态
		userView.setSAA038(aae036);// 申请时间
		userView.setAAB001(aab001);//
		userView.setAAE170(user.getAae170());//
		userView.setBAA001(user.getBaa001());

		String date = CommonUtility.get6BitCurTimeAPP();
		String month = date.substring(4, 6);
		String aae030 = "";
		if ("12".equals(month)) {
			aae030 = Integer.parseInt(date.substring(0, 4)) + 1 + "01";
		} else {
			aae030 = Integer.parseInt(date.substring(0, 4)) + "01";
		}

		for (int i = 0; i < parmidsStr.length; i++) {
			if (parmidsStr[i] != null && !"".equals(parmidsStr[i])) {
				if (parmAAC001Str[i] != null && !"".equals(parmAAC001Str[i])) {
					if (parmAAC040Str[i] != null && !"".equals(parmAAC040Str[i])) {
						String[] parmids = parmidsStr[i].split(",");
						PM_AC01View[] pm_ac01view_temp = new PM_AC01View[parmids.length];
						int parm = parmids.length;
						int total = parmids.length;
						for (int j = 0; j < parmAAC001Str.length; j++) {
							if ((parmids[total - parm]).equals(parmAAC001Str[j])) {

								PM_AC01View ac01View = new PM_AC01View();
								ac01View.setBAE941(bae941);
								ac01View.setAAC001(parmAAC001Str[j]);
								ac01View.setAAC040(parmAAC040Str[j]);// 基本医疗工资
								ac01View.setAAE003(date);
								ac01View.setSAA036(userView.getSAA036());
								ac01View.setSAA015(userView.getSAA015());
								ac01View.setTAA101(date);
								ac01View.setBAA008(CodeConstant.BAA008_BAA008_3);// BAA008_未复核
								ac01View.setTAA103(CodeConstant.TAA103_TAA103_0);// 审核结果,0待审核,1审核通过,2审核不通过
								ac01View.setTAA105("1");// 申报来源,1网上大厅
								ac01View.setAAE140(CodeConstant.AAE140_AAE140_2);
								ac01View.setTAE100("3");
								ac01View.setAAE030(aae030);
								ac01View.setAAE011(userView.getSAA037());// 经办人
								ac01View.setAAE036(aae036);// 经办时间
								pm_ac01view_temp[total - parm] = ac01View;
								if (parm == 1) {
									break;
								} else {
									parm = parm - 1;
								}
							}
						}
						pm_ac01view = (PM_AC01View[]) ArrayUtils.addAll(pm_ac01view, pm_ac01view_temp);
					}
				}
			}
		}

		String s = "1";
		
		// 调用保存按钮
		if (pm_ac01view != null && pm_ac01view.length > 0) {
			s = syac04Service.saveInfo(userView, pm_ac01view);
		}

		if ("0".equals(s)) {
			addMessage(redirectAttributes, "人员基数申报提交失败,请联系医保中心");
		} else {
			addMessage(redirectAttributes, "人员基数申报提交成功");
			
		}

		return "redirect:" + Global.getAdminPath() + "/sybx/sySalaryUpdate/syac04/list/?repage";
//		 return "modules/sybx/sySalaryUpdate/syAc04List";

	}

	@RequestMapping(value = "import")
	public String importExcel(PM_AC01View ac01_view, UserView userView, String ids, String AAC001, String AAC040, Model model,
                              HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
//		CmsSite site = CmsUtils.getSite(request);
//		CmsUser user = CmsUtils.getUser(request);
//		FrontUtils.frontData(request, model, site);
//		WebErrors errors = WebErrors.create(request);
		// 判断用户是否登陆
		String loginName =  UserUtils.getUser().getLoginName();
		String curryTime19 = CommonUtility.get19BitCurTimeAPP();
		String message = "";
		String retFlag = "";
//		UserView userView = new UserView();

		User user = UserUtils.getUser();
		String aab001 = user.getCompany().getId();
		String aab004 = user.getCompany().getName();
		
		// 封装受理受理单的信息到userview
		userView.setSAA015(CodeConstant.SAA015_SAA015_M4006);// 功能id:人员缴费基数申报
		userView.setSAA004("00000334");// 事项id
		userView.setSZZ003("00000363");// 服务机构ID
		userView.setBAE702("1");// 主体类别(0个人,1单位)
		userView.setBAE703(aab001);// 主体编号
		userView.setSAA037(loginName);// 申请人
		userView.setSAA043(CodeConstant.SAA043_SAA043_3);// 业务状态:预审
		userView.setSAA038(curryTime19);// 申请时间
		userView.setAAB001(aab001);// 
		userView.setAAE170(user.getAae170());//
		userView.setBAA001(user.getBaa001());
        userView.setBUS_ID("1"); //执行批量
//		model.addAttribute("saa015", saa015);
//		model.addAttribute("saa004", saa004);
//		model.addAttribute("szz003", szz003);
//		model.addAttribute("sza023", sza023);
//		model.addAttribute("sza024", sza024);
//		model.addAttribute("saa062", saa062);
		
		BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        
		try {
			 MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
	         Iterator<String> iterator = req.getFileNames();
	         while (iterator.hasNext()) {
	        	 MultipartFile multipartFile = req.getFile(iterator.next());
	        	 String fileNames = multipartFile.getOriginalFilename();
	        	 int split = fileNames.lastIndexOf(".");
	        	 //服务器路径
	        	 //String uploadTo = request.getSession().getServletContext().getRealPath("\\") + "upload\\";
	        	 //File dir = new File(uploadTo); 
	        	//判断是否是支持的文件格式
	             if(errorType[0].equals(fileNames.substring(split+1,fileNames.length()))){
	            	 
	             } else {
	            	 model.addAttribute("message", "不是支持的文件格式，请使用.xls文件做批量上传！");
	            	 return "modules/sybx/sySalaryUpdate/syAc04List";
	             }
	             
	             File file = new File(aab001+"."+fileNames.substring(split+1,fileNames.length()));
	             fos = new FileOutputStream(file);
	             bos = new BufferedOutputStream(fos);
	             bos.write(multipartFile.getBytes());
	             HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
	             HSSFSheet hssfSheet=workbook.getSheetAt(0);
	             ArrayList personInfoList = new ArrayList();
	             if(hssfSheet.getLastRowNum()>10000){
	     			 model.addAttribute("message", "批量上传不能超过1万条记录！");
	            	 return "modules/sybx/sySalaryUpdate/syAc04List";
	             }
	             for(int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
	            	 HSSFRow hssfRow = hssfSheet.getRow(rowNum);
	            	 PM_AC01View pm_ac01View = new PM_AC01View();
	            	 if (hssfRow == null) {
	                     continue;
	                 }
	            	 HSSFCell cell_1 = hssfRow.getCell(1);
	            	 if(cell_1 != null){
	            		 String aac001 = cell_1.getStringCellValue();
	            		 if(cell_1 != null && !"".equals(cell_1)){
	            			 pm_ac01View.setAAC001(aac001);
	            		 }
	            	 }
	            	 HSSFCell cell_2 = hssfRow.getCell(2);
	            	 if(cell_2 != null){
	            		 String aac003 = cell_2.getStringCellValue();
	            		 if(cell_2 != null && !"".equals(cell_2)){
	            			 pm_ac01View.setAAC003(aac003);
	            		 }
	            	 }
	            	 HSSFCell cell_3 = hssfRow.getCell(4);
	            	 if(cell_3 != null){
	            		 String aac002 = cell_3.getStringCellValue();
	            		 if(aac002 != null && !"".equals(aac002)){
	            			 pm_ac01View.setAAC002(aac002);
	            		 }
	            	 }
	            	 HSSFCell cell_4 = hssfRow.getCell(4);
	            	 if(cell_4 != null){
	            		 String aac040 = cell_4.getStringCellValue();
	            		 if(cell_4 != null && !"".equals(cell_4)){
	            			 pm_ac01View.setAAC040(aac040);
	            		 }
	            	 }

	            	 personInfoList.add(pm_ac01View);
	             }

	             retFlag = syac04Service.importExcel(userView, personInfoList, "");
	             //存储文件
	             //文件名  fileNames.substring(0,split)
	             //文件格式   fileNames.substring(split+1,fileNames.length())
	             //文件内容 file.getBytes()
	             bos.close();
	 			 fos.close();
	         }
		} catch (Exception e) {
			e.printStackTrace();
			 model.addAttribute("message", "批量上传失败！");
        	 return "modules/sybx/sySalaryUpdate/syAc04List";
		} 

		if("1".equals(retFlag)){
			message = "缴费工资申报批量上传提交成功！";
		} else{
			message = "缴费工资申报批量上传提交失败！失败原因:";
		}
		
		model.addAttribute("message", message);
		
//		Page<PM_AC01View> page = new Page<PM_AC01View>();
//		model.addAttribute("page", page);
//		model.addAttribute("syac04", ac01_view);
//		model.addAttribute("rmb", "2336");
		try {
			this.list(ac01_view, request, response, model,1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "modules/sybx/sySalaryUpdate/syAc04List";
	}
}