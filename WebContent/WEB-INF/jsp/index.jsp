<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<title>${index}</title>
<style>
.formDiv {
	text-align: center;
    width: 420px;
    margin-left: 450px;
}
#formId {
	border: 1px solid black;
	border-radius: 4px;
	margin-top : 10px;
	padding-top: 20px;
	padding-bottom: 20px;
}
#login {
	width: 70px;
    height: 30px;
    margin-left: 40px;
}
#errDiv {
	border: 1px solid red;
    border-radius: 4px;
    padding-top: 10px;
	padding-bottom: 10px;
}
#successDiv {
	border: 1px solid green;
    border-radius: 4px;
    padding-top: 10px;
	padding-bottom: 10px;
}
</style>
</head>
<body>

<div class="formDiv">
	<h2>${index}</h2>
	<br>
	<div id="errDiv" style="display: none;">
		<span id="errSpan" style="color: red; font-size: 18px"></span>
	</div>
	
	<div id="successDiv" style="display: none;">
		<span id="successSpan" style="color: green; font-size: 18px"></span>
	</div>
	
	<form id="formId">
		<h3>Login</h3>
		<label>UserName : </label><input type="text" id="usernameBox">
		<br>
		<br> <label>Password : </label>&nbsp;&nbsp;<input type="password"
			id="passwordBox"> <br>
		<br>
		
		<input type="button" id="login" value="Login" name="Login">
	</form>
</div>

<script type="text/javascript" charset="utf8"
	src="http://datatables.net/release-datatables/media/js/jquery.js"></script>
</body>
<script type="text/javascript">

document.getElementById("login").addEventListener('click', doAjax, false);
 function doAjax(){
 	
 	var data = {
 		userName : $('#usernameBox').val(),
 		password : $('#passwordBox').val()
 	};
 	
 	$.ajax({
 		url:"../handler/login.json",
 		dataType : "json",
 		type:"POST",
 		data: data,
 		async : true,
 		success: function(response){
 			if(response.user){
 				$('#errDiv').css('display','none');
 				$('#formId').css('display','none');
 				$('#successDiv').css('display','block');
 				$('#successSpan').text("Login Successfull");
 			}else{
 				if(!response || response == null, response == undefined){
 				 	$('#errDiv').css('display','block');
 					$('#errSpan').text("Service is temporarily unavailable. Please try after sometime.");
 				}else if(response.errMsg){
	 				$('#errDiv').css('display','block');
	 				$('#errSpan').text(response.errMsg); 					
 				}else if(response.validationMsg){
	 				$('#errDiv').css('display','block');
	 				$('#errSpan').text(response.validationMsg);
	 			}else {
	 			}
 			}
 		},
 		error:function(e){
 				$('#errDiv').css('display','block');
 				$('#errSpan').text("Service is temporarily unavailable. Please try after sometime.");
 		}
 	});
 };

</script>
</html>