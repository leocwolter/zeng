<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tarefa - ${task.name}</title>
<c:import url="/WEB-INF/imports/script-css.jsp"/>
<!-- JQUERY COLORBOX -->
<script type="text/javascript" src="<c:url value="/js/jquery.colorbox-min.js" />"></script>
</head>
<body>
	<h1>${task.name}</h1>
	<section class="description">
		<h4>Descrição:</h4>
		${task.description}
	</section>
	<section class="steps">
		<h4>Passos:</h4>
		<c:forEach items="${task.steps}" var="step">
			${step.description}<br/>		
		</c:forEach>
	</section>
</body>
</html>