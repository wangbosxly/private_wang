<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
  <title>人员缴费查询</title>
  <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
  <script type="text/javascript">
   //页面加载完光标自动定位在AAC003
 	$(document).ready(function() {
		$("#searchForm").validate({
		submitHandler: function(form){
				loading('正在查询，请稍等...');
				form.submit();
		}
		});
        $("#btnSubmit").click(function(){
            top.$.jBox.confirm("确认要导出人员缴费数据吗？","系统提示",function(v,h,f){
                if(v=="ok"){
                    $("#searchForm1").submit();

                }
            },{buttonsFocus:1});
            top.$('.jbox-body .jbox-icon').css('top','55px');
        });
	});
        function page(n,s){
           if(n) $("#pageNo").val(n);
           if(s) $("#pageSize").val(s);
           $("#searchForm").submit();
           return false;
        }
  </script>
</head>
<body>
  <ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/syryjfcx/web_syryjfcx">人员缴费查询</a></li>
  </ul>
  <form:form id="searchForm" modelAttribute="pm_ac88view" action="${ctx}/sybx/syUnitPaymentCheck/personList" method="post" type="hidden">
      <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
      <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
      <form:input path="AAE003" type="hidden" />
      <form:input path="AAE002" type="hidden" />
      <input name="AAE143" value="${pm_ac88view.AAE143}" TYPE="hidden"/>
  </form:form>
  <sys:message content="${message}"/>
  <c:if test="${page!=null}">
  <form:form id="searchForm1"  action="${ctx}/sybx/syryjfcx/web_syryjfcx/export" method="post" class="breadcrumb form-search ">
      <input name="AAE002" value = "${pm_ac88view.AAE002}" TYPE="hidden"/>
      <input name="AAE003" value="${pm_ac88view.AAE003}" TYPE="hidden"/>
      <input name="AAE143" value="${pm_ac88view.AAE143}" TYPE="hidden"/>
  <table id="contentTable" class="table table-striped table-bordered table-condensed">
      <thead>
      <tr style="font-weight: bolder;height:35px;background-color: #FFFFFF;"><td colspan="10">人员缴费信息列表</td></tr>
      <tr>
	     <th>姓&nbsp;&nbsp;&nbsp;名</th>
	     <th>个人编号</th>
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
    <c:if test="${page.list.size()>0}">
      <c:forEach items="${page.list}" var="Info">
        <tr style="border:solid #000000 1px;height: 16px;height:24px;">
          <td>${Info.AAC003}</td>
          <td>${Info.AAC001}</td>
          <td>${Info.AAC002}</td>
          <td>${fns:getDictLabel(Info.AAE143, 'AAE143_5', '')}</td>
          <td>${Info.AAE002}</td>
          <td class="moneyNum">${Info.BAC504}</td>
          <td class="moneyNum">${Info.AAC123}</td>
          <td class="moneyNum">${Info.AAC127}</td>
          <td class="moneyNum">${Info.BAC504_1}</td>
          <td>${fns:getDictLabel(Info.AAE114, 'AAE114_5', '')}</td>
        </tr>
      </c:forEach>
    </c:if>
    <c:if test="${page.list.size()==0}">
      <tr align="center">
        <td colspan="11"><div align="center" style="color: red;font-weight: bold;">未查询到符合条件的记录，请确认您输入的查询条件.</div></td>
      </tr>
    </c:if>
    </tbody>
  </table>
  <div class="pagination">${page}</div>
  <c:if test="${page.list.size()>0}">
	  <div align="center">
	    <input id="btnSubmit" class="btn btn-primary" type="button" value="导 出"  title="确认导出人员缴费信息请点击此按钮"/>
	    <input id="btnCancel" class="btn btn-primary" type="button" value="返 回" onclick="history.go(-1)"/>
	  </div>
  </c:if>
  </form:form>
  </c:if>
</body>
</html>