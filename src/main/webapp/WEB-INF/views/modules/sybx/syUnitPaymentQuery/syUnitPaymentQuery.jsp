<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>单位缴费信息查询</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
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
		<li class="active"><a href="${ctx}/sybx/syUnitPaymentQuery/unit/">单位缴费信息列表</a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="syab88" action="${ctx}/sybx/syUnitPaymentQuery/unit/list" method="post" class="breadcrumb form-search">
		<ul class="ul-form">		
			<li>起始费款所属期：<form:input path="startYM" placeholder="yyyyMMdd" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyyMMdd'});"/><span class="help-inline"><font color="red">*</font> </span></li>
			<li>&nbsp;&nbsp;&nbsp;截止费款所属期：<form:input path="endYM" placeholder="yyyyMMdd" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyyMMdd'});"/><span class="help-inline"><font color="red">*</font> </span></li>
			<li>&nbsp;&nbsp;&nbsp;缴费标志：<form:select path="BAE707" class="input-large" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AAE114_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</form:select></li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

</body>
</html>