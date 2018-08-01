<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <title>单位历史缴费核定查询</title>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <script>
        $(document).ready(function () {
            //$("#name").focus();
            $("#searchForm").validate({
                submitHandler: function (form) {
                    //loading('正在提交，请稍等...');
                    form.submit();
                }
            });

            $("#btnExport").click(function(){
                top.$.jBox.confirm("确认要下载核定表吗？","系统提示",function(v,h,f){
                    if(v=="ok"){
                        $("#pdfForm").attr("action","${ctx}/gsbx/gsUnitPay/printPDF");
                        $("#pdfForm").submit();
                    }
                },{buttonsFocus:1});
                top.$('.jbox-body .jbox-icon').css('top','55px');
            });
        });
        function doSubmit() {
            var f = document.getElementById('searchForm');
            // 开始费款所属期
            var AAE041=$("#AAE041").val();
            // 结束费款所属期
            var AAE042=$("#AAE042").val();
            var aae002 = $("#AAE002").val();
            if(!AAE041||!AAE042){
                top.$.jBox.tip("请填写查询条件");
                return false;
            }
            if(parseInt(AAE042)>parseInt(aae002)){
                top.$.jBox.tip("不能超过最大缴费核定日期："+aae002);
                return false;
            }
            if(parseInt(AAE041)>parseInt(AAE042)){
                top.$.jBox.tip("开始费款所属期不能大于结束费款所属期");
                return false;
            }
            var a =  parseInt(AAE041.substring(4, 6));
            var a1 =  parseInt(AAE041.substring(0,4));
            var b = parseInt(AAE042.substring(4, 6));
            var b1 = parseInt(AAE042.substring(0,4));
            if(0<=a&&a<7){
                if((b1-a1)>0||!(0<=b&&b<7)){
                    top.$.jBox.tip("不允许跨年查询");
                    return false;
                }
            }else if((b1 - a1)>1||!(0<=b&&b<7)){
                top.$.jBox.tip("不允许跨年查询");
                return false;
            }
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gsbx/gsUnitPay/printForm">单位缴费核定单查询</a></li>
</ul>
<form:form id="searchForm" modelAttribute="gsUnitPay" action="${ctx}/gsbx/gsUnitPay/printInfo"
           method="post" class="breadcrumb form-search ">
    <input type="hidden" name="AAC031" value="1">
    <form:input type="hidden" path="AAE002" />
    <ul class="ul-form">
        <div class="control-group">
            <div class="controls">
                <label>开始费款所属期：</label>
                <form:input id="AAE041" path="AAE041" htmlEscape="false" maxlength="50"
                            class="input-medium Wdate required" readonly="true" onclick="WdatePicker({dateFmt:'yyyyMM',maxDate:'%y-%M'});"/>
                <label>结束费款所属期：</label>
                <form:input id="AAE042" path="AAE042" htmlEscape="false" maxlength="50"
                            class="input-medium Wdate required" readonly="true" onclick="WdatePicker({dateFmt:'yyyyMM',maxDate:'%y-%M'});"/>
                <input id="query" class="btn btn-primary" type="submit" onclick="return doSubmit()" value="查询"
                       title="根据录入条件查询人员信息"/>
                <c:if test="${printInfo != null}">
                <input id="btnExport" class="btn btn-primary" type="button"  value="下载核定单"
                       title="根据录入条件查询人员信息"/>
                </c:if>
            </div>
        </div>
    </ul>
</form:form>
<sys:message content="${message}" type="${ctype}"/>
<c:if test="${printInfo != null}">
<form class="breadcrumb form-search " id="pdfForm">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="text-align:center;">
            <th colspan="7">单位缴费核定信息</th>
        </tr>
        <tr>
            <th>险种类型</th>
            <th>本期缴费人数（人）</th>
            <th>上期缴费人数（人）</th>
            <th>缴费工资总额（元）</th>
            <th>缴费比例（%）</th>
            <th>滞纳金（元）</th>
            <th>缴费小计（元）</th>
            <th>待转基金（元）</th>
            <th>应缴</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>工伤保险</td>
                <td>${printInfo.Aab083GS}</td>
                <td>${printInfo.StrAab083GS}</td>
                <td>${printInfo.Aab121GS}</td>
                <td>${printInfo.Aaa040GS}</td>
                <td>${printInfo.ZNJGS}</td>
                <td>${printInfo.Aab137GS}</td>
                <td>${printInfo.Bae719GS}</td>
                <td>${printInfo.YJGS}</td>
            </tr>
            <tr>
                <td>生育保险</td>
                <td>${printInfo.Aab083SY}</td>
                <td>${printInfo.StrAab083SY}</td>
                <td>${printInfo.Aab121SY}</td>
                <td>${printInfo.Aaa040SY}</td>
                <td>${printInfo.ZNJSY}</td>
                <td>${printInfo.Aab137SY}</td>
                <td>${printInfo.Bae719SY}</td>
                <td>${printInfo.YJSY}</td>
            </tr>
        </tbody>
    </table>
</form>
</c:if>
</body>
</html>
