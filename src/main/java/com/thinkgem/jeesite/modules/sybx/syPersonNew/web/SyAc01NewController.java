/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sybx.syPersonNew.web;

import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.nwws.syentity.PM_AC01View;
import com.thinkgem.jeesite.modules.sybx.syPersonNew.service.SyAc01NewService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 人员新参保Controller
 * @author X_P
 * @version 2018-03-26
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/syPersonNew/syac01")
public class SyAc01NewController extends BaseController {

	@Autowired
	private SyAc01NewService syAc01NewService;

	@RequestMapping(value = "form")
	public String form(PM_AC01View syac01, Model model) {
        //封装页面显示参数
        User user = UserUtils.getUser();
        syac01.setAAB001(user.getAab001());
        syac01.setAAB004(user.getAab004());
        //获取缴费基数，前台计算上下限
        Double bac504 = syAc01NewService.querySPGZ(user);
        model.addAttribute("rmb", bac504);
        model.addAttribute("syac01", syac01);
        return "modules/sybx/syPersonNew/syAc01NewForm";
	}
	
	@RequestMapping(value = "save")
	public String save(PM_AC01View syac01, Model model, HttpServletRequest request) {
        String rmb = request.getParameter("rmb");
        //TODO 后台的数据未做单独效验，后期添加
		//进行数据验证
        String  content;
        String ctype = "error";
        //判断出生日期是否小于工作日期
        if(DateUtils.isBigger(syac01.getAAC006(),syac01.getAAC007())){
            content="出生日期要在工作日期之前！";
        //判断参加工作日期是否小于参保日期
        }else if(DateUtils.isBigger(syac01.getAAC007(),syac01.getAAC030())){
            content="工作日期要在参保日期之前！";
        //判断个人身份是否与缴费比例类别匹配
        }else if(isNotRight(syac01)){
            content = "人员身份和缴费比例要匹配！";
        //判断参保时间是否在本月
        }else if(!isNowMoth(syac01)){
            content = "参保时间只能在本月！";
        //判断参保人员是否已经存在
        }else if(!isNotexist(syac01)){
            content = "保存失败，该身份证号已存在或已保存！请核实";
        }else {
            //数据效验合格，调用接口
            String s = syAc01NewService.saveInfo(syac01);
            if (!"1".equals(s)) {
                content = s;
            } else {
                content = "人员参保登记保存成功";
                ctype = "success";
            }
        }
        model.addAttribute("content", content);
        model.addAttribute("ctype", ctype);
        model.addAttribute("rmb", rmb);
        model.addAttribute("syac01", syac01);
        return "modules/sybx/syPersonNew/syAc01NewForm";

	}

    /**
     * 判断新参保人员是否已经存在
     * @param syac01
     * @return
     */
    @ResponseBody
    @RequestMapping("exist")
    public Boolean isNotexist(PM_AC01View syac01) {
        String aac002 = syac01.getAAC002();
        //通过身份证获取个人信息
        PM_AC01View info = null;
        try {
            info = syAc01NewService.findInfoByAAC002(aac002);
        } catch (Exception e) {
            return null;
        }
        return info==null;
    }

    /**
     * 判断参保时间是否在本月???是否超过3个月
     * @param syac01
     * @return
     */
    private boolean isNowMoth(PM_AC01View syac01) {
        Date date = DateUtils.parseDate(syac01.getAAC030());
        int mouthOfTwoDate = DateUtils.getMouthOfTwoDate(date, new Date());
        return mouthOfTwoDate<=2;
    }

    /**
     *  如果是农民,但却不是农民合同制工人缴费比例返回false
     *  如果不是农民，但却是弄民合同制工人缴费比例，返回false;
     * @param syac01
     * @return
     */
    private boolean isNotRight(PM_AC01View syac01) {
        return !(("2".equals(syac01.getAAC012())&&"2".equals(syac01.getAAA040()))||(!"2".equals(syac01.getAAC012())&&!"2".equals(syac01.getAAA040())));
    }

}