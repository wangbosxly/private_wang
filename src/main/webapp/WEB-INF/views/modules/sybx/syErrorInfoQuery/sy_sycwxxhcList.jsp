<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>单位缴费信息查询</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            //$("#name").focus();
            $("#inputForm").validate({
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
        });

        function page(n,s){
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#inputForm").submit();
            return false;
        }
    </script>
</head>
<body>

<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/syErrorInfoQuery/sycwxxcx/">单位缴费信息列表</a></li>
</ul>
<form:form id="inputForm" modelAttribute="syErrorInfo" action="${ctx}/sybx/syErrorInfoQuery/sycwxxcx/list" method="post" class="breadcrumb form-search">
    <ul class="ul-form">
        <li>&nbsp;&nbsp;&nbsp;请选择错误原因：
            <form:select path="CODE_TYPE" class="input-large" cssStyle="width:300px" >
                <form:options items="${fns:getDictList('CODE_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
        </form:select></li>
        <li class="btns">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
        </li>
    </ul>
    <c:if test="${page!=null}">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    </c:if>
</form:form>
<sys:message content="${message}"/>
    <c:if test="${page!=null}">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th>个人编号</th>
            <th>姓名</th>
            <th>身份证</th>
            <th>错误原因</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="syError">

            <tr>
                <td>${syError.AAC001}</td>
                <td>${syError.AAC003}</td>
                <td>${syError.AAC002}</td>
                <td>${syError.AAE013}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>
    </c:if>
</body>
</html>