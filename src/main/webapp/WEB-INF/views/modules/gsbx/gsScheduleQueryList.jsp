<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <title>受理进度</title>
    <script>
        $(document).ready(function () {
            $("#searchForm").validate({
                submitHandler: function (form) {
                    form.submit();
                }
            });
        });
        var i = 1;
        function page(n, s) {
            if (n) $("#pageNo").val(n);
            if (s) $("#pageSize").val(s);
            $("#searchForm").attr("action", "${ctx}/gsbx/gsScheduleQuery/list");
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gsbx/gsScheduleQuery/list">受理进度</a></li>
    <li ><a href="${ctx}/gsbx/gsScheduleQuery/queryDetails">受理进度明细</a></li>
</ul>
<form:form id="searchForm" modelAttribute="gsScheduleQuery" action="${ctx}/gsbx/gsScheduleQuery/list" method="post"
           class="breadcrumb form-search ">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li>
            <label>开始时间：</label>
            <form:input id="StartDate" path="StartDate" htmlEscape="false" maxlength="50"
                        class="input-medium Wdate required" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'});"/>
        </li>
        <li>
            <label>结束时间：</label>
            <form:input id="EndDate" path="EndDate" htmlEscape="false" maxlength="50"
                        class="input-medium Wdate required" readonly="true" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'});"/>
        </li>
        <li><label>功能事项:</label>
            <form:select path="SAA015" name="SAA015" style="width:150px">
                <form:option value="" label="请选择"/>
                <form:options items="${fns:getDictList('SAA015_GS')}" itemLabel="label" itemValue="value"
                              htmlEscape="false"/>
            </form:select>
        </li>
        <li><label>业务状态:</label>
            <form:select path="SAA043" name="SAA043" style="width:150px">
                <form:option value="" label="请选择"/>
                <form:options items="${fns:getDictList('SAA043_GS')}" itemLabel="label" itemValue="value"
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
    <c:forEach items="${pagination.list}" var="info">
        <tr>
            <td>
                <script>document.write(i);
                i++</script>
            </td>
            <td>${info.SAA036}</td>
            <td>${info.AAB034}</td>
            <td>${info.SAA038}</td>
            <td>${fns:getDictLabel(info.SAA015, "SAA015_GS","" )}</td>
            <td>${fns:getDictLabel(info.SAA043, "SAA043_GS","" )}</td>
            <td>${info.AAB004}</td>
            <td><a href="${ctx}/gsbx/gsScheduleQuery/queryDetails?SAA036=${info.SAA036}">查看</a></td>
        </tr>
    </c:forEach>
    <c:if test="${pagination.list.size() <= 0}">
    <tr align="center">
        <td colspan="8">
            <div align="center" style="color: red;font-weight: bold;">未查询到符合条件的记录.</div>
        </td>
    </tr>
    </c:if>
    </tbody>
</table>
<c:if test="${pagination.list.size() > 0}">
    <div class="pagination">${pagination}</div>
</c:if>
</body>
</html>
