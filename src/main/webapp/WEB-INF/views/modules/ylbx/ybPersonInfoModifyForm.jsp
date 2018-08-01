<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>人员信息修改</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#inputForm").validate({
                submitHandler: function(form){
                    form.submit();
                }
            });
        });
    </script>
    <script type="text/javascript">
        function isPostCode(value){
            var regExp = /[1-9]\d{5}(?!\d)/; ///^[1-9][0-9]{5}$/;
            if(!regExp.test(value)){
                $("#aae007").val("");
                $("#messageMsg").text("邮政编码格式不正确，请重新输入");
            }else{
                $("#messageMsg").text("");
            }
        }
        function isTelphone(value){
            var myreg = /^[0-9]{11}$/;
            var regExp = /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)/;
            if(value.length==11){
                if(!myreg.test(value)){
                    $("#aae005").val("");
                    $("#Aae005Msg").text("电话号码格式不正确，请重新输入");
                }else{
                    $("#Aae005Msg").text("");
                }
            }else{
                if(!regExp.test(value)){
                    $("#aae005").val("");
                    $("#Aae005Msg").text("电话号码格式不正确，请重新输入");
                }else{
                    $("#Aae005Msg").text("");
                }
            }
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/ylbx/ybPersonInfoModify/form"}>人员信息列表</a></li>
    <li class="active"><a>人员信息修改</a></li>
</ul><br/>
<sys:message content="${message}" type="${ctype}"/>
<form:form id="inputForm" modelAttribute="ybPerson" action="${ctx}/ylbx/ybPersonInfoModify/save" method="post" class="form-horizontal">
    <form:hidden path="AAC004"/>
    <table class="table-form">
        <tr>
            <td class="tit" width="15%">单位编号:</td>
            <td width="20%"><form:input path="AAB001" htmlEscape="false" maxlength="15" class="input-large" readonly="true"/></td>
            <td class="tit" width="15%">个人编号:</td>
            <td width="20%"><form:input path="AAC001" htmlEscape="false" maxlength="20" class="input-large" readonly="true"/></td>
            <td class="tit" width="15%">公民身份证号码:</td>
            <td width="20%"><form:input path="AAC002" htmlEscape="false" maxlength="18" class="input-large" readonly="true"/></td>
        </tr>

        <tr>
            <td class="tit" width="15%">姓名:</td>
            <td width="20%"><form:input path="AAC003" htmlEscape="false" maxlength="20" class="input-large required"/><span class="help-inline"><font color="red">*</font> </span></td>

            <td class="tit" width="15%">出生日期:</td>
            <td width="20%">
                <form:input path="AAC006" readonly="true" maxlength="10" placeholder="yyyy-MM-dd" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">民族:</td>
            <td width="20%">
                <form:select path="AAC005" class="input-large required" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAC005_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">参加工作日期:</td>
            <td width="20%">
                <form:input path="AAC007" readonly="true" maxlength="10" placeholder="yyyy-MM-dd" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">联系电话:</td>
            <td width="20%"><form:input path="AAE005" htmlEscape="false" maxlength="20" class="input-large required " onblur="isTelphone(this.value)"/><span class="help-inline" style="color:red; font-weight: bold"><font color="red">*</font><font id="Aae005Msg" color="red"  class="bold"></font> </span></td>
            <td class="tit" width="15%">文化程度:</td>
            <td width="20%">
                <form:select path="AAC011" class="input-large" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAC011_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">户口所在地:</td>
            <td width="20%"><form:input path="AAC010" htmlEscape="false" maxlength="100" class="input-large "/></td>
            <td class="tit" width="15%">户口性质:</td>
            <td width="20%">
                <form:select path="AAC009" class="input-large required" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAC009_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">行政职务:</td>
            <td width="20%">
                <form:select path="AAC020" class="input-large required" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAC020_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">人员状态:</td>
            <td width="20%">
                <form:select path="AAC008" class="input-large required" cssStyle="width:160px" >
                    <form:options items="${fns:getDictList('AAC008_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">参保人员类别:</td>
            <td width="20%">
                <form:select path="AKC021" class="input-large required" cssStyle="width:160px" >
                    <form:options items="${fns:getDictList('AKC021_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">公务员标识:</td>
            <td width="20%">
                <form:select path="BAC515" class="input-large" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('BAC515_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">医疗照顾人员标志:</td>
            <td width="20%">
                <form:select path="AKC401" class="input-large required" cssStyle="width:160px" >
                    <form:options items="${fns:getDictList('AKC401_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">个人身份:</td>
            <td width="20%">
                <form:select path="AAC012" class="input-large required" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAC012_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                非公务员参加公务员统筹:
            </td>
            <td width="20%">
                <form:select path="BKC281" class="input-large required"
                             cssStyle="width:160px">
                    <form:option value="" label="请选择" />
                    <form:options items="${fns:getDictList('BKC281_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">婚姻状况:</td>
            <td width="20%">
                <form:select path="AAC017" class="input-large required" cssStyle="width:160px" >
                    <form:options items="${fns:getDictList('AAC017_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">用工形式:</td>
            <td width="20%">
                <form:select path="AAC013" class="input-large required" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('AAC013_YB')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">邮政编码:</td>
            <td width="20%"><form:input path="AAE007" htmlEscape="false" maxlength="6" class="input-large " onblur="isPostCode(this.value)"/><span class="help-inline" style="color:red; font-weight: bold"><font id="messageMsg" color="red"  class="bold"></font> </span></td>
        </tr>
        <tr>
            <td class="tit" width="15%">地址:</td>
            <td width="20%"><form:input path="AAE006" htmlEscape="false" maxlength="100" class="input-large "/></td>
        </tr>
    </table>
    <div class="form-actions">
        <input class="btn btn-primary" type="submit" value="保 存" />&nbsp;
    </div>
</form:form>
<script src="${ctxStatic}/common/front.js" type="text/javascript"></script>
</body>
</html>