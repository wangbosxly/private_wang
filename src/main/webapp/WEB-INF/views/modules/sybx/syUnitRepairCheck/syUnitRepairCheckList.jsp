<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>单位补基数核定</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出单位缴费数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#inputForm").attr("action","${ctx}/sybx/syUnitPaymentQuery/unit/export");
						$("#inputForm").submit();
	
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			
			$("#btnSubmit").click(function(){
				
				$("#inputForm").attr("action","${ctx}/sybx/syUnitRepairCheck/list");
				$("#inputForm").submit();
	
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
        <li class="active"><a href="${ctx}/sybx/syUnitRepairCheck/">单位补基数核定</a></li>
    </ul>
    <sys:message content="${message}"/>
    <form:form id="inputForm" modelAttribute="syab88" action="${ctx}/sybx/syUnitRepairCheck/list" method="post" class="breadcrumb form-search" >
        <ul class="ul-form">
            单位名称：<form:input path="AAB004"  readonly="true" maxlength="20" cssStyle="width:250px;" cssClass="input-medium required"/><span class="help-inline"><font color="red">*</font> </span>
            &nbsp;&nbsp;&nbsp;起始费款所属期：<form:input path="StartYM" placeholder="yyyyMM" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyyMM'});"/><span class="help-inline"><font color="red">*</font> </span>
            &nbsp;&nbsp;&nbsp;截止费款所属期：<form:input path="EndYM" placeholder="yyyyMM" readonly="true" maxlength="10" cssStyle="width:145px;" cssClass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyyMM',maxDate:'%Date'});"/><span class="help-inline"><font color="red">*</font> </span>
                <input id="btnSubmit" class="btn btn-primary" type="submit" value="审核"/>
        </ul>
        <c:if test="${page!=null}">
            <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
            <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
            <c:if test="${page.list.size()>0}">
                <input id="pageSize" name="mark" type="hidden" value="${page.list[0].AAE002}"/>
            </c:if>
        </c:if>
    </form:form>
        <form:form class="breadcrumb form-search" >
        <table id="contentTable" class="table table-striped table-bordered table-condensed">
            <thead>
                <tr style="font-weight: bolder;height:35px;background-color: #FFFFFF;"><td colspan="10">近半年缴费信息列表</td></tr>
                <tr>
                    <th>缴费类型</th>
                    <th>费款所属期</th>
                    <th>人数</th>
                    <th>单位缴费基数总额</th>
                    <th>个人缴费基数总额</th>
                    <th>单位应缴</th>
                    <th>个人应缴</th>
                    <th>滞纳金</th>
                    <th>应缴合计</th>
                    <th>缴费标志</th>
                    <th>查看/操作</th>
                </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${page!=null&&page.list.size()>0}">
                    <c:forEach items="${page.list}" var="syab88">
                        <input type="hidden" name="BAA001" value="${syab88.BAA001}"/>
                        <tr>
                            <td>${fns:getDictLabel(syab88.AAE143, "AAE143_5",'' )}</td>
                            <td>
                                <a href="${ctx}/sybx/syUnitPaymentCheck/changeList?aae002=${syab88.AAE002}">${syab88.AAE002}</a>
                            </td>
                            <td>
                                <a href="${ctx}/sybx/syUnitPaymentCheck/personList?AAE003=${syab88.AAE002}&AAE002=${syab88.AAE002}&AAE143=${syab88.AAE143}">${syab88.AAB083}
                            </td>
                            <td class="moneyNum">${syab88.AAB121}</td>
                            <td class="moneyNum">${syab88.AAB121}</td>
                            <td class="moneyNum">${syab88.BAB701}</td>
                            <td class="moneyNum">${syab88.AAB122}</td>
                            <td class="moneyNum">${syab88.BAE742}</td>
                            <td class="moneyNum">${syab88.AAB137}</td>
                            <td>${syab88.BAE707}</td>
                            <td>
                                <a href="${ctx}/sybx/syUnitPaymentCheck/CollectionList?aae063=${syab88.AAE063}">${syab88.AAE063}</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td style="color: red;font-weight: bold; text-align: center" colspan="11">近半年无单位缴费信息</td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
        <div class="pagination">${page}</div>
            <div  style="color: red;font-weight: bold;">备注：</div>
            <div  style="color: red;font-weight: bold;">1.点击费款所属期查看该月人员异动明细</div>
            <div  style="color: red;font-weight: bold;">2.点击人数查看该月人员缴费明细 </div>
            <div  style="color: red;font-weight: bold;">3.已做过征集计划点击征集流水号查看该月征缴计划信息。</div>
        </form:form>
</body>
</html>