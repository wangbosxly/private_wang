<%@ page contentType="text/html;charset=UTF-8"  isErrorPage="true" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@page import="com.thinkgem.jeesite.common.utils.Exceptions"%>
<%@page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%@page import="com.thinkgem.jeesite.common.web.Servlets"%>
<%
    response.setStatus(500);

// 获取异常类
    Throwable ex = Exceptions.getThrowable(request);
    if (ex != null){
        LoggerFactory.getLogger("500.jsp").error(ex.getMessage(), ex);
    }

// 编译错误信息
    StringBuilder sb = new StringBuilder("错误信息：\n");
    if (ex != null) {
        sb.append(Exceptions.getStackTraceAsString(ex));
    } else {
        sb.append("未知错误.\n\n");
    }

// 如果是异步请求或是手机端，则直接返回信息
    if (Servlets.isAjaxRequest(request)) {
        out.print(sb);
    }

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>错误页面</title>
        <style type="text/css">
            body.error_page
            {
                background-color: #00629f;
                background-image: url(${ctxStatic}/images/error.png);
                background-position: center top;
                background-repeat: no-repeat;
            }
            #error{
                position: absolute;
                padding-top: 400px;
                width: 100%;
                text-align: center;
            }
        </style>
        <script language="javascript" type="text/javascript">
            var timer;
            //启动跳转的定时器
            function startTimes() {
                timer = window.setInterval(showSecondes,1000);
            }

            var i = 5;
            function showSecondes() {
                if (i > 0) {
                    i--;
                    document.getElementById("secondes").innerHTML = i;
                }
                else {
                    window.clearInterval(timer);
                    history.back();
                }
            }

            //取消跳转
            function resetTimer() {
                if (timer != null && timer != undefined) {
                    window.clearInterval(timer);
                    history.back();
                }
            }
        </script> 
    </head>
    <body class="error_page" onload="startTimes();">
        <h1 id="error">
	        遇到错误，&nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转，立即跳转请点击&nbsp;
            <a  href="javascript:resetTimer();">返回</a>
        </h1>
    </body>
</html>
