<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <title>网上办事单位修改信息查询</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function() {

        });
        function page(n,s){
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<form:form id="searchForm" modelAttribute="pm_ab01View" action="${ctx}/lsywsl/web_lsywsl/info" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <input id="SAA036" name="SAA036" type="hidden" value="${SAA036}">
    <input id="SAA015" name="SAA015" type="hidden" value="${SAA015}">
    <ul class="ul-form">
        <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核结果:&nbsp;
            <form:select path="TAA103" cssStyle="width:158px" >
                <form:option value="" label="请选择"/>
                <form:options items="${fns:getDictList('TAA103_3')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            </form:select></li>
        <li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<br>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>申报流水号</th>
        <th>组织机构代码</th>
        <th>单位编号</th>
        <th>法定代表人姓名</th>
        <th>法定代表人身份证号码</th>
        <th>单位类型</th>
        <th>经济类型</th>
        <th>申请时间</th>
        <th>审核结果</th>
        <th>拒绝原因</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="ab01">
        <tr>
            <td>
                    ${ab01.BAE941}
           </td>
            <td>
                    ${ab01.AAB003}
            </td>
            <td>
                    ${ab01.AAB001}
            </td>
            <td>
                    ${ab01.AAB013}
            </td>
            <td>
                    ${ab01.AAB014}
            </td>
            <td>
                    ${fns:getDictLabel(ab01.AAB019,"AAB019_3","")}
            </td>
            <td>
                    ${fns:getDictLabel(ab01.AAB020,"AAB020_3","")}
            </td>
            <td>
                    ${ab01.TAA101}
            </td>
            <td>
                    ${fns:getDictLabel(ab01.TAA103,"TAA103_3","")}
            </td>
            <td>
                    ${ab01.TAA104}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination" align="right"><input  class="btn btn-primary" type="button"  value="返回" onclick="history.go(-1);"/></div>
<div class="pagination">${page}</div>
    </body>
</html>