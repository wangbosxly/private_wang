<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>人员参保查询</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出人员信息数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/gsbx/gsPersonInsuredQuery/export");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			
			$("#btnSubmit").click(function(){
                loading('正在提交，请稍等...');
				$("#searchForm").attr("action","${ctx}/gsbx/gsPersonInsuredQuery/list");
				$("#searchForm").submit();
	
			});
		});
        function page(n,s){
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/gsbx/gsPersonInsuredQuery/list");
            loading('正在提交，请稍等...');
            $("#searchForm").submit();
            return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/gsbx/gsPersonInsuredQuery/form">人员参保信息列表</a></li>
	</ul>
    <sys:message content="${message}"/>
	<form:form id="searchForm" modelAttribute="person" action="${ctx}/gsbx/gsPersonInsuredQuery/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>个人编号：</label>
				<form:input path="AAC001" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>身份证号码：</label>
				<form:input path="AAC002" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
				<form:input path="AAC003" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li>
				<label>险&nbsp;&nbsp;&nbsp;种：</label>
				<form:select path="AAE140" cssStyle="width:120px;"  >
				<form:option value="" label="请选择"/>
				<form:option value="4">工伤保险</form:option>
				<form:option value="5">生育保险</form:option>
				</form:select>
			</li>
			<li><label>参保状态：</label>
				<form:select path="AAC031" class="input-large required" cssStyle="width:160px" >
						<form:option value="" label="请选择"/>
						<form:options items="${fns:getDictList('AAC031_X')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="button" value="查询"/>
                <c:if test="${pagination.list.size()>0}">
				<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
                </c:if>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
    <form class="breadcrumb form-search">
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<input type="hidden" name="BAA001" value="${person.BAA001}"/>
            <tr style="font-weight: bolder;height:35px;background-color: #FFFFFF;"><td colspan="10">单位人员参保信息查询</td></tr>
			<tr>
				<th>个人编号</th>
				<th>姓名</th>
				<th>身份证</th>
				<th>参保时间</th>
                <th>参保状态</th>
                <th>险种类型</th>
			</tr>
		</thead>
		<tbody>
        <c:choose>
        <c:when test="${pagination.list.size()>0}">
		<c:forEach items="${pagination.list}" var="syac01">
			<input type="hidden" name="BAA001" value="${syac01.BAA001}"/>
			<tr>

				<td>${syac01.AAC001}</td>
				<td>${syac01.AAC003}</td>
				<td>${syac01.AAC002}</td>
				<td>${syac01.AAC030}</td>
				<td>${fns:getDictLabel(syac01.AAC031, 'AAC031_5', '')}</td>
				<td>${fns:getDictLabel(syac01.AAE140, 'AAE140_5', '')}</td>
			</tr>
		</c:forEach>
        </c:when>
            <c:otherwise>
                <tr>
                    <td style="color: red;font-weight: bold; text-align: center" colspan="11">未查询到参保信息</td>
                </tr>
            </c:otherwise>
        </c:choose>
		</tbody>
	</table>
	<div class="pagination">${pagination}</div>
    </form>
</body>
</html>