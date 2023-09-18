<%@ page import = "model.*" %>
<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Modify Product</title>
		<%@ include file = "includes/head.jsp" %>
		<link rel="stylesheet" type="text/css" href="css/navbar.css">
	</head>
	<%
		ProductBean p = new ProductBean();
		int id = Integer.parseInt(request.getParameter("id"));
		UserBean auth = (UserBean) request.getSession().getAttribute("auth");
		if (auth == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<body>
		<%@ include file = "includes/navbar.jsp" %>
		
		<div class="container">
			<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Modifica Prodotto</div>
				<div class="card-body">
					<form action="mod-product" method="POST">
						<div class="form-group">
							<label>Id</label>
							<input type="text" class="form-control w-50" name="product-id"  value="<%=id%>" required readonly >
						</div>
						<div class="form-group">
							<label>Nome</label>
							<input type="text" class="form-control" name="product-name"  placeholder="Nome Prodotto" required >
						</div>
						<div class="form-group">
							<label>Categoria</label>
							<br>
							<select name="product-category" id="category">
								<option value="Castagne">Castagne</option>
								<option value="Tartufi">Tartufi</option>
								<option value="Funghi">Funghi</option>
								<option value="Origano">Origano</option>
							</select>
						</div>
						<div class="form-group">
							<label>Prezzo</label>
							<input type="text" class="form-control w-50" name="product-price" placeholder="Prezzo Prodotto" required>
						</div>
						<div class="form-group">
							<label>Immagine</label>
							<input type="text" class="form-control" name="product-image" placeholder="" required>
						</div>
						<br>
						<div class="text-center">
							<button type="submit" class="btn btn-info">Modifica</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
	</body>
</html>