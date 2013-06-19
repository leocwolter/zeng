<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ tag language="java" pageEncoding="UTF-8"%>

<aside class="sidebar">
	<div class="sidebar-click-area">&nbsp;</div>
	<section class="sidebar-content">
		<section class="sidebar-members-area">
			<c:forEach items="${project.contributors}" var="contributor">
				<a href="${linkTo[UserController].profile[contributor.id]}" title="${contributor.name}" class="photo-link project-members-photo-link">
					<img src='<c:url value="${contributor.photo}?s=40"/>' alt="${contributor.name}" height="40" width="40" />
				</a>
			</c:forEach>
		</section>
		<section class="project-notifications">
			<dl>
				<c:forEach items="${project.actions}" var="action">
					<dt>${action.author.name}</dt>
					<dd>${action.text}</dd>
					<dd><joda:format value="${action.creationDate}" pattern="dd/MM/yyyy"/></dd>
					<hr>
				</c:forEach>
			</dl>
		</section>
	</section>
</aside>
