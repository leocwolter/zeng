<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages" %>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - ${project.name}</title>

<c:import url="/WEB-INF/imports/script-css.jsp"/>

<!-- PROJECT STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/project.css"/>" />

<!-- COLORBOX STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/colorbox.css"/>" />

<!-- JQUERY COLORBOX -->
<script type="text/javascript" src="<c:url value="/js/jquery.colorbox-min.js" />"></script>

<!-- SCREEN SIZE SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/screen_size.js" />"></script>

<!-- CATEGORY SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/category.js" />"></script>

<!-- TASK SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/task.js" />"></script>


</head>
	<body>
		<section id="container">
	    	<section id="left_container">
				<header id="top">
					<c:import url="/WEB-INF/imports/header.jsp"/>
					<c:import url="/WEB-INF/imports/category_menu.jsp"/>
				</header>
	            <section id="content">
	            	<section id="category_container" class="resizeble">
		            	<c:forEach items="${project.categories}" var="category">
		            		<zeng-structure:category category="${category}"/>
	            		</c:forEach>
            		</section>
				</section>
				<c:import url="/WEB-INF/imports/footer.jsp"/>
	        </section>
	        <zeng-structure:sideBar/>
        </section>
	</body>

</html>
