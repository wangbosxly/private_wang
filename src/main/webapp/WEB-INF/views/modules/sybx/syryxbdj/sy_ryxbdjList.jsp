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
            //jquery方法
            var options = $("#ywlx option:selected");  //获取选中的项
            var strAAC001 = document.getElementsByName("AAC001");
            /*var strAAC012 = document.getElementsByName("AAC012");
            var strAAA040 = document.getElementsByName("AAA040");
            var strAAC040 = document.getElementsByName("AAC040");*/
            var objarrayAAC001 = strAAC001.length;
            var chestrAAC001 = "";
            /*var chestrAAC012 = "";
            var chestrAAA040 = "";
            var chestrAAC040 = "";*/
            /*if (!moneyFlag) {
                top.$.jBox.tip("个人缴费基数校验失败");
                return false;
            }*/
            for (i = 0; i < objarrayAAC001; i++) {
                if (strAAC001[i].checked == true) {
                    //由于checkbox 有21个 其余20个 故下标减一
                    chestrAAC001 += strAAC001[i].value;
                    /*chestrAAC012 += strAAC012[i-1].value + ",";
                    chestrAAA040 += strAAA040[i-1].value + ",";
                    chestrAAC040 += strAAC040[i-1].value + ",";*/
                }
            }
            if (chestrAAC001 == "") {
                top.$.jBox.tip("请选择预办理续保业务的【人员信息】");
                return false;
            } /*else {
                chestrAAC012 = chestrAAC012.substring(0, chestrAAC012.length-1);
                chestrAAA040 = chestrAAA040.substring(0, chestrAAA040.length-1);
                chestrAAC040 = chestrAAC040.substring(0, chestrAAC040.length-1);
            }*/
            if ($("#cdate").val() == "" || $("#cdate").val() == null) {
                top.$.jBox.tip("请选择续保日期.");   //拿到选中项的值
                return false;
            }
            top.$.jBox.confirm("您确认对已选中人员进行续保操作？", "系统提示", function (v, h, f) {
                if (v == "ok") {
                    var f = $("#secondForm");
                    <%--var url = "${ctx}/sybx/syryxbdj/web_syryxbdj/submit?chestrAAC012=" + chestrAAC012 + "&chestrAAA040=" + chestrAAA040 + "&chestrAAC040=" + chestrAAC040;--%>
                    var url = "${ctx}/sybx/syryxbdj/web_syryxbdj/submit";
                    f.attr("action", url);
                    f.submit();
                }
            }, {buttonsFocus: 1});
            top.$('.jbox-body .jbox-icon').css('top', '55px');

        }

        //页面加载完光标自动定位在AAC003
        window.onload = function () {
            var oInput = document.getElementById("AAC002");
            oInput.focus();
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
                },
            });
        });

        function uploadValidate() {
            if ($("#file").val() == "" || $("#file").val() == null) {
                top.$.jBox.tip("请选择要上传的文件.", "error", "");
                return false;
            }
            if ($("#cdatepl").val() == "" || $("#cdatepl").val() == null) {
                top.$.jBox.tip("请选择续保日期.");   //拿到选中项的值
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
            $("#secondForm").attr("action", "${ctx}/sybx/syryxbdj/web_syryxbdj/list");
            $("#secondForm").submit();
            return false;
        }
        function checkAAC003Value() {
            var aac001_str = document.getElementById("AAC001").value;
            var aac003_str = document.getElementById("AAC003").value;
            var aac002_str = document.getElementById("AAC002").value;
            if (aac001_str === '' && aac002_str === '' && aac003_str === '') {
                top.$.jBox.tip("个人编号|身份证号|姓名必须填写一项!");
                return false;
            }
            return true;
        }
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
        var moneyFlag = true;
        function isMoney(obj){
            moneyFlag = true;
            var mny =  /^\d+\.?\d*$/;
            var value = obj.value;
            var bac504 = document.getElementById('rmb').value;
            var max = bac504*3;
            var min = (bac504*0.6).toFixed(2);
            //验证缴费工资
            if(!mny.test(value)){
                obj.value="0.00";
                top.$.jBox.tip("缴费工资格式不正确，请重新输入!");
                moneyFlag = false;
            } else if (parseInt(value)>parseInt(max)){
                top.$.jBox.tip("缴费基数上限为"+max);
                moneyFlag = false;
            } else if (parseInt(value)<parseInt(min)) {
                top.$.jBox.tip("缴费基数下限为" + min);
                moneyFlag = false;
            }
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/sybx/syryxbdj/web_syryxbdj">人员续保登记</a></li>
</ul>
<form:form id="searchForm" modelAttribute="pm_ac01view" action="${ctx}/sybx/syryxbdj/web_syryxbdj/searchXbInfo"
           method="post" class="breadcrumb form-search ">
    <ul class="ul-form">
        <div class="control-group">
            <div class="controls">
                <label>个人编号：</label><form:input id="AAC001" path="AAC001" htmlEscape="false" maxlength="50"
                                                class="input-medium"/>
                <label>姓&nbsp;&nbsp;&nbsp;名：</label><form:input id="AAC003" path="AAC003" htmlEscape="false"
                                                                maxlength="50" class="input-medium"/>
                <label>身份证号：</label><form:input id="AAC002" path="AAC002" htmlEscape="false" maxlength="18"
                                                class="input-medium"/>
                <input id="query" class="btn btn-primary" type="submit" value="查询" title="根据录入条件查询人员信息"
                       onclick="return checkAAC003Value();"/>
                <label class="control-label">业务办理类型：</label>
                <input type=radio name=a onclick="check(true)" checked="checked">单个选择办理
                <input type=radio name=a onclick="check(false)">批量上传办理
            </div>
        </div>
    </ul>
</form:form>
<sys:message content="${message}"/>
<div id="divD1" style="display:none;">
    <form:form id="searchForm" modelAttribute="pm_ac01view" enctype="multipart/form-data"
               action="${ctx}/sybx/syryxbdj/web_syryxbdj/importExcel" method="post" class="breadcrumb form-search"
               onsubmit="return uploadValidate(this)">
        <table class="table table-striped table-bordered table-condensed">
            <tr>
                <td width="330px" style="text-align: center">续保原因:
                    <select id="ywlx_p" name="AAE160">
                        <option value="121">在职人员续保</option>
                        <option value="839">其他原因</option>
                    </select>
                </td>
                <td width="330px" style="text-align: center">批量续保日期:
                    <input type="text" id="cdatepl" name="cdate" readonly maxlength="10" style="width:145px;"
                           lass="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'%y-{%M-3}-%d'});"/>
                </td>
            </tr>
            <tr>
                <td style="text-align: center" colspan="2">上传文件:
                    <input id="file" name="file" type="file"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" class="btn btn-primary" title="批量上传办理续保业务请点击此按钮" value="确认上传"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<div id="divD2" style="display:block;">
    <form id="secondForm"  action=""
               method="post" class="breadcrumb form-search ">
        <%-- <c:if test="${pm_ac01view.BAC808 != 'noDisplayPageInfo'}"><div class="pagination">${pagination}</div></c:if> --%>
        <input id="pageNo" name="pageNo" type="hidden" value="${pagination.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${pagination.pageSize}"/>
        <input id="rmb" name="rmb" type="hidden" value="${rmb}"/>
        <table id="contentTable" class="table table-striped table-bordered table-condensed">
            <thead>
            <tr style="text-align:center;">
                <th colspan="8">可办理续保的人员信息</th>
            </tr>
            <tr>
                <th><input type="checkbox" id="ALL_AAC001" value="${xb.AAC001}" onclick="checkboxValue('AAC001');"
                           title="全选中或全不选"/></th>
                <th>个人编号</th>
                <th>单位编号</th>
                <th>姓&nbsp;&nbsp;&nbsp;名</th>
                <th>身份证号</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pagination.list}" var="xb">
                <tr>
                    <td><input type="checkbox" name="AAC001" value="${xb.AAC001}#${xb.AAA040}*${xb.AAC002}"
                               title="选择操作请点击此复选框"/></td>
                    <td>${xb.AAC001}</td>
                    <td>${xb.AAB001}</td>
                    <td>${xb.AAC003}</td>
                    <td>${xb.AAC002}</td>
                </tr>
            </c:forEach>
            <c:if test="${pm_ac01view.AAE011 == 'displayInfo'}">
                <tr align="center">
                    <td colspan="5">
                        <div align="center" style="color: red;font-weight: bold;">未查询到符合条件的记录，请确认您输入的查询条件.</div>
                    </td>
                </tr>
            </c:if>
            <c:if test="${pm_ac01view.AAC058 == 'noDataDisplayInfo'}">
                <tr align="center">
                    <td colspan="5">
                        <div align="center" style="color: red;font-weight: bold;">请联系系统维护人员，检查失业接口.</div>
                    </td>
                </tr>
            </c:if>
            </tbody>
        </table>
        <c:if test="${pm_ac01view.BAC808 != 'noDisplayPageInfo'}">
            <div class="pagination">${pagination}</div>
        </c:if>
        <c:if test="${pm_ac01view.BAC801 == 'displayButton'}">
            <div>
                <hr style="color: #00a0dd;border: solid;margin: 0px"/>
                <table class="table table-striped table-bordered table-condensed">
                    <tr>
                        <td class="tit" width="70px">续保原因:</td>
                        <td width="160px">
                            <select id="ywlx" name="AAE160">
                                <option value="121">在职人员续保</option>
                                <option value="839">其他原因</option>
                            </select>
                        </td>
                        <td class="tit" width="70px">续保日期:</td>
                        <td width="160px">
                            <input type="text" id="cdate" name="cdate" readonly maxlength="10" style="width:145px;"
                                   class="input-medium Wdate required" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'%y-{%M-3}-%d'});"/>
                        </td>
                    </tr>
                </table>
                <div style="text-align: center">
                    <input id="btnSubmit" class="btn btn-primary" type="button" value="确认续保"
                           onclick="return checkChoose()" title="选择要续保的人员后点击此按钮"/>
                </div>
            </div>
        </c:if>
    </form>
</div>
</body>
</html>
