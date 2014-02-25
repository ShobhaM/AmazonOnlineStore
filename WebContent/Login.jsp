<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>

<script>

function validateLogin()
{
	var msg = "Validation Failure : ";
	var name = document.getElementById('name').value;
	var pass = document.getElementById("password").value;
	
	var flag1 = true;
	var flag2 = true;
	var flag3 = true;
	
	if(name =='' || name.length ==0)
		{
		flag1 = false;
		 msg = msg+"\n- User name can not be empty.";
		}
		
	if(pass =='' || pass.length ==0)
		{
		flag2 = false;
		 msg = msg+"\n- Password can not be empty.";
		}
	if(valIsSpecial(name))
	{
	flag3 = false;
	 msg = msg+"\n- User name can not have special characters.";
	}	
	
	if(flag1 && flag2 && flag3)
		{
		return true;
		}
	else{
		alert(msg);
		return false;
	}
	

}
function valIsSpecial(textField){
    var iChars = '!@#$%^&*_()+=-[]\\\;,./{}|\:<>?\'\""';
    var specialCount = 0;
    var statusIsSpecial = false;   
    for (var i = 0; i < textField.length; i++){
        if (iChars.indexOf(textField.charAt(i)) != -1){
            specialCount++;
            statusIsSpecial = true;
        }
    }
    
   return statusIsSpecial;
}

function resetFields()
{
	document.getElementById('loginForm').reset();
    return false;
}

</script>

</head>
<body style="background-color:#D8D8D8;">
	<%
		String errorMsg = "";
		if (request.getAttribute("error") != null);
		errorMsg = (String) request.getAttribute("error");
	%>
	<!--    <div id="bodyDiv" align="center" style="width: 1000 px; height: 700px; margin: 100 Auto;">-->
	<br>
	<div id="bodyDiv" align="center" style="margin-left: 100px; margin-right: 100px; height: 700px;" >
		<div id="headerDiv" style="width: 100%; height: 70px;">
			<div id="divWelcomeMsg" style=" float:left;font-style: italic; width: 75%;">
				<h1 align="center">Welcome to Online Store</h1>
			</div>
			<div align="center" style=" float:right;width: 24%; font-style: italic;">
				New User >> <a href="Register.jsp" style="color: black;">Sign up</a>
			</div>
		</div>
		<hr>
		<div id="tableDiv" style="vertical-align: top;">
			<form action="LoginServlet" method="post" id = "loginForm">
				<table align="right" width="300px" id="loginTable">
					<tr>

						<td align="left">
							<div
								style="font-style: normal; font-family: sans-serif; font-size: large;">
								* User Name :</div></td>
						<td><input type="text" id="name" name="name"></td>
					</tr>
					<tr>
						<td align="left">
							<div
								style="font-style: normal; font-family: sans-serif; font-size: large;">* Password
								:</div></td>
						<td><input type="password" id="password" name="password">
						</td>

					</tr>
					<tr height="20px">
						<td align="right"><input type="submit" value="Login"
							onclick=" return validateLogin();"></td>
						<td align="left"><input type="submit" value="Reset"
							onclick=" return resetFields();"></td>
					</tr>
					<%
						if (errorMsg != null) {
					%>
					<tr>
						<td colspan="2"><%=errorMsg%></td>
					</tr>
					<%
						}
					%>
				</table>
			</form>
		</div>

	</div>
</body>
</html>