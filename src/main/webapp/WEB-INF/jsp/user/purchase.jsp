<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages"%>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Zeng - Project management</title>
<!-- NOT LOGGED STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/not-logged-page.css"/>" />
<!-- PURCHASE STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/purchase.css"/>" />
<!-- FORM STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>" />
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />
</head>
<body>
	<section id="container">
		<header class="header">
			<c:import url="/WEB-INF/imports/header.jsp"/>
			<c:import url="/WEB-INF/imports/project-menu.jsp"/>
			
		</header>
		<section id="home-content" class="content">
			<zeng-messages:error />
			<h1 id="purchase-title">Purchase Plans</h1>
			<ol class="offer-sale plans container">
				<li class="option" id="bronze-option">
					<h2 class="plan-title" id="bronze-title">Bronze Plan</h2>
					<ul class="plan-description">
						<li><strong>Unlimited</strong> users</li>
						<li><strong>2</strong> projects</li>
						<li><strong>1GB</strong> of available storage</li>
						<li><strong>Community</strong> support</li>
						<li>
							<!-- FORM BEGIN - PAGSEGURO BUTTON -->
							<form target="pagseguro" action="https://pagseguro.uol.com.br/v2/pre-approvals/request.html" method="post">
								<input type="hidden" name="code" value="77EC8F857C7C77A774915FA4F7447666" />
								<input type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/assinaturas/209x48-assinar-assina.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
							</form>
							<!-- FORM END - PAGSEGURO BUTTON --></li>
					</ul>
				</li>
				<li class="option" id="silver-option">
					<h2 class="plan-title" id="silver-title">Silver Plan</h2>
					<ul class="plan-description">
						<li><strong>Unlimited</strong> users</li>
						<li><strong>5</strong> projects</li>
						<li><strong>3GB</strong> of available storage</li>
						<li><strong>Community</strong> support</li>
						<li>
							<!-- FORM BEGIN - PAGSEGURO BUTTON -->
							<form target="pagseguro" action="https://pagseguro.uol.com.br/v2/pre-approvals/request.html" method="post">
								<input type="hidden" name="code" value="77EC8F857C7C77A774915FA4F7447666" />
								<input type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/assinaturas/209x48-assinar-assina.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
							</form>
							<!-- FORM END - PAGSEGURO BUTTON --></li>
					</ul>
				</li>
				<li class="option" id="gold-option">
					<h2 class="plan-title" id="gold-title">Gold Plan</h2>
					<ul class="plan-description">
						<li><strong>Unlimited</strong> users</li>
						<li><strong>10</strong> projects</li>
						<li><strong>5GB</strong> of available storage</li>
						<li><strong>Specialized</strong> support with email</li>
						<li>
							<!-- FORM BEGIN - PAGSEGURO BUTTON -->
							<form target="pagseguro" action="https://pagseguro.uol.com.br/v2/pre-approvals/request.html" method="post">
								<input type="hidden" name="code" value="77EC8F857C7C77A774915FA4F7447666" />
								<input type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/assinaturas/209x48-assinar-assina.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
							</form>
							<!-- FORM END - PAGSEGURO BUTTON --></li>
					</ul>
				</li>
				<li class="option" id="platinum-option">
					<h2 class="plan-title" id="platinum-title">Platinum Plan</h2>
					<ul class="plan-description">
						<li><strong>Unlimited</strong> users</li>
						<li><strong>Unlimited</strong> projects</li>
						<li><strong>30GB</strong> of available storage</li>
						<li><strong>Specialized</strong> support with email</li>
						<li>
							<!-- FORM BEGIN - PAGSEGURO BUTTON -->
							<form target="pagseguro" action="https://pagseguro.uol.com.br/v2/pre-approvals/request.html" method="post">
								<input type="hidden" name="code" value="77EC8F857C7C77A774915FA4F7447666" />
								<input type="image" src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/assinaturas/209x48-assinar-assina.gif" name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!" />
							</form>
							<!-- FORM END - PAGSEGURO BUTTON --></li>
					</ul>
				</li>
			</ol>
			<br class="clear-fix" />
			<section class="button normal-button" id="extension-button">Extension Plan + More 10GB of Storage</section>
		</section>
		<c:import url="/WEB-INF/imports/footer.jsp" />
	</section>
	<!-- SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/script-import.jsp" />
	<!-- SCREEN SIZE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/screen_size.js" />"></script>
	<!-- HOME FORMS VALIDATE SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/home.js" />"></script>
	<!-- HEADER MARGIN SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/header.js" />"></script>

</body>
</html>