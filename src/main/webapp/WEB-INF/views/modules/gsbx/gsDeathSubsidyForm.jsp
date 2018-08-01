<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>一次性工亡补助金</title>
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
        });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gsbx/gsDeathSubsidy/list">一次性工亡补助金</a></li>
</ul>
<form:form id="inputForm" modelAttribute="gsDeathSubsidy" action="${ctx}/gsbx/gsDeathSubsidy/form"
           method="post" class="breadcrumb form-search">
    <ul class="ul-form">
        <div class="control-group">
            <div class="controls">
                <label>个人编号：</label>
                <form:input id="AAC001" path="AAC001" htmlEscape="false" maxlength="50"
                            cssClass="input-medium"/>
                <label>身份证号：</label>
                <form:input id="AAC002" path="AAC002" htmlEscape="false" maxlength="18"
                            cssClass="input-medium"/>
                <label>姓名：</label>
                <form:input id="AAC003" path="AAC003" htmlEscape="false" maxlength="18"
                            cssClass="input-medium"/>
                <input id="query" class="btn btn-primary" type="submit" value="查询" onclick="return checkValue();">
            </div>
        </div>
    </ul>
</form:form>
<sys:message content="${message}" type="${ctype}"/>
<c:if test="${infoList != null}">
    <form:form id="secondForm" modelAttribute="gsDeathSubsidy" action="${ctx}/gsbx/gsDeathSubsidy/submit"
               method="post"
               class="form-horizontal">
<table class="table-form">
    <c:forEach items="${infoList}" var="Info">
    <tr>
        <td class="tit" width="15%">个人编号:</td>
        <td width="20%">${Info.AAC001}</td>
        <td class="tit" width="15%">姓&nbsp;&nbsp;&nbsp;名:</td>
        <td width="20%">${Info.AAC003}</td>
        <td class="tit" width="15%">工伤伤申号:</td>
        <td width="20%">${Info.ALC150}</td>
    </tr>
    <tr>
        <td class="tit" width="15%">单位编号:</td>
        <td width="20%">${Info.AAB001}</td>
        <td class="tit" width="15%">单位名称:</td>
        <td width="20%">${Info.AAB004}</td>
        <td class="tit" width="15%">工伤发生日期:</td>
        <td width="20%">${Info.ALC020}</td>
    </tr>
    <tr>
        <td class="tit" width="15%">因工死亡时间:</td>
        <td width="20%">${Info.ALC040}</td>
        <td class="tit" width="15%">死亡原因:</td>
        <td width="20%">${Info.BAA021}</td>
        <td class="tit" width="15%">1-4级死亡标志:</td>
        <td width="20%">${fns:getDictLabel(Info.ALC456, "ALC456_GS","" )}</td>
    </tr>
    <tr>
        <td class="tit" width="15%">工伤类别:</td>
        <td width="20%">${fns:getDictLabel(Info.ALC027, "ALC027_GS","" )}</td>
        <td class="tit" width="15%">伤害程度:</td>
        <td width="20%">${fns:getDictLabel(Info.ALC021, "ALC021_GS","" )}</td>
        <td class="tit" width="15%">上年全国城镇居民人均可支配收入:</td>
        <td width="20%">${Info.AAA011}</td>
    </tr>
    <tr>
        <td class="tit" width="15%">一次性工亡补助金月:</td>
        <td width="20%">${Info.BLC005}</td>
        <td class="tit" width="15%">一次性工亡补助金:</td>
        <td width="20%">${Info.ALC115_1}</td>
        <td class="tit" width="15%">上年社平工资:</td>
        <td width="20%">${Info.AAA010}</td>
    </tr>
    <tr>
        <td class="tit" width="15%">丧葬补助金支付月:</td>
        <td width="20%">${Info.BLC004}</td>
        <td class="tit" width="15%">丧葬补助金:</td>
        <td width="20%">${Info.ALC115_0}</td>
    </tr>
    </c:forEach>
</table>
<br>
<div style="text-align: center">
    <input class="btn btn-primary" type="submit" value="提交申报" >
    <a href="${ctx}/gsbx/gsDeathSubsidy/download"  class="button btn btn-primary">下载审批表</a>
</div>
    </form:form>
</c:if>
</body>
</html>
