<%@ page contentType="text/html; UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>${fns:getConfig('productName')}</title>
    <link rel="stylesheet" href="${ctxStatic}/jingle/css/css.css"/>
    <meta name="decorator" content="blank"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#loginForm").validate({
                rules: {
                    validateCode: {remote: "${pageContext.request.contextPath}/servlet/validateCodeServlet"}
                },
                messages: {
                    username: {required: "请填写用户名."}, password: {required: "请填写密码."},
                    validateCode: {remote: "验证码不正确.", required: "请填写验证码."}
                },
                errorLabelContainer: "#messageBox",
                errorPlacement: function (error, element) {
                    error.appendTo($("#loginError").parent());
                }
            });
        });
        // 如果在框架或在对话框中，则弹出提示并跳转到首页
        if (self.frameElement && self.frameElement.tagName == "IFRAME" || $('#left').length > 0 || $('.jbox').length > 0) {
            alert('未登录或登录超时。请重新登录，谢谢！');
            top.location = "${ctx}";
        }

        window.onload = function () {
            var oInput = document.getElementById("username");
            oInput.focus();
        }
    </script>
</head>
<body style="overflow-y:hidden;">
<form id="loginForm" class="form-signin" action="${ctx}/login" method="post">
    <div class="subtop"><img alt="" src="${ctxStatic}/jingle/image/loginlogo.jpg"></div>
    <div class="loginbg">
        <dl>
            <dt>
                <span>用户登录</span>
            </dt>
            <dd>
                <ul>
                    <div id="messageBox" class="alert alert-error ${empty message ? 'hide' : ''}">
                        <button data-dismiss="alert" class="close">×</button>
                        <label id="loginError" class="error">${message}</label>
                    </div>
                    <li class="idbg">
                    <input maxlength="18" class="required" type="text"
                           id="username" name="username" value="${username}" placeholder="帐号" title="登录名不区分大小写"></li>
                    <li class="passwordbg">
                    <input maxlength="18" class="required" type="password"
                           id="password" name="password" placeholder="密码"></li>
                    <br>
                    <c:if test="${isValidateCodeLogin}">
                        <div class="validateCode">
                            <label class="input-label mid" for="validateCode">验证码</label>
                            <sys:validateCode name="validateCode"
                                              inputCssStyle="margin-bottom:0;width:50px; height:25px;"/>
                        </div>
                    </c:if>
                    <li class="dlbtn"><input type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录"></li>
                </ul>
                <div style="height: 30px;text-align: center;line-height: 30px">建议使用谷歌浏览器</div>
                <div style="height: 30px;text-align: center;line-height: 30px"><a href="/static/download-file/65.0.3325.162_chrome32_stable_windows_installer.exe"><strong>点击此处</strong></a>下载32位,
                <a href="/static/download-file/65.0.3325.162_chrome64_stable_windows_installer.exe"><strong>点击此处</strong></a>下载64位</div>

            </dd>
        </dl>
    </div>
</form>
<BR>
<div class="loginfoot">
    Copyright &copy;2015-${fns:getConfig('copyrightYear')} ${fns:getConfig('productName')} </br>Powered By
    长天科技有限公司 ${fns:getConfig('version')}
</div>
</body>
</html>