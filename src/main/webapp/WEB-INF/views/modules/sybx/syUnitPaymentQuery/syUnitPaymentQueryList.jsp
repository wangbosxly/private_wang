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
                        $("#inputForm").attr("action", "${ctx}/sybx/syUnitPaymentQuery/unit/export");
                        $("#inputForm").submit();
                        closeLoading();
                    }
                }, {buttonsFocus: 1});
                top.$('.jbox-body .jbox-icon').css('top', '55px');
            });

            $("#btnSubmit").click(function () {

                $("#inputForm").attr("action", "${ctx}/sybx/syUnitPaymentQuery/unit/list");
                $("#inputForm").submit();

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
            $("#inputForm").attr("action", "${ctx}/sybx/syUnitPaymentQuery/unit/list");
            $("#inputForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/syUnitPaymentQuery/unit/">单位缴费信息列表</a></li>
</ul>
<form:form id="inputForm" modelAttribute="syab88" action="${ctx}/sybx/syUnitPaymentQuery/unit/list" method="post"
           class="breadcrumb form-search">
    <ul class="ul-form">
        <li>起始费款所属期：<form:input path="startYM" placeholder="yyyyMM" readonly="true" maxlength="10"
                                cssStyle="width:145px;" cssClass="input-medium Wdate required"
                                onclick="WdatePicker({dateFmt:'yyyyMM'});"/><span class="help-inline"><font color="red">*</font> </span>
        </li>
        <li>&nbsp;&nbsp;&nbsp;截止费款所属期：<form:input path="endYM" placeholder="yyyyMM" readonly="true" maxlength="10"
                                                  cssStyle="width:145px;" cssClass="input-medium Wdate required"
                                                  onclick="WdatePicker({dateFmt:'yyyyMM'});"/><span class="help-inline"><font
                color="red">*</font> </span></li>
        <li>&nbsp;&nbsp;&nbsp;缴费标志：<form:select path="BAE707" class="input-large" cssStyle="width:160px">
            <form:option value="" label="请选择"/>
            <form:options items="${fns:getDictList('AAE114_5')}" itemLabel="label" itemValue="value"
                          htmlEscape="false"/>
        </form:select></li>
        <li class="btns">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
            <c:if test="${page.list.size()>0}">
                <input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
            </c:if>
        </li>
        <li class="clearfix"></li>
    </ul>
    <c:if test="${page!=null}">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    </c:if>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed" style="margin: auto">
    <thead>
    <input type="hidden" name="BAA001" value="${syab88.BAA001}"/>
    <tr>
        <th>缴费类型</th>
        <th>费款所属期</th>
        <th>缴费基数总额</th>
        <th>缴费人数</th>
        <th>个人应缴金额</th>
        <th>单位应缴金额</th>
        <th>应缴合计</th>
        <th>缴费标志</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${page.list.size()>0}">
            <c:forEach items="${page.list}" var="syab88">
                <input type="hidden" name="BAA001" value="${syab88.BAA001}"/>
                <tr>
                    <td>${fns:getDictLabel(syab88.AAE143,"AAE143_5","")}</td>
                    <td>${syab88.AAE003}</td>
                    <td class="moneyNum">${syab88.AAB121}</td>
                    <td>${syab88.AAB083}</td>
                    <td class="moneyNum">${syab88.AAB122}</td>
                    <td class="moneyNum">${syab88.BAB701}</td>
                    <td class="moneyNum">${syab88.AAB137}</td>
                    <td>${syab88.BAE707}</td>

                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td style="color: red;font-weight: bold; text-align: center" colspan="11">本期暂无单位缴费信息</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>