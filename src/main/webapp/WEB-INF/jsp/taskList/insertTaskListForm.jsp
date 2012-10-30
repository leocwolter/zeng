<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - Insert Task List</title>
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />
<!-- STRUCTURE STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/insert_form.css"/>" />
</head>
<body>
	<form action="${linkTo[TaskListController].insert}" method="post" class="insert-form insert-task-list-form">
		<fieldset>
			<legend>Insert Task List</legend>
			<br/>
			<label for="taskList-name">Name: </label>
			<br/>
			<input type="text" id="taskList-name" name="taskList.name" />
			<br/>
			<input type="hidden" name="categoryId" value="${category.id}">
			<input type="submit" class="button normal-button" value="Insert">
		</fieldset>
	</form>
	<!-- SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/script-import.jsp" />
	<!-- INSERT_FORM SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/insertForm.js" />"></script>
</body>
</html>