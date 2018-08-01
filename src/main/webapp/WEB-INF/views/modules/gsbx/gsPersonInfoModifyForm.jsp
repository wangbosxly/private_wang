<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员信息管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

        });
        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>

<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gsbx/GsPersonInfoModify/form">人员信息列表</a></li>
</ul>
<sys:message content="${message}" type="${ctype}"/>
<form:form id="searchForm" modelAttribute="gsPersonInfoModify" action="${ctx}/gsbx/GsPersonInfoModify/list" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${pagination.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${pagination.pageSize}"/>
    <ul class="ul-form">
        <li><label>个人编号：</label>
            <form:input path="AAC001" htmlEscape="false" maxlength="15" class="input-medium"/>
        </li>
        <li><label>身份证号：</label>
            <form:input path="AAC002" htmlEscape="false" maxlength="20" class="input-medium"/>
        </li>
        <li><label>姓名：</label>
            <form:input path="AAC003" htmlEscape="false" maxlength="20" class="input-medium"/>
        </li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <input type="hidden" name="BAA001" value="${syac01.BAA001}"/>
    <tr>
        <th>个人编号</th>
        <th>姓名</th>
        <th>出生日期</th>
        <th>公民身份证号</th>
        <th>档案出生日期</th>
        <th>参加工作日期</th>
        <th>参保日期</th>
        <th>操作</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pagination.list}" var="syac01">
        <input type="hidden" name="BAA001" value="${syac01.BAA001}"/>
        <tr>
            <td>${syac01.AAC001}</td>
            <td>${syac01.AAC003}</td>
            <td>${syac01.AAC006}</td>
            <td>${syac01.AAC002}</td>
            <td>${syac01.BIC701}</td>
            <td>${syac01.AAC007}</td>
            <td>${syac01.AAC007}</td>
            <td>
                <a href="${ctx}/gsbx/GsPersonInfoModify/update?AAC002=${syac01.AAC002}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${not empty message}">
        <tr align="center">
            <td colspan="8"><div align="center" style="color: red;font-weight: bold;">${message}</div></td>
        </tr>
    </c:if>
    </tbody>
</table>
<c:if test="${pagination.list.size() > 19}">
    <div class="pagination">${pagination}</div>
</c:if>
</body>

</html>