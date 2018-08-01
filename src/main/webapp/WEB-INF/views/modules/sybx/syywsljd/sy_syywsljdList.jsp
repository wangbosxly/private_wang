<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <title>受理进度</title>
    <script>
        var i = 1;
        function page(n, s) {
            if (n) $("#pageNo").val(n);
            if (s) $("#pageSize").val(s);
            $("#searchForm").attr("action", "${ctx}/sybx/syywsljd/web_syywsljd/query");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/syywsljd/web_syywsljd">受理进度</a></li>
    <li ><a href="${ctx}/sybx/syywsljd/web_syywsljd/queryDetails">受理进度明细</a></li>
</ul>
<form:form id="searchForm" modelAttribute="userView" action="${ctx}/sybx/syywsljd/web_syywsljd/query" method="post"
           class="breadcrumb form-search ">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>功能事项:</label>
            <form:select path="SAA015" name="SAA015" style="width:150px">
                <form:option value="" label="请选择"/>
                <form:options items="${fns:getDictList('SAA015_5')}" itemLabel="label" itemValue="value"
                              htmlEscape="false"/>
            </form:select>
        </li>
        <li><label>业务状态:</label>
            <form:select path="SAA043" name="SAA043" style="width:150px">
                <form:option value="" label="请选择"/>
                <form:options items="${fns:getDictList('SAA043_5')}" itemLabel="label" itemValue="value"
                              htmlEscape="false"/>
            </form:select>
        </li>
        <li class="btns">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="btnQuery" class="btn btn-primary" type="submit" value="查询"/>
        </li>
    </ul>
</form:form>

<table id="tablst" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr style="font-weight: bolder;border:dotted 1px;height:35px;background-color: #FFFFFF;">
        <th>序&nbsp;&nbsp;&nbsp;号</th>
        <th>受理单号</th>
        <th>受理人</th>
        <th>受理时间</th>
        <th>功能事项</th>
        <th>业务状态</th>
        <th>单位名称</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="info">
        <tr>
            <td>
                <script>document.write(i);
                i++</script>
            </td>
            <td>${info.Saa036}</td>
            <td>${info.Saa080}</td>
            <td>${info.Saa040}</td>
            <td>${info.Saa055}</td>
            <td>${info.Saa043}</td>
            <td>${info.Saa041}</td>
            <td><a href="${ctx}/sybx/syywsljd/web_syywsljd/queryDetails?SAA036=${info.Saa036}&SAA015=${info.Saa055}">查看</a></td>
        </tr>
    </c:forEach>
    <c:if test="${page.list.size() <= 0}">
    <tr align="center">
        <td colspan="7">
            <div align="center" style="color: red;font-weight: bold;">未查询到符合条件的记录.</div>
        </td>
    </tr>
    </c:if>
    </tbody>
</table>
<c:if test="${page.list.size() > 0}">
    <div class="pagination">${page}</div>
</c:if>
</body>
</html>
