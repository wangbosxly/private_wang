<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员生育信息备案</title>
    <meta name="decorator" content="default"/>
    <script>
        function checkValue() {
            var aac001_str = document.getElementById("AAC001").value;
            var aac002_str = document.getElementById("AAC002").value;
            if (aac001_str === "" && aac002_str === "") {
                top.$.jBox.tip("个人编号和身份证号不可同时为空!");
                return false;
            }
            return true;
        }
        $(document).ready(function () {
            //$("#name").focus();
            $("#inputForm").validate({
                submitHandler: function (form) {
                    //loading('正在提交，请稍等...');
                    form.submit();
                },
                rules:{
                    //身份证号验证
                    AAC002:{card:true}
                },
                messages:{
                    AAC002:{card:"请输入正确的身份证号码"}
                }
            });

            $("#infoForm").validate({
                submitHandler: function (form) {
                    //loading('正在提交，请稍等...');
                    form.submit();
                }
            });
        });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gsbx/gsFertilityRecord/form">人员生育备案</a></li>
</ul>

    <form:form id="inputForm" modelAttribute="gsFertilityRecord" action="${ctx}/gsbx/gsFertilityRecord/info"
               method="post" class="breadcrumb form-search">
        <ul class="ul-form">
            <div class="control-group">
                <div class="controls">
                    <label>个人编号：</label>
                    <form:input id="AAC001" path="AAC001" htmlEscape="false" maxlength="50"
                                cssClass="input-medium "/>
                    <label>身份证号：</label>
                    <form:input id="AAC002" path="AAC002" htmlEscape="false" maxlength="18"
                                cssClass="input-medium "/>
                    <label>姓名：</label>
                    <form:input id="AAC003" path="AAC003" htmlEscape="false" maxlength="18"
                                cssClass="input-medium"/>
                    <input id="query" class="btn btn-primary" type="submit" value="查询" onclick="return checkValue();">
                </div>
            </div>
        </ul>
    </form:form>
<sys:message content="${message}" type="${ctype}"/>
<c:if test="${flag != null}">
<form:form id="infoForm" modelAttribute="gsFertilityRecord" action="${ctx}/gsbx/gsFertilityRecord/submit">
    <form:hidden path="AAC001"/>
    <ul class="ul-form">
        <div class="control-group">
            <div class="controls">
                <label>胎次</label>
                <form:input id="AMC032" path="AMC032" htmlEscape="false" maxlength="1"
                            cssClass="input-medium required"/>
                <span class="help-inline"><font color="red">*</font></span>
                <label style="padding-left: 10px">怀孕日期</label>
                <form:input path="AMC087" readonly="true" maxlength="10" cssStyle="width:145px;"
                            cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                <span class="help-inline"><font color="red">*</font></span>
                <input id="query" class="btn btn-primary" type="submit" value="确认备案" style="margin-bottom: 10px;">
            </div>
        </div>
    </ul>
</form:form>
</c:if>
<c:if test="${infoList!=null}">
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr style="text-align:center;">
        <th colspan="6">人员基本信息</th>
    </tr>
    <tr>
        <th>个人编号</th>
        <th>单位编号</th>
        <th>姓名</th>
        <th>身份证号</th>
        <th>险种类型</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${infoList}" var="Info">
        <tr>
            <td>${Info.AAC001}</td>
            <td>${Info.AAB001}</td>
            <td>${Info.AAC003}</td>
            <td>${Info.AAC002}</td>
            <td>${fns:getDictLabel(Info.AAE140, "AAE140_5","" )}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
<br/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr style="text-align:center;">
        <th colspan="6">人员生育备案信息</th>
    </tr>
    <tr>
        <th>个人编号</th>
        <th>单位编号</th>
        <th>性别</th>
        <th>(配偶或本人)怀孕日期</th>
        <th>胎次</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${infoListLs}" var="Info">
        <tr>
            <td>${Info.AAC001}</td>
            <td>${Info.AAB001}</td>
            <td>${fns:getDictLabel(Info.AAC004,"AAC004_5","")} </td>
            <td>${Info.AMC087}</td>
            <td>${Info.AMC032}</td>
            <td>
                <c:if test="${Info.AAC004==2}">
                <a href="${ctx}/gsbx/gsFertilityRecord/download?AMC087=${Info.AMC087}">打印保险卡</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${infoListLs==null}">
        <tr>
            <td colspan="6" style="color: red;font-weight: bold">无人员生育备案信息</td>
        </tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
