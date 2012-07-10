<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Lista de Tarefas</title>
</head>
<body>
	<form action="${linkTo[TaskPanelController].insert}" method="post">
		<label for="taskPanel-name">Nome: </label>
		<input type="text" id="taskPanel-name" name="taskPanel.name" />

		<select id="taskPanel-category" name="categoryId">
			<c:forEach items="${project.categories}" var="category">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select><br/> 

		<input type="submit" value="Inserir">
	</form>
</body>
</html>