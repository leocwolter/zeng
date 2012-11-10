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
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />
</head>
<body>
	<section id="container">
    	<section id="left-container">
    		<header class="header">
				<c:import url="/WEB-INF/imports/header.jsp"/>
				<c:import url="/WEB-INF/imports/project-menu.jsp"/>
			</header>
            <section id="generic-content" class="content">
			</section>
			<c:import url="/WEB-INF/imports/footer.jsp"/>
        </section>
       </section>
    <!-- SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/script-import.jsp" />
	<!-- DROPDOWN MARGIN SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/dropdown.js" />"></script>
	<!-- MODAL SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/modal-script.jsp"></c:import>	
	<!-- HEADER MARGIN SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/header.js" />"></script>
</body>
</html>