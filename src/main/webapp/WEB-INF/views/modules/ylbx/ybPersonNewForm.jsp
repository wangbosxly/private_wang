<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>人员信息管理</title>
    <meta name="decorator" content="default" />
    <script type="text/javascript">
        $(document).ready(function() {
            //$("#name").focus();
            $("#inputForm").validate({
                submitHandler: function(form){
                    //loading('正在提交，请稍等...');
                    form.submit();
                },
                rules:{
                    //身份证号验证
                    AAC002:{required:true,card:true,remote:{url: "${ctx}/ylbx/ybPersonNew/exist",type: "post",dataType: "json"}}

                },
                messages:{
                    AAC002:{required:"请输入身份证号",card:"请输入正确的身份证号码",remote:"该身份证号已存在或已保存"}
                }


            });
        });
    </script>

    <script type="text/javascript">

        function checkSFZ(value,birthday,gender,saa015,saa004,szz003,sza023,sza024,saa062){
            //$("#messageAAC002").text("");
            if(value.length == 0){
                return;
            }
            //验证身份证号码
            if(!idCard(value,birthday,gender)){
                $("#AAC002").focus();
                $("#messageAAC002").text("身份证号码格式不正确，请重新输入");
            }

            //验证是否满16周岁
            var strbrithday = document.getElementById('AAC006').value;
            var age = jsGetAge(strbrithday);
            if(age<16){
                $("#AAC002").focus();
                $("#messageAAC002").text("参保人员未满16周岁！");
            } else {
                $("#messageAAC002").text("");
            }
        }


        function jsGetAge(strBirthday){
            var returnAge;
            var strBirthdayArr=strBirthday.split("-");
            var birthYear = strBirthdayArr[0];
            var birthMonth = strBirthdayArr[1];
            var birthDay = strBirthdayArr[2];
            d = new Date();
            var nowYear = d.getFullYear();
            var nowMonth = d.getMonth() + 1;
            var nowDay = d.getDate();
            if(nowYear == birthYear){
                returnAge = 0;//同年 则为0岁
            }
            else{
                var ageDiff = nowYear - birthYear ; //年之差
                if(ageDiff > 0){
                    if(nowMonth == birthMonth) {
                        var dayDiff = nowDay - birthDay;//日之差
                        if(dayDiff < 0)
                        {
                            returnAge = ageDiff - 1;
                        }
                        else
                        {
                            returnAge = ageDiff ;
                        }
                    }
                    else
                    {
                        var monthDiff = nowMonth - birthMonth;//月之差
                        if(monthDiff < 0)
                        {
                            returnAge = ageDiff - 1;
                        }
                        else
                        {
                            returnAge = ageDiff ;
                        }
                    }
                }
                else
                {
                    returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
                }
            }
            return returnAge;//返回周岁年龄
        }

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
            } else {
                $("#codeerror").text("");
            }
        }
        function isMoney(value){
            var mny =  /^\d+\.?\d*$/;
            var flog=false;
            //验证缴费工资
            if(!mny.test(value)){
                $("#AAC040").val("");
                $("#messageAAC040").text("缴费工资格式不正确，请重新输入");
            }else{
                var bab808 = document.getElementById('rmb').value;
                var bab808max = bab808*3;
                var bab808min = bab808*0.6;
                bab808min = bab808min.toFixed(2);
                if(!bab808){
                    $("#AAC040").val("");
                    $("#messageAAC040").text("缴费基数获取失败,请刷新后再试");
                }else if(parseInt(value)>parseInt(bab808max)){
                    $("#AAC040").val("");
                    $("#messageAAC040").text("缴费基数上限为"+bab808max);
                } else if (parseInt(value)<parseInt(bab808min)){
                    $("#AAC040").val("");
                    $("#messageAAC040").text("缴费基数下限为"+bab808min);
                } else{
                    $("#messageAAC040").text("");
                    flog=true;
                }
            }
            return flog;
        }

        function isPostCode(value){
            var regExp = /[1-9]\d{5}(?!\d)/; ///^[1-9][0-9]{5}$/;

            if(!regExp.test(value)){
                $("#aae007").val("");
                $("#messageAae007").text("邮政编码格式不正确，请重新输入");
            }else{
                $("#messageAae007").text("");
            }
        }

        function isTelphone(value){
            var myreg = /^[0-9]{11}$/;
            var regExp = /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)/;

            if(value.length==11){
                if(!myreg.test(value)){
                    $("#aae005").val("");
                    $("#messageAae005").text("电话号码格式不正确，请重新输入");
                }else{
                    $("#messageAae005").text("");
                }
            }else{
                if(!regExp.test(value)){
                    $("#aae005").val("");
                    $("#messageAae005").text("电话号码格式不正确，请重新输入");
                }else{
                    $("#messageAae005").text("");
                }
            }

        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active">
        <a href="${ctx}/ylbx/ybPersonNew/form?id=${ac01.aac001}">人员信息添加</a>
    </li>
</ul><br />
<sys:message content="${message}" type="${ctype}"/>
<form:form id="inputForm" modelAttribute="ybPerson"
           action="${ctx}/ylbx/ybPersonNew/save" method="post"
           class="form-horizontal">
    <input type="hidden" name="rmb" id="rmb" value="${rmb}"/>
    <table class="table-form">
        <tr>
            <td class="tit" width="15%">
                单位编号:
            </td>
            <td width="20%">
                <form:input path="AAB001" htmlEscape="false" maxlength="15"
                            class="input-large " readonly="true" />
            </td>
            <td class="tit" width="15%">
                单位名称:
            </td>
            <td width="20%">
                <form:input path="AAB004" htmlEscape="false" maxlength="50"
                            class="input-large " readonly="true" />
            </td>
            <td class="tit" width="15%">
                公民身份证号码:
            </td>
            <td width="20%">
                <form:input path="AAC002" htmlEscape="false" maxlength="18"
                            onblur="checkSFZ(this.value,'AAC006','AAC004')"
                            class="input-large required" />
                <span id="messageAAC002" style="color: red; font-weight: bold"><font
                        style="color: red;">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">
                姓名:
            </td>
            <td width="20%">
                <form:input path="AAC003" htmlEscape="false" maxlength="20"
                            class="input-large required" />
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                性别:
            </td>
            <td width="20%" id="AAC004">
                <form:radiobuttons path="AAC004" items="${fns:getDictList('AAC004_YB')}" itemLabel="label" itemValue="value" htmlEscape="false" class="input-large required"/>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                出生日期:
            </td>
            <td width="20%">
                <form:input path="AAC006" readonly="true" maxlength="10"
                            placeholder="yyyy-MM-dd" cssStyle="width:145px;"
                            cssClass="input-medium Wdate required"
                            onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">
                民族:
            </td>
            <td width="20%">
                <form:select path="AAC005" class="input-large required"
                             cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC005_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                户口性质:
            </td>
            <td width="20%">
                <form:select path="AAC009" class="input-large required"
                             cssStyle="width:160px">
                    <form:option value="" label="请选择" />
                    <form:options items="${fns:getDictList('AAC009_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                参加工作日期:
            </td>
            <td width="20%">
                <form:input path="AAC007" readonly="true" maxlength="10"
                            placeholder="yyyy-MM-dd" cssStyle="width:145px;"
                            cssClass="input-medium Wdate required"
                            onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" />
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">
                人员状态:
            </td>
            <td width="20%">
                <form:select path="AAC008" class="input-large required"
                             cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC008_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                参保人员类别:
            </td>
            <td width="20%">
                <form:select path="AKC021" class="input-large required"
                             cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AKC021_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">参保时间:</td>
            <td width="20%">
                <form:input path="BAC510" readonly="true" placeholder="yyyy-MM-dd" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%Date'});"/><span id="messageAac030_3" class="help-inline"><font color="red">*</font></span>
            </td>

        </tr>
        <tr>
            <td class="tit" width="15%">
                婚姻状况:
            </td>
            <td width="20%">
                <form:select path="AAC017" class="input-large required"
                             cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC017_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                用工形式:
            </td>
            <td width="20%">
                <form:select path="AAC013" class="input-large required"
                             cssStyle="width:160px">
                    <form:option value="" label="请选择" />
                    <form:options items="${fns:getDictList('AAC013_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                个人身份:
            </td>
            <td width="20%">
                <form:select path="AAC012" class="input-large required"
                             cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC012_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
        </tr>

        <tr>
            <td class="tit" width="15%">
                文化程度:
            </td>
            <td width="20%">
                <form:select path="AAC011" class="input-large required"
                             cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC011_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                医疗照顾人员标志:
            </td>
            <td width="20%">
                <form:select path="AKC401" class="input-large required"
                             cssStyle="width:160px">
                    <form:option value="" label="请选择" />
                    <form:options items="${fns:getDictList('AKC401_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>
            <td class="tit" width="15%">
                公务员标识:
            </td>
            <td width="20%">
                <form:select path="BAC515" class="input-large required"
                             cssStyle="width:160px">
                    <form:option value="" label="请选择" />
                    <form:options items="${fns:getDictList('BAC515_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
            </td>

        </tr>
        <tr>
            <td class="tit" width="15%">
                行政职务:
            </td>
            <td width="20%">
                <form:select path="AAC020" class="input-large required"
                             cssStyle="width:160px">
                    <form:options items="${fns:getDictList('AAC020_YB')}"
                                  itemLabel="label" itemValue="value" htmlEscape="false" />
                </form:select>
                <span class="help-inline"><font color="red">*</font> </span>
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
            <td class="tit" width="15%">
                缴费工资:
            </td>
            <td width="20%"><form:input id="AAC040" path="AAC040" htmlEscape="false" maxlength="10" onblur="isMoney(this.value)" class="input-large required"/><span class="help-inline" style="color:red; font-weight: bold"><font id="messageAAC040" color="red"></font>*</span></td>

        </tr>
        <tr>
            <td class="tit" width="15%">
                联系电话:
            </td>
            <td width="20%">
                <form:input path="AAE005" htmlEscape="false" maxlength="20"
                            class="input-large " onblur="isTelphone(this.value)" />
                <span class="help-inline" style="color: red; font-weight: bold"><font
                        id="messageAae005" color="red" class="bold"></font> </span>
            </td>
            <td class="tit" width="15%">
                邮政编码:
            </td>
            <td width="20%">
                <form:input path="AAE007" htmlEscape="false" maxlength="6"
                            class="input-large " onblur="isPostCode(this.value)" />
                <span class="help-inline" style="color: red; font-weight: bold"><font
                        id="messageAae007" color="red" class="bold"></font> </span>
            </td>
            <td class="tit" width="15%">
                地址:
            </td>
            <td width="20%">
                <form:input path="AAE006" htmlEscape="false" maxlength="100"
                            class="input-large " />
            </td>
        </tr>
        <tr>
            <td class="tit" width="15%">
                户口所在地:
            </td>
            <td width="20%">
                <form:input path="AAC010" htmlEscape="false" maxlength="100"
                            class="input-large " />
            </td>
        </tr>
    </table>
    <div class="form-actions">
        <input id="btnSave" name="btnSave" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
    </div>
</form:form>
<script src="${ctxStatic}/common/front.js" type="text/javascript"></script>
</body>
</html>