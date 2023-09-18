<%@ page import = "connection.ConPool" %>
<%@ page import = "dao.OrderDao" %>
<%@ page import = "model.*" %>
<%@ page import = "java.util.List" %>
<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Managment</title>
<%@ include file="includes/head.jsp"%>
</head>
	<%
		int amm = 0;
		UserBean auth = (UserBean) request.getSession().getAttribute("auth");
		if (auth != null) {
		
			if (auth.getUserID() == 1) {
				amm = 1;
			}
		}
		request.setAttribute("auth", auth);
		OrderDao odao = new OrderDao(ConPool.getConnection());
		List<OrderBean> orders = odao.getAllOrders();
	%>
<body>
	<%@ include file = "/includes/navbar.jsp" %>
	
	<div class="container">
		<div class="card-header my-3">Tutti gli Ordini</div>
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
						<td><%=o.getPrice() %></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order-admin?id=<%=o.getOrderID()%>">Cancella Ordine</a></td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
	
	<%@ include file = "/includes/footer.jsp" %>
</body>
</html>