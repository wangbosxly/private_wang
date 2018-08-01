<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员停保登记</title>
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
            //jquery方法
            var options = $("#ywlx option:selected");  //获取选中的项
            //js原生校验
            var strAAC001 = document.getElementsByName("AAC001S");
            var objarrayAAC001 = strAAC001.length;
            var chestrAAC001 = "";
            for (i = 0; i < objarrayAAC001; i++) {
                if (strAAC001[i].checked == true) {
                    chestrAAC001 += strAAC001[i].value;
                }
            }
            if (chestrAAC001 == "" && options.val() == "5") {
                top.$.jBox.tip("请选择【人员信息】和【业务类型】.");
                return false;
            }
            if (chestrAAC001 == "") {
                top.$.jBox.tip("请选择【人员信息】");
                return false;
            }
            if (options.val() == "5") {
                top.$.jBox.tip("请正确选择【业务类型】");   //拿到选中项的值
                return false;
            }
            if ($("#cdate").val() == "" || $("#cdate").val() == null) {
                top.$.jBox.tip("请选择停保日期");
                return false;
            }
            top.$.jBox.confirm("您确认对已选中人员进行停保操作？", "系统提示", function (v, h, f) {
                if (v == "ok") {
                    $("#secondForm").submit();

                }
            }, {buttonsFocus: 1});
            top.$('.jbox-body .jbox-icon').css('top', '55px');
        }
        //页面加载完光标自动定位在AAC003
        window.onload = function () {
            var oInput = document.getElementById("AAC003");
            oInput.focus();
        }

        function uploadValidate() {
            var options = $("#ywlx option:selected");  //获取选中的项
            if ($("#file").val() == "" || $("#file").val() == null) {
                top.$.jBox.tip("您选择批量上传时，请选择要上传的文件.");
                return false;
            }
            if ($("#cdatepl").val() == "" || $("#cdatepl").val() == null) {
                alert("请选择停保日期");
                return false;
            }
            //jquery方法
            var options = $("#ywlx_p option:selected");  //获取选中的项
            if (options.val() == "5") {
                top.$.jBox.tip("您选择批量上传作时，请正确选择【业务类型】");   //拿到选中项的值
                return false;
            }
        }

        function checkAAC003Value() {
            var aac001_str = document.getElementById("AAC001").value;
            var aac003_str = document.getElementById("AAC003").value;
            var aac002_str = document.getElementById("AAC002").value;
            if (aac001_str == '' && aac002_str == '') {
                top.$.jBox.tip("个人编号|身份证号必须填写一项!");
                return false;
            }
        }
        function page(n, s) {
            if (n) $("#pageNo").val(n);
            if (s) $("#pageSize").val(s);
            $("#secondForm").attr("action", "${ctx}/sybx/syrytbdj/web_syrytbdj/list");
            $("#secondForm").submit();
            return false;
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
        });
        //控制业务办理类型
        function check(flag) {
            if (flag == true) {
                document.getElementById("divD1").style.display = "none";//隐藏批量上传操作
                document.getElementById("divD2").style.display = "block";//显示单个操作
            } else {
                document.getElementById("divD1").style.display = "block";
                document.getElementById("divD2").style.display = "none";
            }
        }
       /* function change_1() {
            var id = $("#ywlx").val();
            var mySelect = $("#AAE160_SELECT");
            if (id == 3) {
                mySelect.empty();
                mySelect.append('<select id="AAE160_1" class="input2" name="AAE160" style="width:180px">' +
                                '<option value="210">在职人员退休</option>' +
                                '<option value="211">在职人员死亡</option>' +
                                '</select>');
            } else if (id == 2){
                mySelect.empty();
                mySelect.append('<select id="AAE160_1" class="input2" name="AAE160" style="width:180px">' +
                                '<option value="220">失业登记享受待遇</option>' +
                                '<option value="221">在职人员解除劳动合同</option>' +
                                '<option value="222">在职人员辞职</option>' +
                                '<option value="223">在职人员被辞退</option>' +
                                '<option value="224">在职人员参军</option>' +
                                '<option value="225">在职人员上学</option>' +
                                '<option value="227">在职人员失踪</option>' +
                                '<option value="228">停薪留职</option>' +
                                '<option value="228">工作调动</option>' +
                                '</select>');
            }
        }*/
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gsbx/gsPersonStopProtect/form">人员停保登记</a></li>
</ul>
<form:form id="searchForm" modelAttribute="gsPersonStopProtect" action="${ctx}/gsbx/gsPersonStopProtect/list"
           method="post" class="breadcrumb form-search ">
    <input type="hidden" name="AAC031" value="1">
    <ul class="ul-form">
        <div class="control-group">
            <div class="controls">
                <label>个人编号：</label><form:input id="AAC001" path="AAC001" htmlEscape="false" maxlength="50"
                                                class="input-medium"/>
                <label>身份证号：</label><form:input id="AAC002" path="AAC002" htmlEscape="false" maxlength="18"
                                                class="input-medium"/>
                <label>姓&nbsp;&nbsp;&nbsp;名：</label><form:input id="AAC003" path="AAC003" htmlEscape="false"
                                                                maxlength="40" class="input-medium"/>
                <input id="query" class="btn btn-primary" type="submit" value="查询" onclick="return checkAAC003Value();"
                       title="根据录入条件查询人员信息"/>
                <label class="control-label">业务办理类型：</label>
                &nbsp;&nbsp;&nbsp;<input type=radio name=a onclick="check(true)" checked="checked">单个选择办理
                <input type=radio name=a onclick="check(false)">批量上传办理
            </div>
        </div>
    </ul>
</form:form>
<sys:message content="${message}" type="${ctype}"/>
<div id="divD1" style="display:none;">
    <form:form id="searchForm" modelAttribute="gsPersonStopProtect" enctype="multipart/form-data"
               action="${ctx}/gsbx/gsPersonStopProtect/fileUpload" method="post" class="breadcrumb form-search"
               onsubmit="return uploadValidate(this)">
        <table class="table table-striped table-bordered table-condensed">
            <tr>
                <td width="330px" style="text-align: center">批量停保原因:
                    <select class="input2" name="AAE160" id="AAE160PL" style="width:180px">
                        <option value="" >请选择</option>
                        <c:forEach items="${fns:getDictList('AAE160_6')}" var="item">
                            <option value="${item.value}" ${item.value==category?'selected':''}>${item.label}</option>
                        </c:forEach>
                    </select>
                </td>
                <td width="330px" style="text-align: center">批量停保日期:
                    <input id="cdatepl" name="cdate" readonly maxlength="10" style="width:145px;"
                           type="text" class="input-medium Wdate required"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'%y-{%M-3}-%d'});"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: center" colspan="3">上传文件:
                    <input id="file" name="file" type="file"/>
                </td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center">
                    <input type="submit" class="btn btn-primary" title="批量上传办理续保业务请点击此按钮" value="确认上传"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<div id="divD2" style="display:block;">
    <form:form id="secondForm" modelAttribute="pm_ac01view" action="${ctx}/gsbx/gsPersonStopProtect/submit"
               method="post"
               class="breadcrumb form-search ">
        <%-- <c:if test="${pm_ac01view.BAC808 != 'noDisplayPageInfo'}"><div class="pagination">${pagination}</div></c:if> --%>
        <input id="pageNo" name="pageNo" type="hidden" value="${pagination.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${pagination.pageSize}"/>
        <table id="contentTable" class="table table-striped table-bordered table-condensed">
            <thead>
            <tr style="text-align:center;">
                <th colspan="7">可办理停保的人员信息</th>
            </tr>
            <tr>
                <th><input type="checkbox" id="ALL_AAC001" value="${Info.AAC001}" onclick="checkboxValue('AAC001S');"
                           title="全选中或全不选"/></th>
                <th>个人编号</th>
                <th>单位编号</th>
                <th>姓&nbsp;&nbsp;&nbsp;名</th>
                <th>身份证号</th>
                <th>险种类型</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pagination.list}" var="Info">
                <tr>
                    <td><input type="checkbox" name="AAC001S" value="${Info.AAC001}&${Info.AAE140}"
                               title="选择操作请点击此复选框"/></td>
                    <td>${Info.AAC001}</td>
                    <td>${Info.AAB001}</td>
                    <td>${Info.AAC003}</td>
                    <td>${Info.AAC002}</td>
                    <td>${fns:getDictLabel(Info.AAE140, "AAE140_5","" )}</td>
                </tr>
            </c:forEach>
                <%--<c:if test="${pm_ac01view.AAE011 == 'displayInfo'}">--%>
            </tbody>
        </table>
        <c:if test="${pagination.list.size() > 19}">
            <div class="pagination">${pagination}</div>
        </c:if>
        <c:if test="${pagination.list.size() > 0}">
            <div>
                <hr style="color: #00a0dd;border: solid;margin: 0px"/>
                <table class="table table-striped table-bordered table-condensed">
                    <tr>
                        <td class="tit" width="70px">停保原因:</td>
                        <td width="160px" id="AAE160_SELECT">
                            <select name="AAE160" class="input-large required" style="width:160px" >
                                <option value="" >请选择</option>
                                <c:forEach items="${fns:getDictList('AAE160_6')}" var="item">
                                    <option value="${item.value}" ${item.value==category?'selected':''}>${item.label}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td class="tit" width="70px">停保日期:</td>
                        <td width="160px">
                            <input type="text" id="cdate" name="cdate" readonly maxlength="10" style="width:145px;"
                                   class="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'%y-{%M-3}-%d'});"/>
                        </td>
                    </tr>
                </table>
                <div style="text-align: center">
                    <input id="btnSubmit" class="btn btn-primary" type="button" onclick="return checkChoose()"
                           value="确认停保"
                           title="选择要停保的人员后点击此按钮"/>
                </div>
            </div>
        </c:if>
    </form:form>
</div>
</body>
</html>
