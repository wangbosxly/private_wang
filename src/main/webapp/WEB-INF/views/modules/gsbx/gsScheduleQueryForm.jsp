<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <title>受理进度明细</title>
    <script>
        var i = 1;
        function page(n, s) {
            if (n) $("#pageNo").val(n);
            if (s) $("#pageSize").val(s);
            $("#searchForm").attr("action", "${ctx}/sybx/syywsljd/web_syywsljd/queryDetails");
            $("#searchForm").submit();
            return false;
        }
        function eligibleExp() {
            // 导出合格人员
            var f = document.getElementById('searchForm');
            f.action = "${ctx}/sybx/syywsljd/web_syywsljd/eligibleExp";
            f.submit();
        }
        function doSearch() {
            var SAA036 = $("#SAA036").val();
            if (SAA036 === "" || SAA036 == null) {
                alert("受理单号不能为空。");
                return false;
            }
            var f = document.getElementById('searchForm');
            f.action = "${ctx}/gsbx/gsScheduleQuery/queryDetails";
            f.submit();
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/gsbx/gsScheduleQuery/list">受理进度</a></li>
    <li class="active"><a href="#">受理进度明细</a></li>
</ul>
<form:form modelAttribute="gsScheduleQuery" id="searchForm" action="${ctx}/gsbx/gsScheduleQuery/queryDetails"
           method="post" class="breadcrumb form-search ">
    <ul class="ul-form">
        <li>
            <label>受理单号:</label>
            <form:input path="SAA036" id="SAA036" htmlEscape="false" maxlength="50" cssClass="input-medium required"/>
            <span class="help-inline"><font
                    color="red">*</font> </span>
        </li>
        <li><label>审核结果:</label>
            <form:select path="TAA103" name="TAA103" style="width:150px">
                <form:option value="" label="请选择"/>
                <form:options items="${fns:getDictList('TAA103_5')}" itemLabel="label" itemValue="value"
                              htmlEscape="false"/>
            </form:select>
        </li>
        <li class="btns">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="btnQuery" class="btn btn-primary" type="button" value="查询" onclick="doSearch()"/>
            <%--<input class="btn btn-primary" type="button" value="导出不合格人员" onclick="eligibleExp()"/>--%>
        </li>
    </ul>
</form:form>
<table id="tablst" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr style="font-weight: bolder;border:dotted 1px;height:35px;background-color: #FFFFFF;">
        <th>受理单号</th>
        <th>个人编号</th>
        <th>姓名</th>
        <th>身份证</th>
        <th>申报时间</th>
        <th>申报结果</th>
        <th>未通过原因</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ pagination.list }" var="item">
        <tr>
            <td>${ item.SAA036 }</td>
            <td>${ item.AAC001 }</td>
            <td>${ item.AAC003 }</td>
            <td>${ item.AAC002 }</td>
            <td>${ item.TAA101 }</td>
            <td>${fns:getDictLabel(item.TAA103,'TAA103_5','')}</td>
            <td>${ item.TAA104 }</td>
        </tr>
    </c:forEach>
    <c:if test="${pagination.list.size() <= 0}">
        <tr>
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
