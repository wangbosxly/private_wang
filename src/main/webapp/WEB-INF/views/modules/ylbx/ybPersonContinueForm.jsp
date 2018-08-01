<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>人员续保登记</title>
    <meta name="decorator" content="default"/>
    <script>
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

        function checkAAC003Value() {
            var aac001_str = document.getElementById("AAC001").value;
            var aac003_str = document.getElementById("AAC003").value;
            var aac002_str = document.getElementById("AAC002").value;
            if (aac001_str === '' && aac002_str === '' && aac003_str === '') {
                top.$.jBox.tip("个人编号|身份证|姓名必须填写一项!");
                return false;
            }
        }

        function checkChoose() {
            //jquery方法
            var options = $("#ywlx option:selected");  //获取选中的项
            //js原生校验
            var strAAC001 = document.getElementsByName("AAC001S");
            var objarrayAAC001 = strAAC001.length;
            var chestrAAC001 = "";
            var num = 0;
            for (i = 0; i < objarrayAAC001; i++) {
                if (strAAC001[i].checked == true) {
                    chestrAAC001 += strAAC001[i].value;
                    num += 1;
                }
            }
            if (chestrAAC001 == "") {
                top.$.jBox.tip("请选择【人员信息】");
                return false;
            }
            if (num > 1) {
                top.$.jBox.tip("每次只能操作一条数据,不允许批量操作");
                return false;
            }
            if ($("#AAE160").val() == "" || $("#AAE160").val() == null) {
                top.$.jBox.tip("请选择【续保原因】");
                return false;
            }
            if ($("#AAE035").val() == "" || $("#AAE035").val() == null) {
                top.$.jBox.tip("请选择【续保日期】");
                return false;
            }
            top.$.jBox.confirm("您确认对已选中人员进行续保操作？", "系统提示", function (v, h, f) {
                if (v == "ok") {
                    $("#secondForm").submit();

                }
            }, {buttonsFocus: 1});
            top.$('.jbox-body .jbox-icon').css('top', '55px');
        }
        function uploadValidate() {
            if ($("#AAE160").val() == "" || $("#AAE160").val() == null) {
                top.$.jBox.tip("请选择【续保原因】");
                return false;
            }
            if ($("#AAE035").val() == "" || $("#AAE035").val() == null) {
                alert("请选择续保日期");
                return false;
            }
            var options = $("#ywlx option:selected");  //获取选中的项
            if ($("#file").val() == "" || $("#file").val() == null) {
                top.$.jBox.tip("您选择批量上传时，请选择要上传的文件.");
                return false;
            }
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
        function eligibleExp() {
            // 导出不合格人员
            var f = document.getElementById('queryForm');
            f.action = "${ctx}/ylbx/ybPersonContinue/eligibleExp";
            f.submit();
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/ylbx/ybPersonContinue/form">人员续保登记</a></li>
</ul>
<form:form id="queryForm" modelAttribute="ybPerson" action="${ctx}/ylbx/ybPersonContinue/list" method="post"
           class="breadcrumb form-search ">
    <input type="hidden" name="AAC031" value="2">
    <input type="hidden" name="AAE140" value="3">
    <input type="hidden" name="SAA015" value="M3005">
    <ul class="ul-form">
        <li><label style="width: auto">个人编号：</label>
            <form:input path="AAC001" htmlEscape="false" maxlength="15" class="input-medium"/>
        </li>
        <li><label style="width: auto">公民身份号码：</label>
            <form:input path="AAC002" htmlEscape="false" maxlength="180" class="input-medium"/>
        </li>
        <li><label style="width: auto">姓名：</label>
            <form:input path="AAC003" htmlEscape="false" maxlength="20" class="input-medium"/>
        </li>
        <li>&nbsp;&nbsp;&nbsp;
            <input id="query" class="btn btn-primary" type="submit" value="查询" onclick="return checkAAC003Value();"
                   title="根据录入条件查询人员信息"/>
        </li>
        <li>
            <label class="control-label">办理类型：</label>
            &nbsp;&nbsp;&nbsp;<input type=radio name=a onclick="check(true)" checked="checked">单个选择办理
            <input type=radio name=a onclick="check(false)">批量上传办理

    </ul>
</form:form>
<sys:message content="${message}" type="${ctype}"/>
<div id="divD1" style="display:none;">
    <form:form id="searchForm" modelAttribute="ybPerson" enctype="multipart/form-data"
               action="${ctx}/ylbx/ybPersonContinue/fileUpload" method="post" class="breadcrumb form-search"
               onsubmit="return uploadValidate(this)">
        <input type="hidden" name="AAC031" value="2">
        <input type="hidden" name="AAE140" value="3">
        <input type="hidden" name="SAA015" value="M3005">
        <table class="table table-striped table-bordered table-condensed">
            <tr>
                <td width="330px" style="text-align: center">批量续保原因:
                    <form:select path="AAE160" id="AAE160" class="input-large required"
                                 cssStyle="width:160px">
                        <form:option value="" label="请选择" />
                        <form:options items="${fns:getDictList('AAE160_YB_XB')}"
                                      itemLabel="label" itemValue="value" htmlEscape="false" />
                    </form:select>
                </td>
                <td width="330px" style="text-align: center">批量续保日期:
                    <input id="AAE035" name="AAE035" readonly maxlength="10" style="width:145px;"
                           type="text" class="input-medium Wdate required"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'});"/>
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
<c:if test="${pagination.list.size() > 0}">
<form:form id="secondForm" modelAttribute="ybPerson" action="${ctx}/ylbx/ybPersonContinue/submit"
           method="post"
           class="breadcrumb form-search ">
    <input type="hidden" name="AAC031" value="2">
    <input type="hidden" name="AAE140" value="3">
    <input type="hidden" name="SAA015" value="M3005">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="text-align:center;">
            <th colspan="7">可办理续保的人员信息</th>
        </tr>
        <tr>
            <th><input type="checkbox" id="ALL_AAC001" value="${Info.AAC001}" onclick="checkboxValue('AAC001S');"
                       title="全选中或全不选"/></th>
            <th>个人编号</th>
            <th>姓&nbsp;&nbsp;&nbsp;名</th>
            <th>身份证号</th>
            <th>险种类型</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pagination.list}" var="Info">
            <tr>
                <td><input type="checkbox" name="AAC001S" value="${Info.AAC001}&${Info.BAC510}"
                           title="选择操作请点击此复选框"/></td>
                <td>${Info.AAC001}</td>
                <td>${Info.AAC003}</td>
                <td>${Info.AAC002}</td>
                <td>${fns:getDictLabel(Info.AAE140, "AAE140_YB","" )}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        <div>
            <hr style="color: #00a0dd;border: solid;margin: 0px"/>
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <td class="tit" width="70px">续保原因:</td>
                    <td width="160px">
                        <form:select path="AAE160" id="AAE160" class="input-large required"
                                     cssStyle="width:160px">
                            <form:option value="" label="请选择"/>
                            <form:options items="${fns:getDictList('AAE160_YB_XB')}"
                                          itemLabel="label" itemValue="value" htmlEscape="false"/>
                        </form:select>
                        <span class="help-inline"><font color="red">*</font> </span>
                    </td>
                    <td class="tit" width="70px">续保日期:</td>
                    <td width="160px">
                        <input type="text" id="AAE035" name="AAE035" readonly maxlength="10" style="width:145px;"
                               class="input-medium Wdate required"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'});"/>
                        <span class="help-inline"><font color="red">*</font> </span>
                    </td>
                </tr>
            </table>
        </div>
        <div style="text-align: center">
            <input id="btnSubmit" class="btn btn-primary" type="button" onclick="return checkChoose()"
                   value="确认续保"
                   title="选择要续保的人员后点击此按钮"/>
        </div>
</form:form>
</c:if>
</div>
<c:if test="${not empty errorListShow}">
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="text-align:center;">
            <th colspan="7">批量操作保存失败人员信息</th>
        </tr>
        <tr>
            <th>受理单号</th>
            <th>个人编号</th>
            <th>公民身份号码</th>
            <th>姓名</th>
            <th>申报时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${errorList}" var="info">
            <tr>
                <td>${info.SAA036}</td>
                <td>${info.AAC001}</td>
                <td>${info.AAC002}</td>
                <td>${info.AAC003}</td>
                <td>${info.TAA101}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="text-align: center">
        <input id="btnExport" class="btn btn-primary" type="button" onclick="return eligibleExp()"
               value="导出数据"
               title="导出批量操作错误人员信息"/>
    </div>
</c:if>
</body>
</html>
