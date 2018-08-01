package com.thinkgem.jeesite.modules.sybx.quickStart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * 失业使用指南
 *
 * @author X_P
 * @create 2018-04-24 16:52
 */
@Controller
@RequestMapping("${adminPath}/sybx/quickStart")
public class QuickStart {

    @RequestMapping("form")
    public String form(){
        return "modules/sybx/quickStart/quickStart";
    }
}