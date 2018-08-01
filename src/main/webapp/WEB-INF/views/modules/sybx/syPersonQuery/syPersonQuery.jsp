<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>人员信息查询</title>
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
			$("#searchForm").attr("action","${ctx}/sybx/syPersonQuery/syac01/list");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
	
</head>
<body>
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sybx/syPersonQuery/syac01/">人员信息查询</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="syac01" action="${ctx}/sybx/syPersonQuery/syac01/list" method="post" class="breadcrumb form-search">
		<ul class="ul-form">
		
			<li><label>姓名：</label>
				<form:input path="AAC003" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>身份证号码：</label>
				<form:input path="AAC002" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>个人编号：</label>
				<form:input path="AAC001" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>参保状态：</label>
				<form:select path="AAC031" class="input-large" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AAC031')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>

</body>
</html>