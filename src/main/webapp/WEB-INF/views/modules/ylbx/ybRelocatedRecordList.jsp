<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>异地安置备案管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#searchForm").validate({
                submitHandler: function(form){
                    loading('正在提交，请稍等...');
                    form.submit();
                }
            });
        });
        function page(n,s){
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/ylbx/ybRelocatedRecord/list">异地安置备案列表</a></li>
</ul>
<form:form id="searchForm" modelAttribute="specialBusiness" action="${ctx}/ylbx/ybRelocatedRecord/list" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${pagination.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${pagination.pageSize}"/>
    <ul class="ul-form">
        <div class="control-group">
            <div class="controls">
                <label>个人编号：</label><form:input id="AAC001" path="AAC001" htmlEscape="false" maxlength="50"
                                                class="input-medium"/>
                <label>身份证号：</label><form:input id="AAC002" path="AAC002" htmlEscape="false" maxlength="50"
                                                class="input-medium"/>
                <input id="query" class="btn btn-primary" type="submit" value="查询" title="根据录入条件查询异地安置备案信息"/>
            </div>
        </div>
    </ul>
</form:form>
<div style="margin:10px;color:red;font-weight:bold;">说明：申报时间12月1日至12月31日，其他时间不开放</div>
<sys:message content="${message}" type="${ctype}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>个人编号</th>
        <th>身份证号</th>
        <th>姓名</th>
        <th>长住外地详细地址</th>
        <th>长住外地原因</th>
        <th>有效起始日期</th>
        <th>有效截止日期</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pagination.list}" var="info">
        <tr>
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
                    ${info.AAE006}
            </td>
            <td>
                    ${info.BKC021}
            </td>
            <td>
                    ${info.BKE003}
            </td>
            <td>
                    ${info.BKE004}
            </td>
            <td>
                <a href="${ctx}/ylbx/ybRelocatedRecord/info?AAC001=${info.AAC001}">修改</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${pagination}</div>
</body>
</html>