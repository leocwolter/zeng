<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ taglib prefix="zeng-messages" tagdir="/WEB-INF/tags/messages" %>
<%@ taglib prefix="zeng-structure" tagdir="/WEB-INF/tags/structure" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zeng - ${project.name}</title>
<c:import url="/WEB-INF/imports/script-css.jsp"/>

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
});

</script>
</head>
	<body>
		<section id="container">
	    	<section id="left_container">
	    	
	            <zeng-structure:header/>
	            
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
	            	<ul id="category_container" class="resizeble">
		            	<c:forEach items="${project.categories}" var="category">
		            		<li class="category" id="category_${category.id}">	
								<h2>${category.name}</h2>
								<c:forEach items="${category.taskPanels}" var="taskPanel">
									<zeng-structure:taskList taskPanel="${taskPanel}"/>
								</c:forEach>
							</li>
	            		</c:forEach>
            		</ul>
				</section>
				
				<zeng-structure:footer/>
				
	        </section>
	        
	        <zeng-structure:sideBar/>
        
        </section>
	</body>

</html>
