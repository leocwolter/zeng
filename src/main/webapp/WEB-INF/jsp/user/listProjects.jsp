<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Projetos</title>
	</head>
	<body>
		<h1>Seus Projetos</h1>
		<c:forEach items="${projects}" var="project">
			<section class="project">
				<a class="titulo-project" href='<c:url value="/projects/"/>${project.url}/${project.id}'>${project.name}</a><br />
			</section>
		</c:forEach>
	</body>
</html>