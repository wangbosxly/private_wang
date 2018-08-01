<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>转诊转院备案管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/movehospital/kc29/">转诊转院备案列表</a></li>
		<shiro:hasPermission name="movehospital:kc29:edit"><li><a href="${ctx}/movehospital/kc29/form">转诊转院备案添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="kc29" action="${ctx}/movehospital/kc29/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>个人编号</th>
				<th>住院号</th>
				<th>转院类型</th>
				<th>转院原因</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="movehospital:kc29:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="kc29">
			<tr>
				<td><a href="${ctx}/movehospital/kc29/form?id=${kc29.id}">
					${kc29.aac001}
				</a></td>
				<td>
					${kc29.akc190}
				</td>
				<td>
					${kc29.bkc009}
				</td>
				<td>
					${kc29.bkc047}
				</td>
				<td>
					<fmt:formatDate value="${kc29.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${kc29.remarks}
				</td>
				<shiro:hasPermission name="movehospital:kc29:edit"><td>
    				<a href="${ctx}/movehospital/kc29/form?id=${kc29.id}">修改</a>
					<a href="${ctx}/movehospital/kc29/delete?id=${kc29.id}" onclick="return confirmx('确认要删除该转诊转院备案吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>