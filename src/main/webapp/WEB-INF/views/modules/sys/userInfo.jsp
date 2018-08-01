<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>个人信息</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
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
		<li class="active"><a href="${ctx}/sys/user/info">个人信息</a></li>
		<%-- <li><a href="${ctx}/sys/user/modifyPwd">修改密码</a></li> --%>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/info" method="post" class="form-horizontal"><%--
		<form:hidden path="email" htmlEscape="false" maxlength="255" class="input-xlarge"/>
		<sys:ckfinder input="email" type="files" uploadPath="/mytask" selectMultiple="false"/> --%>
		<sys:message content="${message}"/>
<%-- 		<div class="control-group">
			<label class="control-label">头像:</label>
			<div class="controls">
				<form:hidden id="nameImage" path="photo" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="nameImage" type="images" uploadPath="/photo" selectMultiple="false" maxWidth="100" maxHeight="100"/>
			</div>
		</div> --%>
		<table class="table-form" border="1"  width="100%">
<%-- 				<tr height="50">
					<td class="tit"><label class="control-label">归属机构:</label></td>
					<td><label class="lbl">${user.company.name}</label></td>
					<td class="tit"><label class="control-label">归属部门:</label></td>
					<td><label class="lbl">${user.office.name}</label></td>
				</tr>
 				<tr height="50">
					<td class="tit" ><label class="control-label">姓名:</label></td>
					<td><form:input path="name" htmlEscape="false" maxlength="50" class="required" readonly="true"/>${user.name}</td>
					<td class="tit"><label class="control-label">上次登录信息:</label></td>
					<td><label class="lbl">IP：${user.oldLoginIp} &nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/></label></td>
				</tr>
			<tr height="50">
					<td class="tit" ><label class="control-label">电话:</label></td>
					<td><form:input path="phone" htmlEscape="false" maxlength="11"/></td>
					<td class="tit"><label class="control-label">手机号码:</label></td>
					<td><form:input path="mobile" htmlEscape="false" maxlength="11"/></td>
				</tr>
				<tr height="50">
					<td class="tit"><label class="control-label">邮箱:</label></td>
					<td><form:input path="email" htmlEscape="false" maxlength="50" class="email"/></td>
					<td class="tit" ><label class="control-label">备注:</label></td>
					<td><form:input path="remarks" htmlEscape="false" maxlength="200"/></td>
				</tr> --%>
				<tr height="50">
					<td class="tit"><label class="control-label">电话号码</label></td>
					<td>${user.phone}</td>
					<td class="tit" ><label class="control-label">用户姓名</label></td>
					<td>${user.name}</td>
				</tr>
				<tr height="50">
					<td class="tit"><label class="control-label">身份证号</label></td>
					<td>${user.no}</td>
					<td class="tit" ><label class="control-label">注册时间</label></td>
					<td><fmt:formatDate value="${user.createDate}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				</tr>
				<tr height="50">
					<td class="tit"><label class="control-label">手机号码</label></td>
					<td>${user.mobile}</td>
					<td class="tit" ><label class="control-label">备注</label></td>
					<td>${user.bac501}</td>
				</tr>
		</table>		
<%-- 		<div class="control-group">
			<label class="control-label">归属机构:</label>
			<div class="controls">
				<label class="lbl">${user.company.name}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">归属部门:</label>
			<div class="controls">
				<label class="lbl">${user.office.name}</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="required" readonly="true"/>
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="50" class="phone"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机号码:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户类型:</label>
			<div class="controls">
				<label class="lbl">${fns:getDictLabel(user.userType, 'sys_user_type', '无')}</label>
			</div>
		</div> 
 		<div class="control-group">
			<label class="control-label">用户角色:</label>
			<div class="controls">
				<label class="lbl">${user.roleNames}</label>
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">上次登录信息:</label>
			<div class="controls">
				<label class="lbl">IP: ${user.oldLoginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.oldLoginDate}" type="both" dateStyle="full"/></label>
			</div>
		</div>
		
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存" title="确定保存请点击我" />
		</div>--%>
	</form:form>
</body>
</html>