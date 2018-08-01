<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员缴费基数申报</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        function checkboxValue(Obj) {
            var collid = document.getElementById("ALL_AAC001")
            var coll = document.getElementsByName(Obj)
            if (collid.checked) {
                for (var i = 0; i < coll.length; i++) {
                    coll[i].checked = true;
                }
            } else {
                for (var i = 0; i < coll.length; i++) {
                    coll[i].checked = false;
                }
            }
        }
        $(document).ready(function () {
            //$("#name").focus();
            $("#searchForm").validate({
                submitHandler: function (form) {
                    //loading('正在提交，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function (error, element) {
                    if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
        });
        function download() {
            top.$.jBox.confirm("确认要导出吗？","系统提示",function(v,h,f){
                if(v=="ok"){
                    $("#searchForm").attr("action","${ctx}/gsbx/gsPaymentBase/download");
                    $("#searchForm").submit();
                }
            },{buttonsFocus:1});
            top.$('.jbox-body .jbox-icon').css('top','55px');
        }
        function page(n,s){
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#searchForm").attr("action","${ctx}/gsbx/gsPaymentBase/list");
            loading('正在提交，请稍等...');
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gsbx/gsPaymentBase/form">缴费基数打印</a></li>
</ul>
<sys:message content="${message}" type="${ctype}"/>
<form:form id="searchForm" modelAttribute="gsPaymentBase" action="${ctx}/gsbx/gsPaymentBase/list"
           method="post" class="breadcrumb form-search ">
    <ul class="ul-form">
        <div class="control-group">
            <div class="controls">
                <label>年&nbsp;&nbsp;&nbsp;度：</label><form:input path="AAE030" maxlength="4" cssStyle="width:120px;" cssClass="input-medium Wdate required " onclick="WdatePicker({dateFmt:'yyyy'});"/>
                <label>险&nbsp;&nbsp;&nbsp;种：</label><form:select path="AAE140" cssStyle="width:120px;"  >
                    <form:option value="4">工伤保险</form:option>
                    <form:option value="5">生育保险</form:option>
                </form:select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="query" class="btn btn-primary" type="submit" value="查询"
                       title="根据录入条件查询人员信息"/>

                <c:if test="${fn:length(pagination.list)>0}">
                        <input  class="btn btn-primary" type="button" value="下载" onclick="download()"
                                title="下载人员缴费基数信息"/>
                </c:if>
            </div>
        </div>
    </ul>
</form:form>
<form id="secondForm" action="${ctx}/gsbx/gsPaymentBase/submit"
           method="post"
           class="breadcrumb form-search ">
    <%-- <c:if test="${pm_ac01view.BAC808 != 'noDisplayPageInfo'}"><div class="pagination">${pagination}</div></c:if> --%>
    <input id="pageNo" name="pageNo" type="hidden" value="${pagination.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${pagination.pageSize}"/>
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr style="text-align:center;">
    <th colspan="7">人员基数列表信息</th>
    </tr>
    <tr>
    <th>个人编号</th>
    <th>姓&nbsp;&nbsp;&nbsp;名</th>
    <th>身份证号</th>
    <th>启用时间</th>
    <th>参保时间</th>
    <th>缴费基数</th>
    <th>险种类型</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pagination.list}" var="Info" varStatus="InfoStatus">
            <td>${Info.AAC001}</td>
            <td>${Info.AAC003}</td>
            <td>${Info.AAC002}</td>
            <td>${Info.AAE030}</td>
            <td>${Info.AAC030}</td>
            <td>${Info.BAC504}</td>
            <td>${fns:getDictLabel(Info.AAE140,"AAE140_5" ,"" )}</td>
        </tr>
    </c:forEach>
    <%--<c:if test="${pm_ac01view.AAE011 == 'displayInfo'}">--%>
    </tbody>
    </table>
        <div class="pagination">${pagination}</div>
</form>
<div id="divD1" style="display:none;">


</div>
</body>
</html>
