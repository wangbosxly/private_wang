<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <title>稳岗补贴</title>
    <style>
        .table tr .tit {
            text-align: right;
        }
    </style>
    <script >
        function checkBAA008() {
            return $("#BAA008").val()=="年审未通过";
        }

        function checkAAB019() {
            return $("#AAB019").val()!="企业";
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/sywgbt/web_sywgbt/">稳岗补贴申报</a></li>
</ul>
<sys:message content="${message}"/>
<form id="searchForm" class="breadcrumb form-search " enctype="multipart/form-data" action="${ctx}/sybx/sywgbt/web_sywgbt/examine" method="post">
    <ul class="ul-form">
        <li>
            <label>单位编号：</label>
            <input type="text" id="AAB001" name="AAB001" class="input-medium" value="${user.aab001}" readonly>
        </li>
        <li>
            <label>申报年份：</label>
            <input type="text" id="AAE002" name="AAE002" class="input-medium" value="${AAE002}" readonly>
        </li>
        <li>
            <label>公司名称：</label>
            <input style="width : 260px" type="text" id="AAB004" name="AAB004" class="input-medium" value="${user.aab004}" readonly>
        </li>
    </ul>
    <ul class="ul-form">
        <li>
            <label>单位类型：</label>
            <input type="text" id="AAB019" name="AAB019" class="input-medium" value="${fns:getDictLabel(unit.AAB019, "AAB019_5","" )}" readonly>
        </li>
        <li>
            <label>参保时间：</label>
            <input type="text" id="AAB050" name="AAB050" class="input-medium" value="${unit.AAB050}" readonly>
        </li>
        <li>
            <label>年审状态：</label>
            <input type="text" id="BAA008" name="BAA008" class="input-medium" value="${fns:getDictLabel(unit.BAA008, "BAA008_X","" )}" readonly>
        </li>
    </ul>
    <ul class="ul-form">
        <li>
            <label>上年实缴：</label>
            <input type="text"  class="input-medium moneyNum" value="${lastMoney.realysum}" readonly>
        </li>
        <li>
            <label>补贴上限：</label>
            <input type="text"  class="input-medium moneyNum" value="${Maxmoney}" readonly>
        </li>
    </ul>
    <c:if test="${msg==null}">
    <ul class="ul-form" >
        <li>
            <label>添加文件</label>
            <input type="file" name="file" id="file">
        </li>
        <li class="btns">
            <input type="submit" class="btn btn-primary" value="上传明细" onclick="return doSubmit()">
        </li>
    </ul>
    </c:if>
</form>
<c:if test="${state=='2-2'}">
    <form action="" class="breadcrumb form-search">
        <div style="margin: auto;width:100%">
        <table class="table table-bordered">
            <tr>
                <td class="tit">社会保险登记证号:</td>
                <td ><input type="text"  class="input-large" /></td>
                <td class="tit">联系人及电话:</td>
                <td ><input type="text"  class="input-large " /></td>
                <td class="tit">开户银行名称:</td>
                <td ><input type="text"  class="input-large required"/><span  style="color:red; font-weight: bold"><font style="color: red;">*</font></span></td>
            </tr>
            <tr>
                <td class="tit" style="text-align: right">开户账号:</td>
                <td ><input type="text"  class="input-large" /></td>
                <td class="tit" >上年度正常减员人数:</td>
                <td ><input type="text"  class="input-large " /></td>
                <td class="tit" >上年度实际裁员人数:</td>
                <td ><input type="text"  class="input-large required"/><span style="color:red; font-weight: bold"><font style="color: red;">*</font></span></td>
            </tr>
            <tr>
                <td class="tit" style="text-align: right">裁员率(%):</td>
                <td ><input type="text"  class="input-large" /></td>
                <td colspan="4"></td>
            </tr>
        </table>
        </div>
    </form>
</c:if>
<c:if test = "${msg!=null}">
    <form class="breadcrumb form-search ">
            <li>
                <div style="color: red;font-weight: bold;" >${msg}</div>
            </li>
    </form>
</c:if>
<form class="breadcrumb form-search ">
<table id="contentTable" class="table table-striped table-bordered table-condensed" style="text-align: center">
    <thead>
    <input type="hidden" name="BAA001" value="${syac01.BAA001}"/>
    <tr style="font-weight: bolder;height:35px;background-color: #FFFFFF;">
        <td colspan="12">历史稳岗补贴列表</td>
    </tr>
    <tr>
        <th>申请流水号</th>
        <th>补贴类别</th>
        <th>申报年月</th>
        <th>补贴总额</th>
        <th>失业保险补贴</th>
        <th>养老保险补贴</th>
        <th>医疗保险补贴</th>
        <th>生活补贴/岗位补贴</th>
        <th>转岗培训补贴</th>
        <th>技能提升培训补贴</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${array!=null&&array.size()>1}">
    <c:forEach items="${array}" var="wg">
        <tr>
            <td>${wg.bAZ005}</td>
            <td>${fns:getDictLabel(wg.BjB003,"BJB003_X","")}</td>
            <%--<c:if test="${wg.bJB003 == '01'}">
                <td>兼并重组</td>
            </c:if>
            <c:if test="${wg.bJB003 == '02'}">
                <td>化解产能过剩</td>
            </c:if>
            <c:if test="${wg.bJB003 == '03'}">
                <td>淘汰落后产能</td>
            </c:if>
            <c:if test="${wg.bJB003 == '04'}">
                <td>城市、企业转型</td>
            </c:if>
            <c:if test="${wg.bJB003 == '06'}">
                <td>其他</td>
            </c:if>
            <c:if test="${wg.bJB003 == ''}">
                <td></td>
            </c:if>--%>
            <td>${wg.aAE030}</td>
            <td class="moneyNum">${wg.aJC159}</td>
            <td class="moneyNum">${wg.bJC410}</td>
            <td class="moneyNum">${wg.bJC408}</td>
            <td class="moneyNum">${wg.bJC409}</td>
            <td class="moneyNum">${wg.bJC411}</td>
            <td class="moneyNum">${wg.bJC400}</td>
            <td class="moneyNum">${wg.bJC403}</td>
            <c:if test="${wg.bAZ005 != '合计'}">
            <td>
                <a href="${ctx}/sybx/sywgbt/web_sywgbt/downloadExcel?baz005=${wg.bAZ005}">导出人员明细</a>
            </td>
            </c:if>
            <c:if test="${wg.bAZ005 == '合计'}">
                <td>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </c:if>
    <c:if test="${array==null||array.size()==1}">
        <td colspan="12" style="font-weight: bolder;color: red" >无稳岗补贴历史信息</td>
    </c:if>
    </tbody>
</table>
</form>
<script type="text/javascript">


    function doSubmit() {
        $("#searchForm").validate();
        /*var aae002 = $("#AAE002").val();
        if (aae002 == null || aae002 == "") {
            $.jBox.tip("请输入申报年份");
            return false;
        }
        var bjb003 = $("#BJB003").val();
        if (bjb003 == null || bjb003 == "") {
            $.jBox.tip("补贴类别");
            return false;
        }*/
        var file = $("#file").val();
        if (file == null || file == "") {
            $.jBox.tip("请选择要上传的文件");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
