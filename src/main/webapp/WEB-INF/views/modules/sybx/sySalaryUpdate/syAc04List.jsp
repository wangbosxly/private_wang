<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>缴费基数申报</title>
	<meta name="decorator" content="default"/>
    <script type="text/javascript" src="${ctxStatic}/sy.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#searchForm").validate({
				submitHandler: function(form){
					//loading('正在提交，请稍等...');
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
	
	<script type="text/javascript">
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
		 
		 function checkChooseAAC001(){
			 
			var bab808 = document.getElementById('rmb').value;
			var max = bab808*3;
			var min = (bab808*0.6).toFixed(2);
				
			 var tableId = document.getElementById("tablst");
			 
			 var strAAC001=document.getElementsByName("ids");
			 var objarrayAAC001=strAAC001.length;
			 var chestrAAC001="";
			 for (i=0;i<objarrayAAC001;i++){
			   if(strAAC001[i].checked == true)
			   {
				   
				   var aac040 = tableId.rows[i].cells[5].children[0].value;
				   var name = tableId.rows[i].cells[2].innerHTML;
				   if(parseInt(aac040)>parseInt(max)){
						alert(name+"的缴费基数不能超过上限"+max);
						return false;
					} else if (parseInt(aac040)<parseInt(min)){
						alert(name+"的缴费基数不能低于下限"+min);
						return false;
					}
				   chestrAAC001+=strAAC001[i].value;
			   }
			 }
			 if(chestrAAC001 == ""){
				 alert("请选择预办理缴费基数申报的【人员信息】");
				 return false;
			 }
		 }
		 
		 
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
				//验证缴费工资
				if(!mny.test(value)){
					obj.value="0.00";
					$(inputobj).prop("checked", false);
					//obj.focus();
					alert("缴费工资格式不正确，请重新输入!");
				}else{
					var bab808 = document.getElementById('rmb').value;
					var max = bab808*3;
					var min = (bab808*0.6).toFixed(2);
					
					if(parseInt(value)>parseInt(max)){
						obj.value="0.00";
						$(inputobj).prop("checked", false);
						//obj.focus();
						alert("缴费基数上限为"+max);
					} else if (parseInt(value)<parseInt(min)){
						obj.value="0.00";
						$(inputobj).prop("checked", false);
						//obj.focus();
						alert("缴费基数下限为"+min);
					} else {
						totalRow = accSub(totalRow,parm);
						totalRow = accAdd(totalRow,value);
						$('#sumrmb').html(totalRow);
					}
				}
		}
		 
		$(document).ready(function() { 
			$('#tablst tr').each(function() { 
				$(this).find('td:eq(5)').each(function(){ 
					totalRow += parseFloat($(this).text());
					 
				}); 
			}); 
			totalRow = totalRow.toFixed(2);
			if(totalRow==0||totalRow==null||totalRow==undefined){
				$('#sumrmb').val(0);
			}else{
				$('#sumrmb').html(totalRow);
			}
		}); 

		function accAdd(arg1, arg2) { 
		    var r1, r2, m; 
		    try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 } 
		    try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 } 
		    m = Math.pow(10, Math.max(r1, r2)) 
		    return (arg1 * m + arg2 * m) / m 
		} 

		function accSub(arg1, arg2) { 
		    var r1, r2, m, n; 
		    try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 } 
		    try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 } 
		    m = Math.pow(10, Math.max(r1, r2)); 
		    n = (r1 >= r2) ? r1 : r2; 
		    return ((arg1 * m - arg2 * m) / m).toFixed(n); 
		} 
		
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/sybx/sySalaryUpdate/syac04/list");
			$("#searchForm").submit();
	    	return false;
	    }
		
		function uploadValidate() {	
			if($("#file").val()==""||$("#file").val()==null) {
				alert("请选择要上传的文件");
				$("#file").focus();
				return false;
			}
		}
		
	</script>
	
</head>
<body>
	
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sybx/sySalaryUpdate/syac04/list">缴费基数申报</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="syac04" action="${ctx}/sybx/sySalaryUpdate/syac04/save" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>

	
	<c:if test="${not empty message}">
			<div id="messageBox" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div> 
			<script type="text/javascript">if(!top.$.jBox.tip.mess){top.$.jBox.tip.mess=1;top.$.jBox.tip(${message},"success",{persistent:true,opacity:0});$("#messageBox").show();}</script>
		</c:if>
		
	<table id="tablst" class="table table-hover"><!-- table table-striped table-bordered table-condensed -->
	
		<input type="hidden" name="rmb" id="rmb" value="${rmb}"/>
		
		<thead>
			<tr>
				<th><input type="checkbox" id="ids" name="ids" value="${syac04.AAC001}" onclick="cli('ids');" title="全选中或全不选"/></th>
				<th>个人编号</th>
				<th>姓名</th>
				<th>档案出生日期</th>
				<th>公民身份证号</th>
				<th style="text-align:center;">缴费基数</th>

			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="syac04">
		
			<tr>
				<td><input type="checkbox"  id="ids" name="ids" value="${syac04.AAC001}" title="确认申报此人缴费基数请点击此复选框"/></td>
				<td><input type="hidden" name="AAC001" value="${syac04.AAC001}"/>${syac04.AAC001}</td>
				<td>${syac04.AAC003}</td>
				<td>${syac04.BIC701}</td>
				<td>${syac04.AAC002}</td>
				<td style="text-align:center;">
					<input id="AAC040" name="AAC040" type="text" onfocus="getMoney(this)" onblur="isMoney(this)" value="${syac04.AAC040}" maxlength="8" style="background-color:#D4FFFF;width:90px;margin:0;padding:0;text-align:right">
				</td>
		
				
			</tr>
			
			<!--<tr id="totalRow">
									<td></td><td></td><td></td><td></td><td>缴费基数合计</td><td id="sumrmb" style="text-align:left;">0</td>
			</tr> -->
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		按固定值增加：<input type=text name="money1" id="money1" size="16" maxlength="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		按基数的百分比增加：<input type=text name="money2" id="money2" size="16" maxlength="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="btnEdit" class="btn btn-primary" type="button" value="修改" onclick="update(this);" />&nbsp;&nbsp;&nbsp;
		<input id="btnEdit1" class="btn btn-primary" type="button" value="社平工资" onclick="update1();" />&nbsp;&nbsp;&nbsp;
		<input id="btnEdit2" class="btn btn-primary" type="button" value="基数上限" onclick="update2();" />&nbsp;&nbsp;&nbsp;
		<input id="btnEdit3" class="btn btn-primary" type="button" value="基数下限" onclick="update3();" />&nbsp;&nbsp;&nbsp;
	</table>
	<br>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="修改确认" onclick="return checkChooseAAC001()" title="选择要申报的人员后点击此按钮"/>
	</table>
	</form:form>
	<form:form id="importForm" modelAttribute="syac04" action="${ctx}/sybx/sySalaryUpdate/syac04/import" onsubmit="return uploadValidate(this)" enctype="multipart/form-data" method="post" class="breadcrumb form-search">
		<input type="hidden" name="saa015" id="saa015" value="${saa015}"/>
        <input type="hidden" name="saa004" id="saa004" value="${saa004}"/>
        <input type="hidden" name="szz003" id="szz003" value="${szz003}"/>
        <input type="hidden" name="sza023" id="sza023" value="${sza023}"/>
        <input type="hidden" name="sza024" id="sza024" value="${sza024}"/>
        <input type="hidden" name="saa062" id="saa062" value="${saa062}"/>
        <input type="hidden" name="szz046" id="szz046" value="${szz046}"/>
    	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<td colspan="1" class="pn-sp" align="right" >上传文件：</td>
			<td colspan="1" class="pn-sp" align="left" ><input type="file" name="file" id="file"/><input type="submit" class="btn btn-primary" value="批量上传"/></td>
			<td colspan="5" class="pn-sp" align="left" ></td>
		</table>
		<div style="margin:10px;color:red;font-weight:bold;">说明：按固定值增加与按基数的百分比增加只能填写一项,点击修改按钮，修改基数录入。</div>
	</form:form>

	<script type="text/javascript">
            
           function update(obj){
           	
        	var newAAC040 = 0.00;
			var bab808 = document.getElementById('rmb').value;
			var max = bab808*3;
			var min = (bab808*0.6).toFixed(2);
			
			var money1 = document.getElementById('money1').value;
			var money2 = document.getElementById('money2').value;
			
			if(money1 == '' && money2 == ''){
				document.getElementById('money1').value="";
				document.getElementById('money2').value="";
				document.getElementById('money1').focus();
				alert('按固定值增减和按基数的百分比增减不能同时为空，请输入其中一项!');
				return;
			}
			
			if(money1 != '' && money2 != ''){
				document.getElementById('money1').value="";
				document.getElementById('money2').value="";
				document.getElementById('money1').focus();
				alert('按固定值增减和按基数的百分比增减不能同时输入，请输入其中一项!');
				return;
			}
			
			if(money1 !== ''){
				var value = $('#money1').val();
				var mny =  /^\d+\.?\d*$/; //^(\-|\+)?\d+(\.\d+)?$
				//验证缴费工资
				if(!mny.test(value)){
					document.getElementById('money1').value="";
					document.getElementById('money1').focus();
					alert("录入的固定值格式错误，请重新输入!");
				}else{
					//totalRow = 0;
					$('#tablst tr').each(function() { 
						
						var returnFlag = '0';
						
						$(this).find('td:eq(5)').each(function(){ 
							//totalRow = accAdd(totalRow,value);
							
							var strInputText=$(this).children();
							
							var oldAAC040 = strInputText.val();
							newAAC040 = oldAAC040*1 + value*1;

							if(parseInt(newAAC040)>parseInt(max)){
								returnFlag = "1";
							} else if(parseInt(newAAC040)<parseInt(min)){
								returnFlag = "2";
							} else{
								$(this).html('<input name="AAC040" id="AAC040" type="text" onfocus="getMoney(this)" onblur="isMoney(this)" value="'+newAAC040+'" maxlength="8" style="background-color:#D4FFFF;width:90px;margin:0;padding:0;text-align:right"/>');
							}
						}); 
						
						if(parseInt(returnFlag) == 1){
							alert("修改后的缴费基数不能超过上限"+max);
							return false;
						} 
						if (parseInt(returnFlag) == 2){
							alert("修改后的缴费基数不能低于下限"+min);
							return false;
						}

					}); 
					//$('#sumrmb').html(totalRow);
				}
			}
			
			if(money2 !== ''){
				
				var value = $('#money2').val();
				var mny =  /^\d+\.?\d*$/; //^(\-|\+)?\d+(\.\d+)?$
				//验证缴费工资
				if(!mny.test(value)){
					document.getElementById('money2').value="";
					document.getElementById('money2').focus();
					alert("录入的百分比值格式错误，请重新输入!");
				}else{
					//totalRow = 0;
					$('#tablst tr').each(function() { 
						
						var returnFlag = '0';
						
						$(this).find('td:eq(5)').each(function(){ 
							//totalRow = accAdd(totalRow,value);
							
							var strInputText=$(this).children();
							
							var oldAAC040 = strInputText.val();
							newAAC040 = oldAAC040*1 + (oldAAC040 * 1 * value)*1;

							if(parseInt(newAAC040)>parseInt(max)){
								returnFlag = "1";
							} else if(parseInt(newAAC040)<parseInt(min)){
								returnFlag = "2";
							} else{
								$(this).html('<input name="AAC040" id="AAC040" type="text" onfocus="getMoney(this)" onblur="isMoney(this)" value="'+newAAC040+'" maxlength="8" style="background-color:#D4FFFF;width:90px;margin:0;padding:0;text-align:right"/>');
							}
						}); 
						
						if(parseInt(returnFlag) == 1){
							alert("修改后的缴费基数不能超过上限"+max);
							return false;
						} 
						if (parseInt(returnFlag) == 2){
							alert("修改后的缴费基数不能低于下限"+min);
							return false;
						}

					}); 
					//$('#sumrmb').html(totalRow);
				}
			}
           	
		}
            
		function update1(){

			var bab808 = document.getElementById('rmb').value;
			var max = bab808*3;
			var min = (bab808*0.6).toFixed(2);

			totalRow = 0;
			$('#tablst tr').each(function() { 
			$(this).find('td:eq(5)').each(function(){ 
				totalRow = accAdd(totalRow,bab808);
				$(this).html('<input name="AAC040" id="AAC040" type="text" onfocus="getMoney(this)" onblur="isMoney(this)" value="'+bab808+'" maxlength="8" style="background-color:#D4FFFF;width:90px;margin:0;padding:0;text-align:right"/>');
			}); 
			}); 
			$('#sumrmb').html(totalRow);

		}
			
		function update2(){
			
			var bab808 = document.getElementById('rmb').value;
			var max = bab808*3;
			var min = (bab808*0.6).toFixed(2);

			totalRow = 0;
			$('#tablst tr').each(function() { 
			$(this).find('td:eq(5)').each(function(){ 
				totalRow = accAdd(totalRow,max);
				$(this).html('<input name="AAC040" id="AAC040" type="text" onfocus="getMoney(this)" onblur="isMoney(this)" value="'+max+'" maxlength="8" style="background-color:#D4FFFF;width:90px;margin:0;padding:0;text-align:right"/>');
			}); 
			}); 
			$('#sumrmb').html(totalRow);


		}

		function update3(){
			
			var bab808 = document.getElementById('rmb').value;
			var max = bab808*3;
			var min = (bab808*0.6).toFixed(2);

			totalRow = 0;
			$('#tablst tr').each(function() { 
			$(this).find('td:eq(5)').each(function(){ 
				totalRow = accAdd(totalRow,min);
				$(this).html('<input name="AAC040" id="AAC040" type="text" onfocus="getMoney(this)" onblur="isMoney(this)" value="'+min+'" maxlength="8" style="background-color:#D4FFFF;width:90px;margin:0;padding:0;text-align:right"/>');
			}); 
			}); 
			$('#sumrmb').html(totalRow);

		}
	</script>

</body>
</html>