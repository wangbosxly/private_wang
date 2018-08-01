<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员续保登记</title>
    <meta name="decorator" content="default"/>
    <title>Title</title>

</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/sytemplate/download">模板下载</a></li>
</ul>
<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th width="70%" style="text-align: center">模板名称</th>
        <th style="text-align: center">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${fns:getDictList('FILE_5')}" var="down">
    <tr>
        <td >${down.label}(${down.description})</td>
        <td style="text-align: center">
            <a href="${down.value}" class="btn btn-primary">下载</a>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>
</body>
</html>
