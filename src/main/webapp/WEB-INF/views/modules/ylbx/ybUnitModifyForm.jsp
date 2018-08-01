<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>单位信息修改</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#inputForm").validate({
                submitHandler: function(form){
                    form.submit();
                }
            });
        });
        function checkidCard(value){
            $("#codeerror").text("");
            if(value.length == 0){
                return;
            }
            //验证身份证号码
            if(!check_idCard(value)){
                $("#docno").val("");
                $("#docno").focus();
                $("#codeerror").text("身份证号码不正确，请重新输入");
            }
        }
        function isPostCode(value){
            var regExp = /[1-9]\d{5}(?!\d)/; ///^[1-9][0-9]{5}$/;
            if(!regExp.test(value)){
                $("#AAE007").val("");
                $("#messageAae007").text("邮政编码格式不正确，请重新输入");
            }else{
                $("#messageAae007").text("");
            }
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/ylbx/ybUnitModify/form">单位基本信息修改</a></li>
</ul><br/>
<sys:message content="${message}" type="${ctype}"/>
<form:form id="inputForm" modelAttribute="ybUnit" action="${ctx}/ylbx/ybUnitModify/save" method="post" class="form-horizontal">
    <form:hidden path="AAB001"/>
    <form:hidden path="BAA001"/>
    <form:hidden path="AAB003"/>
    <form:hidden path="AAB020"/>
    <form:hidden path="AAE119"/>
    <form:hidden path="BAA008"/>
    <form:hidden path="BAB811"/>
    <table class="table-form">
        <tr>
            <td class="tit" width="15%">单位编号:</td>
            <td width="20%"><form:input path="AAB001" htmlEscape="false" maxlength="15" class="input-large " disabled="true" /></td>
            <td class="tit" width="15%">单位状态:</td>
            <td width="20%">
                <form:select path="AAE119" class="input-large" disabled="true">
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAE119_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
            <td class="tit" width="15%">单位电话:</td>
            <td width="20%"><form:input path="AAB005" htmlEscape="false" maxlength="20" class="input-large"/></td>
        </tr>
        <tr>
            <td class="tit" width="15%">组织机构代码:</td>
            <td width="20%"><form:input path="AAB003" htmlEscape="false" maxlength="18" class="input-large" disabled="true" /></td>
            <td class="tit" width="15%">单位名称:</td>
            <td width="20%"><form:input path="AAB004" htmlEscape="false" maxlength="100" class="input-large required "/><span class="help-inline"><font color="red">*</font> </span></td>
            <td class="tit" width="15%">单位地址:</td>
            <td width="20%"><form:textarea path="AAE006" htmlEscape="false" rows="2" maxlength="100" class="input-large required " /><span class="help-inline"><font color="red">*</font> </span></td>
        </tr>
        <tr>
            <td class="tit" width="15%">单位类型:</td>
            <td width="20%">
                <form:select path="AAB019" class="input-large required " >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAB019_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">邮政编码:</td>
            <td width="20%"><form:input path="AAE007" htmlEscape="false" maxlength="6" class="input-large " onblur="isPostCode(this.value)"/><span class="help-inline" style="color:red; font-weight: bold"><font id="messageAae007" color="red"  class="bold"></font> </span></td>
            <td class="tit" width="15%">隶属关系:</td>
            <td width="20%">
                <form:select path="AAB021" class="input-large required " >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAB021_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>

        <tr>
            <td class="tit" width="15%">主管部门或总机构:</td>
            <td width="20%"><form:input path="AAB023" htmlEscape="false" maxlength="20" class="input-large"/></td>
            <td class="tit" width="15%">单位传真:</td>
            <td width="20%"><form:input path="BAB512" htmlEscape="false" maxlength="20" class="input-large "/></td>
            <td class="tit" width="15%">行业代码:</td>
            <td width="20%">
                <form:select path="AAB022" class="input-large required " >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAB022_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>

        <tr>
            <td class="tit" width="15%">法定代表人身份证号码:</td>
            <td width="20%"><form:input path="AAB014" htmlEscape="false" maxlength="18" onblur="checkidCard(this.value)" class="input-large required"/><span id="codeerror" style="color:red; font-weight: bold"><font style="color: red;">*</font></span></td>
            <td class="tit" width="15%">法定代表人姓名:</td>
            <td width="20%"><form:input path="AAB013" htmlEscape="false" maxlength="20" class="input-large required"/><span class="help-inline"><font color="red">*</font> </span></td>
            <td class="tit" width="15%">法定代表人电话:</td>
            <td width="20%"><form:input path="AAB015" htmlEscape="false" maxlength="20" class="input-large "/></td>
        </tr>

        <tr>
            <td class="tit" width="15%">缴费单位专管员姓名:</td>
            <td width="20%"><form:input path="AAB016" htmlEscape="false" maxlength="20" class="input-large required"/><span class="help-inline"><font color="red">*</font> </span></td>
            <td class="tit" width="15%">缴费单位专管员电话:</td>
            <td width="20%"><form:input path="AAB018" htmlEscape="false" maxlength="20" class="input-large "/></td>
            <td class="tit" width="15%">缴费单位专管员所在部门:</td>
            <td width="20%"><form:input path="AAB017" htmlEscape="false" maxlength="100" class="input-large "/></td>
        </tr>



        <tr>
            <td class="tit" width="15%">执照（证）种类:</td>
            <td width="20%">
                <form:select path="AAB006" class="input-large" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAB006_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
            </td>
            <td class="tit" width="15%">批准成立单位:</td>
            <td width="20%"><form:input path="AAB010" htmlEscape="false" maxlength="100" class="input-large "/></td>
            <td class="tit" width="15%">批准日期:</td>
            <td width="20%">
                <input id="ab01.AAB011"  name="AAB011"  type="text" readonly="readonly" maxlength="10" class="input-medium Wdate" style="width:145px;"
                       value="${ab01.AAB011}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
            </td>
        </tr>

        <tr>
            <td class="tit" width="15%">执照（证）有效期限:</td>
            <td width="20%"><form:input path="AAB009" htmlEscape="false" maxlength="3" class="input-large "/></td>
            <td class="tit" width="15%">执照（证）号码:</td>
            <td width="20%"><form:input path="AAB007" htmlEscape="false" maxlength="20" class="input-large "/></td>
            <td class="tit" width="15%">发照（证）日期:</td>
            <td width="20%">
                <input id="ab01.AAB008"  name="AAB008"  type="text" readonly="readonly" maxlength="10" class="input-medium Wdate" style="width:145px;"
                       value="${ab01.AAB008}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">缴费方式:</td>
            <td width="20%">
                <form:select path="AAB033" class="input-large required " >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAB033_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">备注:</td>
            <td width="20%"><form:textarea path="AAE013" htmlEscape="false" rows="2" maxlength="100" class="inpulargerge " /></td>
        </tr>

        <tr>
            <td class="tit" width="15%">缴费银行类别:</td>
            <td width="20%">
                <form:select path="BAB502" class="input-large required " >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('BAB502_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">缴费开户银行行号:</td>
            <td width="20%"><form:input path="AAB024" htmlEscape="false" maxlength="100" class="input-large "/></td>
        </tr>

        <tr>
            <td class="tit" width="15%">缴费银行户名:</td>
            <td width="20%"><form:input path="AAB025" htmlEscape="false" maxlength="100" class="input-large "/></td>
            <td class="tit" width="15%">缴费银行账号:</td>
            <td width="20%"><form:input path="AAB026" htmlEscape="false" maxlength="40" class="input-large "/></td>

        </tr>

        <tr>
            <td class="tit" width="15%">支付银行类别:</td>
            <td width="20%">
                <form:select path="BAB503" class="input-large required " >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('BAB502_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">支付开户银行行号:</td>
            <td width="20%"><form:input path="AAB027" htmlEscape="false" maxlength="100" class="input-large "/></td>
        </tr>

        <tr>
            <td class="tit" width="15%">支付银行户名:</td>
            <td width="20%"><form:input path="AAB028" htmlEscape="false" maxlength="100" class="input-large "/></td>
            <td class="tit" width="15%">支付银行账号:</td>
            <td width="20%"><form:input path="AAB029" htmlEscape="false" maxlength="40" class="input-large "/></td>
        </tr>
    </table>
    <div class="form-actions">
        <input id="btnSave" name="btnSave" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
    </div>
</form:form>
<script src="${ctxStatic}/common/front.js" type="text/javascript"></script>
</body>
</html>