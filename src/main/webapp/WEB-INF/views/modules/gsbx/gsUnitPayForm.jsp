<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <title>单位缴费查询</title>
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
        });
        function doSubmit() {
            var f = document.getElementById('searchForm');
            // 开始费款所属期
            var AAE041=$("#AAE041").val();
            // 结束费款所属期
            var AAE042=$("#AAE042").val();
            var aae041 = parseInt(AAE041);
            var aae042 = parseInt(AAE042);
            if(!AAE041||!AAE042){
                top.$.jBox.tip("请填写查询条件");
                return false;
            }
            if(aae041>aae042){
                top.$.jBox.tip("开始费款所属期不能大于结束费款所属期");
                return false;
            }
            var aae002 = parseInt($("#AAE002").val());
            if(aae041>aae002&&aae042>aae002){
                top.$.jBox.tip("请先核定"+aae002+"的缴费");
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
    <li class="active"><a href="${ctx}/gsbx/gsUnitPay/form">单位缴费信息</a></li>
</ul>
<form:form id="searchForm" modelAttribute="gsUnitPay" action="${ctx}/gsbx/gsUnitPay/info"
           method="post" class="breadcrumb form-search ">
    <input type="hidden" name="AAC031" value="1">
    <form:input type="hidden" path="AAE002"/>
    <ul class="ul-form">
        <div class="control-group">
            <div class="controls">
                <label>开始费款所属期：</label>
                <form:input id="AAE041" path="AAE041" htmlEscape="false" maxlength="50"
                            class="input-medium Wdate required" readonly="true" onclick="WdatePicker({dateFmt:'yyyyMM',maxDate:'%y-%M'});"/>
                <label>结束费款所属期：</label>
                <form:input id="AAE042" path="AAE042" htmlEscape="false" maxlength="50"
                            class="input-medium Wdate required" readonly="true" onclick="WdatePicker({dateFmt:'yyyyMM',maxDate:'%y-%M'});"/>
                <label>是否计算利息：</label>
                <form:select path="BAE746" >
                    <form:option value="0">否</form:option>
                    <form:option value="1">是</form:option>
                </form:select>
                <label>是否计算滞纳金：</label>
                <form:select path="BAE747" >
                    <form:option value="0">否</form:option>
                    <form:option value="1">是</form:option>
                </form:select>
                <input id="query" class="btn btn-primary" type="submit" onclick="return doSubmit()" value="查询"
                       title="根据录入条件查询人员信息"/>
            </div>
        </div>
    </ul>
</form:form>
<sys:message content="${message}" type="${ctype}"/>
<c:if test="${list != null}">
<form:form class="breadcrumb form-search">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="font-weight: bolder;height:35px;background-color: #FFFFFF;">
            <td colspan="10">近半年缴费信息列表</td>
        </tr>
        <tr>
            <th>缴费类型</th>
            <th>险种类型</th>
            <th>费款所属期</th>
            <th>人数</th>
            <th>单位缴费基数总额</th>
            <th>单位应缴</th>
            <th>应收核定类别</th>
            <th>应缴合计</th>
            <th>缴费比例类别</th>
            <th>缴费状态</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${list.size()>0}">
                <c:forEach items="${list}" var="syab88">
                    <input type="hidden" name="BAA001" value="${syab88.BAA001}"/>
                    <input type="hidden" name="AAE143" value="${syab88.AAE143}"/>
                    <tr>
                        <td>${syab88.AAE143}</td>
                        <td>${syab88.AAE140}</td>
                        <td>${syab88.AAE002}</td>
                        <td>${syab88.AAB083}</td>
                        <td class="moneyNum">${syab88.AAB120}</td>
                        <td class="moneyNum">${syab88.BAB701}</td>
                        <td>${syab88.BAB706}</td>
                        <td class="moneyNum">${syab88.AAB137}</td>
                        <td>
                            <c:if test="${syab88.AAE140=='工伤保险'}">
                                ${fns:getDictLabel(syab88.AAA040,"BAA104_GS" ,"" )}
                            </c:if>
                            <c:if test="${syab88.AAE140=='生育保险'}">
                                ${fns:getDictLabel(syab88.AAA040,"BAA105_GS" ,"" )}
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${syab88.BAE707==null}">
                                未缴费
                            </c:if>
                            <c:if test="${syab88.BAE707!=null}">
                                已实缴
                            </c:if>
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
</form:form>
</c:if>
<c:if test="${infoList != null}">
<form:form id="secondForm" modelAttribute="gsUnitPay" action="${ctx}/gsbx/gsUnitPay/submit"
           method="post"
           class="form-horizontal">
<table class="table-form">
    <tr style="height: 45px">
        <td class="tit" width="15%">单位编号:</td>
        <td width="20%">${userInfo.gsAAB001}</td>
        <td class="tit" width="15%">单位名称:</td>
        <td width="20%">${userInfo.gsAAB004}</td>
        <td class="tit" width="15%">单位类型:</td>
        <td width="20%">${fns:getDictLabel(unitInfo.AAB019, "AAB019_GS","" )}</td>
    </tr>
    <tr style="height: 45px">
        <td class="tit" width="15%">经济类型:</td>
        <td width="20%">${fns:getDictLabel(unitInfo.AAB020, "AAB020_GS","" )}</td>
        <td class="tit" width="15%">行业代码:</td>
        <td width="20%">${fns:getDictLabel(unitInfo.AAB022, "AAB022_GS","" )}</td>
        <td class="tit" width="15%">行业企业代码:</td>
        <td width="20%">${fns:getDictLabel(unitInfo.BAB519, "BAB519_GS","" )}</td>
    </tr>
    <tr style="height: 45px">
        <td class="tit" width="15%">是否计算利息</td>
        <td width="20%"><c:if test="${gsUnitPay.BAE746 ==0}">否</c:if><c:if test="${gsUnitPay.BAE746 ==1}">是</c:if></td>
        <td class="tit" width="15%">是否计算滞纳金</td>
        <td width="20%"><c:if test="${gsUnitPay.BAE747 ==0}">否</c:if><c:if test="${gsUnitPay.BAE747 ==1}">是</c:if></td>
    </tr>
</table>
<br/>
<table  class="table table-striped table-bordered table-condensed">
    <thead>
        <tr>
            <th>险种类型</th>
            <th>参保日期</th>
            <th>最近参保时间</th>
            <th>参保状态</th>
            <th>费率</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${unitInfoList}" var="Info">
        <tr>
            <td>${fns:getDictLabel(Info.AAE140, "AAE140_5","" )}</td>
            <td>${Info.AAB050}</td>
            <td>${Info.BAB510}</td>
            <td>${fns:getDictLabel(Info.AAB051, "AAB051_GS","" )}</td>
            <td>
                <c:if test="${Info.AAE140 == 4}">
                    ${fns:getDictLabel(Info.AAA040, "BAA104_GS","" )}
                </c:if>
                <c:if test="${Info.AAE140 == 5}">
                    ${fns:getDictLabel(Info.AAA040, "BAA105_GS","" )}
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr style="text-align:center;">
        <th colspan="7">单位缴费信息</th>
    </tr>
    <tr>
        <th>险种类型</th>
        <th>费款所属期</th>
        <th>人数</th>
        <th>单位缴费基数总额</th>
        <th>单位应缴</th>
        <th>滞纳金金额</th>
        <th>应缴合计</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${infoList}" var="Info">
        <tr>
            <td>${fns:getDictLabel(Info.AAE140, "AAE140_5","" )}</td>
            <td>${Info.AAE002}</td>
            <td>${Info.personCount}</td>
            <td><fmt:formatNumber type="number" value="${Info.AAB121}" pattern="0.00" maxFractionDigits="2"/></td>
            <td><fmt:formatNumber type="number" value="${Info.BAB701}" pattern="0.00" maxFractionDigits="2"/></td>
            <td><fmt:formatNumber type="number" value="${Info.BAE742}" pattern="0.00" maxFractionDigits="2"/></td>
            <td><fmt:formatNumber type="number" value="${Info.AAB137}" pattern="0.00" maxFractionDigits="2"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<input id="query" class="btn btn-primary" type="submit" value="核定"
       title="根据录入条件查询人员信息"/>
</form:form>
</c:if>
</body>
</html>
