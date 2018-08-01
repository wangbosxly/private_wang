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
                /*var url = "

                ${ctx}/sybx/syUnitPaymentCheck/submit";
                var data = '{"AAE002":"

                ${list[0].AAE002}"}';
                $.post(url,data,function(d){

                });*/
                $("#searchForm").attr("action", "${ctx}/sybx/syUnitPaymentCheck/submit");
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
<form:form id="searchForm" modelAttribute="syab88" action="${ctx}/sybx/syUnitPaymentCheck/submit" method="post"
           class="breadcrumb form-search">
    <input type="hidden" name="AAE002" value="${list[0].AAE002}"/>
    <ul class="ul-form">
        单位编号：<form:input path="AAB001" readonly="true" maxlength="20" cssStyle="width:250px;"
                             cssClass="input-medium required"/><span class="help-inline"><font
                color="red">*</font> </span>
        单位名称：<form:input path="AAB004" readonly="true" maxlength="20" cssStyle="width:250px;"
                             cssClass="input-medium required"/><span class="help-inline"><font
                color="red">*</font> </span>

            <c:choose>
                <c:when test="${list[0].AAB001!=null}">
                    <input id="btnSubmit" class="btn btn-primary" type="button" value="提交"/>
                </c:when>
                <c:when test="${list==null||(list[0].AAB001==null&&fn:length(list[0].AC88ViewList)>0)}">
                    <input class="btn btn-primary" type="button" value="返 回" onclick="history.go(-1)"/>
                </c:when>
            </c:choose>
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
                    <td>
                        ${list[0].AAE002}
                    </td>
                    <td>
                        ${list[0].AAB083}
                    </td>
                    <td class="moneyNum">${list[0].AAB121}</td>
                    <td class="moneyNum">${list[0].AAB121}</td>
                    <td class="moneyNum">${list[0].BAB701}</td>
                    <td class="moneyNum">${list[0].AAB122}</td>
                    <td class="moneyNum">${list[0].BAE742}</td>
                        <%--${syab88.BAE713}--%>
                    <td class="moneyNum">${list[0].AAB137}</td>
                    <td>
                        <a href="${ctx}/sybx/syUnitPaymentCheck/export?baa005=${list[0].BAA005}">下载明细</a>
                    </td>
                </tr>
            </c:when>
            <c:when test="${list==null}">
                <tr>
                    <td style="color: red;font-weight: bold; text-align: center" colspan="11">
                        暂无本期应缴信息或本期缴费已核定
                    </td>
                </tr>
            </c:when>
            <c:when test="${fn:length(list[0].AC88ViewList)>0}">
                <tr>
                    <td style="color: red;font-weight: bold; text-align: center" colspan="11">
                        存在基数不合法员工，请修正基数后再次核定
                    </td>
                </tr>
            </c:when>
        </c:choose>
        </tbody>
    </table>
</form:form>
<%--错误人员信息--%>
<form:form class="breadcrumb form-search">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="font-weight: bolder;height:35px;background-color: #FFFFFF;">
            <td colspan="10">本期人员基数低于缴费下限或高于上限明细</td>
        </tr>
        <tr>
            <th>个人编号</th>
            <th>姓名</th>
            <th>身份证号</th>
            <th>缴费工资</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${list[0].AAB001==null&&fn:length(list[0].AC88ViewList)>0}">
                <c:forEach items="${list[0].AC88ViewList}" var="syab88">
                    <tr>
                        <td>${syab88.AAC001}</td>
                        <td>${syab88.AAC003}</td>
                        <td>${syab88.AAC002}</td>
                        <td class="moneyNum">${syab88.BAC504}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td style="color: red;font-weight: bold; text-align: center" colspan="11">本期无不正常人员信息</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</form:form>
<%--近半年缴费记录--%>
<form:form class="breadcrumb form-search">
    <table class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="font-weight: bolder;height:35px;background-color: #FFFFFF;">
            <td colspan="10">近半年缴费信息列表</td>
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
            <c:when test="${resultList!=null&&resultList.size()>0}">
                <c:forEach items="${resultList}" var="syab88">
                    <input type="hidden" name="BAA001" value="${syab88.BAA001}"/>
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
                            <%--${syab88.BAE713}--%>
                        <td>${syab88.BAE707}</td>
                        <td>
                            <a href="${ctx}/sybx/syUnitPaymentCheck/CollectionList?aae063=${syab88.AAE063}">${syab88.AAE063}</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td style="color: red;font-weight: bold; text-align: center" colspan="11">近半年无单位缴费信息</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</form:form>
<%--人员异动信息--%>
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
            <c:when test="${personChangeList!=null&&personChangeList.size()>0}">
                <c:forEach items="${personChangeList}" var="syab88">
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
</form:form>
</body>
</html>