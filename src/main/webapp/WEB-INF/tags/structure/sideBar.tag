<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ tag language="java" pageEncoding="UTF-8"%>

<aside class="project-sidebar">
	<div class="project-sidebar-click-area">&nbsp;</div>
	<section class="project-sidebar-content">
		<section class="project-sidebar-members-area">
			<c:forEach items="${project.contributors}" var="contributor">
				<a href="${linkTo[UserController].profile[contributor.id]}" title="${contributor.name}" class="photo-link project-members-photo-link">
					<img src='<c:url value="${contributor.photo}?s=40"/>' alt="${contributor.name}" height="40" width="40" />
				</a>
			</c:forEach>
		</section>
		<dl class="project-notifications">
			<c:forEach items="${project.actions}" var="action">
				<dt class="notification-author notification-data">${action.author.name}</dt>
				<dd class="notification-action notification-data">${action.text}</dd>
				<dd class="notification-date notification-data"><joda:format value="${action.creationDate}" pattern="dd/MM/yyyy"/></dd>
				<hr>
			</c:forEach>
		</dl>
	</section>
</aside>
