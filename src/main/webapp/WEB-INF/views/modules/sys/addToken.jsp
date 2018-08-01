<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>绑定密匙</title>
    <meta name="decorator" content="default"/>

    <script type="text/javascript">
        $(document).ready(function() {

            $("#inputForm").validate({
                rules: {
                },
                submitHandler: function(form){
                    loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function(error, element) {
                    $("#messageBox").text("输入有误，请先更正。");
                    if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
            $(".bangding").click(function () {
                var i = $(this);
                var id = $(this).data("id");
                top.$.jBox.confirm("确认要解除绑定吗？","系统提示",function(v,h,f){
                    if(v=="ok"){
                        var url = "${ctx}/sys/user/delToken";
                        $.post(url,{"id":id},function(){
                           location.href="${ctx}/sys/user/addTokenList/";
                        });
                    }
                },{buttonsFocus:1});
                top.$('.jbox-body .jbox-icon').css('top','55px');
            });

        });


    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sys/user/addTokenList/">密匙绑定</a></li>
</ul>
<sys:message content="${message}"/>
    <form:form id="inputForm" modelAttribute="token" action="${ctx}/sys/user/addToken" method="post" class="breadcrumb form-search ">
    <ul class="ul-form">
        <div class="control-group">
            <div class="controls">
                <label>密匙账户：</label>
                <form:input path="tokenName"  htmlEscape="false" value="" maxlength="50" minlength="1" class="input-medium required"/>
                <span id="tokenNamespan"><font color="red">*</font> </span>
                <label>密匙密码：</label>
                <form:password path="password" htmlEscape="false"  value="" maxlength="50" minlength="1" class="input-medium required"/>
                <span class="help-inline"><font color="red">*</font> </span>
                <label>密匙类型：</label><form:select path="remarks"  htmlEscape="false" maxlength="50" minlength="1" class="input-large required" cssStyle="width:160px" >
                                        <form:option value="" label="请选择"/>
                                        <form:options items="${fns:getDictList('tokenType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                        </form:select><span class="help-inline"><span class="help-inline"><font color="red">*</font> </span>
                <input id="btnSubmit" class="btn btn-primary" type="submit" value="绑定"  title="绑定密匙"/>
            </div>
        </div>
    </ul>
    </form:form>
<div class="breadcrumb form-search">
<c:if test="${tokens!=null}">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="text-align:center;"><th colspan="8" >已绑定的密匙列表</th></tr>
        <tr>
            <th>绑定类型</th>
            <th>密匙账号</th>
            <th>密匙状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tokens}" var="token">

            <tr>
                <td>${fns:getDictLabel(token.remarks,"tokenName","")}</td>
                <td>${token.tokenName}</td>
                <td>
                   <c:if test="${token.state=='0'}">正常</c:if>
                   <c:if test="${token.state=='1'}"><span style="color: red">失效</span></c:if>
                   <c:if test="${token.state=='2'}"><span style="color: red">已锁定</span></c:if>
                </td>
                <td><a   class="bangding btn-link" data-id=${token.id}>解除绑定</a></td>
              <%--<td>${fns:getDictLabel(syab88.BAE707, 'BAE707', '')}</td>--%>
            </tr>
        </c:forEach>
        <c:if test="${tokens.size()==0}">
            <td colspan="3"><div align="center" style="color: red;font-weight: bold;">未绑定密匙</div></td>
        </c:if>
        </tbody>
    </table>
</c:if>
    <div  style="color: red;font-weight: bold;">完成密匙绑定后，请重新登录账号</div>
    <div  style="color: red;font-weight: bold;">如果密匙状态为已锁定，请联系经办机构</div>
</div>
</body>
</html>

