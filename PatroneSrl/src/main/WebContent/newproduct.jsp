<%@ page import = "model.UserBean" %>
<%@ page import = "model.ProductBean" %>
<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add Product</title>
		<%@ include file = "includes/head.jsp" %>
		<link rel="stylesheet" type="text/css" href="css/navbar.css">
	</head>
	<%
    UserBean auth = (UserBean) request.getSession().getAttribute("auth");
    if(auth==null){
    	response.sendRedirect("products.jsp");
    }
    %>
	<body>
		<%@ include file = "includes/navbar.jsp" %>
		
		<div class="container">
			<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Nuovo Prodotto</div>
				<div class="card-body">
					<form action="new-product" method="post">
						<div class="form-group">
							<label>Nome Prodotto</label>
							<input type="text" class="form-control" name="product-name" required>
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
							<input type="text" class="form-control w-50" name="product-price" required>
						</div>
						<div class="form-group">
							<label>Immagine</label>
							<input type="text" class="form-control" name="product-image" >
						</div>
						<br>
						<div class="text-center">
							<button type="submit" class="btn btn-primary">Aggiungi</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
		<%@ include file = "includes/footer.jsp" %>
	</body>
</html>