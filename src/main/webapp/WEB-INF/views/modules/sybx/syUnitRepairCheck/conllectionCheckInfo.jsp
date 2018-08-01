<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>单位缴费信息查询</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btnExport").click(function () {
                top.$.jBox.confirm("确认要导出单位缴费数据吗？", "系统提示", function (v, h, f) {
                    if (v == "ok") {
                        $("#searchForm").attr("action", "${ctx}/sybx/syUnitPaymentQuery/unit/export");
                        $("#searchForm").submit();

                    }
                }, {buttonsFocus: 1});
                top.$('.jbox-body .jbox-icon').css('top', '55px');
            });

            $("#btnSubmit").click(function () {
                $("#searchForm").attr("action", "${ctx}/sybx/syUnitRepairCheck/submit");
                $("#searchForm").submit();

            });

            $("#inputForm").validate({
                submitHandler: function (form) {
                    loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function (error, element) {
                    $("#messageBox").text("输入有误，请先更正。");
                    if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });

        });

        function page(n, s) {
            if (n) $("#pageNo").val(n);
            if (s) $("#pageSize").val(s);
            $("#inputForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/syUnitPaymentCheck/">单位缴费核定</a></li>
</ul>
<sys:message content="${message}"/>
<form:form id="searchForm" modelAttribute="syab88" action="${ctx}/sybx/syUnitRepairCheck/submit" method="post"
           class="breadcrumb form-search">
    <input type="hidden" name="AAE002" value="${list[0].AAE002}"/>
    <ul class="ul-form">
        <li>单位编号：<form:input path="AAB001" readonly="true" maxlength="20" cssStyle="width:250px;"
                             cssClass="input-medium required"/><span class="help-inline"><font
                color="red">*</font> </span></li>
        <li>单位名称：<form:input path="AAB004" readonly="true" maxlength="20" cssStyle="width:250px;"
                             cssClass="input-medium required"/><span class="help-inline"><font
                color="red">*</font> </span></li>
        <li class="btns">
            <c:choose>
                <c:when test="${list[0].AAB001!=null}">
                    <input id="btnSubmit" class="btn btn-primary" type="button" value="审核"/>
                </c:when>
                <c:otherwise>
                    <input class="btn btn-primary" type="button" value="返 回" onclick="history.go(-1)"/>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
    </form:form>
    <form:form class="breadcrumb form-search">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="font-weight: bolder;height:35px;background-color: #FFFFFF;">
            <td colspan="10">本期应缴信息列表</td>
        </tr>
        <tr>
            <th>险种类型</th>
            <th>费款所属期</th>
            <th>人数</th>
            <th>单位缴费基数总额</th>
            <th>个人缴费基数总额</th>
            <th>单位应缴</th>
            <th>个人应缴</th>
            <th>滞纳金</th>
            <th>应缴合计</th>
            <th>查看/操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${list[0].AAB001!=null}">
                <tr>
                    <td>${fns:getDictLabel(list[0].AAE140, "AAE140_5",'' )}</td>
                    <td>${list[0].AAE002}</td>
                    <td>${list[0].AAB083}</td>
                    <td class="moneyNum">${list[0].AAB121}</td>
                    <td class="moneyNum">${list[0].AAB121}</td>
                    <td class="moneyNum">${list[0].BAB701}</td>
                    <td class="moneyNum">${list[0].AAB122}</td>
                    <td class="moneyNum">${list[0].BAE742}</td>
                    <td class="moneyNum">${list[0].AAB137}</td>
                    <td>
                        <a href="${ctx}/sybx/syUnitRepairCheck/export?baa005=${list[0].BAA005}">下载明细</a>
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <td style="color: red;font-weight: bold; text-align: center" colspan="11">
                        暂无本期应缴信息或本期缴费已核定
                    </td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</form:form>
</body>
</html>