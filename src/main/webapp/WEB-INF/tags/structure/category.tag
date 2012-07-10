<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/structure" prefix="zeng-structure" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section class="category" id="category_${category.id}">	
<h2>${category.name}</h2>
	<c:forEach items="${category.taskPanels}" var="taskPanel">
		<zeng-structure:taskList taskPanel="${taskPanel}"/>
	</c:forEach>
</section>