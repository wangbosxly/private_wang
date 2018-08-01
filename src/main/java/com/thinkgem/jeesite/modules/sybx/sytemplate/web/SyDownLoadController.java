package com.thinkgem.jeesite.modules.sybx.sytemplate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author svnlei
 * @date 2018/4/19
 */
@Controller
@RequestMapping(value = "${adminPath}/sybx/sytemplate/download")
public class SyDownLoadController {

    @RequestMapping(value = { "list", "" })
    public String list () {
        return "modules/sybx/sytemplate/syDownloadList";
    }

}
