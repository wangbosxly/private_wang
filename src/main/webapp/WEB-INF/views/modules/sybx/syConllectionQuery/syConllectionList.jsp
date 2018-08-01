<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>单位缴费信息查询</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出单位缴费数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/sybx/syUnitPaymentQuery/unit/export");
						$("#searchForm").submit();
	
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			
			$("#btnSubmit").click(function(){
				
				$("#searchForm").attr("action","${ctx}/sybx/syUnitPaymentQuery/unit/list");
				$("#searchForm").submit();
	
			});

            $("#inputForm").validate({
                submitHandler: function(form){
                    loading('正在提交，请稍等...');
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


        function page(n,s){
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#inputForm").submit();
            return false;
        }
	</script>
</head>
<body>
    <ul class="nav nav-tabs">
        <li ><a href="${ctx}/sybx/syCollectionQuery/form">征集计划定制</a></li>
        <li class="active"><a href="${ctx}/sybx/syCollectionQuery/list">历史征集计划查询</a></li>
    </ul>
   <form:form id="inputForm" modelAttribute="syab88" action="${ctx}/sybx/syCollectionQuery/list" method="post" class="breadcrumb form-search">
        <ul class="ul-form">
            起始费款所属期：<form:input path="startYM" placeholder="yyyyMM" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyyMM'});"/><span class="help-inline"><font color="red">*</font> </span>
            &nbsp;&nbsp;&nbsp;截止费款所属期：<form:input path="endYM" placeholder="yyyyMM" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyyMM'});"/><span class="help-inline"><font color="red">*</font> </span>
                <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>

        </ul>
        <c:if test="${page!=null}">
            <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
            <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        </c:if>
    </form:form>
    <sys:message content="${message}"/>
        <form class="breadcrumb form-search">
        <table id="contentTable" class="table table-striped table-bordered table-condensed">
            <thead>

                <input type="hidden" name="BAA001" value="${syab88.BAA001}"/>

                <tr>
                    <th>对应费款所属期</th>
                    <th>缴费人数</th>
                    <th>单位应缴金额</th>
                    <th>个人应缴金额</th>
                    <th>应缴合计</th>
                    <th>经办人</th>
                    <th>经办时间</th>
                    <th>征集流水号</th>
                    <th>操作</th>
                </tr>
            </thead>

            <tbody>
            <c:if test="${page.list.size()>0}">
            <c:forEach items="${page.list}" var="syab88">

                <input type="hidden" name="BAA001" value="${syab88.BAA001}"/>
                <tr>
                    <td>${syab88.AAE003}</td>
                    <td>${syab88.AAB083}</td>
                    <td class="moneyNum">${syab88.BAB701}</td>
                    <td class="moneyNum">${syab88.AAB122}</td>
                    <td class="moneyNum">${syab88.BAE713}</td>
                    <td>${syab88.AAE011}</td>
                    <td>${syab88.AAE036}</td>
                    <td><a href="${ctx}/sybx/syCollectionQuery/record?aae063=${syab88.AAE063}">${syab88.AAE063}</a></td>
                    <td><a href="${ctx}/sybx/syCollectionQuery/exportPdf?aae063=${syab88.AAE063}&aae003=${syab88.AAE003}">打印明细</a></td>

                </tr>
            </c:forEach>
            </c:if>
            <c:if test="${page.list.size()==0||page.list==null}">
                <tr>
                    <td  style="color: red;font-weight: bold; text-align: center" colspan="10">无对应费款所属期内征集计划</td>
                </tr>
            </c:if>
            </tbody>
        </table>
        <div class="pagination">${page}</div>
        <div  style="color: red;font-weight: bold;">备注：</div>
        <div  style="color: red;font-weight: bold;">1.点击征集流水号查看该次历史缴费核定信息</div>
        <div  style="color: red;font-weight: bold;">2.点击打印明细打印征集合计单。</div>
        </form>
</body>
</html>