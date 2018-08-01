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
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
	
	
	
	<script type="text/javascript">
		$(function() {
		    $("#inputForm").validate();
		});
		

		function parentChange(){
			$('#akc040').empty();

			$('#akc040').append('<option value="false" selected="selected">==请选择==</option>');

			var id = $("#bkc022").val();

			var para = {"id":id};
			$.post('${ctx}/otherplace/kc31/getCity/',para,function(data,status){
				  for(var i=0;i<data.length;i++){
				  //alert(data[i].value+":"+data[i].name)
					  var dis = '<option value="'+data[i].akc040+'">'+data[i].akc040Name+'</option>';
					  $('#akc040').append(dis);
				  }
			  }, "json");
		}
	</script>
	
	
	
	
</head>
<body>
	<ul class="nav nav-tabs">
		<!-- 
		<li><a href="${ctx}/otherplace/kc31/">异地安置备案列表</a></li>
		 -->
		<li class="active"><a href="${ctx}/otherplace/kc31/form?id=${kc31.id}">异地安置备案<shiro:hasPermission name="otherplace:kc31:edit">${not empty kc31.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="otherplace:kc31:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="kc31" action="${ctx}/otherplace/kc31/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		
		
		<table class="table-form">
				<tr>
				
				<input type="hidden" name="aac001" value="${kc31.aac001}"/>
				<input type="hidden" name="baa001" value="${kc31.baa001}"/>
				
					<td class="tit" width="15%">所在省市:</td>
					<td width="20%">
						<form:select path="bkc022" class="input-large required" cssStyle="width:160px" onchange="parentChange()">
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('BKC022')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
					<td class="tit" width="15%">所在市县:</td>
					<td width="20%">
						<form:select path="akc040" class="input-large required" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKC040')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>					
					<td class="tit" width="15%">常住外地详细地址:</td>
					<td width="20%">
						<form:input path="aae006" htmlEscape="false" maxlength="100" class="input-large required"/>
						<span class="help-inline"><font color="red">*</font> </span>
					</td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">有效开始日期:</td>
					<td width="20%">
					<form:input path="bke003" readonly="readonly" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required " onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
					<span class="help-inline"><font color="red">*</font> </span></td>
					<td class="tit" width="15%">有效截止日期:</td>
					<td width="20%">
						<form:input path="bke004" readonly="readonly" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate " onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
					</td>
					<td class="tit" width="15%">常住外地原因:</td>
					<td width="20%">
					<form:select path="bkc021" class="input-large" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('BKC021_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
					</td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">联系人:</td>
					<td width="20%"><form:input path="aae004" htmlEscape="false" maxlength="20" class="input-large " /></td>
					<td class="tit" width="15%">联系电话:</td>
					<td width="20%"><form:input path="aae005" htmlEscape="false" maxlength="20" class="input-large " /></td>
					<td class="tit" width="15%">门诊专用病历号:</td>
					<td width="20%"><form:input path="bkc020" htmlEscape="false" maxlength="18" class="input-large required"/><span class="help-inline"><font color="red">*</font> </span></td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">第一家医疗机构编号:</td>
					<td width="20%">
					<form:select path="akb020" class="input-large required" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKB020_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
					<td class="tit" width="15%">第一家医院名称:</td>
					<td width="20%"><form:input path="akb021" htmlEscape="false" maxlength="30" class="input-large required" /><span class="help-inline"><font color="red">*</font> </span></td>
					<td class="tit" width="15%">第一家医院等级:</td>
					<td width="20%">
					<form:select path="aka101" class="input-large required" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKA101_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">联系人:</td>
					<td width="20%"><form:input path="bkb011" htmlEscape="false" maxlength="20" class="input-large "/></td>
					<td class="tit" width="15%">联系电话:</td>
					<td width="20%"><form:input path="bkb003" htmlEscape="false" maxlength="20" class="input-large "/></td>
					<td class="tit" width="15%">地址:</td>
					<td width="20%"><form:input path="bkb013" htmlEscape="false" maxlength="100" class="input-large "/></td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">第二家医疗机构编号:</td>
					<td width="20%">
					<form:select path="bkb001" class="input-large" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKB020_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
					</td>
					<td class="tit" width="15%">第二家医院名称:</td>
					<td width="20%"><form:input path="bkb002" htmlEscape="false" maxlength="30" class="input-large " /></td>
					<td class="tit" width="15%">第二家医院等级:</td>
					<td width="20%">
					<form:select path="bkb005" class="input-large" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKA101_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
					</td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">联系人:</td>
					<td width="20%"><form:input path="bkb006" htmlEscape="false" maxlength="20" class="input-large " /></td>
					<td class="tit" width="15%">联系电话:</td>
					<td width="20%"><form:input path="bkb012" htmlEscape="false" maxlength="20" class="input-large " /></td>
					<td class="tit" width="15%">地址:</td>
					<td width="20%"><form:input path="bkb024" htmlEscape="false" maxlength="100" class="input-large " /></td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">第三家医疗机构编号:</td>
					<td width="20%">
					<form:select path="bkb040" class="input-large" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKB020_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
					</td>
					<td class="tit" width="15%">第三家医院名称:</td>
					<td width="20%"><form:input path="bkb041" htmlEscape="false" maxlength="30" class="input-large " /></td>
					<td class="tit" width="15%">第三家医院等级:</td>
					<td width="20%">
					<form:select path="bkb042" class="input-large" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKA101_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
					</td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">联系人:</td>
					<td width="20%"><form:input path="bkb044" htmlEscape="false" maxlength="20" class="input-large " /></td>
					<td class="tit" width="15%">联系电话:</td>
					<td width="20%"><form:input path="bkb043" htmlEscape="false" maxlength="20" class="input-large " /></td>
					<td class="tit" width="15%">地址:</td>
					<td width="20%"><form:input path="bkb045" htmlEscape="false" maxlength="100" class="input-large "/></td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">住地医保机构名称:</td>
					<td width="20%"><form:input path="bkb007" htmlEscape="false" maxlength="100" class="input-large " /></td>
					<td class="tit" width="15%">联系电话:</td>
					<td width="20%"><form:input path="bkb008" htmlEscape="false" maxlength="20" class="input-large " /></td>
					<td class="tit" width="15%">住地医保机构邮编:</td>
					<td width="20%"><form:input path="bkb010" htmlEscape="false" maxlength="6" class="input-large " /></td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">住地医保机构地址:</td>
					<td width="20%" colspan="5"><form:textarea path="bkb009" htmlEscape="false" rows="2" maxlength="100" class="input-large " cssStyle="width:660px"/></td>
				</tr>

				
		</table>

		<div class="form-actions">
			<shiro:hasPermission name="otherplace:kc31:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>

	</form:form>
</body>
</html>