<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages" %>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Zeng - ${project.name}</title>
<!-- PROJECT STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/showProject.css"/>" />
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />
</head>
	<body>
		<section id="container">
	    	<section id="left-container" class="container">
				<header class="header">
					<c:import url="/WEB-INF/imports/header.jsp"/>
					<c:import url="/WEB-INF/imports/category_menu.jsp"/>
				</header>
	            <section id="project-content" class="content">
	            	<section id="category-container" class="resizable">
		            	<c:forEach items="${project.categories}" var="category">
		            		<zeng-structure:category category="${category}"/>
	            		</c:forEach>
            		</section>
				</section>
				<c:import url="/WEB-INF/imports/footer.jsp"/>
	        </section>
	        <zeng-structure:sideBar/>
        </section>
		<!-- SCRIPTS IMPORT -->
		<c:import url="/WEB-INF/imports/script-import.jsp" />
		<!-- GENERIC MODAL SCRIPT - BIND -->
		<script type="text/javascript" src="<c:url value="/js/generic.js" />"></script>
		<!-- SCREEN SIZE SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/screen_size.js" />"></script>
		<!-- HEADER MARGIN SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/header.js" />"></script>
		<!-- SHOWPROJECT SCRIPT -->
		<script type="text/javascript" src="<c:url value="/js/showProject.js" />"></script>
	</body>
</html>
