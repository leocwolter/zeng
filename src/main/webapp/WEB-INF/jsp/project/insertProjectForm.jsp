<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Projeto</title>
</head>
<body>
	<form action="${linkTo[ProjectController].insert}" method="post">
		<label for="project-name">Nome: </label>
		<input type="text" id="project-name" name="project.name" /><br/>
	
		<label for="project-contributors">Colaboradores: </label><br/>
		<input id="project-contributors[${i.count}]" type="text" name="contributors[${i.count}].email"/>
	
		<input type="submit" value="Inserir">
	</form>
</body>
</html>