<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>社保人员基本信息管理</title>
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
		<li class="active"><a href="${ctx}/nwws/personBasicInfo/">社保人员基本信息列表</a></li>
		<shiro:hasPermission name="nwws:personBasicInfo:edit"><li><a href="${ctx}/nwws/personBasicInfo/form">社保人员基本信息添加</a></li></shiro:hasPermission>
		<shiro:hasPermission name="nwws:personBasicInfo:edit"><li><a href="${ctx}/nwws/personBasicInfo/wage">社保人员缴费工资申报</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pm_ac01View" action="${ctx}/nwws/personBasicInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号码</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>联系电话</th>
				<th>更新时间</th>
				<shiro:hasPermission name="nwws:personBasicInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pm_ac01View">
			<tr>
				<td>
					${pm_ac01View.AAC003}
				</td>
				<td>
					${pm_ac01View.AAC002}
				</td>
				<td>
					${fns:getDictLabel(pm_ac01View.AAC004,'AAC004_3','无性别信息')}
				</td>
				<td>
					${pm_ac01View.AAC006}
				</td>
				<td>
					${pm_ac01View.AAE005}
				</td>
				<td>
					${pm_ac01View.BAA010}
				</td>
				<shiro:hasPermission name="nwws:personBasicInfo:edit"><td>
    				<a href="${ctx}/nwws/personBasicInfo/form?id=${pm_ac01View.AAC001}">修改</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<form:form id="inputForm" modelAttribute="pm_ac01View" action="${ctx}/nwws/personBasicInfo/list" method="post" class="form-horizontal">
	<div class="form-actions">
			<shiro:hasPermission name="nwws:personBasicInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;</shiro:hasPermission>
	</div>
	</form:form>
	<div class="pagination">${page}</div>
</body>
</html>