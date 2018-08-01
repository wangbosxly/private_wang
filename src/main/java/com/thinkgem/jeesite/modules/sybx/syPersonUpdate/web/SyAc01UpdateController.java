/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syPersonUpdate.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.client.CodeConstant;
import com.thinkgem.jeesite.modules.nwws.client.CommonUtility;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.sybx.syPersonUpdate.service.SyAc01UpdateService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 人员信息修改Controller
 * @author wh
 * @version 2017-06-14
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syPersonUpdate/syac01")
@SuppressWarnings( { "unchecked", "rawtypes" })
public class SyAc01UpdateController extends BaseController {

	@Autowired
	private SyAc01UpdateService syAc01UpdateService;

    @RequestMapping(value = {"list", ""},method = RequestMethod.GET)
    public String list(Integer pageNo, PM_AC01View syac01, Model model){
        model.addAttribute("message", "请输入查询条件.");
        model.addAttribute("syac01", syac01);
        return "modules/sybx/syPersonUpdate/syAc01UpdateList";
    }
	@RequestMapping(value = {"list", ""},method = RequestMethod.POST)
	public String list(Integer pageNo, PM_AC01View syac01, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		JSONObject json = new JSONObject();
		json.put("AAE170", user.getAae170()); //AAE170	操作人
		json.put("AAB001", user.getAab001()); //AAB001	单位编号
		json.put("SAA015", CodeConstant.SAA015_SAA015_M4004);
		json.put("BAA001", user.getBaa001());// 数据分区
		json.put("AAE140", CodeConstant.AAE140_AAE140_2);//险种
		json.put("BAC808", CodeConstant.SY_PAGE_SIZE);//每页数据量
		if (pageNo == null) {
			json.put("BAC809", "1");
		} else {
			json.put("BAC809", pageNo);
		}
		if (syac01.getAAC001() != null && !"".equals(syac01.getAAC001())) {
			json.put("AAC001", syac01.getAAC001());
		}
		if (syac01.getAAC003() != null && !"".equals(syac01.getAAC003())) {
			json.put("AAC003", "'" + syac01.getAAC003() + "'");
		}
		try {
			Page<PM_AC01View> p = syAc01UpdateService.findPage(new Page<PM_AC01View>(request,response),json);
			if (p != null && p.getList().size() > 0) {
				model.addAttribute("pagination", p);
			} else {
				model.addAttribute("message", "未查询到符合条件的记录，请确认您输入的查询条件.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "请联系系统维护人员，检查失业接口");
		}
		model.addAttribute("syac01", syac01);
		return "modules/sybx/syPersonUpdate/syAc01UpdateList";
	}

	@RequestMapping(value = "form")
	public String form(HttpServletRequest request, Model model) {
		User user = UserUtils.getUser();String aac002 = request.getParameter("aac002");//获取身份证号
		//设置接口参数
		JSONObject json = new JSONObject();
		json.put("AAE170",user.getAae170());
		json.put("AAB001",user.getAab001());
		json.put("BAA001",user.getBaa001());
		json.put("AAC002",aac002);
		PM_AC01View pm_ac01View = syAc01UpdateService.findInfo(json.toString());
		model.addAttribute("syac01", pm_ac01View);
		return "modules/sybx/syPersonUpdate/syAc01UpdateForm";
	}

	@RequestMapping(value = "save")
	public String save(PM_AC01View syac01, Model model) {
		//校验身份信息
		//AAC012身份为农民是校验 或选择AAA040缴费比例类别为农民合同缴费比例
		if ("2".equals(syac01.getAAC012()) || "2".equals(syac01.getAAA040())) {
			if (!syac01.getAAC012().equals(syac01.getAAA040())) {
				model.addAttribute("message", "个人身份与缴费比例类别关系对应失败，农民合同制工人缴费比例对应农民身份");
				model.addAttribute("syac01", syac01);
				return "modules/sybx/syPersonUpdate/syAc01UpdateForm";

			}
		}
		//获取系统信息
		User user = UserUtils.getUser();
		//设置接口参数
		JSONObject json = (JSONObject) JSONObject.toJSON(syac01);
		json.put("BAE941", "XY" + CommonUtility.getBAE941());//★申报流水号.
		json.put("AAE011", user.getLoginName());//经办人.
		json.put("AAE036", CommonUtility.get19BitCurTimeAPP());//经办时间.
		json.put("BAA001", user.getBaa001());//数据分区编号.
		json.put("BAA008", CodeConstant.BAA008_BAA008_3);//复核标志.
		json.put("SAA036", "XY" + CommonUtility.getSAA036());//★受理单ID.
		json.put("AAE140", CodeConstant.AAE140_AAE140_2);// 险种类型
		json.put("TAE100", "2");//基本信息类别
		json.put("TAA101", CommonUtility.get19BitCurTimeAPP());//★申报时间
		json.put("TAA102", CodeConstant.TAA102_TAA102_2);//★处理标志:已上传
		json.put("TAA103", CodeConstant.TAA103_TAA103_1);//★ 审核结果,0待审核,1审核通过,2审核不通过.
		json.put("TAA105", CodeConstant.TAA105_TAA105_1);//★申报来源,1网上大厅.
		json.put("AAB001", user.getAab001());// 主体编号.
		json.put("SAA015", CodeConstant.SAA015_SAA015_M4003);// 功能id.
		json.put("SAA004", " ");// 事项id.
		json.put("SZZ003", " ");// 服务机构ID.
		json.put("BAE702", "1");// 主体类别(0个人,1单位).
		json.put("BAE703", user.getAab001());// 主体编号.
		json.put("SAA037", user.getLoginName());// 申请人.
		json.put("SAA043", CodeConstant.SAA043_SAA043_3);// 业务状态:预审.
		json.put("SAA038", CommonUtility.get19BitCurTimeAPP());// 申请时间.
		json.put("AAE170", user.getAae170());//.
		json.put("SAA031", "");
		json.put("BUS_ID", "");
		try {
			JSONObject jsonObject = syAc01UpdateService.saveInfo(json);
			if ("0".equals(jsonObject.getString("code"))) {
				model.addAttribute("message", "人员信息修改保存成功");
			} else {
				model.addAttribute("message", jsonObject.getString("msg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "请联系系统维护人员，检查失业接口");
		}
		model.addAttribute("syac01", syac01);
		return "modules/sybx/syPersonUpdate/syAc01UpdateForm";
	}

}