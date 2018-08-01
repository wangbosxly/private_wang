<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>门诊特殊病人员登记</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#inputForm").validate({

            });
        });
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="#">人员登记</a>
    </li>
</ul><br/>
<sys:message content="${message}" type="${ctype}"/>
<form:form id="inputForm" modelAttribute="specialBusiness"
           action="${ctx}/ylbx/ybSpecialPatient/save" method="post"
           class="form-horizontal">
    <table class="table-form">
        <tr>
            <td class="tit" width="15%">姓名</td>
            <td width="20%">
                <form:input path="AAC003" htmlEscape="false" maxlength="20"
                            class="input-large required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">身份证号</td>
            <td width="20%">
                <form:input path="AAC002" htmlEscape="false" maxlength="18"
                            class="input-large required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">病种名称</td>
            <td width="20%">
                <form:select path="AKA120" class="input-large required">
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AKA120_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">单位名称</td>
            <td width="20%">
                <form:input path="AAB004" readonly="true" htmlEscape="false" maxlength="50"
                            class="input-large "/><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">经办人</td>
            <td width="20%">
                <form:input path="AAE011" readonly="true" htmlEscape="false" maxlength="50"
                            class="input-large "/><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">手机号码</td>
            <td width="20%">
                <form:input path="AAE171" htmlEscape="false" maxlength="11"
                            class="input-large required"/><font color="red">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">单位电话</td>
            <td width="20%">
                <form:input path="AAB005" htmlEscape="false" maxlength="15"
                            class="input-large required"/><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">异地安置</td>
            <td width="20%">
                <select name="ISYD" id="ISYD" title="ISYD" class="input-large required">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">有效开始日期:</td>
            <td width="20%">
                <form:input path="BKE003" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/><span id="messageAac030_3" class="help-inline"><font color="red">*</font></span>
            </td>
            <td class="tit" width="15%">有效截止日期:</td>
            <td width="20%">
                <form:input path="BKE004" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/><span id="messageAac030_3" class="help-inline"><font color="red">*</font></span>
            </td>
        </tr>
    </table>
    <div class="form-actions">
        <input id="btnSave" name="btnSave" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
    </div>
</form:form>
<div style="margin:10px;color:red;font-weight:bold;">说明：病种只能选一种，申报时间每年5月5日至5月15日，其他时间不开放。</div>
</body>
</html>
