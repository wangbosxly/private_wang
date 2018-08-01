<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script type="text/javascript" src="http://hovertree.com/ziyuan/jquery/jquery-1.12.0.min.js"></script>
<meta name="decorator" content="default"/>
<html>
<head>
	<title></title>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#searchForm").validate({
				submitHandler: function(form){
					//loading('正在提交，请稍等...');
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
	<script>  
	    var i=1;  
	</script>
	<script>
        function find(a,b) {
            window.open("http://10.189.129.167:7012/interservice/attachment.do?archiveId="+a+"&userName="+b);
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/lsywsl/web_lsywsl">历史业务受理</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="sa06aView" action="${ctx}/lsywsl/web_lsywsl/query" method="post" class="breadcrumb form-search ">
		<ul class="ul-form">
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;受理单号:&nbsp;
				<form:input path="SAA036" htmlEscape="false"  class="input-medium"/>
			</</li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;功能事项:&nbsp;
		    <form:select path="SAA015" cssStyle="width:158px" >
		      <form:option value="" label="请选择"/>
		      <form:options items="${fns:getDictList('SAA015')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
		    </form:select></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			业务状态:&nbsp;
		    <form:select path="SAA043" cssStyle="width:158px" >
		      <form:option value="" label="请选择"/>
		      <form:options items="${fns:getDictList('SAA043')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
		    </form:select></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				险种:&nbsp;
				<form:select path="AAE140" cssStyle="width:158px" >
					<form:option value="" label="请选择"/>
					<form:options items="${fns:getDictList('AAE140')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select></li>
			<li class="btns">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="btnQuery" class="btn btn-primary" type="submit" value="查询"/>
			</li>			
		</ul>
	
		
	</form:form>
	<sys:message content="${message}"/>
	<table id="tablst" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr style="font-weight: bolder;border:dotted 1px;height:35px;background-color: #FFFFFF;">
			<th>序&nbsp;&nbsp;&nbsp;号</th>
			<th>受理单号</th>
			<th>功能事项</th>
			<th>险种</th>
			<th>业务状态</th>
			<th>申请时间</th>
				<th>查询资料</th>
			<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page_sa06aview.list}" var="info">
			<tr>
				<td><script>document.write(i);i++</script></td>
				<td>${info.SAA036}</td>
				<td>${fns:getDictLabel(info.SAA015, 'SAA015', '')}</td>
				<td>${fns:getDictLabel(info.AAE140, 'AAE140', '')}</td>
				<td>${fns:getDictLabel(info.SAA043, 'SAA043', '')}</td>
				<td>${info.SAA038}</td>
				<td>
					<a onclick="find(${info.PAN001},${info.BAE703})">查看档案</a>
				</td>
				<td>
				<a onclick="jump('${info.SAA036}','${info.SAA015}')">操作详情</a>
				</td>
				</tr>
		</c:forEach>
		<c:if test="${sa06aView.BUS_ID == 'noData'}">
		<tr align="center">
		<td colspan="8"><div align="center" style="color: red;font-weight: bold;">未查询到符合条件的记录.</div></td>
		</tr>
		</c:if>	
		</tbody>
	</table>
	<script type="text/javascript">
	function jump( a, b){
        location = '${ctx}/lsywsl/web_lsywsl/info?SAA036='+a+'&SAA015='+b;
	}
	</script>
</body>
</html>

