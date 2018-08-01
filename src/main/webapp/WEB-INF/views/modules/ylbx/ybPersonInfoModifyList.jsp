<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>人员信息管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {

        });
        function page(n,s){
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
    <script type="text/javascript">
        function page(n,s){
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/ylbx/ybPersonInfoModify/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a>人员信息列表</a></li>
</ul>
<sys:message content="${message}" type="${ctype}"/>
<form:form id="searchForm" modelAttribute="ybPerson" action="${ctx}/ylbx/ybPersonInfoModify/list" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${pagination.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${pagination.pageSize}"/>
    <ul class="ul-form">
        <li><label style="width: auto">个人编号：</label>
            <form:input path="AAC001" htmlEscape="false" maxlength="15" class="input-medium"/>
        </li>
        <li><label style="width: auto">公民身份号码：</label>
            <form:input path="AAC002" htmlEscape="false" maxlength="180" class="input-medium"/>
        </li>
        <li><label style="width: auto">姓名：</label>
            <form:input path="AAC003" htmlEscape="false" maxlength="20" class="input-medium"/>
        </li>
        <li class="btns" style="width: auto"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>单位编号</th>
        <th>个人编号</th>
        <th>公民身份号码</th>
        <th>姓名</th>
        <th>性别</th>
        <th>民族</th>
        <th>出生日期</th>
        <th>户口性质</th>
        <th>参加工作日期</th>
        <th>详情查看</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pagination.list}" var="info">
        <tr>
            <td>
                    ${info.AAB001}
            </td>
            <td>
                    ${info.AAC001}
            </td>
            <td>
                    ${info.AAC002}
            </td>
            <td>
                    ${info.AAC003}
            </td>
            <td>
                    ${fns:getDictLabel(info.AAC004, 'AAC004_YB', '')}
            </td>
            <td>
                    ${fns:getDictLabel(info.AAC005, 'AAC005_YB', '')}
            </td>
            <td>
                    ${info.AAC006}
            </td>
            <td>
                    ${fns:getDictLabel(info.AAC009, 'AAC009_YB', '')}
            </td>
            <td>
                    ${info.AAC007}
            </td>
            <td>
                <a href="${ctx}/ylbx/ybPersonInfoModify/update?AAC001=${info.AAC001}">修改</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${pagination}</div>
</body>
</html>