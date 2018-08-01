<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>失业待遇查询</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
	<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
	
	<script type="text/javascript">
	
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/sybx/syTreatmentQuery/person/list");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
	
</head>
<body>
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sybx/syTreatmentQuery/person/form">失业待遇查询</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="syjc02" action="${ctx}/sybx/syTreatmentQuery/person/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		
			<li><label>身份证：</label>
				<form:input path="AAC002" htmlEscape="false" readonly="true" maxlength="18" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
				<form:input path="AAC003" htmlEscape="false" readonly="true" maxlength="20" class="input-medium"/>
			</li>			

			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

</body>
</html>