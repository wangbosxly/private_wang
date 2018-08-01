<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>异地安置备案管理</title>
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
		<li class="active"><a href="${ctx}/otherplace/kc31/">异地安置备案列表</a></li>
		<shiro:hasPermission name="otherplace:kc31:edit"><li><a href="${ctx}/otherplace/kc31/form">异地安置备案添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="kc31" action="${ctx}/otherplace/kc31/" method="post" class="breadcrumb form-search">
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
				<th>长住外地详细地址</th>
				<th>长住外地原因</th>
				<th>有效起始日期</th>
				<th>有效截止日期</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="otherplace:kc31:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="kc31">
			<tr>
				<td><a href="${ctx}/otherplace/kc31/form?id=${kc31.id}">
					${kc31.aac001}
				</a></td>
				<td>
					${kc31.aae006}
				</td>
				<td>
					${kc31.bkc021}
				</td>
				<td>
					${kc31.bke003}
				</td>
				<td>
					${kc31.bke004}
				</td>
				<td>
					<fmt:formatDate value="${kc31.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${kc31.remarks}
				</td>
				<shiro:hasPermission name="otherplace:kc31:edit"><td>
    				<a href="${ctx}/otherplace/kc31/form?id=${kc31.id}">修改</a>
					<a href="${ctx}/otherplace/kc31/delete?id=${kc31.id}" onclick="return confirmx('确认要删除该异地安置备案吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>