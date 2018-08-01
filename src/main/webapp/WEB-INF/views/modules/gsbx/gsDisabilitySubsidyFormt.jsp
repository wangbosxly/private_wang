<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>一次性伤残补助金</title>
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
    <li class="active"><a href="${ctx}/gsbx/gsDisabilitySubsidy/list">一次性伤残补助金</a></li>
</ul>
<form:form id="inputForm" modelAttribute="gsDisabilitySubsidy" action="${ctx}/gsbx/gsDisabilitySubsidy/form"
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
<form:form id="secondForm" modelAttribute="gsDisabilitySubsidy" action="${ctx}/gsbx/gsDisabilitySubsidy/submit"
           method="post"
           class="form-horizontal">
    <table class="table-form">
        <c:forEach items="${infoList}" var="Info">
            <tr>
                <td class="tit" width="15%">个人编号:</td>
                <td width="20%">${Info.AAC001}</td>
                <td class="tit" width="15%">姓&nbsp;&nbsp;&nbsp;名:</td>
                <td width="20%">${Info.AAC003}</td>
                <td class="tit" width="15%">单位名称:</td>
                <td width="20%">${Info.AAB004}</td>
            </tr>
            <tr>
                <td class="tit" width="15%">工伤发生日期:</td>
                <td width="20%">${Info.ALC020}</td>
                <td class="tit" width="15%">工伤报告日期:</td>
                <td width="20%">${Info.ALC203}</td>
                <td class="tit" width="15%">工伤认定日期:</td>
                <td width="20%">${Info.ALC031}</td>
            </tr>
            <tr>
                <td class="tit" width="15%">工伤认定编号:</td>
                <td width="20%">${Info.ALC029}</td>
                <td class="tit" width="15%">认定文号:</td>
                <td width="20%">${Info.ALC042}</td>
                <td class="tit" width="15%">工伤认定单位:</td>
                <td width="20%">${fns:getDictLabel(Info.ALC030, "ALC030_GS","" )}</td>
            </tr>
            <tr>
                <td class="tit" width="15%">工伤论定结论:</td>
                <td width="20%">${fns:getDictLabel(Info.ALC313, "ALC313_GS","" )}</td>
                <td class="tit" width="15%">事故地点:</td>
                <td width="20%">${Info.ALC023}</td>
                <td class="tit" width="15%">鉴定类型:</td>
                <td width="20%">${fns:getDictLabel(Info.ALC214, "ALC214_GS","" )}</td>
            </tr>
            <tr>
                <td class="tit" width="15%">鉴定日期:</td>
                <td width="20%">${Info.ALC034}</td>
                <td class="tit" width="15%">鉴定编号:</td>
                <td width="20%">${Info.ALC035}</td>
                <td class="tit" width="15%">鉴定单位:</td>
                <td width="20%">${fns:getDictLabel(Info.ALC033, "ALC033_GS","" )}</td>
            </tr>
            <tr>
                <td class="tit" width="15%">联系人:</td>
                <td width="20%">${Info.AAE004}</td>
                <td class="tit" width="15%">联系电话:</td>
                <td width="20%">${Info.AAE005}</td>
                <td class="tit" width="15%">伤残等级:</td>
                <td width="20%">${fns:getDictLabel(Info.ALA040, "ALA040_GS","" )}</td>
            </tr>
            <tr>
                <td class="tit" width="15%">个人前12个月工资:</td>
                <td width="20%">${Info.AAA013}</td>
                <td class="tit" width="15%">一次性伤残补助金月数:</td>
                <td width="20%">${Info.ALA041_020}</td>
                <td class="tit" width="15%">一次性伤残补助金:</td>
                <td width="20%">${Info.ALC110}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div style="text-align: center">
    <input class="btn btn-primary" type="submit" value="提交申报" >
    <a href="${ctx}/gsbx/gsDisabilitySubsidy/download"  class="button btn btn-primary">下载审批表</a>
    </div>
</form:form>
</c:if>
</body>
</html>
