<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>失业待遇查询</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出失业待遇数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/sybx/syTreatmentQuery/person/export");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			
			$("#btnSubmit").click(function(){
				
				$("#searchForm").attr("action","${ctx}/syUnitPaymentQuery/unit/list");
				$("#searchForm").submit();
	
			});
		});
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
		<li class="active"><a href="${ctx}/sybx/syTreatmentQuery/person/">失业待遇查询列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="syjc02" action="${ctx}/sybx/syTreatmentQuery/person/" method="post" class="breadcrumb form-search">
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
				<input id="btnSubmit" class="btn btn-primary" type="button" value="查询"/>
				<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			
			<input type="hidden" name="BAA001" value="${syjc02.BAA001}"/>
			
			<tr>
				<th>姓名</th>
				<th>身份证</th>
				<th>应享受月数</th>
				<th>剩余享受月数</th>
				<th>失业金标准</th>
				<th>发放状态</th>

			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="syjc02">
		
			<input type="hidden" name="BAA001" value="${syjc02.BAA001}"/>
			<tr>
				<td>${syjc02.AAC003}</td>
				<td>${syjc02.AAC002}</td>
				<td>${syjc02.AJC097}</td>
				<td>${syjc02.AJC099}</td>
				<td>${syjc02.AJC096}</td>
				<td>${fns:getDictLabel(syjc02.AAE116, 'AAE116_2', '')}</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>