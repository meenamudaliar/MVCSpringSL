<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
welcome to login

<font color="red">${errorMessage}</font>



<form method="post">

Name:<input type="text" name="uname"/>
<br/>
password<input type="password" name="pass"/>
<br/>
<button>Login</button>
</form>



</body>
</html>