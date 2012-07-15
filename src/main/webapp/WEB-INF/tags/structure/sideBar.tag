<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag language="java" pageEncoding="UTF-8"%>

<section id="project_sidebar">
	<div id="project_sidebar_click_area" class="project_sidebar_click_area">&nbsp;</div>
	<div id="project_sidebar_content">
		<section id="project_sidebar_members_area">
			<c:forEach items="${project.contributors}" var="contributor">
				<a href="#" title="${contributor.name}" id="project_members_photo_link"
					class="photo_link">
					<img src="${contributor.photo}" alt="${contributor.name}" height="40" width="40" />
				</a>
			</c:forEach>
		</section>
	</div>
</section>
