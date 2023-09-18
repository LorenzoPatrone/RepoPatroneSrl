<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import = "connection.ConPool" %>
<%@ page import = "dao.ProductDao" %>
<%@ page import = "model.*" %>
<%@ page import = "java.util.List" %>
<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8" %>

<!DOCTYPE html>
<html lang=en>
	<head>
		<meta charset = "UTF-8">
		<title>Products</title>
		<%@ include file = "includes/head.jsp" %>
		<link rel="stylesheet" type="text/css" href="css/navbar.css">
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
		<%@ include file = "includes/navbar.jsp" %>
		
		<div class="container">
			<br><br>
				<div class="text-center h1">Prodotti</div>
			<br><br>
			<% if(admin==1) { %>
				<br>
				<div class="text-center">
					<a href="newproduct.jsp" class="btn btn-info">Aggiungi Prodotto</a>
					<a href="gestorders.jsp" class="btn btn-info">Gestisci Ordini</a>
				</div>
				<br><br>
			<% } %>
			<div class="row">
			<form id="myform" name="myform" method="POST"
				action="filteredproductpage.jsp">
				<label for="filter">Filtra per:</label> <select name="filter"
					id="filter">
					<optgroup label="Categoria">
						<option value="100">Tutti</option>
						<option value="Castagne">Castagne</option>
						<option value="Tartufi">Tartufi</option>
						<option value="Funghi">Funghi</option>
						<option value="Origano">Origano</option>
					</optgroup>
				</select> <input type="submit" value="Filtra"
					onclick="window.location.href='filteredproductpage.jsp'" />
			</form>
			<% 	
			if(!list.isEmpty()){
				for(ProductBean p:list){
					if(admin != 1){
			%>
					<div class="col-md-3 my-3">
						<div class="card w-100" style="width: 18rem;">
							<img class="card-img-top" src="imgs/jpg/<%= p.getImage()%>" alt="Immagine mancante">
							<div class="card-body">
								<h5 class="card-title"><%= p.getProductName() %></h5>
								<h6 class="price">Prezzo: <%= p.getPrice()%> €</h6>
								<h6 class="category">Categoria: <%=p.getCategory()%></h6>
								<div class="mt-3 d-flex justify-content-between">
									<a href="add-to-cart?id=<%= p.getProductID() %>" class="">Aggiungi al Carrello</a>
								</div>
							</div>
						</div>
					</div>
					<%} else {%>
					<div class="col-md-3 my-3">
						<div class="card w-100" style="width: 18rem;">
							<img class="card-img-top" src="imgs/jpg/<%= p.getImage()%>" alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title"><%= p.getProductName() %></h5>
								<h6 class="price">Prezzo: <%= p.getPrice()%> €</h6>
								<h6 class="category">Categoria: <%=p.getCategory()%></h6>
								<div class="mt-3 d-flex justify-content-between">
									<a href="modifyproduct.jsp?id=<%=p.getProductID() %>" class="btn btn-info">Modifica</a>
									<a href="remove-product?id=<%=p.getProductID() %>"class="btn btn-danger">Rimuovi</a>
								</div>
							</div>
						</div>
					</div>
					<% }
				}
			}%>
			</div>
		</div>
		
		<%@ include file="includes/footer.jsp" %>
	</body>
</html>