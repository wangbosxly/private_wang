<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>失业金申领</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
	<script type="text/javascript">
	 //页面加载完光标自动定位在AAC003
	 window.onload = function() {
	   var oInput = document.getElementById("AAC003");
	   oInput.focus(); 
	}
    function print(type){
     	var aac002=$("#AAC002").val();
     	var aac003=$("#AAC003").val();
     	var ajc050=$("#AJC050").val();
     	var ajc090=$("#AJC090").val(); 	
     	//alert("身份证号："+aac002+"姓名："+aac003+"本次失业日期:"+ajc050+"本次参加工作日期:"+ajc090+"类型："+type);
     	var url = "${ctx}/sysyjsl/web_sysyjsl/printWord/?AAC002="+aac002+"&AAC003="+aac003+"&AJC050="+ajc050+"&AJC090="+ajc090+"&TYPE="+type;
     	var urlone = encodeURI(url);    
     	window.open(encodeURI(urlone));
     }    
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sybx/sysyjsl/web_sysyjsl">失业金申领</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="pm_jc02view" action="${ctx}/sybx/sysyjsl/web_sysyjsl/search" method="post" class="breadcrumb form-search ">
	<ul class="ul-form">
		<li><label>姓&nbsp;&nbsp;&nbsp;名：</label><form:input path="AAC003" readonly="true" htmlEscape="false" maxlength="50" class="input-medium"/></li>
		<li><label>身份证号：</label><form:input path="AAC002" title="身份证号作为查询条件时，其中字母自动默认为大写后进行匹配查询" htmlEscape="false" readonly="true" maxlength="18" class="input-medium"/></li>
		<li class="btns">
			<input id="btnSearch" class="btn btn-primary" type="submit" value="查询" title="身份证号作为查询条件时，其中字母自动默认为大写后进行匹配查询"/><font color="red">提示：点击【查询】按钮后方可办理失业金申领业务.</font>
		</li>			
	</ul>
	</form:form>
	<c:if test="${pm_jc02view.AAE011 != 'noDisplayDetailInfo'}">
	<form:form id="searchForm" modelAttribute="pm_jc02view" action="${ctx}/sybx/sysyjsl/web_sysyjsl/submit" method="post" class="breadcrumb form-search ">
		<table class="table-form" border="1"  width="100%">
				<tr align="center" height="40">
					<td class="tit">个人编号:</td>
					<td><form:input path="AAC001" htmlEscape="false" maxlength="50" class="input-large" readonly="true"/>
					</td>
					<td class="tit">姓&nbsp;&nbsp;&nbsp;名:</td>
					<td><form:input path="AAC003" htmlEscape="false" maxlength="50" class="input-large" readonly="true"/></td>
					<td class="tit" >身份证号:</td>
					<td><form:input path="AAC002" htmlEscape="false" maxlength="18" class="input-large" readonly="true"/></td>
				</tr>
				<tr align="center" height="40">
					<td class="tit">单位编号:</td>
					<td><form:input path="AAB001" htmlEscape="false" maxlength="15" class="input-large" readonly="true"/></td>
					<td class="tit">单位名称:</td>
					<td><form:input path="BAZ001" htmlEscape="false" maxlength="50" class="input-large" readonly="true"/></td>
					<td class="tit" >农民工标志:</td>
					<td><form:input path="AJA004" htmlEscape="false" maxlength="18" class="input-large" readonly="true"/></td>
				</tr>
				<tr align="center" height="40">
					<td class="tit">本次参加工作日期:</td>
					<td><form:input path="AJC050" htmlEscape="false" maxlength="15" class="input-large" readonly="true"/></td>
					<td class="tit">本次失业日期:</td>
					<td><form:input path="AJC090" htmlEscape="false" maxlength="50" class="input-large" readonly="true"/></td>
					<td class="tit" >失业登记日期:</td>
					<td><form:input path="AJC094" htmlEscape="false" maxlength="18" class="input-large" readonly="true"/></td>
				</tr>
				<tr align="center" height="40">
					<td class="tit">参保日期:</td>
					<td><form:input path="AJC310" htmlEscape="false" maxlength="15" class="input-large" readonly="true"/></td>
					<td class="tit">工资发放至月:</td>
					<td><form:input path="AJC091" htmlEscape="false" placeholder="yyyyMM" maxlength="6" class="input-large"/></td>
					<td class="tit" >待遇申领日期:</td>
					<td><form:input path="AJC095" htmlEscape="false" maxlength="18" class="input-large" readonly="true"/></td>
				</tr>
				<tr align="center" height="40">
					<td class="tit">应享受月数:</td>
					<td><form:input path="AJC097" htmlEscape="false" maxlength="15" class="input-large" readonly="true"/></td>
					<td class="tit">累计缴费月数:</td>
					<td><form:input path="AJC054" htmlEscape="false" maxlength="50" class="input-large" readonly="true"/></td>
					<td class="tit" >视同缴费月数:</td>
					<td><form:input path="AJC001" htmlEscape="false" maxlength="18" class="input-large" readonly="true"/></td>
				</tr>
				<tr align="center" height="40">
					<td class="tit">月失业金标准:</td>
					<td><form:input path="AJC096" htmlEscape="false" maxlength="15" class="input-large" readonly="true"/></td>
					<td class="tit">原从事职业(工种):</td>
					<td><form:input path="ACA111" htmlEscape="false" maxlength="50" class="input-large"/></td>
					<td class="tit" >失业原因:</td>
					<td><form:input path="AJC093" htmlEscape="false" maxlength="18" class="input-large" readonly="true"/></td>
				</tr>
				<tr align="center" height="40">
					<td class="tit">个人特长:</td>
					<td><form:input path="BJC100" htmlEscape="false" maxlength="15" class="input-large"/></td>
					<td class="tit">培训意向:</td>
					<td><form:input path="BJC101" htmlEscape="false" maxlength="50" class="input-large"/></td>
					<td class="tit" >求职意向:</td>
					<td><form:input path="BJC102" htmlEscape="false" maxlength="18" class="input-large"/></td>
				</tr>
				<tr align="center" height="40">
					<td class="tit">银行账号:</td>
					<td><form:input path="AAE010" htmlEscape="false" size="25" maxlength="40" class="input-large"/></td>
					<td class="tit">备注:</td>
					<td align="left" colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;
					<form:input path="AAE013" htmlEscape="false" size="100" maxlength="100" class="input-large"/></td>
				</tr>
		</table>
		<c:if test="${pm_jc02view.AKB020 == 'displayButton'}">
			<table class="table-form" border="0"  width="100%">
				<tr align="center" height="49">
					<td class="tit" colspan="6">
					<input id="btnSubmit" class="btn btn-primary" type="submit" value="登记确认" title="登记确认请点击此按钮"/>
 					<input id="btnPrintWord" class="btn btn-primary" type="button" value="下载模板"onclick="print(0)" title="下载word格式数据请点击此按钮"/>
 					<!-- <input id="btnPrintPdf" class="btn btn-primary" type="button" value="下载pdf" onclick="print(1)" title="下载pdf格式数据请点击此按钮"/>	 -->				
					</td>
				</tr>
			</table>
		</c:if>							
	</form:form>
	</c:if>
	<c:if test="${pm_jc02view.AAE018 == 'displayInfo'}">
		<table class="table-form" width="100%" style="background-color: #F5F5F5;border: 0;width: 100%;">
			<tr align="center" height="49">
				<td class="tit" colspan="6">
				<font style="color: red;font-weight: bold;">提示：此人尚未参加失业保险.</font>
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>
