<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>社保人员基本信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<shiro:hasPermission name="nwws:personBasicInfo:edit"><li><a href="${ctx}/nwws/personBasicInfo/list">社保人员基本信息列表</a></li></shiro:hasPermission>
		<shiro:hasPermission name="nwws:personBasicInfo:edit"><li><a href="${ctx}/nwws/personBasicInfo/joiningList">异常信息列表</a></li></shiro:hasPermission>
		<li class="active"><a href="${ctx}/nwws/personBasicInfo/form?id=${personBasicInfo.id}">社保人员基本信息查询成功<shiro:hasPermission name="nwws:personBasicInfo:edit">${not empty personBasicInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="nwws:personBasicInfo:edit">查看</shiro:lacksPermission></a></li>
		<shiro:hasPermission name="nwws:personBasicInfo:edit"><li><a href="${ctx}/nwws/personBasicInfo/wage">社保人员缴费工资申报</a></li></shiro:hasPermission>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="personBasicInfo" action="${ctx}/nwws/personBasicInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">公民身份号码：</label>
			<div class="controls">
				<form:input path="aac002" htmlEscape="false" maxlength="18" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<form:input path="aac003" htmlEscape="false" maxlength="20" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出生日期：</label>
			<div class="controls">
				<input id="aac006"  name="aac006"  type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
				value="${personBasicInfo.aac006}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">性别：</label>
			<div class="controls">
				<form:select path="aac004" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AAC004')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">参加工作日期：</label>
			<div class="controls">
				<input id="aac007"  name="aac007"  type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
				value="${personBasicInfo.aac007}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">民族：</label>
			<div class="controls">
				<form:select path="aac005" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AAC005')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">户口性质：</label>
			<div class="controls">
				<form:select path="aac009" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AAC009')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">人员状态：</label>
			<div class="controls">
				<form:select path="aac008" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AAC008')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">参保人员类别：</label>
			<div class="controls">
				<form:select path="akc021" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AKC021')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">缴费工资：</label>
			<div class="controls">
				<form:input path="aac040" htmlEscape="false" maxlength="20" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">公务员类别：</label>
			<div class="controls">
				<form:select path="bac515" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('BAC515')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">医疗照顾人员标志：</label>
			<div class="controls">
				<form:select path="akc401" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AKC401')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">非公务员是否参加公务员统筹：</label>
			<div class="controls">
				<form:select path="bkc281" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('BKC281')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">婚姻状况：</label>
			<div class="controls">
				<form:select path="aac017" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AAC017')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用工形式：</label>
			<div class="controls">
				<form:select path="aac013" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AAC013')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工种信息：</label>
			<div class="controls">
				<form:input path="aac121" htmlEscape="false" maxlength="20" class="input-xlarge "/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工作车间：</label>
			<div class="controls">
				<form:input path="aac122" htmlEscape="false" maxlength="20" class="input-xlarge "/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">个人身份：</label>
			<div class="controls">
				<form:select path="aac012" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AAC012')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地址：</label>
			<div class="controls">
				<form:textarea path="aae006" htmlEscape="false" rows="4" maxlength="100" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮政编码：</label>
			<div class="controls">
				<form:input path="aae007" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮件地址：</label>
			<div class="controls">
				<form:input path="bac501" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">户口所在地：</label>
			<div class="controls">
				<form:textarea path="aac010" htmlEscape="false" rows="4" maxlength="100" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系电话：</label>
			<div class="controls">
				<form:input path="aae005" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">文化程度：</label>
			<div class="controls">
				<form:select path="aac011" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('AAC011')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="nwws:personBasicInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>