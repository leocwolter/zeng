<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages" %>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projetos</title>

<c:import url="/WEB-INF/imports/script-css.jsp"/>

<!-- COLORBOX STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/colorbox.css"/>" />

<!-- JQUERY COLORBOX -->
<script type="text/javascript" src="<c:url value="/js/jquery.colorbox-min.js" />"></script>

<!-- INSERT_FORM SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/generic.js" />"></script>

	
</head>
	<body>
		<body>
		<section id="container">
	    	<section id="left-container">
	    		<header>
					<c:import url="/WEB-INF/imports/header.jsp"/>
					<nav id="menu-bar" class="resizable">
						<h1>Meus Projetos:</h1>
						<ul id="menu">
							<c:forEach items="${projects}" var="project">
								<li><a href="${linkTo[ProjectController].showProject}${project.url}"	title="Project ${project.id}">${project.name}</a></li>
							</c:forEach>
						</ul>
						<section id="menu-bar-buttons">
							<a	href="${linkTo[ProjectController].insertProjectForm}${project.id}" title="Adicionar Projeto" class="button colorbox">Adicionar projeto</a>
						</section>
					</nav>
				</header>
	            <section id="generic-content" class="content">
				</section>
				<c:import url="/WEB-INF/imports/footer.jsp"/>
	        </section>
        </section>
	</body>
</html>