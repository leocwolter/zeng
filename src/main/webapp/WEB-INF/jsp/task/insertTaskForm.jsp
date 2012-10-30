<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - Insert Task</title>
<!-- CSS IMPORT -->
<c:import url="/WEB-INF/imports/css-import.jsp" />
<!-- STRUCTURE STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/insert_form.css"/>" />
</head>
<body>
	<form action="${linkTo[TaskController].insert}" method="POST" class="insert-form insert-task-form">
		<fieldset>
			<legend>Insert Task</legend>
			<br/>
			
			<label for="task-name">Name: </label>
			<br/>
			<input type="text" id="task-name" name="task.name" />
			<br/>
			
			<label for="task-description">Description: </label>
			<br/>
			<input type="text" id="task-description" name="task.description" />
			<br/>
		
			<label for="task-contributors">Contributors: </label>
			<br/>
			<c:forEach items="${taskList.projectContributors}" var="contributor" varStatus="i">
				<input id="task-contributors[${i.count}]" type="checkbox" value="${contributor.id}" name="task.contributors[${i.count}].id"/>
				<label for="task-contributors[${i.count}]">${contributor.name} </label>
				<br/> 
			</c:forEach>
		
			<label for="expirationDate">Expiration Date: </label>
			<br/>
			<input type="date" id="expirationDate" name="expirationDate" />
			<br/>
	
			<input type="hidden" name="task.taskList.id" value="${taskList.id}"/>
	
			<input type="submit" class="button normal-button" value="Insert">
		</fieldset>
	</form>
	<!-- SCRIPTS IMPORT -->
	<c:import url="/WEB-INF/imports/script-import.jsp" />
	<!-- JQUERY VALIDATION SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js" />"></script>
	<!-- INSERT_FORM SCRIPT -->
	<script type="text/javascript" src="<c:url value="/js/insertForm.js" />"></script>
</body>
</html>

