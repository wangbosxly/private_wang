<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员异动信息列表</title>
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
    <li class="active"><a href="${ctx}/sybx/syUnitPaymentCheck">人员异动信息列表</a></li>
</ul>
<sys:message content="${message}"/>
<form:form cssClass="breadcrumb form-search">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <th colspan="11">人员异动信息列表</th>
        </tr>
        <tr>
            <th width="20%">险种类型</th>
            <th width="20%">变更类型</th>
            <th width="20%">总人次</th>
            <th width="20%">异动缴费基数总额</th>
            <th width="20%">操作</th>
        </tr>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${list!=null&&list.size()>0}">
                <c:forEach items="${list}" var="syab88">
                    <tr>
                        <td>${fns:getDictLabel(syab88.AAE140, "AAE140_5",'' )}</td>
                        <td>${fns:getDictLabel(syab88.AAC050, "AAC050_5",'' )}</td>
                        <td>${syab88.AAC002_1}</td>
                        <td class="moneyNum">${syab88.BAC504}</td>
                        <td>
                            <a href="${ctx}/sybx/syUnitPaymentCheck/changeInfo?bac720=${syab88.AAC050}&aae002=${aae002}">查询明细</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td style="color: red;font-weight: bold; text-align: center" colspan="11">暂无本期人员异动信息</td>
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