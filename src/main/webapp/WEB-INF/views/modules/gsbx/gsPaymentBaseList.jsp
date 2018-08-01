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
        $(document).ready(function() {
            //$("#name").focus();
            $("#secondForm").validate({
                submitHandler: function(form){
                    //loading('正在提交，请稍等...');
                    form.submit();
                },
                rules:{
                    //社平工资验证
                    list:{required:true,remote:{url: "${ctx}/gsbx/gsPersonNew/isRight",type: "post",dataType: "json"}}

                },
                messages:{
                    list:{required:"必填项",remote:"缴费基数不符合要求"}
                }
            });
        });
        function checkRight(money) {
            var bac504 = $("#salary").html();
            var baa151 = $("#salary1").html();
            if(!money){
                $("#listmessage").html("必填项");
                return false
            }else if(bac504==="请刷新"){
                $("#listmessage").html("获取社平工资失败");
                return false;
            }else if(parseFloat(money)<parseFloat(bac504)) {
                $("#listmessage").html("申报基数不能低于社平工资：" + bac504);
                return false;
           }else if(parseFloat(money)>parseFloat(baa151)){
                $("#listmessage").html("申报基数不能高于社平工资3倍：" + baa151);
                return false;
           }
            $("#listmessage").html("");
            return true;
        }
        $(function () {
            var url = "${ctx}/gsbx/gsPersonNew/salary";
            $.post(url,function (date) {
                if(date){
                    $("#salary").html(date.BAC504);
                    $("#salary1").html(date.BAA151);
                }else{
                    $("#salary").html("请刷新");
                }
            })
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

        function checkInfo(){
            var aac001 = $("#AAC001").val();
            var AAC002 = $("#AAC002").val();
            if(aac001==""&&AAC002==""){
                top.$.jBox.tip("个人编号与身份证号必须填写一项!");
                return false;
            }
        }

        function checkChoose() {
            //jquery方法
            var options = $("#ywlx option:selected");  //获取选中的项
            //js原生校验
            var strAAC001 = document.getElementsByName("AAC001");
            var objarrayAAC001 = strAAC001.length;
            var chestrAAC001 = "";
            for (i = 0; i < objarrayAAC001; i++) {
                if (strAAC001[i].checked == true) {
                    chestrAAC001 += strAAC001[i].value;
                }
            }
            if (chestrAAC001 == "") {
                top.$.jBox.tip("请选择申报人员信息");
                return false;
            }
            var money = $("#list").val();
            if(!checkRight(money)){
                top.$.jBox.tip("缴费基数不合法");
                return false;
            }
            top.$.jBox.confirm("您确认对已选中人员进行基数申报操作？", "系统提示", function (v, h, f) {
                if (v == "ok") {
                    $("#secondForm").attr("action","${ctx}/gsbx/gsPaymentBase/submit");
                    $("#secondForm").submit();
                }
            }, {buttonsFocus: 1});
            top.$('.jbox-body .jbox-icon').css('top', '55px');
        }
        function page(n,s){
            if(n) $("#pageNo").val(n);
            if(s) $("#pageSize").val(s);
            $("#secondForm").attr("action","${ctx}/gsbx/gsPaymentBase/sblist");
            loading('正在提交，请稍等...');
            $("#secondForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gsbx/gsPaymentBase/sbform">人员缴费基数申报</a></li>
</ul>
<sys:message content="${message}" type="${ctype}"/>
<form:form id="searchForm" modelAttribute="gsPaymentBase" action="${ctx}/gsbx/gsPaymentBase/sblist"
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
                                                                maxlength="50" class="input-medium"/>
                <label>险&nbsp;&nbsp;&nbsp;种：</label><form:select path="AAE140" >
                    <form:option value="4">工伤保险</form:option>
                    <form:option value="5">生育保险</form:option>
                </form:select>
                <label class="control-label">业务办理类型：</label>
                &nbsp;&nbsp;&nbsp;<input type=radio name=a onclick="check(true)" checked="checked">单个选择办理
                <input type=radio name=a onclick="check(false)">批量上传办理
                <input id="query" class="btn btn-primary" type="submit" value="查询" onclick="return checkInfo()"
                       title="根据录入条件查询人员信息"/>

               <%-- <c:if test="${fn:length(pagination.list)>0}">
                        <input  class="btn btn-primary" type="button" value="下载" onclick="download()"
                                title="下载人员缴费基数信息"/>
                </c:if>--%>
            </div>
        </div>
    </ul>
</form:form>
<div id="divD2" style="display:block;">
<form id="secondForm"  action="${ctx}/gsbx/gsPaymentBase/submit"
      method="post" class="breadcrumb form-search ">
    <%-- <c:if test="${pm_ac01view.BAC808 != 'noDisplayPageInfo'}"><div class="pagination">${pagination}</div></c:if> --%>
    <input id="pageNo" name="pageNo" type="hidden" value="${pagination.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${pagination.pageSize}"/>
    <input id="rmb" name="rmb" type="hidden" value="${rmb}"/>
    <table id="contentTable" class="table table-striped table-bordered table-condensed">
        <thead>
        <tr style="text-align:center;">
            <th colspan="8">人员参保信息</th>
        </tr>
        <tr>
            <th><input type="checkbox" id="ALL_AAC001" value="${xb.AAC001}" onclick="checkboxValue('AAC001');"
                       title="全选中或全不选"/></th>
            <th>个人编号</th>
            <th>单位编号</th>
            <th>姓&nbsp;&nbsp;&nbsp;名</th>
            <th>身份证号</th>
            <th>险种类型</th>
            <th>缴费基数</th>
            <%--<th>个人身份</th>
            <th>缴费比例类别</th>
            <th>个人缴费基数</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pagination.list}" var="xb" varStatus="xbStatus">
            <tr>
                <td><input type="checkbox" name="AAC001" value="${xb.AAC001}&${xb.AAE140}"
                           title="选择操作请点击此复选框"/></td>
                <td>${xb.AAC001}</td><input type="hidden" name="list[${xbStatus.index}].AAC001" value="${xb.AAC001}" />
                <td>${xb.AAB001}</td>
                <td>${xb.AAC003}</td>
                <td>${xb.AAC002}</td><input type="hidden" name="list[${xbStatus.index}].AAC002" value="${xb.AAC002}" />
                <td>${fns:getDictLabel(xb.AAE140, "AAE140_5","" )}</td><input type="hidden" name="list[${xbStatus.index}].AAE140" value="${xb.AAE140}" />
                <td style="width: 20%"><input type="number" name="list[${xbStatus.index}].BAC504" onblur="checkRight(this.value)" id = "list"/><label style="color: red ;font-weight: bold;" id="listmessage"></label></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${pagination}</div>
    <c:if test="${fn:length(pagination.list)> 0}">
        <div>
            <hr style="color: #00a0dd;border: solid;margin: 0px"/>
            <div style="text-align: center">
                <br>
                <input id="btnSubmit" class="btn btn-primary" type="button" value="申报基数"
                       onclick="return checkChoose()" title="填写基数并选择后点击申报"/>
            </div>
        </div>
    </c:if>

</form>
</div>
<div id="divD1" style="display:none;">
<form  action="${ctx}/gsbx/gsPaymentBase/upload" enctype="multipart/form-data"
      method="post" class="breadcrumb form-search ">
    <br>
    <div style="text-align: center">
    上传文件：<input id="file" name="file" type="file"/>
    <input type="submit" class="btn btn-primary" title="批量上传办理续保业务请点击此按钮" value="确认上传"/>
    </div>
</form>
</div>
<form class="breadcrumb form-search">
    <div style="color: red;font-weight: bold;">备注：</div>
    <div style="color: red;font-weight: bold;">1.当年已经申报过基数的人员无法再次申报</div>
    <div style="color: red;font-weight: bold;">2.批量操作时先下载往年申报基数表，按照申报数据重新填写上传即可</div>
   <%-- <div style="color: red;font-weight: bold;">3.申报基数不能低于<span id="salary"></span>，不能高于<span id="salary1"></span>。</div>--%>
    <div style="color: red;font-weight: bold;">3.申报的基数不能低于社平工资（<span id="salary" style="color: blue"></span>）或高于社平工资3倍（<span id="salary1" style="color: blue"></span>）。</div>
</form>
</body>
</html>
