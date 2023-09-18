<%@ page import = "model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title>About Us</title>
		<%@ include file = "includes/head.jsp" %>
		<link rel="stylesheet" type="text/css" href="css/navbar.css">
		
		<style type="text/css">
			img{
				max-width: 50%;
				max-height: 50%
			}
		</style>
	</head>
	<%
	    UserBean auth = (UserBean) request.getSession().getAttribute("auth");
    %>
	<body>
		<%@ include file = "includes/navbar.jsp" %>
		<div class="container">
			<br><br>
			<h3> CHI SIAMO </h3>
			
			<p>
			Agli inizi degli anni ‘90 Patrone Lorenzo, spinto dall’amore per
				il suo territorio, luogo di antica tradizione per la raccolta del
				tartufo, dei funghi e delle castagne, e dalla passione per i preziosi
				doni della terra, intraprese la realizzazione di un sogno: far
				conoscere i prodotti della sua Irpinia. Partendo dalla sua esperienza,
				Lorenzo, nei primi anni, iniziò a commercializzare i tartufi, i funghi
				e le castagne, espandendosi a poco a poco oltre i confini irpini.
				Dotato di grandi doti carismatiche e di una conoscenza dei prodotti
				divenuta impeccabile col tempo, Lorenzo iniziò la sua avventura
				insieme a sua moglie e ad alcuni preziosi collaboratori: amici e
				colleghi dediti alla ricerca del tartufo, ristoratori, partners
				commerciali e successivamente suo figlio: Guerino. La sua azienda, il
				suo sogno, iniziava così ad avere basi solide. Nel 1998, per
				soddisfare le esigenze di una clientela sempre più ampia, Lorenzo e
				Guerino pensarono bene di commercializzare anche i prodotti conservati
				al tartufo, ai funghi e alle castagne.
			</p>
			<div class="row row-no-margin">
				<img class="col-xs-12 col-sm-6 col-no-padding" src="${pageContext.request.contextPath}/imgs/jpg/lago-laceno.jpg" alt="Immagine non trovata" >
				<img class="col-xs-12 col-sm-6 col-no-padding" src="${pageContext.request.contextPath}/imgs/jpg/montella.jpg" alt="Immagine non trovata" >
			</div>
			<br><br><br><br>
			<h3> L'AZIENDA </h3>
		
			<p>
			Attualmente Lorenzo, con l’aiuto e l’occhio attento del figlio
				Guerino, segue la produzione di tutte le specialità conservate (al
				tartufo e non solo) e con passione è sempre alla ricerca di nuove
				ricette per soddisfare il palato di ciascun consumatore. In ogni
				prodotto a marchio Patrone potrete star certi di trovare la qualità e
				la genuinità delle materie prime, accuratamente selezionate con
				dedizione. Ogni vasetto è prodotto artigianalmente, e passo dopo passo
				è seguito e scrupolosamente controllato. Il figlio Guerino, oggi
				ricopre il ruolo di suo padre, dedicandosi costantemente e con lo
				stesso entusiasmo e carisma alla minuziosa ricerca e scelta dei
				prodotti. Responsabile diretto delle vendite del prodotto fresco,
				controlla in prima persona la qualità dei prodotti e si occupa della
				loro commercializzazione in Italia e all’estero.<br> Lo store online,
				offre un’ampia scelta di prodotti: oltre a tartufi, funghi freschi e
				castagne, surgelati e conservati (salse, creme al tartufo, ai funghi
				o alle castagne, ecc…), si possono trovare i prodotti più ricercati 
				dai gourmet: formaggi e salumi al tartufo locali, una selezione di mieli
				al tartufo e non, marmellate e confetture, liquori al tartufo, vini,
				olio e tanti altri prodotti, il tutto condito dalla simpatia e dalla
				cordialità della famiglia Patrone.
			</p>
			<div class="row row-no-margin">
				<img class="col-xs-12 col-sm-6 col-no-padding" src="${pageContext.request.contextPath}/imgs/jpg/AziendaInternoSinistra.jpg" alt="Immagine non trovata" >
				<img class="col-xs-12 col-sm-6 col-no-padding" src="${pageContext.request.contextPath}/imgs/jpg/trofeo.jpg" alt="Immagine non trovata" >
			</div>
		</div>
		<footer><%@ include file="includes/footer.jsp" %></footer>
	</body>
</html>