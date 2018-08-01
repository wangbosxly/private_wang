<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>异地安置备案管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {
            //$("#name").focus();
            $("#inputForm").validate({
                submitHandler: function(form){
                    loading('正在提交，请稍等...');
                    form.submit();
                }
            });
        });
        function findtemplate(v) {
            $.ajax({
                type : "post",
                async : false,
                url : "${ctx}/ylbx/ybRelocatedRecord/getPostTemplateJson",
                data : {
                    'value' : v
                },
                dataType : "json",
                success : function(msg) {
                    $("#template").empty();
                    //$("#template").select2();
                    if (msg.length > 0) {
                        for (var i = 0; i < msg.length; i++) {
                            var partId = msg[i].value;
                            var partName = msg[i].label;
                            var $option = $("<option>").attr({
                                "value" : partId
                            }).text(partName);
                            $("#template").append($option);
                        }
                        //$("#template option:first").prop("selected", 'selected');
                        $("#template").change();
                    } else {
                        var partId = '';
                        var partName = '请选择';
                        var $option = $("<option>").attr({
                            "value" : partId
                        }).text(partName);
                        $("#template").append($option);
                    }
                },
                error : function(json) {
                    $.jBox.alert("网络异常！");
                }
            });
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/ylbx/ybRelocatedRecord/list">异地安置备案</a></li>
</ul><br/>
<sys:message content="${message}" type="${ctype}"/>
<form:form id="inputForm" modelAttribute="specialBusiness" action="${ctx}/ylbx/ybRelocatedRecord/save" method="post" class="form-horizontal">
    <form:hidden path="BAA001" />
    <table class="table-form">
        <tr>
            <td class="tit" width>姓名</td>
            <td width="20%"><form:input path="AAC003" readonly="true" htmlEscape="false" maxlength="20" class="input-large " /></td>
            <td class="tit" width>身份证</td>
            <td width="20%"><form:input path="AAC002" readonly="true" htmlEscape="false" maxlength="20" class="input-large " /></td>
            <td class="tit" width>个人编号</td>
            <td width="20%"><form:input path="AAC001" readonly="true" htmlEscape="false" maxlength="20" class="input-large " /></td>
        </tr>
        <tr>
            <td class="tit" width="15%">所在省市:</td>
            <td width="20%">
                <form:select path="BKC022" class="input-large required" cssStyle="width:160px" onchange="findtemplate(this.options[this.options.selectedIndex].value);">
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AA26_10')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">所在市县:</td>
            <td width="20%">
                <form:select id="template" path="AKC040" class="input-large required" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AA26_10_482')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">常住外地详细地址:</td>
            <td width="20%">
                <form:input path="AAE006" htmlEscape="false" maxlength="100" class="input-large required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>

        <tr>
            <td class="tit" width="15%">有效开始日期:</td>
            <td width="20%">
                <form:input path="BKE003" readonly="readonly" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required " onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                <span class="help-inline"><font color="red">*</font> </span></td>
            <td class="tit" width="15%">有效截止日期:</td>
            <td width="20%">
                <form:input path="BKE004" readonly="readonly" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate " onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
            </td>
            <td class="tit" width="15%">常住外地原因:</td>
            <td width="20%">
                <form:input path="BKC021" htmlEscape="false" maxlength="100" class="input-large"/>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">联系人:</td>
            <td width="20%"><form:input path="AAE004" htmlEscape="false" maxlength="20" class="input-large " /></td>
            <td class="tit" width="15%">联系电话:</td>
            <td width="20%"><form:input path="AAE005" htmlEscape="false" maxlength="20" class="input-large " /></td>
            <td class="tit" width="15%">门诊专用病历号:</td>
            <td width="20%"><form:input path="BKC020" htmlEscape="false" maxlength="18" class="input-large "/></td>
        </tr>
        <tr>
            <td class="tit" width="15%">三级医院名称:</td>
            <td width="20%"><form:input path="AKB021" htmlEscape="false" maxlength="30" class="input-large required" /><span class="help-inline"><font color="red">*</font> </span></td>
            <td class="tit" width="15%">联系电话:</td>
            <td width="20%"><form:input path="BKB003" htmlEscape="false" maxlength="20" class="input-large "/></td>
            <td class="tit" width="15%">邮编:</td>
            <td width="20%"><form:input path="BKB011" htmlEscape="false" maxlength="20" class="input-large "/></td>
        </tr>
        <tr>
            <td class="tit" width="15%">地址:</td>
            <td width="20%" colspan="5"><form:textarea path="BKB013" htmlEscape="false" maxlength="100" class="input-large " cssStyle="width:770px"/></td>
        </tr>
        <tr>
            <td class="tit" width="15%">二级医院名称:</td>
            <td width="20%"><form:input path="BKB002" htmlEscape="false" maxlength="30" class="input-large " /></td>
            <td class="tit" width="15%">联系电话:</td>
            <td width="20%"><form:input path="BKB006" htmlEscape="false" maxlength="20" class="input-large " /></td>
            <td class="tit" width="15%">邮编:</td>
            <td width="20%"><form:input path="BKB012" htmlEscape="false" maxlength="20" class="input-large "/></td>
        </tr>
        <tr>
            <td class="tit" width="15%">地址:</td>
            <td width="20%" colspan="5"><form:textarea path="BKB024" htmlEscape="false" maxlength="100" class="input-large " cssStyle="width:770px"/></td>
        </tr>
        <tr>
            <td class="tit" width="15%">一级医院名称:</td>
            <td width="20%"><form:input path="BKB041" htmlEscape="false" maxlength="30" class="input-large " /></td>
            <td class="tit" width="15%">联系电话:</td>
            <td width="20%"><form:input path="BKB043" htmlEscape="false" maxlength="20" class="input-large " /></td>
            <td class="tit" width="15%">邮编:</td>
            <td width="20%"><form:input path="BKB044" htmlEscape="false" maxlength="20" class="input-large " /></td>

        </tr>
        <tr>
            <td class="tit" width="15%">地址:</td>
            <td width="20%" colspan="5"><form:textarea path="BKB045" htmlEscape="false" maxlength="100" class="input-large " cssStyle="width:770px"/></td>
        </tr>
        <tr>
            <td class="tit" width="15%">住地医保机构名称:</td>
            <td width="20%"><form:input path="BKB007" htmlEscape="false" maxlength="100" class="input-large " /></td>
            <td class="tit" width="15%">联系电话:</td>
            <td width="20%"><form:input path="BKB008" htmlEscape="false" maxlength="20" class="input-large " /></td>
            <td class="tit" width="15%">住地医保机构邮编:</td>
            <td width="20%"><form:input path="BKB010" htmlEscape="false" maxlength="6" class="input-large " /></td>
        </tr>
        <tr>
            <td class="tit" width="15%">住地医保机构地址:</td>
            <td width="20%" colspan="5"><form:textarea path="BKB009" htmlEscape="false" maxlength="100" class="input-large " cssStyle="width:770px"/></td>
        </tr>
    </table>
    <div class="form-actions">
        <input id="btnSave" name="btnSave" class="btn btn-primary" type="submit" value="保 存"/>
    </div>

</form:form>
<div style="margin:10px;color:red;font-weight:bold;">说明：申报时间12月1日至12月31日，其他时间不开放</div>
</body>
</html>