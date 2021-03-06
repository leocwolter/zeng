<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - Insert Project</title>
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />
<!-- STRUCTURE STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/insert_form.css"/>" />
</head>
<body>
	<form action="${linkTo[ProjectController].insert}" method="POST" class="insert-form simple-insert-form">
		<fieldset>
			<legend>Insert Project</legend>
			<br/>
			
			<label for="project-name">Name: </label>
			<br/>
			<input type="text" id="project-name" name="project.name" />
			<br/>
		
			<label for="project-contributors">Contributors: </label>
			<br/>
			<input id="project-contributors[0]" type="text" name="contributors[0].email"/>
			<br/>
			<input type="hidden" name="showUrl" value="${linkTo[ProjectController].showProject}"/> 
			<input type="submit" class="button normal-button" value="Insert">
		</fieldset>
	</form>
	<!-- SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/script-import.jsp" />
	<!-- INSERT FORM SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/insert-form/insert-form.js" />"></script>
	<!-- INSERT PROJECT SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/insert-form/insert-category-project.js" />"></script>
</body>
</html>