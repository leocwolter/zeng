<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - ${project.name}</title>

<!-- GENERIC STYLE -->
<link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css"/>' />

<!-- STRUCTURE STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/project.css"/>" />

<!-- STRUCTURE STYLE -->
<link rel="stylesheet" type="text/css" href="<c:url value="/css/colorbox.css"/>" />

<!-- JQUERY -->
<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>

<!-- JQUERY UI -->
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.8.18.custom.min.js"/>"></script>

<!-- JQUERY COLORBOX -->
<script type="text/javascript" src="<c:url value="/js/jquery.colorbox-min.js" />"></script>

<!-- SCREEN SIZE SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/screen_size.js" />"></script>

<!-- NEW CATEGORY SCRIPT -->
<script type="text/javascript" src="<c:url value="/js/category.js" />"></script>


<style>
	#dialog label, #dialog input { display:block; }
	#dialog label { margin-top: 0.5em; }
	#dialog input, #dialog textarea { width: 95%; }
	#tabs { margin-top: 1em; }
	#tabs li .ui-icon-close { float: left; margin: 0.4em 0.2em 0 0; cursor: pointer; }
	#add_tab { cursor: pointer; }
</style>
<script>
$(function(){
	$("#new_category").colorbox({iframe:true, width:"305px", height:"200px"});
})
</script>
</head>
	<body>
		<section id="container">
	    	<section id="left_container">
	            <header class="resizeble">
	            	<a href="home.html" id="small_logo"></a>
	                <form action="search.jsp" method="get" id="search_form">
	                	<input type="text" name="search_field" id="search_field" class="text" />
	                    <input type="submit" id="search_field_button" value="BUSCAR" />
	                </form>
	                <a href="#" title="${userSession.user.name}" id="user_name_link">
	                	${userSession.user.name}
	                </a>
	                <a href="#" title="Atualization" id="atualization_icon">&nbsp;</a>
	                <a href="#" title="Menssages" id="message_icon">&nbsp;</a>
	            </header>
	            <nav id="menu_bar" class="resizeble">
	            	<h1>${project.name}</h1>
	                <ul id="menu">
	                	<c:forEach items="${project.categories}" var="category">
	                    	<li><a href="#category_${category.id}" title="Categoria ${category.id}" id="category_selected">${category.name}</a></li>
	                	</c:forEach>
	                </ul>
                    <section id="menu_bar_buttons">
                        <a href="${linkTo[CategoryController].insertCategoryForm}${project.id}" id="new_category" title="Adicionar Categoria">Adicionar categoria</a>
                        <a href="${linkTo[TaskPanelController].insertTaskPanelForm}${category.id}" title="Adicionar Lista" id="new_task_list" class="button">+ Nova Lista</a>
                    </section>
	            </nav>
	            <section id="content">
	            	<c:forEach items="${project.categories}" var="category">
		            	<section class="category resizeble" id="category_1">
							<h2>${category.name}</h2>
							<c:forEach items="${category.taskPanels}" var="taskPanel">
			                	<section class="task_area">
			                    	<h3>${taskPanel.name}</h3>
			                        <nav class="task_menu_bar">
			                        	<ul class="task_menu">
			                            	<li><a href="#" class="task_philter_selected">All</a></li>
			                            	<li><a href="#">To do</a></li>
			                                <li><a href="#">Doing</a></li>
			                                <li><a href="#">Done</a></li>
			                                <li><a href="#">Accepted</a></li>
			                                <li><a href="#">Rejected</a></li>
			                            </ul>
			                        </nav>
			                        <section class="task_list">
				                        <c:forEach items="${taskPanel.tasks}" var="task">
				                            <div class="task_box">${task.name }</div>
				                            <section class="options-task">
												<c:if test="${task.state != 'DONE'}">
													<c:if test="${task.state != 'DOING'}">
														<a href="${linkTo[TaskController].start}${task.id}">Começar tarefa</a>/
													</c:if>
													<c:if test="${task.state != 'TODO'}">
														<a href="${linkTo[TaskController].stop}${task.id}">Devolver tarefa</a>/
													</c:if>
													<a href="${linkTo[TaskController].finalize}${task.id}">Finalizar tarefa</a>/
												</c:if>
											</section>
			            	            </c:forEach>
			                        </section>
			                	</section>
			                </c:forEach>
			            </section>
	            	</c:forEach>
	            </section>
	            <footer>
	            	<section id="copyright" class="resizeble">
	                	Zeng - Copyright 2012 - All rights reserved
	                </section>
	            </footer>
	        </section>
	        <section id="project_sidebar">
	        	<div id="project_sidebar_click_area" class="project_sidebar_click_area">&nbsp;</div>
	            <div id="project_sidebar_content">
	            	<section id="project_sidebar_members_area">
	                	<a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	                		<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                    <a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	                    	<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                    <a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	                    	<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                    <a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	                    	<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                    <a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	                    	<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                    <a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	                		<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                    <a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	
	                    	<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                    <a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	                    	<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                    <a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	                    	<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                    <a href="#" title="Enzo Toshio" id="project_members_photo_link" class="photo_link">
	                    	<img src="img/users_images/user_photo.jpg" alt="Enzo Toshio" height="40" width="40" />
	                    </a>
	                </section>
	            </div>
	        </section>
		</section>
	</body>

</html>
