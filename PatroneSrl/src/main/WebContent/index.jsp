<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import = "connection.ConPool" %>
<%@ page import = "dao.ProductDao" %>
<%@ page import = "model.*" %>
<%@ page import = "java.util.List" %>
<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title>Home</title>
		<%@ include file = "includes/head.jsp" %>
		<link rel="stylesheet" type="text/css" href="css/navbar.css">
		<style type="text/css">
		.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			user-select: none;
		}
		
		@media ( min-width : 768px) {
			.bd-placeholder-img-lg {
				font-size: 3.5rem;
			}
		}
		
		.b-example-divider {
			width: 100%;
			height: 3rem;
			background-color: rgba(0, 0, 0, .1);
			border: solid rgba(0, 0, 0, .15);
			border-width: 1px 0;
			box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
				rgba(0, 0, 0, .15);
		}
		
		.b-example-vr {
			flex-shrink: 0;
			width: 1.5rem;
			height: 100vh;
		}
		
		.bi {
			vertical-align: -.125em;
			fill: currentColor;
		}
		
		.nav-scroller {
			position: relative;
			z-index: 2;
			height: 2.75rem;
			overflow-y: hidden;
		}
		
		.nav-scroller .nav {
			display: flex;
			flex-wrap: nowrap;
			padding-bottom: 1rem;
			margin-top: -1px;
			overflow-x: auto;
			text-align: center;
			white-space: nowrap;
			-webkit-overflow-scrolling: touch;
		}
		
		.btn-bd-primary {
			--bd-violet-bg: #712cf9;
			--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
			--bs-btn-font-weight: 600;
			--bs-btn-color: var(--bs-white);
			--bs-btn-bg: var(--bd-violet-bg);
			--bs-btn-border-color: var(--bd-violet-bg);
			--bs-btn-hover-color: var(--bs-white);
			--bs-btn-hover-bg: #6528e0;
			--bs-btn-hover-border-color: #6528e0;
			--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
			--bs-btn-active-color: var(--bs-btn-hover-color);
			--bs-btn-active-bg: #5a23c8;
			--bs-btn-active-border-color: #5a23c8;
		}
		
		.bd-mode-toggle {
			z-index: 1500;
		}
		</style>

	</head>
	<%
	int admin = 0;
	UserBean auth = (UserBean) request.getSession().getAttribute("auth");
	if (auth != null) {
		if (auth.getUserID() == 1) {
			admin = 1;
		}
	}
	request.setAttribute("auth", auth);
	ProductDao products = new ProductDao(ConPool.getConnection());
	List<ProductBean> list = products.getAllProducts();
	%>
	<body>
	
		<%@ include file = "includes/navbar.jsp" %>

		<main>
			<div class="px-4 py-5 my-5 text-center">
				<h1 class="display-5 fw-bold">Castagne Tartufi e Funghi</h1>
				<div class="col-lg-6 mx-auto">
					<p class="lead mb-4">I tesori dell'irpinia attentamente selezionati per voi.</p>
					<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
						<a href="aboutUs.jsp"><button type="button" class="btn btn-primary btn-lg px-4 gap-3">La Nostra Storia</button></a>
						<a href="products.jsp"><button type="button" class="btn btn-outline-secondary btn-lg px-4">Prodotti</button></a>
					</div>
				</div>
			</div>
			<%@ include file = "includes/carousel.jsp" %> 		
		</main>
		<div class="b-example-divider"> </div>		
		<div class="container px-4 py-5" id="custom-cards">
			<h2 class="pb-2 border-bottom">Più venduto</h2>
	
			<div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">
				
				<div class="col">
					<div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" onclick="location.href='products.jsp';">
						<img class="card-img-top" src="imgs/jpg/CastagneDelPrete.jpg" alt="Immagine mancante">
						<div class="card-body">
							<h3 id="Card1" class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold" style="font-size: 2rem;">Castagne del Prete</h3>
							<p class="card-text">Provenienti da castagneti nostrani,<br>lavorati secondo la tradizione.</p>
						</div>
					</div>
				</div>
				
				<div class="col">
					<div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" onclick="location.href='products.jsp';">
						<img class="card-img-top" src="imgs/jpg/TartufoFresco.jpg" alt="Immagine mancante">
						<div class="card-body">
							<h3 id="Card1" class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold" style="font-size: 2rem;">Tartufo Nero di Bagnoli</h3>
							<p class="card-text">Sono la nostra punta di diamante,<br> e con oltre 30 anni di esperienza,<br>li raccogliamo, trattiamo e vendiamo.</p>
						</div>
					</div>
				</div>
				
				<div class="col">
					<div class="card card-cover h-100 overflow-hidden text-bg-dark rounded-4 shadow-lg" onclick="location.href='products.jsp';">
						<img class="card-img-top" src="imgs/jpg/CastagneSciroppate.jpg" alt="Immagine mancante">
						<div class="card-body">
							<h3 id="Card1" class="pt-5 mt-5 mb-4 display-6 lh-1 fw-bold" style="font-size: 2rem;">Castagne Sciroppate</h3>
							<p class="card-text">Realizzate secondo antiche ricette,<br> preparate con solo frutta fresca <br> scelta da un team esperto.</p>
						</div>
					</div>
				</div>				
			</div>
		</div>
	
		<div class="b-example-divider"></div>		
		<footer><%@ include file="includes/footer.jsp" %></footer>
	</body>
</html>