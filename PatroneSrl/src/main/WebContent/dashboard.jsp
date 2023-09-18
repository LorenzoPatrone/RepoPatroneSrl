<%@ page import = "connection.ConPool" %>
<%@ page import = "dao.*" %>
<%@ page import = "model.*" %>
<%@ page import = "java.util.List" %>
<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8" %>

<!DOCTYPE html>
<html lang=en>
	<head>
		<meta charset="UTF-8">
		<title>Admin Page</title>
		<%@include file="includes/head.jsp"%>
	</head>
	<%
		int admin = 0;
		UserBean auth = (UserBean) request.getSession().getAttribute("auth");
		if (auth != null){
			if(auth.getUserID() == 1){
				admin = 1;
			}	
		}
		request.setAttribute("auth", auth);
		ProductDao products = new ProductDao(ConPool.getConnection());
		List<ProductBean> list = products.getAllProducts();
	%>
	<body>
		<%@include file="includes/navbar.jsp"%>
		
		<h1>Admin Page</h1>
		
		<p>Questa pagina è accesibile solo all'amministratore.</p>
		
		<a href="<%=request.getContextPath()%>/common/Logout">Logout</a>
		
		<%@include file="includes/footer.jsp"%>
	</body>
</html>