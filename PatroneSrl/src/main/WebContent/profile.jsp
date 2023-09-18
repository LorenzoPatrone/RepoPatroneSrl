<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Profile</title>
		<%@include file="includes/head.jsp"%>
		<link rel="stylesheet" type="text/css" href="css/navbar.css">
	</head>
	<%
	    UserBean auth = (UserBean) request.getSession().getAttribute("auth");
	    if(auth==null){
	    	response.sendRedirect("index.jsp");
    	}
    %>
	<body>
		<%@include file="includes/navbar.jsp"%>
		
		<div class="container">
			<div class="card w-50 mx-auto my-5">
				<div class="card-header text-center h4">Modifica Dati Utente</div>
				<div class="card-body">
					<form action="mod-profile" method="post">
						<div class="form-group">
						<label>Codice Utente</label>
						<input type="text" class="form-control" name="id" value="<%=auth.getUserID() %>" required readonly>
						</div>
						<br>
						<div class="form-group">
						<label>Nome Utente</label>
						<input type="text" class="form-control" name="firstname" value="<%=auth.getFirstname() %>" required>
						</div>
						<br>
						<div class="form-group">
						<label>Cognome</label>
						<input type="text" class="form-control" name="lastname" value="<%=auth.getLastname() %>" required>
						</div>
						<br>
						<div class="form-group">
						<label>Indirizzo</label>
						<input type="text" class="form-control" name="address" value="<%=auth.getAddress() %>" required>
						</div>
						<br>
						<div class="form-group">
						<label>Email</label>
						<input type="email" class="form-control" name="email" value="<%=auth.getEmail() %>" required>
						</div>
						<br>
						<div class="form-group">
						<label>Password</label>
						<input type="password" class="form-control" name="password" value="<%=auth.getPassword() %>" required>
						</div>
					
						<div class="text-center">
						<br>
						<button type="submit" class="btn btn-primary">Modifica</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<%@include file="includes/footer.jsp"%>
	</body>
</html>