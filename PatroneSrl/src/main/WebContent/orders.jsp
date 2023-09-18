<%@page import="java.text.DecimalFormat"%>
<%@ page import = "connection.ConPool" %>
<%@ page import = "dao.OrderDao" %>
<%@ page import = "dao.ProductDao" %>
<%@ page import = "model.*" %>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang=en>
	<head>
		<meta charset="UTF-8">
		<title>Orders</title>
		<%@include file="includes/head.jsp"%>
		<link rel="stylesheet" type="text/css" href="css/navbar.css">
	</head>
	<%
		DecimalFormat dcf = new DecimalFormat("#.##");
		request.setAttribute("dcf", dcf);
		UserBean auth = (UserBean) request.getSession().getAttribute("auth");
		List<OrderBean> orders = null;
		
		if (auth != null) {
		    request.setAttribute("person", auth);
		    OrderDao orderDao = new OrderDao(ConPool.getConnection());
			orders = orderDao.userOrders(auth.getUserID());
		}else{
			response.sendRedirect("login.jsp");
		}
		@SuppressWarnings("unchecked")
		ArrayList<CartBean> cart_list = (ArrayList<CartBean>) session.getAttribute("cart-list");
		if (cart_list != null) {
			request.setAttribute("cart_list", cart_list);
		}
	%>
	<body>
		<%@include file="includes/navbar.jsp"%>
		
		<div class="container">
			<br><br>
			<div class="card-header my-3 text-center h1">Ordini</div>
			<br><br>
			<table class="table table-light">
				<thead>
					<tr>
						<th scope="col">Ordine</th>
						<th scope="col">Data</th>
						<th scope="col">Nome</th>
						<th scope="col">Categoria</th>
						<th scope="col">Quantità</th>
						<th scope="col">Prezzo</th>
						<th scope="col">Cancella</th>
					</tr>
				</thead>
				<tbody>
			
				<%
				if(orders != null){
					for(OrderBean o:orders){%>
						<tr>
							<td><%=o.getOrderID() %></td>
							<td><%=o.getDate() %></td>
							<td><%=o.getProductName() %></td>
							<td><%=o.getCategory() %></td>
							<td><%=o.getQty() %></td>
							<td><%=dcf.format(o.getPrice()) %> €</td>
							<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrderID()%>">Cancella Ordine</a></td>
						</tr>
					<%}
				}
				%>
				</tbody>
			</table>
		</div>
		
		<%@include file="includes/footer.jsp"%>
	</body>
</html>