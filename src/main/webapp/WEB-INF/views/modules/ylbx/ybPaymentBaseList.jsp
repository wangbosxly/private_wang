<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script type="text/javascript" src="http://hovertree.com/ziyuan/jquery/jquery-1.12.0.min.js"></script>
<meta name="decorator" content="default"/>
<html>
<head>
    <title>缴费基数申报</title>
    <!-- 改变行和列的颜色  begin -->
    <!--
    <style>
        .hovertreeClass a {
            color: black;
            text-decoration: none;
        }
        td.hewenqi, tr.hewenqi {
            background: #f0f0f0;
            background-color: #D4FFFF;
        }
        table.hovertreeClass {
            border-collapse: collapse;
            width: 100%;
        }
        .hovertreeClass td, th {
            border: solid #000000 1px;
        }
    </style>
    <script type="text/javascript">
    $(document).ready(function () {
        var hover_index = 0;
        $("table.hovertreeClass td").hover(function () {
            hover_index = $(this).parent().find('td').index(this);
            $("table.hovertreeClass tr").find("td:eq(" + hover_index + ")").addClass("hewenqi");
            $(this).addClass("hewenqi");
        }, function () {
            $("table.hovertreeClass tr").find("td:eq(" + hover_index + ")").removeClass("hewenqi");
            $(this).removeClass("hewenqi");
        });

        $("table.hovertreeClass tbody tr").hover(function () {
            $(this).addClass("hewenqi");
        }, function () {
            $(this).removeClass("hewenqi");
        });
    });
    </script>
    -->
    <!-- 改变行和列的颜色 end -->


    <script type="text/javascript">
        //第一个方法
        function cli(Obj)
        {
            var collid = document.getElementById("ids")
            var coll = document.getElementsByName(Obj)
            if (collid.checked){
                for(var i = 0; i < coll.length; i++){
                    coll[i].checked = true;
                }
            }else{
                for(var i = 0; i < coll.length; i++){
                    coll[i].checked = false;
                }
            }
        }
        //第二个方法
        function checkChooseAAC001(){
            var strAAC001=document.getElementsByName("ids");
            var objarrayAAC001=strAAC001.length;
            var chestrAAC001="";
            for (i=0;i<objarrayAAC001;i++){
                if(strAAC001[i].checked == true)
                {
                    chestrAAC001+=strAAC001[i].value;
                }
            }
            if(chestrAAC001 == ""){
                alert("请选择预办理缴费基数申报的【人员信息】");
                return false;
            }
        }
        //第三个方法
        function page(n,s){
            if(n) {$("#pageNo").val(n)};
            if(s) {$("#pageSize").val(s)};
            $("#searchForm").attr("action","${ctx}/ylgsbx/jfjssb/web_jfjssb/list?user_aae140=${user_aae140}");
            $("#searchForm").submit();
            return false;
        }
        //第四个方法
        function getMoney(obj){
            var mny =  /^\d+\.?\d*$/;
            var value = obj.value;

            //验证缴费工资
            if(!mny.test(value)){
                parm=0;
            }else{
                parm=value;
            }
        }
        function isMoney(obj){
            var mny =  /^\d+\.?\d*$/;
            var value = obj.value;
            var trobj = obj.parentElement.parentElement;
            var inputobj = trobj.children[0].children[0];
            var spgz=document.getElementsByName("spgz");
            var s = spgz[0].value;
            //验证缴费工资
            if(!mny.test(value)){
                obj.value="0.00";
                $(inputobj).prop("checked", false);
                alert("缴费工资格式不正确，请重新输入!");
                return false;
            }else{
                if(parseInt(value)>parseInt(s)){
                    obj.value="0.00";
                    $(inputobj).prop("checked", false);
                    alert("缴费基数上限为"+s);
                }
            }
        }
        function upload(){
            var panskyid = $("#pan001").val();
            var userName = $("#userName").val();
            window.open("http://10.189.129.167:7012/interservice/uploadFileList.do?userName="+userName+"&archiveId="+panskyid);
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="#"><font style="color: #2FA4E7;">缴费基数申报</font></a></li>
    <!--
		<li class="active"><a href="${ctx}/ylgsbx/jfjssb/web_jfjssb/toPage">批量&nbsp;缴费基数申报</a></li>
		 -->
</ul>
<form:form id="searchForm1" modelAttribute="person" action="${ctx}/ylgsbx/jfjssb/web_jfjssb?user_aae140=${user_aae140}" method="post" class="breadcrumb form-search">
    <input id="user_aae140" name="user_aae140" type="hidden" value="${user_aae140}"/>
    <ul class="ul-form">
        <li><label>个人编号：</label>
            <form:input path="AAC001" htmlEscape="false" maxlength="18" class="input-medium"/>
        </li>
        <li><label>身份证号码：</label>
            <form:input path="AAC002" htmlEscape="false" maxlength="18" class="input-medium"/>
        </li>
        <li><label>姓名：</label>
            <form:input path="AAC003" htmlEscape="false" maxlength="20" class="input-medium"/>
        </li>
        <li class="btns">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
        </li>
    </ul>

</form:form>
<form:form id="searchForm" modelAttribute="person" action="${ctx}/ylgsbx/jfjssb/web_jfjssb/submit?user_aae140=${user_aae140}" method="post" class="breadcrumb form-search">
    <input id="user_aae140" name="user_aae140" type="hidden" value="${user_aae140}"/>
    <input id="pageNo" name="pageNo" type="hidden" value="${listInfo.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${listInfo.pageSize}"/>
    <input id="nodeid" name="nodeid" type="hidden" value="${nodeid}"/>
    <input id="pan001" name="pan001" type="hidden" value="${pan001}"/>
    <input id="userName" name="userName" type="hidden" value="${userName}"/>
    <input id="fondsid" name="fondsid" type="hidden" value="${fondsid}"/>
    <c:if test="${not empty message}">
        <div id="messageBox" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
        <script type="text/javascript">if(!top.$.jBox.tip.mess){top.$.jBox.tip.mess=1;top.$.jBox.tip(${message},"success",{persistent:true,opacity:0});$("#messageBox").show();}</script>
    </c:if>
    <table id="tablst" class="table table-hover"><!-- hovertreeClass 光标移动改变行列样式-->
        <thead>
        <tr>
            <th><input type="checkbox" id="ids" name="ids" value="${info.AAC001}" onclick="cli('ids');" title="全选中或全不选"/></th>
            <th>个人编号</th>
            <th>姓&nbsp;&nbsp;&nbsp;名</th>
            <th>出生日期</th>
            <th>身份证号</th>
            <th>单位名称</th>
            <th>经办时间</th>
            <c:if test="${control_text.BKC288 == '3'}"><th style="text-align:center;">医疗缴费基数</th></c:if>
            <c:if test="${control_text.BKC288 == '4'}"><th style="text-align:center;">工伤缴费基数</th></c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listInfo.list}" var="info">
            <tr>
                <td><input type="checkbox"  id="ids" name="ids" value="${info.AAC001}" title="确认申报此人缴费基数请点击此复选框"/></td>
                <td><input type="hidden" name="number" value="${info.AAC001}"/>${info.AAC001}</td>
                <td>${info.AAC003}</td>
                <td>${info.AAC006}</td>
                <td>${info.AAC002}</td>
                <td>${info.AAB004}</td>
                <td><input type="hidden" name="spgz" id ="spgz" value="${info.BAC504}"/>${info.AAE036}</td>
                <td><input name="AAC040" type="text"  value="${info.AAC040}" onfocus="getMoney(this)" onblur="isMoney(this)"  maxlength="8" style="width:60px;margin:0;padding:0;text-align:right;background-color:#D4FFFF;"></td>
            </tr>
        </c:forEach>
        <c:if test="${tempInfo.BAC801 != 'noDisplayInfo'}">
            <tr align="center">
                <td colspan="9"><div align="center" style="color: red;font-weight: bold;">未查询到符合条件的记录.</div></td>
            </tr>
        </c:if>
        <c:if test="${tempInfo.AAB060 == 'noDate'}">
            <tr align="center">
                <td colspan="9"><div align="center" style="color: red;font-weight: bold;font-size:large;">缴费基数申报业务您已办理完毕，请联系中心人员办理审核业务.</div></td>
            </tr>
        </c:if>
        </tbody>
    </table>
    <div class="pagination">${listInfo}</div>
    <c:if test="${tempInfo.AAE011 == 'displayButton'}">
        <table width="100%" border="0" cellspacing="1" cellpadding="0" class="cnlist tablst" bgcolor="#dbedf4">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td colspan="9">
                        <input id="btn" class="btn btn-primary" type ="button" value="上传资料"  onclick="upload();">
                        <input id="btnSubmit" class="btn btn-primary" type="submit" value="批量修改确认" onclick="return checkChooseAAC001()" title="选择要申报的人员后点击此按钮"/>
                        <c:if test="${control_text.BKC288 == '3'}">
                            <input type=text name="money" id="money"  value="请输入定额医疗基数" onfocus="cleanValue(this);" maxlength="8" style="height:28px;width:135px;margin:0;padding:0;text-align:right" title="如果所有人员医疗基数相同，请在此输入框中输入医疗基数定值，点击【按固定值修改医疗基数】按钮.">
                            <input type="button" class="btn btn-primary" style="width:170px;" value="按固定值修改医疗基数"  onclick="updateaac040();"></c:if>
                        <c:if test="${control_text.BKC288 == '4'}">
                            <input type=text name="money" id="money"  value="请输入定额医疗基数" onfocus="cleanValue(this);" maxlength="8" style="height:28px;width:135px;margin:0;padding:0;text-align:right" title="如果所有人员工伤基数相同，请在此输入框中输入医疗基数定值，点击【按固定值修改工伤基数】按钮.">
                            <input type="button" class="btn btn-primary" style="width:170px;" value="按固定值修改医疗基数"  onclick="updateaac040();"></c:if>
                    </td>
                </tr>
            </table>
            <script type="text/javascript">
                function cleanValue(obj){
                    if(obj.value != ""){
                        obj.value = ""};
                }

                function updateaac040(){

                    var value = $('#money').val();
                    var mny =  /^\d+\.?\d*$/;
                    //验证缴费工资
                    if(!mny.test(value)){
                        $('#money').val("");
                        $('#money').focus();
                        alert("请正确输入医疗基数格式，例（0.00）！！！");
                    }else{
                        totalRow = 0;
                        $('#tablst tr').each(function() {
                            $(this).find('td:eq(7)').each(function(){
                                $(this).html('<input name="AAC040" id="AAC040" type="text" onfocus="getMoney(this)" onblur="isMoney(this)"  style="width:60px;margin:0;padding:0;text-align:right;background-color:#D4FFFF;" maxlength="8"  value="'+value+'"/>');
                            });
                        });
                    }
                }
            </script>
        </table>
    </c:if>
</form:form>
<div style="margin:10px;color:red;font-weight:bold;">说明：此功能分为两个步骤完成.1.选择需要申报缴费基数的人员并上传资料。2.待所有人的证件上传完成后点击批量修改确认。</div>
</body>
</html>
