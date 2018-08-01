<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>单位信息修改</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
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
                    AAC002:{required:true,card:true,remote:{url: "${ctx}/gsbx/gsPersonNew/exist",type: "post",dataType: "json"}}
                },
                messages:{
                    AAC002:{required:"请输入身份证号",card:"请输入正确的身份证号码",remote:"该身份证号已存在或已保存"}
                }
			});
		});
	</script>
	
	<script type="text/javascript">
	
		function checkSFZ(value,birthday,gender,tBirthday){
			if(value.length == 0){
				return;
			}
			//验证身份证号码
			if(!idCard(value,birthday,gender,tBirthday)){
				$("#AAC002").val("");
				$("#AAC002").focus();
				$("#messageAAC002").text("");
			}else {
                $("#messageAAC002").text("");
            }
			//验证是否满16周岁
			var strbrithday = document.getElementById('AAC006').value;
			var age = jsGetAge(strbrithday);
			if(age<16){
				$("#AAC002").focus();
				$("#messageAAC002").text("参保人员未满16周岁！");
				$("#AAC002").val("");
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
			}
		}

		function isPostCode(value){
			var regExp = /[1-9]\d{5}(?!\d)/; ///^[1-9][0-9]{5}$/;
			
			if(!regExp.test(value)){
				$("#AAE007").val("");
				$("#messageAAE007").text("邮政编码格式不正确，请重新输入");
			}else{
				$("#messageAAE007").text("");
			}
		}
		
		function isTelphone(value){
			var myreg = /^[0-9]{11}$/;
			var regExp = /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)/;
			
			if(value.length==11){
				if(!myreg.test(value)){
					$("#AAE005").val("");
					$("#messageAAE005").text("电话号码格式不正确，请重新输入");
				}else{
					$("#messageAAE005").text("");
				}
			}else{
				if(!regExp.test(value)){
					$("#AAE005").val("");
					$("#messageAAE005").text("电话号码格式不正确，请重新输入");
				}else{
					$("#messageAAE005").text("");
				}
			}
			
		}

	</script>
	
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/gsbx/gsUnitModify/form">单位基本信息修改</a></li>
	</ul><br/>
    <sys:message content="${message}" type="${ctype}"/>
	<form:form id="inputForm" modelAttribute="gsUnitModify" action="${ctx}/gsbx/gsUnitModify/save" method="post" class="form-horizontal">
		<table class="table-form">
				<input type="hidden" name="rmb" id="rmb" value="${rmb}"/>
            <tr>
                <td class="tit" width="15%">单位编号:</td>
                <td width="20%"><form:input path="AAB001" htmlEscape="false" maxlength="15" class="input-large " disabled="true" /></td>
                <td class="tit" width="15%">单位名称:</td>
                <td width="20%"><form:input path="AAB004" htmlEscape="false" maxlength="50" class="input-large " disabled="true"  /></td>
                <td class="tit" width="15%">单位电话:</td>
                <td width="20%"><form:input path="AAB005"  maxlength="18" Style="width:200px"  class="input-large "/></td>
            </tr>
            <tr>
                <td class="tit" width="15%">缴费专管员姓名:</td>
                <td width="20%"><form:input path="AAB016"  maxlength="18" Style="width:200px"  class="input-large "/></td>
                <td class="tit" width="15%">缴费单位专管员所在部门:</td>
                <td width="20%"><form:input path="AAB017"  maxlength="18" Style="width:200px"  class="input-large "/></td>
                <td class="tit" width="15%">缴费单位专管员电话:</td>
                <td width="20%"><form:input path="AAB018"  maxlength="18" Style="width:200px"  class="input-large "/></td>
            </tr>
            <tr>
                <td class="tit" width="15%">单位内码:</td>
                <td width="20%">
                    <form:input path="BAB801" class="input-large required"/>
                </td>
                <td class="tit" width="15%">社会保险登记证编码:</td>
                <td width="20%">
                    <form:input path="AAB002" htmlEscape="false" maxlength="50" class="input-large " disabled="true"  />
                </td>
                <td class="tit" width="15%">工商登记执照种类:</td>
                <td width="20%">
                    <form:input path="AAB006" class="input-large required" Style="width:185px" value='${fns:getDictLabel(gsUnitModify.AAB006, "AAB006_5","" )}' disabled="true"  />
                        <span class="help-inline"></span>
                </td>
            </tr>
            <tr>
                <td class="tit" width="15%">法定代表人姓名:</td>
                <td width="20%"><form:input path="AAB013" htmlEscape="false" maxlength="15" class="input-large " disabled="true" /></td>
                <td class="tit" width="15%">法定代表人身份号:</td>
                <td width="20%"><form:input path="AAB014" htmlEscape="false" maxlength="50" class="input-large " disabled="true" /></td>
                <td class="tit" width="15%">单位类型:</td>
                <td width="20%">
                    <form:input path="AAB019" class="input-large required" Style="width:210px" value='${fns:getDictLabel(gsUnitModify.AAB019, "AAB019_5","" )}' disabled="true"  />
                       <span class="help-inline"> </span>
                </td>
            </tr>
            <tr>
                <td class="tit" width="15%">单位地址:</td>
                <td width="20%"><form:input path="AAE006" htmlEscape="false"  class="input-large " /></td>
                <td class="tit" width="15%">单位状态:</td>
                <td width="20%">
                    <form:input path="AAE119" class="input-large required" Style="width:185px" value='${fns:getDictLabel(gsUnitModify.AAE119, "AAE119_5","" )}' disabled="true"  />
                    <span class="help-inline"><font color="red">*</font> </span>
                </td>
                <td class="tit" width="15%">缴费方式:</td>
                <td width="20%">
                    <form:input path="AAB033" class="input-large required" cssStyle="width:185px" disabled="true"   value='${fns:getDictLabel(gsUnitModify.AAB033, "AAB033_5","" )}'/>
                    <span class="help-inline"> </span>
                </td>
            <tr>
                <td class="tit" width="15%">传真:</td>
                <td width="20%">
                    <form:input path="BAB512" htmlEscape="false" maxlength="50" class="input-large " />
                </td>
                <td class="tit" width="15%">单位网址:</td>
                <td width="20%">
                    <form:input path="BAB513" class="input-large" Style="width:185px" />
                    <span class="help-inline"></span>
                </td>
            </tr>
            </tr>
	</table>
		<div class="form-actions">
			<input id="btnSave" name="btnSave" class="btn btn-primary" type="button" onclick="doSubmit()" value="保 存"/>&nbsp;
		</div>
	</form:form>
	<script type="text/javascript">

		function doSubmit(){
          //  if(isMoney()){ 缴费工资验证
                $("#btnSave").submit();
            //}
		}
	</script>
	<script src="${ctxStatic}/common/front.js" type="text/javascript"></script>
</body>
</html>