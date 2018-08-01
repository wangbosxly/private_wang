<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>缴费记录查询</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
	<script type="text/javascript">
	 //页面加载完光标自动定位在AAC003
		 window.onload = function() {
	    var oInput = document.getElementById("AAC002");
	    oInput.focus(); 
	}
	 
	$(document).ready(function() {
		$("#searchForm").validate({
		submitHandler: function(form){
				loading('正在查询，请稍等...');
				form.submit();
		}
		});
	});	
	
	//序列使用
	var i=1; 		 
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sybx/syjfjlcx/web_syjfjlcx">缴费记录查询</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="pm_ac01view" action="${ctx}/sybx/syjfjlcx/web_syjfjlcx/searchInfo" method="post" class="breadcrumb form-search ">
	<ul class="ul-form">
		<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		姓&nbsp;&nbsp;&nbsp;名：<form:input id="AAC003" path="AAC003" readonly="true" htmlEscape="false" maxlength="20" class="input-medium"/></li>
		<li>&nbsp;&nbsp;&nbsp;
		身份证号：<form:input id="AAC002" path="AAC002" htmlEscape="false" readonly="true" maxlength="18" class="input-medium required"/><font color="red">*</font></li>
		<li class="btns">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" title="身份证号作为查询条件时，其中字母自动默认为大写后进行匹配查询"/>
		</li>
	</ul>
	</form:form>			
	<sys:message content="${message}"/>
	<form:form id="searchForm" modelAttribute="pm_ac01view" action="${ctx}/sybx/syjfjlcx/web_syjfjlcx/exportExcel" method="post" class="breadcrumb form-search ">
  	<input id="AAC003" name="AAC003" type="hidden" value="${pm_ac01view.AAC003}"/>
  	<input id="AAC002" name="AAC002" type="hidden" value="${pm_ac01view.AAC002}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
	    <thead>
	      <tr style="text-align:center;"><th colspan="10">缴费记录信息列表</th></tr>
	      <tr>
	      <th>序&nbsp;&nbsp;&nbsp;号</th>
	      <th>姓&nbsp;&nbsp;&nbsp;名</th>
	      <th>身份证号</th>
	      <th>缴费类型</th>
	      <th>费款所属期</th>
	      <th>个人缴费基数总额</th>
	      <th>个人缴费金额</th>
	      <th>单位应缴金额</th>
	      <th>缴费合计</th>
	      <th>缴费标志</th>
	      </tr>
	    </thead>
		<tbody>
	    <c:forEach items="${pagination_jfjlcx.list}" var="Info">
	      <tr>
	      	<td><script>document.write(i);i++</script></td>
	        <td>${Info.AAC003}</td>
	        <td>${Info.AAC002}</td>
	        <td>${fns:getDictLabel(Info.AAE143, 'AAE143', '')}</td>
	        <td>${Info.AAE002}</td>
	        <td class="moneyNum">${Info.BAC504}</td>
	        <td class="moneyNum">${Info.AAC123}</td>
	        <td class="moneyNum">${Info.AAC127}</td>
	        <td class="moneyNum">${Info.BAC504_1}</td>
	        <td>${fns:getDictLabel(Info.AAE114, 'AAE114', '')}</td>
	      </tr>
	    </c:forEach>
	    <c:if test="${pm_ac01view.AAE011 == 'firstDisplayInfo'}">
	      <tr align="center">
			<td colspan="10"><div align="center" style="color: red;font-weight: bold;">暂无数据，请输入查询条件后点击【查询】按钮.</div></td>
	      </tr>
	    </c:if>
	    <c:if test="${pm_ac01view.AAC058 != 'noQuery'}">
	      <tr align="center">
			<td colspan="10"><div align="center" style="color: red;font-weight: bold;">未查询到符合条件的记录，请确认您输入的查询条件.</div></td>
	      </tr>
	    </c:if>	    
		</tbody>
	</table>
	<div class="pagination">${pm_ac01view_Info}</div>
	<c:if test="${pm_ac01view.BAC801 != 'noDisplayButton'}">
		<div align="center">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="确认导出"  title="确认导出人员缴费信息请点击此按钮"/>
			<!-- <input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/> -->
		</div>
	</c:if>
	</form:form>
</body>
</html>
