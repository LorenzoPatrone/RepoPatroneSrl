<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">Patrone</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto">
				
				<li class="nav-item">
					<a class="nav-link" href="aboutUs.jsp">About Us</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="index.jsp">Home</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="products.jsp">Prodotti</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="cart.jsp">Carrello</a>
				</li>
				
				<% if(auth != null) { %>
					<li class="nav-item">
						<a class="nav-link" href="orders.jsp">Ordini</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="profile.jsp?id=<%=auth.getUserID() %>" >Profilo</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="log-out">Logout</a>
					</li>
				<% } else { %>
					<li class="nav-item">
						<a class="nav-link" href="login.jsp">Login</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="signup.jsp">Signup</a>
					</li>
				<% } %>
			</ul>
		</div>
	</div>
</nav>