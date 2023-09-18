<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.List" %>
<%@ page import = "connection.ConPool" %>
<%@ page import = "dao.ProductDao" %>
<%@ page import = "model.UserBean" %>
<%@ page import = "model.CartBean" %>
<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8" %>

<!DOCTYPE html>
<html lang=en>
	<head>
		<meta charset="UTF-8">
		<title>Cart</title>
		<%@include file="includes/head.jsp"%>
		<link rel="stylesheet" type="text/css" href="css/navbar.css">
		
	</head>
	<%
		UserBean auth = (UserBean) request.getSession().getAttribute("auth");
		if (auth != null) {
			request.setAttribute("auth", auth);
		}
		@SuppressWarnings("unchecked")
		ArrayList<CartBean> cart_list = (ArrayList<CartBean>) session.getAttribute("cart-list");
		List<CartBean> cartProduct = null;
		if(cart_list != null) {
			ProductDao pdao = new ProductDao(ConPool.getConnection());
			double total = pdao.getTotalCartPrice(cart_list);
			cartProduct = pdao.getCartProduct(cart_list);
			request.setAttribute("cart_list", cart_list);
			request.setAttribute("total", total);
		}
	%>
	<body>
		<%@include file="includes/navbar.jsp"%>
		
		<div class="container my-3">
		<br><br>
			<div class="text-center h1">Carrello</div>
		<br><br>
		<table class="table table-light" style="border-radius: 16px;">
			<thead>
				<tr>
					<th scope="col">Prodotto</th>
					<th scope="col">Categoria</th>
					<th scope="col">Prezzo</th>
					<th scope="col">Quantità</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (CartBean c : cartProduct) {
				%>
				<tr>
					<td><%=c.getProductName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%=c.getPrice()%> €</td>
					<td>
						<form action="order-now" method="POST" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getProductID()%>" class="form-input">
							<div class="form-group d-flex justify-content-between w-50">
							    <a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getProductID()%>"><i class="fa-solid fa-minus"></i></a>
								<input type="text" name="quantity" class="form w-50"  value="<%=c.getQuantity()%>" readonly> 
								<a class="btn btn-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getProductID()%>"><i class="fa-solid fa-plus "></i></a>
							</div>
						</form>
					</td>
					<td><a class="btn btn-sm btn-danger" href="remove-from-cart?id=<%=c.getProductID() %>" >Rimuovi</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
		<div class="card shadow-2-strong mb-5 mb-lg-0" style="border-radius: 16px;">
			<div class="card-body p-4">
				<div class="row">
					<div class="col-lg-4 col-xl-3">
						<div class="d-flex justify-content-between" style="font-weight: 500;">
							<p class="mb-2">Subtotal</p>
							<p class="mb-2">${((total>0)?total:0)} €</p>
						</div>
						<hr class="my-4">
						<div class="d-flex justify-content-between mb-4" style="font-weight: 500;">
							<p class="mb-2">Total</p>
							<p class="mb-2">${(total>0)?total:0} €</p>
						</div>
						<button type="button" class="btn btn-primary btn-block btn-lg">
							<div class="d-flex justify-content-between" onclick="location.href='cart-check-out'">
								<span>Checkout: ${(total>0)?total:0} €</span>
							</div>
						</button>
					</div>
				</div>
			</div>
		</div>					
	</div>
		<br><br><br><br>
		<footer><%@ include file="includes/footer.jsp" %></footer>
	</body>
</html>