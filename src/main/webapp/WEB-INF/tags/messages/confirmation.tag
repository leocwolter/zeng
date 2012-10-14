<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${!empty confirmacao}">
	<section class="success message">${confirmacao}</section>
</c:if>