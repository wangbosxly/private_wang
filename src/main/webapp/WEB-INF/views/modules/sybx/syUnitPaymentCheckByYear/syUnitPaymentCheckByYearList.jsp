<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>登记年检申请</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {

            $("#btnSubmit").click(function () {

                $("#inputForm").attr("action", "${ctx}/sybx/syUnitPaymentCheck/check");
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
            $("#inputForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/syUnitPaymentCheckByYear/form/">登记年审申请</a></li>
</ul>
<sys:message content="${message}"/>
<form:form id="inputForm" modelAttribute="syCheckByYear"
           method="post"
           class="breadcrumb form-search">
    <ul class="ul-form">
        单位编号：<form:input path="AAB001" readonly="true" maxlength="20" cssStyle="width:100px;"
                         cssClass="input-medium required"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        单位名称：<form:input path="AAB004" readonly="true" maxlength="20" cssStyle="width:250px;"
                         cssClass="input-medium required"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        申报年份：<form:input path="year" placeholder="yyyy" readonly="true" maxlength="10" cssStyle="width:50px;"
                         Class="input-medium required"/>&nbsp;
    </ul>
    <ul class="clearfix"></ul>
    <ul class="ul-form">
        单位类型：<input type="text" name="AAB019" readonly="true" maxlength="20" style="width:100px;"
                         class="input-medium required" value="${fns:getDictLabel(syCheckByYear.AAB019, "AAB019_5","" )}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        经济类型：<input type="text" name="AAB020" readonly="true" maxlength="20" style="width:250px;"
                         class="input-medium required" value="${fns:getDictLabel(syCheckByYear.AAB020, "AAB020_5","" )}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        行业类型：<input  type="text" name="AAB022"  readonly="true" maxlength="10" style="width:50px;"
                         class="input-medium required" value="${fns:getDictLabel(syCheckByYear.AAB022, "AAB022_5","" )}"/>&nbsp;
    </ul>
</form:form>
<c:if test="${msg==null}">
<form:form class="breadcrumb form-search" action="${ctx}/sybx/syUnitPaymentCheckByYear/submit" method="post">
    <ul class="ul-form">
        应缴金额：<input type="text"  maxlength="20" style="width:130px;" readonly="true"
                         class="input-medium required" value="${sum}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        实缴金额：<input  type="text" maxlength="20" style="width:130px;" readonly="true"
                         class="input-medium required" value="${realysum}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        欠缴金额：<input type="text" placeholder="欠缴金额"  maxlength="10" style="width:130px;" readonly="true"
                    class="input-medium required" value="${locksum}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        待转基金余额：<input type="text" placeholder="待转基金余额"  maxlength="10" style="width:130px;" readonly="true"
                    class="input-medium required" value="${fund}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <c:if test="${locksum==0}">
            <button type="submit" class="btn btn-primary">提交</button>
        </c:if>
    </ul>
</form:form>
<form:form class="breadcrumb form-search">
    <c:if test="${syCheckByYear.BAA008==1}">
        <ul >
            <div style="color: red;font-weight: bold;">年审已经通过</div>
        </ul>
    </c:if>
    <c:if test="${locksum!=0}">
        <ul >
            <div style="color: red;font-weight: bold;">有欠缴费用，不能进行年审</div>
        </ul>
    </c:if>
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="font-weight: bolder;height:35px;background-color: #FFFFFF;">
            <td colspan="10">上年缴费信息列表</td>
        </tr>
        <tr>
            <th>缴费类型</th>
            <th>费款所属期</th>
            <th>人数</th>
            <th>单位缴费基数总额</th>
            <th>个人缴费基数总额</th>
            <th>单位应缴</th>
            <th>个人应缴</th>
            <th>滞纳金</th>
            <th>应缴合计</th>
            <th>缴费标志</th>
            <th>查看/操作</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${page!=null&&page.list.size()>0}">
                <c:forEach items="${page.list}" var="syab88">
                    <input type="hidden" name="BAA001" value="${syab88.BAA001}"/>
                    <input type="hidden" name="AAE143" value="${syab88.AAE143}"/>
                    <tr>
                        <td>${fns:getDictLabel(syab88.AAE143, "AAE143_5",'' )}</td>
                        <td>
                            <a href="${ctx}/sybx/syUnitPaymentCheck/changeList?aae002=${syab88.AAE002}">${syab88.AAE002}</a>
                        </td>
                        <td>
                            <a href="${ctx}/sybx/syUnitPaymentCheck/personList?AAE003=${syab88.AAE002}&AAE002=${syab88.AAE002}&AAE143=${syab88.AAE143}">${syab88.AAB083}
                        </td>
                        <td class="moneyNum">${syab88.AAB121}</td>
                        <td class="moneyNum">${syab88.AAB121}</td>
                        <td class="moneyNum">${syab88.BAB701}</td>
                        <td class="moneyNum">${syab88.AAB122}</td>
                        <td class="moneyNum">${syab88.BAE742}</td>
                        <td class="moneyNum">${syab88.AAB137}</td>
                        <td>${syab88.BAE707}</td>
                        <td>
                            <a href="${ctx}/sybx/syUnitPaymentCheck/CollectionList?aae063=${syab88.AAE063}">${syab88.AAE063}</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td style="color: red;font-weight: bold; text-align: center" colspan="11">上年无单位缴费信息</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
    <div class="pagination">${page}</div>
</form:form>
</c:if>
<c:if test="${msg!=null}">
    <div style="color: red;font-weight: bold;">${msg}</div>
</c:if>
</body>
</html>