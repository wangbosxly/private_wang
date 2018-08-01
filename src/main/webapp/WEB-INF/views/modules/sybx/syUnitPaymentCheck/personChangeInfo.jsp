<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员异动信息明细列表</title>
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

                $("#searchForm").attr("action", "${ctx}/sybx/syUnitPaymentQuery/unit/list");
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
    <li class="active"><a href="${ctx}/sybx/syUnitPaymentCheck">人员异动信息明细列表</a></li>
</ul>
<sys:message content="${message}"/>
<form:form cssClass="breadcrumb form-search">
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <input type="hidden" name="BAA001" value="${syab88.BAA001}"/>
    <tr><th colspan="11">人员异动信息明细列表</th></tr>
    <tr>
        <th>个人编号</th>
        <th>身份证号</th>
        <th>姓名</th>
        <th>变更类型</th>
        <th>变更原因</th>
        <th>缴费基数</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${list!=null&&list.size()>0}">
            <c:forEach items="${list}" var="syab88">
                <tr>
                    <td>${syab88.AAC001}</td>
                    <td>${syab88.AAC002}</td>
                    <td>${syab88.AAC003}</td>
                    <td>${fns:getDictLabel(syab88.AAC050, "AAC050_5",'' )}</td>
                    <td>${fns:getDictLabel(syab88.AAE160, "AAE160_5",'' )}</td>
                    <td class="moneyNum">${syab88.BAC504}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
                <td style="color: red;font-weight: bold; text-align: center" colspan="11">暂无本期人员异动明细信息</td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
    <div align="center">
        <input id="btnCancel" class="btn btn-primary" type="button" value="返 回" onclick="history.go(-1)"/>
    </div>
</form:form>
</body>
</html>