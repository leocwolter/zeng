<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!empty errors }">
		<c:forEach var="error" items="${errors}">
			<section class="error message">${error.message}</section>
		</c:forEach>
</c:if>