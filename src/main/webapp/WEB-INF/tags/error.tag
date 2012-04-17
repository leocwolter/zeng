<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!empty errors }">
	<ul class="erro">
		<c:forEach var="error" items="${errors}">
			<li>${error.message}</li>
		</c:forEach>
	</ul>
</c:if>