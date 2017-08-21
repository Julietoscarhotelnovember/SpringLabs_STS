<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="/sidebar/header.jsp"></jsp:include>
	
	<div class="col-sm-4"></div>
		  
	<div class="col-sm-4">
	<h2>Login</h2>
	<br><br>
	Session:${sessionScope.sid }
	<form action="login.htm" method="post" name="loginform">
		<div>
			<label>ID</label>
			<input type="text" name="id" class="form-control"> 
		 </div>
		<br>
		<div>
			<label>PW</label>
			<input type="text" name="pw" class="form-control">
		</div>
		<br>
		<div style="text-align: right">
			<input type="submit" value="로그인" class="btn btn-default">
		</div>
		
	</form>
	<form action="new.htm">
	<div style="text-align: right">
			<input type="submit" value="새로고침" class="btn btn-default">
		</div>
		</form>

	</div>
	
</body>
</html>