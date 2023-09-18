<%@ page import = "model.UserBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang=en>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<%@include file="includes/head.jsp"%>
		<link rel="stylesheet" type="text/css" href="css/navbar.css">
	</head>
	<%
	    UserBean auth = (UserBean) request.getSession().getAttribute("auth");
	    if(auth!=null){
	    		response.sendRedirect("index.jsp");
	    }
    %>
	<body>
		<%@include file="includes/navbar.jsp"%>
		
		<%@include file="includes/signupForm.jsp"%>
		
		<%@include file="includes/footer.jsp"%>
	</body>
</html>