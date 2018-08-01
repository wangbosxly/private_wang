package com.thinkgem.jeesite.modules.sybx.sysyjsl.web;

import com.thinkgem.jeesite.common.utils.excel.sy.StaticCodeConvert;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.ComUtilty;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.client.GenerateSequenceUtil;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_JC02View;
import com.thinkgem.jeesite.modules.nwws.syentity.UserView;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.sybx.sysyjsl.service.SySyjslService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 失业失业金申领控制器
 * @description 
 * @since 20170614
 * @author njx
 * @version 1.0
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/sysyjsl/web_sysyjsl")
public class SySyjslController extends BaseController {
	
	@Autowired
	private SySyjslService sysyjslservice;
	
	@RequestMapping(value = { "list", "" })
	public String list(PM_JC02View pm_jc02view, HttpServletRequest request, HttpServletResponse response, Model model) {
		//获取系统相关信息
		User user =  UserUtils.getUser();
		//根据登录人自动给姓名和身份证号赋值
		pm_jc02view.setAAC003(user.getName());
		pm_jc02view.setAAC002(user.getNo());
		
		//设置实体属性
		//AAE011 作为临时显示标记，点击功能菜时，将AAE011 赋值为 noDisplayDetailInfo 不显示详细信息
		pm_jc02view.setAAE011("noDisplayDetailInfo");//将AAE011 作为临时显示标记
		pm_jc02view.setAAE013("noDisplayInfo");//不显示提示信息
		model.addAttribute("pm_jc02view", pm_jc02view);
		pm_jc02view.getAAE011();
		//转向页面
		return "modules/sybx/sysyjsl/sy_syjslInfo";
	}

	@RequestMapping(value = {"search"})
	public String search(PM_JC02View pm_jc02view, HttpServletRequest request, HttpServletResponse response, Model model) {
		//获取系统相关信息
		User user =  UserUtils.getUser();
		
		//创建对象
		UserView userView = new UserView();
		PM_AC01View pm_ac01view = new PM_AC01View();

		//组装值
		userView.setBAE702(CodeConstant.BAE702_BAE702_0); //0经办机构  失业金是经办机构领取的吗?
		userView.setSAA004(" ");
		userView.setSAA015(CodeConstant.SAA015_SAA015_M4009);//事功能id
		userView.setSAA037(user.getLoginName());
		System.out.println("SAA037："+user.getLoginName());
		userView.setSZZ003("");//赋值是什么
		userView.setBAA001(user.getBaa001());//汉中失业数据分区不赋值
		System.out.println("BAA001："+user.getBaa001());
		
		//设置查询条件，调用失业金申领查询接口
		pm_ac01view.setAAC002(pm_jc02view.getAAC002());//身份证号
		pm_ac01view.setAAC003(pm_jc02view.getAAC003());//姓名
		System.out.println("aac002："+pm_jc02view.getAAC002()+" aac003："+pm_jc02view.getAAC003());
		
		
		
		//开始调用接口
		System.out.println("******1.控制层开始调用nwwssy2901接口开始******");
		pm_jc02view = sysyjslservice.searchInfo(pm_ac01view);
		if(pm_jc02view!=null){
			System.out.println("******2.控制层调用nwwssy2901接口结束，调用成功，数据返回成功******");
			//转换以下三个值的显示方式
			pm_jc02view.setAJC090(pm_jc02view.getAJC090());
			pm_jc02view.setAJC094(pm_jc02view.getAJC094());
			pm_jc02view.setAJC095(pm_jc02view.getAJC095());
			pm_jc02view.setAKB020("displayButton");//控制按钮
			//AAE011 作为临时显示标记，点击查询按钮后重新给AAE011赋值为displayDetailInfo，显示详细信息
			pm_jc02view.setAJA004(StaticCodeConvert.returnCodeName_AJA004(pm_jc02view.getAJA004()));
			pm_jc02view.setAAE011("displayDetailInfo");
			pm_jc02view.setAAE018("noDisplayInfo");//不显示提示信息
		}else{
			pm_jc02view = new PM_JC02View();
			pm_jc02view.setAJA004(CodeConstant.EMPTY_EMPTY);
			System.out.println("******3.控制层调用nwwssy2901接口结束，接口没有数据返回，请检查原因，所在：SySyjslController 类中******");
			pm_jc02view.setAKB020("noDisplayButton");//控制按钮
			//AAE011 作为临时显示标记，点击查询按钮后重新给AAE011赋值为displayDetailInfo，显示详细信息
			pm_jc02view.setAAE011("noDisplayDetailInfo");
			pm_jc02view.setAAE018("displayInfo");//查询没有结果显示提示信息
			
			//从新赋值，保证当查不到数据时，使用户可以看见当前个人信息
			pm_jc02view.setAAC003(user.getName());
			pm_jc02view.setAAC002(user.getNo());
		}
		//将查询的值显示在页面
		model.addAttribute("pm_jc02view", pm_jc02view);
		return "modules/sybx/sysyjsl/sy_syjslInfo";
	}
	
	/**
	 * 登记确认
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "submit")
	public String submit(HttpServletRequest request, HttpServletResponse response, Model model) {
		//创建对象
		UserView userView = new UserView();
		User user =  UserUtils.getUser();
		PM_JC02View pm_jc02view = new PM_JC02View();
		//生成流水号
		GenerateSequenceUtil gsu = new GenerateSequenceUtil();
		String saa036 = "hz"+gsu.generateSequenceNo();
		String bae941 = gsu.generateSequenceNo();

		// 封装保存信息
		userView.setBAE702(CodeConstant.BAE702_BAE702_0);// 主体类别(单位、个人)
		userView.setSAA015(CodeConstant.SAA015_SAA015_M4009);// 功能id
		userView.setSAA004(" ");// 事项id
		userView.setSZZ003(" ");// 服务机构ID
		userView.setBAE703(request.getParameter("AAC001"));// 主体编号
		userView.setSAA037(user.getLoginName());// 申请人
		userView.setSAA036(saa036);// 受理单ID
		userView.setSAA043(CodeConstant.SAA043_SAA043_3);//待审
		userView.setSAA038(CommonUtility.get19BitCurTimeAPP());//申请时间
		
		pm_jc02view.setSAA036(saa036);//★受理单ID
		pm_jc02view.setBAE941(bae941);
		pm_jc02view.setAAC001(request.getParameter("AAC001"));
		pm_jc02view.setAAE010(request.getParameter("AAE010"));//银行账号
		pm_jc02view.setACA111(request.getParameter("ACA111"));//原从事职业(工种)
		pm_jc02view.setAJC093(request.getParameter("AJC093"));//失业原因
		pm_jc02view.setAJC090(request.getParameter("AJC090"));//本次失业日期
		pm_jc02view.setAJC094(request.getParameter("AJC094"));//失业登记日期
		pm_jc02view.setAJC091(request.getParameter("AJC091"));//工资发放至月
		pm_jc02view.setAJC095(request.getParameter("AJC095"));//待遇申领日期
		pm_jc02view.setSAA015(userView.getSAA015());//★功能id
		pm_jc02view.setAAE011(user.getName());//'经办人' 由于身份证号登录，保存到核心时，太长.因此保存身份证对应的姓名
		pm_jc02view.setTAA101(CommonUtility.get19BitCurTimeAPP());// ★申报时间
		pm_jc02view.setTAA102(CodeConstant.EMPTY_EMPTY);// ★处理标志
		pm_jc02view.setTAA103(CodeConstant.TAA103_TAA103_0);// ★审核结果0待审核,1审核通过,2审核不通过
		pm_jc02view.setTAA104(CodeConstant.EMPTY_EMPTY);// ★未通过原因
		pm_jc02view.setTAA105(CodeConstant.TAA105_TAA105_1);// ★申报来源,1网上大厅
		pm_jc02view.setAAE003(CommonUtility.get6BitCurTimeAPP());
		pm_jc02view.setAAE036(CommonUtility.get19BitCurTimeAPP());//'经办日期'
		pm_jc02view.setAJC096(request.getParameter("AJC096"));
		pm_jc02view.setAJC097(request.getParameter("AJC097"));
		pm_jc02view.setBAZ001(CodeConstant.EMPTY_EMPTY);
		pm_jc02view.setAJC050(request.getParameter("AJC050"));
//		pm_jc02view.setAJC310(request.getParameter("AJC310"));
		pm_jc02view.setBAA001(user.getBaa001());
		pm_jc02view.setAJA004(StaticCodeConvert.returnCodeName_AJA004_TO_VALUE(request.getParameter("AJA004")));
		if(ComUtilty.isempty(request.getParameter("AAE013"))){
			pm_jc02view.setAAE013(request.getParameter("AAE013"));//备注
		}
		if(ComUtilty.isempty(request.getParameter("BJC100"))){
			pm_jc02view.setBJC100(request.getParameter("BJC100"));//个人特长
		}
		if(ComUtilty.isempty(request.getParameter("BJC101"))){
			pm_jc02view.setBJC101(request.getParameter("BJC101"));//培训意向
		}
		if(ComUtilty.isempty(request.getParameter("BJC102"))){
			pm_jc02view.setBJC102(request.getParameter("BJC102"));//求职意向
		}
		pm_jc02view.setBAA001(user.getBaa001().substring(0, 4)+""+user.getBaa001().substring(6,8));
		pm_jc02view.setAAB034(user.getBaa001().substring(0, 4)+""+user.getBaa001().substring(6,8));
		
		System.out.println("******1.控制层SySyjslController开始调用nwwssy2310方法保存数据接口.******");
		sysyjslservice.nwwssy2310(userView, pm_jc02view);
		System.out.println("******6.控制层SySyjslController调用nwwssy2310方法执行完毕.******");
		
		return "redirect:" + adminPath + "/sybx/sysyjsl/web_sysyjsl/list";
	}
	
	@RequestMapping(value = "printWord")
	public void printWord(HttpServletRequest request, HttpServletResponse response, String AAC002, String AAC003, String AAC001, String AJC050, String AJC090, String TYPE){
		String tempUserName="";
		try {
			tempUserName = URLDecoder.decode(AAC003.trim(), "UTF-8");
			System.out.println("参数传递身份证号："+AAC002+"参数传递姓名："+tempUserName+"参数传递身份证号："+AJC050+"参数传递本次失业日期："+AJC090+"类型："+TYPE);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("AAC003", tempUserName);
		params.put("AAC002", AAC002);
		params.put("AJC050", AJC050);
		params.put("AJC090", AJC090);
		
//		String path=this.getClass().getClassLoader().getResource("/").getPath();
//		path=path.substring(0,path.lastIndexOf("jeesite-master"));
//	    String fp  = path+"bjsycms"+site.getSolutionPath()+"/sy/M4009/report.jasper";
		//生成后下载的文件在：C:\Users\Administrator\Downloads 
	    File reportFile1 = new File(CommonUtility.FILE_ADDRESS);
	    JasperReport jasperReport1 = null;
		try {
			jasperReport1 = (JasperReport) JRLoader.loadObject(reportFile1);
		} catch (JRException e) {
			e.printStackTrace();
		}
	    ResultSet rst=null;
	    JRDataSource dataSource = new JRResultSetDataSource(rst);
	    JasperPrint jasperPrint = null;
		try {
			jasperPrint = JasperFillManager.fillReport(jasperReport1, params, dataSource);
		} catch (JRException e) {
			e.printStackTrace();
		}
	    ServletOutputStream ouputStream=null;
		try {
			ouputStream = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//①生成word格式
		if("0".equals(TYPE)){
			    response.setContentType("application/vnd.ms-word");    
			    String defaultname=AAC002+".doc";    
				try {
					String fileName = new String(defaultname.getBytes("GBK"), "utf-8");
					response.setHeader("Content-disposition", "attachment; filename=" + fileName);    
					JRDocxExporter exporter = new JRDocxExporter();
					exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
					try {
						exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
					} catch (IOException e) {
						e.printStackTrace();
					}    
					try {
						exporter.exportReport();
					} catch (JRException e) {
						e.printStackTrace();
					}   
					try {
						ouputStream.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}    
					try {
						ouputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					} 
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
			}    
		}/*else{//②生成word格式
			response.setContentType("application/pdf");
			String defaultname = AAC002+".pdf";
			try {
				String fileName = new String(defaultname.getBytes("gbk"), "utf-8");
				response.setHeader("Content-disposition", "attachment; filename=" + fileName);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
			exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
			try {
				exporter.exportReport();
			} catch (JRException e) {
				e.printStackTrace();
			}
			try {
				ouputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}*/
	}	
}
