<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8"%>

<aside id="project-sidebar">
	<div id="project-sidebar-click-area">&nbsp;</div>
	<section id="project-sidebar-content">
		<section id="project-sidebar-members-area">
			<c:forEach items="${project.contributors}" var="contributor">
				<a href="#" title="${contributor.name}" id="project-members-photo-link"
					class="photo-link">
					<img src="${contributor.photo}" alt="${contributor.name}" height="40" width="40" />
				</a>
			</c:forEach>
		</section>
		<section id="project-notifications">
			<dl>
				<c:forEach items="${project.notifications}" var="notification">
					<dt>${notification.author.name}</dt><br/>
					<dd>${notification.action}</dd>
				</c:forEach>
			</dl>
		</section>
	</section>
</aside>
