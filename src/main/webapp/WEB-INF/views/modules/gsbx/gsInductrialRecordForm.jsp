<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <title>人员工伤信息备案</title>

    <script type="text/javascript">

        function checkValue() {
            var aac001_str = document.getElementById("AAC001").value;
            var aac002_str = document.getElementById("AAC002").value;
            var aac003_str = document.getElementById("AAC003").value;
            if (aac003_str !== "" || aac003_str !== undefined) {
                if ("" === aac001_str && "" === aac002_str) {
                    top.$.jBox.tip("个人编号和身份证不可同时为空!");
                    return false;
                }
            }
            if ("" !== aac001_str && undefined !==aac001_str ) {
                return true
            }
            if ("" !== aac002_str && undefined !==aac001_str) {
                return true
            }
            top.$.jBox.tip("查询条件不可同时为空!");
            return false;
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
            $("#submitForm").validate({
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
    <li class="active"><a href="${ctx}/gsbx/gsInductrialRecord/form">人员工伤备案</a></li>
</ul>

<form:form id="inputForm" modelAttribute="gsInductrialRecord" action="${ctx}/gsbx/gsInductrialRecord/info"
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
<c:if test="${InfoJson != null}">
<form:form id="submitForm" modelAttribute="gsInductrialRecord" action="${ctx}/gsbx/gsInductrialRecord/submit"
           method="post" class="form-horizontal">
    <table class="table-form">
        <tr>
            <td class="tit" width="15%">姓名:</td>
            <td width="20%"><input name="AAC003" value="${InfoJson.AAC003}" style="width:145px;padding: 4px 6px;border-radius: 4px;" maxlength="50" class="input-large "
                                   readonly="true"/></td>
            <td class="tit" width="15%">个人编号:</td>
            <td width="20%"><input name="AAC001" value="${InfoJson.AAC001}" style="width:145px;padding: 4px 6px;border-radius: 4px;" maxlength="50" class="input-large "
                                   readonly="true"/></td>
            <td class="tit" width="15%">单位编号:</td>
            <td width="20%"><input name="AAB001" value="${InfoJson.AAB001}" style="width:145px;padding: 4px 6px;border-radius: 4px;" maxlength="50" class="input-large "
                                        readonly="true"/></td>
        </tr>
        <tr>
            <td class="tit" width="15%">身份证号:</td>
            <td width="20%"><input name="AAC002" value="${InfoJson.AAC002}" style="width:145px;padding: 4px 6px;border-radius: 4px;" maxlength="50" class="input-large "
                                   readonly="true"/></td>
            <td class="tit" width="15%">工伤发生日期</td>
            <td width="20%"><form:input path="ALC020" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /><span class="help-inline"><font color="red">*</font> </span></td>
            <td class="tit" width="15%">工伤报告日期</td>
            <td width="20%"><form:input path="ALC203" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /><span class="help-inline"><font color="red">*</font> </span></td>
        </tr>
        <tr>
            <td class="tit" width="15%">报告人姓名</td>
            <td width="20%"><form:input path="ALC024" htmlEscape="false" maxlength="50" cssStyle="width:145px;" cssClass="input-large required"/></td>
            <td class="tit" width="15%">报告人联系电话</td>
            <td width="20%"><form:input path="ALC605" htmlEscape="false" maxlength="11" cssStyle="width:145px;" class="input-large required"/><span class="help-inline"><font color="red">*</font> </span></td>
            <td class="tit" width="15%">报告方式</td>
            <td width="20%">
                <form:select path="ALC025" class="input-large" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('ALC025_GS')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
                    <span class="help-inline"><font color="red">*</font> </span>
        </tr>
        <tr>
            <td class="tit" width="15%">伤害程度</td>
            <td width="20%">
                <form:select path="ALC021" class="input-large" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('ALC021_GS')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
                    <span class="help-inline"><font color="red">*</font> </span>
            <td class="tit" width="15%">伤害部位</td>
            <td width="20%">
                <form:select path="ALC022" class="input-large" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('ALC022_GS')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
                    <span class="help-inline"><font color="red">*</font> </span>
            <td class="tit" width="15%">事故类别</td>
            <td width="20%">
                <form:select path="ALC207" class="input-large" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('ALC207_GS')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
                    <span class="help-inline"><font color="red">*</font> </span>
          </tr>
        <tr>
            <td class="tit" width="15%">工伤类别</td>
            <td width="20%">
                <form:select path="ALC027" class="input-large" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('ALC027_GS')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
                    <span class="help-inline"><font color="red">*</font> </span>
            <td class="tit" width="15%">是否定点医疗机构</td>
            <td width="20%">
                <form:select path="ALC626" class="input-large" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('ALC626_GS')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
                    <span class="help-inline"><font color="red">*</font> </span>
            <td class="tit" width="15%">医疗机构名称</td>
            <td width="20%"><form:input path="AKB021"  htmlEscape="false" maxlength="50" cssStyle="width:145px;"  cssClass="input-large required" /><span class="help-inline"><font color="red">*</font> </span></td>
        </tr>
        <tr>
            <td class="tit" width="15%">事故地点</td>
            <td width="50%" colspan="5"><form:input path="ALC023"  maxlength="100" cssStyle="width:970px;" cssClass="input-medium required" /><span class="help-inline"><font color="red">*</font> </span></td>
        </tr>
        <tr>
            <td class="tit" width="15%">事故摘要</td>
            <td width="75%" colspan="5"><form:input path="ALC800"  maxlength="200" cssStyle="width:970px;" cssClass="input-medium required"/><span class="help-inline"><font color="red">*</font> </span></td>
        </tr>
    </table>
    <div class="form-actions">
        <input id="btnSave" name="btnSave" class="btn btn-primary" type="submit"  value="确认备案"/>&nbsp;
    </div>
</form:form>
</c:if>
</body>
</html>
