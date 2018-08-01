<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员信息修改</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            //$("#name").focus();
            $("#inputForm").validate({
                submitHandler: function (form) {
                    //loading('正在提交，请稍等...');
                    $("#AAC012").attr("disabled",false);
                    $("#AAA040").attr("disabled",false);
                    $("#AAC008").attr("disabled",false);
                    $("#AAC058").attr("disabled",false);
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
    </script>

    <script type="text/javascript">

        function isPostCode(value) {
            var regExp = /[1-9]\d{5}(?!\d)/; ///^[1-9][0-9]{5}$/;

            if (!regExp.test(value)) {
                $("#aae007").val("");
                $("#messageAae007").text("邮政编码格式不正确，请重新输入");
            } else {
                $("#messageAae007").text("");
            }
        }

        function isTelphone(value) {
            var myreg = /^[0-9]{11}$/;
            var regExp = /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)/;

            if (value.length == 11) {
                if (!myreg.test(value)) {
                    $("#aae005").val("");
                    $("#messageAae005").text("电话号码格式不正确，请重新输入");
                } else {
                    $("#messageAae005").text("");
                }
            } else {
                if (!regExp.test(value)) {
                    $("#aae005").val("");
                    $("#messageAae005").text("电话号码格式不正确，请重新输入");
                } else {
                    $("#messageAae005").text("");
                }
            }

        }

    </script>

</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/gsbx/GsPersonInfoModify/form">人员信息列表</a></li>
    <li class="active"><a href="${ctx}/sybx/syPersonUpdate/syac01/update?id=${syac01.AAC001}">人员信息修改</a></li>
</ul>
<sys:message content="${message}" type="${ctype}"/>
<br/>
<form:form id="inputForm" modelAttribute="gsPersonInfoModify" action="${ctx}/gsbx/GsPersonInfoModify/save" method="post"
           class="form-horizontal">
    <table class="table-form">
        <tr>
            <td class="tit" width="15%">单位编号:</td>
            <td width="20%"><form:input path="AAB001" htmlEscape="false" maxlength="15" class="input-large "
                                        disabled = "true"/></td>
            <td class="tit" width="15%">公民身份证号码:</td>
            <td width="20%"><form:input path="AAC002" htmlEscape="false" maxlength="18" disabled = "true"
                                        class="input-large"/></td>
            <td class="tit" width="15%">证件类型:</td>
            <td width="20%">
                <form:select path="AAC058" class="input-large required" cssStyle="width:160px" disabled="true">
                    <form:options items="${fns:getDictList('AAC058_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">个人编号:</td>
            <td width="20%"><form:input path="AAC001" htmlEscape="false" maxlength="50" class="input-large "
                                        readonly = "true"/></td>
            <td class="tit" width="15%">档案出生日期:</td>
            <td width="20%"><form:input path="BIC701" disabled = "true" maxlength="10" cssStyle="width:145px;"
                                        cssClass="input-medium Wdate required"
                                        onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/><span class="help-inline"><font
                    color="red">*</font> </span></td>
            <td class="tit" width="15%">出生日期:</td>
            <td width="20%"><form:input path="AAC006" htmlEscape="false" maxlength="50" class="input-large "
                                        disabled = "true"/></td>
        </tr>
        <tr>
            <td class="tit" width="15%">姓名:</td>
            <td width="20%"><form:input path="AAC003" htmlEscape="false" maxlength="20"
                                        class="input-large required" disabled = "true" /><span class="help-inline"></span></td>
            <td class="tit" width="15%">性别:</td>
            <td width="20%">
                <form:radiobuttons path="AAC004" items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value"
                                   htmlEscape="false" class="input-large required" disabled = "true"/><span class="help-inline"><font
                    color="red">*</font> </span>
            </td>
            <%--<td class="tit" width="15%">户口所在地:</td>
            <td width="20%"><form:input path="AAC010" htmlEscape="false" maxlength="20" class="input-large "/><span
                    class="help-inline"></span></td>--%>

        </tr>
        <tr>
            <td class="tit" width="15%">民族:</td>
            <td width="20%">
                <form:select path="AAC005" class="input-large required" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC005_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">户口性质:</td>
            <td width="20%">
                <form:select path="AAC009" class="input-large required" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC009_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">用工形式:</td>
            <td width="20%">
                <input  type ="text" name="AAC013" class="input-large required" style="width:160px" value="${fns:getDictLabels(gsPersonInfoModify.AAC013,'AAC013_5','')}"  disabled = "true" />
                <span class="help-inline"></span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">个人身份:</td>
            <td width="20%">
                <form:select id="AAC012" path="AAC012" class="input-large required" disabled="true" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC012_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
           <%-- <td class="tit" width="15%">人员状态:</td>
            <td width="20%">
                <form:select id="AAC008" path="AAC008" class="input-large required" cssStyle="width:160px" disabled="true">
                    <form:options items="${fns:getDictList('AAC008_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select>
            </td>--%>
            <td class="tit" width="15%">婚姻状况:</td>
            <td width="20%">
                <form:select path="AAC017" class="input-large required" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC017_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">行政职务:</td>
            <td width="20%">
                <form:select path="AAC020" class="input-large required" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC020_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">工人技术等级:</td>
            <td width="20%">
                <form:select path="AAC015" class="input-large required" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC015_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">是否特殊工种:</td>
            <td width="20%">
                <form:select path="AAC019" class="input-large required" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC019_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">专业技术职务:</td>
            <td width="20%">
                <form:select path="AAC014" class="input-large required" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC014_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>

            <td class="tit" width="15%">高级技术职务类型:</td>
            <td width="20%">
                <form:select path="BAC521" class="input-large required" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('BAC521_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <%--<td class="tit" width="15%">缴费比例类别:</td>
            <td width="20%">
                <form:select id="AAA040" path="AAA040" class="input-large required" disabled="true" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAA040_X')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>--%>
        </tr>
        <tr>
           <%-- <td class="tit" width="15%">联系电话:</td>
            <td width="20%"><form:input path="AAE005" htmlEscape="false" maxlength="20" class="input-large "
                                        onblur="isTelphone(this.value)"/><span class="help-inline"
                                                                               style="color:red; font-weight: bold"><font
                    id="messageAae005" color="red" class="bold"></font> </span></td>--%>
            <%--<td class="tit" width="15%">邮政编码:</td>
            <td width="20%"><form:input path="AAE007" htmlEscape="false" maxlength="6" class="input-large "
                                        onblur="isPostCode(this.value)"/><span class="help-inline"
                                                                               style="color:red; font-weight: bold"><font
                    id="messageAae007" color="red" class="bold"></font> </span></td>--%>
            <%--<td class="tit" width="15%">邮件地址:</td>
            <td width="20%"><form:input path="BAC501" htmlEscape="false" maxlength="6" class="input-large "
                                        onblur="isPostCode(this.value)"/><span class="help-inline"
                                                                               style="color:red; font-weight: bold"><font
                     color="red" class="bold"></font> </span></td>--%>
        </tr>
        <tr>
            <td class="tit" width="15%">文化程度:</td>
            <td width="20%">
                <form:select path="AAC011" class="input-large required" cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC011_5')}" itemLabel="label" itemValue="value"
                                  htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <%--<td class="tit" width="15%">地址:</td>
            <td width="20%"><form:input path="AAE006" htmlEscape="false" maxlength="100" class="input-large "/></td>--%>

            <td class="tit" width="15%">参加工作日期:</td>
            <td ><form:input path="AAC007" htmlEscape="false" class="input-large Wdate " cssStyle="width:145px"
                                        onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" readonly="ture"/></td>
        </tr>
       <%-- <tr>
            <td class="tit" width="15%">备注:</td>
            <td width="20%" colspan="5"><form:input path="AAE013" htmlEscape="false" maxlength="100"
                                                    class="input-large " cssStyle="width:999px"/></td>
        </tr>--%>

    </table>
    <%--<div style="margin:10px;font-size:15px;color:red;font-weight:bold;">备注：此功能分为两个步骤完成，1.修改待修改人员信息。2.提交审核。提交审核按钮必须在本次所有待修改人员信息全部修改完成后再点击。</div>--%>
    <div class="form-actions">
        <input id="btnSave" name="btnSave" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
            <%--<input id="btnSubmit" name="btnSubmit" class="btn btn-primary" type="button" onclick="doSubmit()" value="提交审核"/>--%>
    </div>
</form:form>
<script type="text/javascript">

    function doSubmit() {

        //$("#inputForm").attr("action","${ctx}/sybx/syPersonUpdate/syac01/submit");
        //$("#inputForm").submit();

        //var f = document.getElementById('inputForm');
        //f.action="${ctx}/sybx/syPersonUpdate/syac01/submit";
        //f.submit();

        window.location.href = "${ctx}/sybx/syPersonUpdate/syac01/submit"
    }
</script>
<script src="${ctxStatic}/common/front.js" type="text/javascript"></script>
</body>
</html>