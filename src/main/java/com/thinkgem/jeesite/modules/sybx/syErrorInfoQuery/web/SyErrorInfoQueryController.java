package com.thinkgem.jeesite.modules.sybx.syErrorInfoQuery.web;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sybx.syErrorInfoQuery.entity.SyErrorInfo;
import com.thinkgem.jeesite.modules.sybx.syErrorInfoQuery.service.SyErrorInfoQueryService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述:
 * 单位基础信息错误核查
 *
 * @author X_P
 * @create 2018-03-16 11:25
 */
@Controller
@RequestMapping("${adminPath}/sybx/syErrorInfoQuery/sycwxxcx")
public class SyErrorInfoQueryController {

    @Autowired
    private SyErrorInfoQueryService syErrorInfoQueryService;

    /**
     *  进入错误信息查询页面
     * @param syErrorInfo
     * @param model
     * @return
     */
    @RequestMapping(value={"form",""})
    public String form(SyErrorInfo syErrorInfo, Model model){
        //TODO 防止前台报错，提交空值字段。后期修改前台判断。
        model.addAttribute("syErrorInfo", syErrorInfo);
        return "modules/sybx/syErrorInfoQuery/sy_sycwxxhcList";
    }

    /**
     *  显示查询结果，如果不存在则返回null;
     * @param CODE_TYPE  查询的错误类型 0，查询所有错误  1-5针对5种错误
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(String CODE_TYPE, HttpServletRequest request, HttpServletResponse response,Model model){
        //参数封装
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AAE170",user.getAae170());
        jsonObject.put("AAB001",user.getAab001());
        jsonObject.put("BAA001",user.getBaa001());
        jsonObject.put("CODE_TYPE",CODE_TYPE);
        //调用接口获取分页数据
        Page<SyErrorInfo> page = syErrorInfoQueryService.getJSONPage(new Page<SyErrorInfo>(request,response), jsonObject);
        //数据不存在则前台page==null;
        if(page!=null) {
            model.addAttribute("page", page);
        }else{
            model.addAttribute("message","没有查询到错误信息");
        }
        SyErrorInfo syErrorInfo = new SyErrorInfo();
        syErrorInfo.setCODE_TYPE(CODE_TYPE);
        model.addAttribute("syErrorInfo", syErrorInfo);
        return "modules/sybx/syErrorInfoQuery/sy_sycwxxhcList";
    }
}