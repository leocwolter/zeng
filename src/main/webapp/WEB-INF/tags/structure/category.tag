
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/structure" prefix="zeng-structure" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="category" required="true" type="br.com.zeng.model.Category" %>

<section class="category" id="category_${category.id}">	
<h2>${category.name}</h2>
	<c:forEach items="${category.taskLists}" var="taskList">
		<zeng-structure:taskList taskList="${taskList}"/>
	</c:forEach>
</section>