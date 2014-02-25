<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<script>

function validateFields()
{
	var msg = "Validation Failure : ";
	var fname = document.getElementById('fName').value;
	var lname = document.getElementById('lName').value;
	var pass = document.getElementById("password").value;
	var email = document.getElementById('email').value;
	
	var flag1 = true;
	var flag2 = true;
	var flag3 = true;
	var flag4 = true;
	var flag5 = true;
	var flag6 = true;
	
	if(fname =='' || fname.length ==0)
		{
		flag1 = false;
		msg = msg+"\n- First name can not be empty.";
		}
	
	 if(valIsSpecial(fname))
	{
	 flag2 = false;
	 msg = msg+"\n- First name can not have special characters.";
	 }
	
	if(lname =='' || lname.length ==0)
		{
		flag3 = false;
		msg = msg+"\n- Last name can not be empty.";
		
		}
	
	if(valIsSpecial(lname))
	{
	flag4 = false;
	msg = msg+"\n- Last name can not have special characters.";
	
	}	
	
	if(pass =='' || pass.length ==0)
		{
		flag5 = false;
		msg = msg+"\n- Password can not be empty.";
	
		}
		
	if(email =='' || emial.length ==0)
		{
		flag6 = false;
		msg = msg+"\n- Email can not be empty.";
	
		}
	
	if(flag1 && flag2 && flag3 && flag4 && flag5 && flag6)
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
	document.getElementById('registerForm').reset() ;
	return false;
}

</script>

</head>
<body style="background-color: #D8D8D8;">
<div align="center" style="margin-left: 90px; margin-right: 90px; height: 700px; " >
</br></br>
<div id="divWelcomeMsg"  style=" font-style: italic; "><h2 align="center"> Please fill your details to register.  </h2></div>
<hr>

</br></br>

<div style="font-style:italic;font-family: sans-serif;font-size: large;">
Registration form
</div>
<div>
<form action="/OnlineStore/Rest/WebService/SignUp" method="post" id = "registerForm">
<table align="center" width="300px" id="registerTable">
<tr>

<td align="left">
 <div style="font-style: normal;font-family: sans-serif;font-size: large;">* First Name :</div> 
</td>
<td>
<input type="text" id="fName" name = "fname">
</td>
</tr>
<tr>
<td align="left">
<div style="font-style: normal;font-family: sans-serif;font-size: large; " >* Last Name :</div> 
</td>
<td>
 <input type="text" id= "lName" name = "lname">
</td>
</tr>

<tr>
<td align="left">
<div style="font-style: normal;font-family: sans-serif;font-size: large; " >* Email :</div> 
</td>
<td>
 <input type="text" id= "email" name = "email">
</td>
</tr>

<tr>
<td align="left">
<div style="font-style: normal;font-family: sans-serif;font-size: large; " >* Password :</div> 
</td>
<td>
 <input type="password" id= "password" name = "pwd">
</td>
</tr>

<tr height="20px">
<td align="right">
<input type="submit" value ="SignUp" onclick="return validateFields();">
</td>
<td align="left">
<input type="submit" value ="Reset" onclick="return resetFields();">
</td>
</tr>
</table>
</form>
</div>
</br></br>
<hr>


<% 
	if(request.getAttribute("msg")!=null)
	{
	 String msg = (String)request.getAttribute("msg");
	 String msgArr[] = msg.split(":");
	 if(msgArr[0].trim().equalsIgnoreCase("success"))
	 {%>
	<div id = msgDiv align="center" style="font-style: italic;font-family: sans-serif;font-size:medium; " > <%= msgArr[1] %> <a href="Login.jsp">Click here to login.</div>	 
	<%		 
	 }
	 else
	 {%>
		 <div id = msgDiv align="center" style="font-style: italic;font-family: sans-serif;font-size:medium; " >  <%= msgArr[1] %>  </div>
		
	<% 
	 }
	}
%>

</div>

</body>
</html>