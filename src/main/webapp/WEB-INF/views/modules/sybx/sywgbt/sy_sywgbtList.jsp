<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
    <title>稳岗补贴</title>
    <script >
        $(document).ready(function() {
            $("#inputForm").validate({
                submitHandler: function(form){
                    form.submit();
                },
                rules:{
                    BJB003:{required:true},
                    BJC408:{required:true},
                    BJC409:{required:true,remote:{url: "${ctx}/sybx/sywgbt/web_sywgbt/validatePerson",type: "post",dataType: "json"}},
                    BJC410:{required:true,remote:{url: "${ctx}/sybx/sywgbt/web_sywgbt/validateGrant",type: "post",dataType: "json"}}
                },
                messages:{
                    BJB003:{required:"此项为必选项"},
                    BJC408:{required:"此项为必选项"},
                    BJC409:{required:"此项为必选项",remote:"超过职工人数"},
                    BJC410:{required:"此项为必选项",remote:"补贴超过上限"}
                }
            });
        });
        $(function () {
            var flog = false;
            if(checkBAA008()){
                $("#BAA008").css("color", "red");
                flog = true;
            }
            if(checkAAB019()){
                $("#AAB019").css("color", "red");
                flog = true;
            }
            if(flog){
                $("#sub").addClass("active");
                $("#sub").attr("disabled", "true");
                $("#info").html("不满足申请条件");
            }else{
                $("#sub").addClass("btn-primary");
            }
        });

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
    <li class="active"><a href="${ctx}/sybx/sywgbt/web_sywgbt/">稳岗补贴申请</a></li>
</ul>
<sys:message content="${message}"/>
<form id="searchForm" class="breadcrumb form-search " enctype="multipart/form-data">
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
            <input type="text"  class="input-medium moneyNum" value="${lastMoney.grant}" readonly>
        </li>
        <li>
            <label>补贴比例：</label>
            <input type="text"  class="input-medium" value="50%" readonly>
        </li>
    </ul>
</form>
<form:form  id="inputForm" modelAttribute="syWgbt" action="${ctx}/sybx/sywgbt/web_sywgbt/form" method="post" cssClass="breadcrumb form-search">
    <ul  class="ul-form">
        <c:if test="${unit.AAB019!=10||unit.BAA008!=1||lastMoney.num!=12}">
        <li>
            <div style="color: red;font-weight: bold;" id="info" >不满足申请条件<c:if test="${lastMoney.num!=12}">,上年缴费必须满12个月</c:if></div>
        </li>
        </c:if>
        <c:if test = "${msg!=null}">
            <li>
                <div style="color: red;font-weight: bold;" >${msg}</div>
            </li>
        </c:if>

    </ul>
    <c:if test="${SAA043!='预审'}">
        <ul class="ul-form">
            <li>
                <label>补贴类别：</label>
                <form:select path="BJB003" class="input-large required" cssStyle="width:160px" >
                    <form:option value="" label="请选择"/>
                    <form:options items="${fns:getDictList('BJB003_X')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select><span class="help-inline"><font color="red">*</font> </span>
            </li>
            <li>
            <label>补贴项目：</label>
            <form:select path="BJC408" class="input-large required" cssStyle="width:160px" >
                <form:option value="" label="请选择"/>
                <form:options items="${fns:getDictList('SYBT_TYPE')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select><span class="help-inline"><font color="red">*</font> </span>
            </li>
            <li>
                <label>补贴人数：</label>
                <form:input path="BJC409" class="input-large required" cssStyle="width:160px" placeholder="不能超过上年末职工人数"/><span class="help-inline"><font color="red">*</font> </span>
            </li>
            <li>
                <label>补贴总额：</label>
                <form:input path="BJC410" class="input-large required " cssStyle="width:160px" placeholder="不能超过补贴上限"/><span class="help-inline"><font color="red">*</font> </span>
            </li>
            <li>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" class="btn" id="sub" value="申请" <%--<c:if test="${unit.AAB019!=10||unit.BAA008!=1||lastMoney.num!=12}">disabled</c:if>--%>>
            </li>
        </ul>
    </c:if>
</form:form>

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
            <td>${fns:getDictLabel(wg.bjB003,'BJB003_X',"")}</td>
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
        var aae002 = $("#AAE002").val();
        if (aae002 == null || aae002 == "") {
            $.jBox.tip("请输入申报年份");
            return false;
        }
        var bjb003 = $("#BJB003").val();
        if (bjb003 == null || bjb003 == "") {
            $.jBox.tip("补贴类别");
            return false;
        }
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
