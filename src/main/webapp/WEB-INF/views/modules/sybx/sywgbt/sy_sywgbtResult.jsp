<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <title>稳岗补贴审核</title>
    <style>
        form .ul-form li {
            width: 33%;
        }
    </style>
    <script type="text/javascript">

        function submitForm () {
            // 确认提交审核
            debugger;
            var ajc159 = $('#ajc159').val();
            if (ajc159 != 0) {
                var f = document.getElementById('inputForm');
                f.action = "${ctx}/sybx/sywgbt/web_sywgbt/confirmSubmit";
                f.submit();
            } else {
                alert("申报补贴0元，不可提交");
                return false;
            }

        }

        function failExport () {
            //导出不合格人员
            debugger;
            var f = document.getElementById('inputForm');
            f.action = "${ctx}/sybx/sywgbt/web_sywgbt/failExport";
            f.submit();
        }

        function eligibleExp() {
            // 导出合格人员
            debugger;
            var ajc159 = $('#ajc159').val();
            if (ajc159 != 0) {
                var f = document.getElementById('inputForm');
                f.action = "${ctx}/sybx/sywgbt/web_sywgbt/eligibleExp";
                f.submit();
            } else {
                alert("没有合格人员，不可导出");
            }
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/sybx/sywgbt/web_sywgbt/">稳岗补贴</a></li>
    <li class="active"><a href="#">稳岗补贴审核</a></li>
</ul>

<form id="inputForm" action="" method="post" class="breadcrumb form-search">
    <input type="hidden" name="SAA036" id="saa036_reg" value="${SAA036}"/>
    <c:if test="${unitInfoBack != null}">
        <ul class="ul-form">
            <li>单位编号：<input type="text" readonly value="${unitInfoBack.aAB001}" name="AAB001"
                            cssClass="input-medium required"  style="margin-left: 63px;"><span
                    class="help-inline"></span></li>
            <li>单位名称：<input type="text" readonly value="${unitInfoBack.aAB004}" name="AAB004"
                          cssClass="input-medium required"  style="margin-left: 51px;"><span
                    class="help-inline"></span></li>
            <li>参保人员：<input type="text" readonly value="${unitInfoBack.aAB083}" name="AAB083"
                            cssClass="input-medium required"  style="margin-left: 37px;"><span
                    class="help-inline"></span></li>
        </ul>
        <ul class="ul-form">
            <li>单位缴费基数：<input type="text" readonly value="${unitInfoBack.aAB121}" name="AAB121"
                              class="moneyNum"  style="margin-left: 38px;"><span
                    class="help-inline"></span></li>
            <li>单位上年度缴费额：<input type="text" readonly value="${unitInfoBack.bAB701}" name="BAB701"
                                class="moneyNum" ><span
                    class="help-inline"></span></li>
            <li>个人上年度缴费：<input type="text" readonly value="${unitInfoBack.aAB122}" name="AAB122"
                               class="moneyNum" ><span
                    class="help-inline"></span></li>
        </ul>
        <ul class="ul-form">

            <li>企业上年度缴费总额：<input type="text" readonly value="${unitInfoBack.aAB122+unitInfoBack.bAB701}" name="AAB137"
                                 class="moneyNum" /><span
                    class="help-inline"></span></li>
        </ul>
    </c:if>
    <form id="subsidy" action="" class="breadcrumb form-search" method="post">
        <c:if test="${ examineVO != null }">
            <input type="hidden" name="BAZ005" id="BAZ005_reg" value="${examineVO.bAZ005}"/>
            <ul class="ul-form">
                <li>生活/岗位补贴:<input type="text" readonly value="${examineVO.bJC411}" name="BJC411"
                                   class="moneyNum"
                                   style="margin-left: 44px;"><span class="help-inline"></span></li>
                <li>技能提升培训：<input type="text" readonly value="${examineVO.bJC403}" name="BJC403"
                                  class="moneyNum" 
                                  style="margin-left: 25px;"><span class="help-inline"></span></li>
                <li>转岗培训补贴：<input type="text" readonly value="${examineVO.bJC400}" name="BJC400"
                                  class="moneyNum" 
                                  style="margin-left: 10px;"><span class="help-inline"></span></li>
            </ul>
            <ul class="ul-form">
                <li>养老保险补贴: <input type="text" readonly value="${examineVO.bJC408}" name="BJC408"
                                   class="moneyNum" 
                                   style="margin-left: 46px;"><span class="help-inline"></span></li>
                <li>医疗保险补贴：<input type="text" readonly value="${examineVO.bJC409}" name="BJC409"
                                  class="moneyNum" 
                                  style="margin-left: 27px;><span class=" help-inline"><span class="help-inline"></span></li>
                <li>失业保险补贴：<input type="text" readonly value="${examineVO.bJC410}" name="BJC410"
                                  class="moneyNum" 
                                  style="margin-left: 10px;"><span class="help-inline"></span></li>
            </ul>
            <ul class="ul-form">
                <li>申报补贴总额：<input type="text" readonly value="${examineVO.aJC159}" name="AJC159" id="AJC159"
                                  class="moneyNum" 
                                  style="margin-left: 38px;"><span class="help-inline"></span></li>
                <li>补贴类型：<input type="text" readonly value="${fns:getDictLabel(examineVO.bJB003,'BJB003_X' , '')}" name="BJB003"
                                cssClass="input-medium required"  style="margin-left: 52px;"><span
                        class="help-inline"></span></li>
            </ul>
        </c:if>
    </form>
    <c:if test="${examineVO != null }">
        <div align="center">
            <input class="btn btn-primary" type="button" value="导出合格人员" onclick="eligibleExp()"/>
            <input class="btn btn-primary" type="button" value="确认" onclick="return submitForm()"/>
        </div>
    </c:if>
</form>
<c:if test="${not empty message}">
    <div id="messageBox" class="alert alert-success">
        <button data-dismiss="alert" class="close">×</button>
            ${message}</div>
    <script type="text/javascript">if (!top.$.jBox.tip.mess) {
        top.$.jBox.tip.mess = 1;
        top.$.jBox.tip(${message}, "success", {persistent: true, opacity: 0});
        $("#messageBox").show();
    }</script>
</c:if>
<form id="Form" action="" method="post" class="breadcrumb form-search">
    <h3>不合格人员</h3>
    <table id="contentTable" class="table table-striped table-bordered table-condensed" style="text-align: center">
        <thead>
        <tr>
            <th>个人编号</th>
            <th>姓名</th>
            <th>公民身份号码</th>
            <th>申报日期</th>
            <th>养老保险补贴</th>
            <th>医疗保险补贴</th>
            <th>失业保险补贴</th>
            <th>生活/岗位补贴</th>
            <th>转岗培训补贴</th>
            <th>技能提升培训补贴</th>
            <th>错误原因</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pagination_err.list}" var="c">
            <tr>
                <input type="hidden" name="BAZ005" id="BAZ005" value="${c.bAZ005}"/>
                <input type="hidden" name="TAA104" id="TAA104" value="${c.tAA104}"/>
                <td width="9%">${c.aAC001}</td>
                <td width="9%">${c.aAC003}</td>
                <td width="9%">${c.aAC002}</td>
                <td width="9%">${c.aAE030}</td>
                <td class="moneyNum" width="9%">${c.bJC408}</td>
                <td class="moneyNum" width="9%">${c.bJC409}</td>
                <td class="moneyNum" width="9%">${c.bJC410}</td>
                <td class="moneyNum" width="9%">${c.bJC411}</td>
                <td class="moneyNum" width="9%">${c.bJC400}</td>
                <td class="moneyNum" width="9%">${c.bJC403}</td>
                <td width="9%">${c.tAA104}</td>
            </tr>
        </c:forEach>
        <c:if test="${pagination_err.list.size() <= 0 }">
            <tr>
                <td style="text-align: center" colspan="11">无不合格人员</td>
            </tr>
        </c:if>
        </tbody>
    </table>
    <c:if test="${pagination_err.list.size() > 0}">
        <div class="pagination">${pagination_err}</div>
    </c:if>
    <c:if test="${pagination_err.list.size() > 0}">
        <div align="center">
            <input class="btn btn-primary" type="button" value="返回" onclick="javascpipt:history.go(-1);"/>
            <input class="btn btn-primary" type="button" value="导出不合格人员" onclick="failExport()"/>
        </div>
    </c:if>
</form>
</body>
</html>
