<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>转诊转院备案管理</title>
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
</head>
<body>
	<ul class="nav nav-tabs">
	<!-- 
		<li><a href="${ctx}/movehospital/kc29/">转诊转院备案列表</a></li>
	 -->
		<li class="active"><a href="${ctx}/movehospital/kc29/form?id=${kc29.id}">转诊转院备案<shiro:hasPermission name="movehospital:kc29:edit">${not empty kc29.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="movehospital:kc29:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="kc29" action="${ctx}/movehospital/kc29/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		
		<table class="table-form">
				<tr>
					<td class="tit" width="15%" >个人编号:</td>
					<td width="20%"><form:input path="aac001" htmlEscape="false" maxlength="12" class="input-large " readonly="true"/></td>
					<td class="tit" width="15%">姓名:</td>
					<td width="20%"><form:input path="aac003" htmlEscape="false" maxlength="30" class="input-large " readonly="true"/></td>
					<td class="tit" width="15%">转院类型:</td>
					<td width="20%">
					<form:select path="bkc009" class="input-large required " cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('BKC009_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">转院开始日期:</td>
					<td width="20%">
					<form:input path="bkc087" readonly="readonly" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required " onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
					<span class="help-inline"><font color="red">*</font> </span>
					</td>
					<td class="tit" width="15%">病种:</td>
					<td width="20%"><form:input path="bkc018" htmlEscape="false" maxlength="30" class="input-large " /></td>
					<td class="tit" width="15%">省内省外:</td>
					<td width="20%">
					<form:select path="akc180" class="input-large" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKC180_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
					</td>
				</tr>
				
				
				<tr>
					<td class="tit" width="15%">转前医院:</td>
					<td width="20%">
					<form:select path="bkc003" class="input-large required " >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKB020_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
					<td class="tit" width="15%">转往医院:</td>
					<td width="20%">
					<form:select path="bkc006" class="input-large required " >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AKB020_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select><span class="help-inline"><font color="red">*</font> </span>
					</td>
				</tr>
				
				<tr>
					<td class="tit" width="15%">病情摘要及诊断:</td>
					<td width="20%" colspan="5"><form:textarea path="bkc001" htmlEscape="false" rows="2" maxlength="500" class="input-large " cssStyle="width:660px"/></td>
				</tr>
				
				<tr>
					<td class="tit" width="15%" >备注:</td>
					<td width="20%" colspan="5"><form:textarea path="akc174" htmlEscape="false" rows="2" maxlength="500" class="input-large " cssStyle="width:660px"/></td>
				</tr>
				
		</table>

		<div class="form-actions">
			<shiro:hasPermission name="movehospital:kc29:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>

		 
		 
		 
		 
		 
	</form:form>
</body>
</html>