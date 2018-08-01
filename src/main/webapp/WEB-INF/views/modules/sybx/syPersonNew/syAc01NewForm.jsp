<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>人员新参保</title>
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
                    AAC002:{required:true,card:true,remote:{url: "${ctx}/sybx/syPersonNew/syac01/exist",type: "post",dataType: "json"}}
                },
                messages:{
                    AAC002:{required:"请输入身份证号",card:"请输入正确的身份证号码",remote:"该身份证号已存在或已保存"}
                }
			});
		});

		function isFarmer(){
            var farmer = $("#farmer");
            var farmer1 = $("#farmer1");
            var value = $("#AAC012").val();
            var value1 = $("#AAA040").val();
            var falg = true;
            if(value==="2"&&value1!=="2"){
                    farmer.html("农民身份只适用于农民合同制工人缴费");
                    farmer.addClass("error");
                    falg = false;
            }else if(value1==="2"&&value!=="2"){
                farmer1.html("农民合同制工人缴费只适用于农民身份");
                farmer1.addClass("error");
                falg = false;
            }else{
                farmer1.html("<font color=\"red\">&nbsp;*</font>");
                farmer1.removeClass("error");
                farmer.html("<font color=\"red\">&nbsp;*</font>");
                farmer.removeClass("error");
            }
            return falg;
        }
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

		function isMoney(){
			var mny =  /^\d+\.?\d*$/;
			var flog=false;
			var value = $("#AAC040").val();
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
		<li class="active"><a href="${ctx}/sybx/syPersonNew/syac01/form?id=${syac01.AAC001}">人员信息添加</a></li>
	</ul><br/>
    <sys:message content="${content}" type="${ctype}"/>
	<form:form id="inputForm" modelAttribute="syac01" action="${ctx}/sybx/syPersonNew/syac01/save" method="post" class="form-horizontal">
		<table class="table-form">
		
				<input type="hidden" name="BAA001" value="${syac01.BAA001}"/>
				<input type="hidden" name="rmb" id="rmb" value="${rmb}"/>
            <tr>
					<td class="tit" width="15%">单位编号:</td>
					<td width="20%"><form:input path="AAB001" htmlEscape="false" maxlength="15" class="input-large " readonly="true"/></td>
					<td class="tit" width="15%">单位名称:</td>
					<td width="20%"><form:input path="AAB004" htmlEscape="false" maxlength="50" class="input-large " readonly="true"/></td>
					<td class="tit" width="15%">公民身份证号码:</td>
					<td width="20%"><form:input path="AAC002" htmlEscape="false" maxlength="18" onblur="checkSFZ(this.value,'AAC006','AAC004','BIC701')" class="input-large required"/><span id="messageAAC002" style="color:red; font-weight: bold"><font style="color: red;">*</font></span></td>
				</tr>


				<tr>
					<td class="tit" width="15%">姓名:</td>
					<td width="20%"><form:input path="AAC003" htmlEscape="false" maxlength="20" class="input-large required"/><span class="help-inline"><font color="red">*</font> </span></td>
					<td class="tit" width="15%">档案出生日期:</td>
					<td width="20%"><form:input path="BIC701" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /><span class="help-inline"><font color="red">*</font> </span></td>
					<td class="tit" width="15%">出生日期:</td>
					<td width="20%"><form:input path="AAC006" readonly="true"  maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" /><span class="help-inline"><font color="red">*</font> </span></td>
				</tr>

				<tr>
					<td class="tit" width="15%">性别:</td>
					<td width="20%" id="AAC004">
					<input type="radio" name="AAC004" value="true" disabled="true" checked>男
					<input type="radio" name="AAC004" value="false" disabled="true">女
					<span class="help-inline"><font color="red">*</font> </span>
					</td>
				
					<td class="tit" width="15%">民族:</td>
					<td width="20%">
						<form:select path="AAC005" class="input-large required" cssStyle="width:160px" >
						<form:options items="${fns:getDictList('AAC005_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
                        <span class="help-inline"><font color="red">*</font> </span>
					</td>
					
					<td class="tit" width="15%">参加工作日期:</td>
					<td width="20%">
					<form:input path="AAC007" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
					<span class="help-inline"><font color="red">*</font> </span>
					</td>
				</tr>

				<tr>
					<td class="tit" width="15%">户口性质:</td>
                    <td width="20%">
                        <form:select path="AAC009" class="input-large required" cssStyle="width:160px" >
                            <form:options items="${fns:getDictList('AAC009_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select><span class="help-inline"><font color="red">*</font> </span>
                    </td>
				
					<td class="tit" width="15%">是否特殊工种:</td>
					<td width="20%">
						<form:select path="AAC019" class="input-large required" cssStyle="width:160px" >
						<form:options items="${fns:getDictList('AAC019_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
					
					<td class="tit" width="15%">行政职务:</td>
					<td width="20%">
						<form:select path="AAC020" class="input-large required" cssStyle="width:160px" >
						<form:options items="${fns:getDictList('AAC020_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">工人技术等级:</td>
					<td width="20%">
						<form:select path="AAC015" class="input-large required" cssStyle="width:160px" >
						<form:options items="${fns:getDictList('AAC015_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
					
					<td class="tit" width="15%">专业技术职务:</td>
					<td width="20%">
						<form:select path="AAC014" class="input-large required" cssStyle="width:160px" >
						<form:options items="${fns:getDictList('AAC014_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
				
					<td class="tit" width="15%">高级技术职务类型:</td>
					<td width="20%">
						<form:select path="BAC521" class="input-large required" cssStyle="width:160px" >
						<form:options items="${fns:getDictList('BAC521_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
				</tr>

				<tr>
					<td class="tit" width="15%">婚姻状况:</td>
					<td width="20%">
					<form:select path="AAC017" class="input-large required" cssStyle="width:160px" >
						<form:options items="${fns:getDictList('AAC017_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
					
					<td class="tit" width="15%">用工形式:</td>
					<td width="20%">
						<form:select path="AAC013" class="input-large required" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AAC013_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
					
					<td class="tit" width="15%">个人身份:</td>
					<td width="20%">
						<form:select path="AAC012" class="input-large required" cssStyle="width:160px" onchange="isFarmer()" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AAC012_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select><span for="AAC012" style="color:red; font-weight: bold" ><font color="red" id="farmer">&nbsp;*</font></span>
					</td>
					
				</tr>

				<tr>
					<td class="tit" width="15%">文化程度:</td>
					<td width="20%">
					<form:select path="AAC011" class="input-large" cssStyle="width:160px" >
						<form:options items="${fns:getDictList('AAC011_5')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
					</td>
					<td class="tit" width="15%">联系电话:</td>
					<td width="20%"><form:input path="AAE005" htmlEscape="false" maxlength="20" class="input-large " onblur="isTelphone(this.value)"/><span class="help-inline" style="color:red; font-weight: bold"><font id="messageAAE005" color="red"  class="bold"></font> </span></td>
					<td class="tit" width="15%">邮政编码:</td>
					<td width="20%"><form:input path="AAE007" htmlEscape="false" maxlength="6" class="input-large " onblur="isPostCode(this.value)"/><span class="help-inline" style="color:red; font-weight: bold"><font id="messageAAE007" color="red"  class="bold"></font> </span></td>

				</tr>

				<tr>
					<td class="tit" width="15%">缴费工资:</td>
					<td width="20%"><form:input id="AAC040" path="AAC040" htmlEscape="false" maxlength="10" onblur="isMoney(this.value)" class="input-large"/><span class="help-inline" style="color:red; font-weight: bold"><font id="messageAAC040" color="red"></font>*</span></td>
					<td class="tit" width="15%">户口所在地:</td>
					<td width="20%"><form:input path="AAC010" htmlEscape="false" maxlength="100" class="input-large "/></td>
					<td class="tit" width="15%">邮件地址:</td>
					<td width="20%"><form:input path="BAC501" htmlEscape="false" maxlength="20" class="input-large " onblur="isPostCode(this.value)"/><span class="help-inline" style="color:red; font-weight: bold"><font id="messageAae007" color="red"  class="bold"></font> </span></td>

				</tr>

				<tr>
					<td class="tit" width="15%">参保时间:</td>
					<td width="20%">
					<form:input path="AAC030" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%Date',minDate:'%y-{%M-3}-%d'});"/><span id="messageAac030_3" class="help-inline"><font color="red">*</font></span>
					</td>

					<td class="tit" width="15%">缴费比例类别:</td>
					<td width="20%">
						<form:select path="AAA040" class="input-large required" cssStyle="width:180px" onchange="isFarmer()">
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AAA040_X')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
						<span for="AAA040" style="color:red; font-weight: bold" ><font color="red" id="farmer1">&nbsp;*</font> </span>
					</td>
				</tr>

				<tr>
					<td class="tit" width="15%">地址:</td>
					<td width="20%" colspan="5"><form:input path="AAE006" htmlEscape="false" maxlength="100" class="input-large " cssStyle="width:999px"/></td>
				</tr>

				<tr>
					<td class="tit" width="15%" >备注:</td>
					<td width="20%" colspan="5"><form:input path="AAE013" htmlEscape="false" maxlength="100" class="input-large " cssStyle="width:999px"/></td>
				</tr>

	</table>
		<div class="form-actions">
			<input id="btnSave" name="btnSave" class="btn btn-primary" type="button" onclick="doSubmit()" value="保 存"/>&nbsp;
		</div>
	</form:form>
	<script type="text/javascript">

		function doSubmit(){
            if(isMoney()&&isFarmer()){
                $("#btnSave").submit();
            }
		}
	</script>
	<script src="${ctxStatic}/common/front.js" type="text/javascript"></script>
</body>
</html>