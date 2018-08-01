<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员续保登记</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
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


        function checkChoose() {
            var strAAC001 = document.getElementsByName("BAA005s");
            var objarrayAAC001 = strAAC001.length;
            var chestrAAC001 = "";

            for (i = 0; i < objarrayAAC001; i++) {
                if (strAAC001[i].checked == true) {
                    chestrAAC001 += strAAC001[i].value;
                }
            }

            if (chestrAAC001 == "") {
                $.jBox.tip("请在列表中至少选择一条征集计划");
                return false;
            }
            top.$.jBox.confirm("确认对选中的征集计划进行确认吗？","系统提示",function(v,h,f){
                if(v=="ok"){
                    $("#secondForm").submit();
                    setTimeout(function(){
                        location.reload();
                    },2000);
                }
            },{buttonsFocus:1});
            top.$('.jbox-body .jbox-icon').css('top','55px');
        }


        $(document).ready(function () {
            $("#searchForm").validate({
                submitHandler: function (form) {
                    loading('正在查询，请稍等...');
                    form.submit();
                },
                errorContainer: "#messageBox",
                errorPlacement: function (error, element) {
                    /* $("#messageBox").text("输入有误，请先更正。"); */
                    if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
                        error.appendTo(element.parent().parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });

            $("#btnSubmit").click(function(){
                checkChoose();
            });
        });

        function uploadValidate() {
            if ($("#file").val() == "" || $("#file").val() == null) {
                alert("请选择要上传的文件.");
                //$("#file").focus();
                return false;
            }

            //jquery方法
            var options = $("#ywlx_p option:selected");  //获取选中的项
            if (options.val() == "0") {
                alert("您选择批量操作时，请正确选择业务类型.");   //拿到选中项的值
                return false;
            }
        }

        function optOperate() {
            if (confirm("您确认对已选中人员进行续保操作?")) {
                return;
            } else {
                return false;
            }
        }

        function page(n, s) {
            if (n) $("#pageNo").val(n);
            if (s) $("#pageSize").val(s);
            $("#secondForm").attr("action", "${ctx}/sybx/syCollectionQuery/formSubmit");
            $("#secondForm").submit();
            return false;
        }

        //控制业务办理类型
        function check(flag) {
            if (flag == true) {
                document.getElementById("divD1").style.visibility = "hidden";//隐藏批量操作div
            } else if (flag == false) {
                document.getElementById("divD1").style.visibility = "visible";//单个选择操作
            }
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/syCollectionQuery/form">征集计划定制</a></li>
    <li><a href="${ctx}/sybx/syCollectionQuery/list">历史征集计划查询</a></li>
</ul>
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
<form:form id="secondForm" modelAttribute="list[0]" action="${ctx}/sybx/syCollectionQuery/formSubmit" method="post"
           class="breadcrumb form-search ">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="text-align:center;">
            <th colspan="8">征集计划列表</th>
        </tr>
        <tr>
            <th><input type="checkbox" id="ALL_AAC001" value="${xb.AAC001}" onclick="checkboxValue('BAA005s');"
                       title="全选中或全不选"/></th>
            <th>费款所属期</th>
            <th>单位缴费基数总额</th>
            <th>缴费人数</th>
            <th>单位缴费</th>
            <th>个人缴费</th>
            <th>应缴合计</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${list!=null&&list.size()>0}">
                <c:forEach items="${list}" var="xb">
                    <tr>
                        <td><input type="checkbox" name="BAA005s" value="${xb.BAA005}"
                                   title="选择操作请点击此复选框"/></td>
                        <td>${xb.AAE002}</td>
                        <td class="moneyNum">${xb.AAB121}</td>
                        <td>${xb.AAB083}</td>
                        <td class="moneyNum">${xb.BAB701}</td>
                        <td class="moneyNum">${xb.AAB122}</td>
                        <td class="moneyNum">${xb.AAB137}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td style="color: red;font-weight: bold; text-align: center" colspan="10"> 无征缴计划信息</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
       <c:if test="${list!=null&&list.size()>0}">
            <div align="center">
                <input  class="btn btn-primary" type="button" onclick="return checkChoose();" value="确认定制"/>
            </div>
        </c:if>
</form:form>
</body>
</html>
