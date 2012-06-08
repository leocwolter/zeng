// JavaScript Document

$(document).ready(function(){
	
	//Take the screen width
	var left_container = $('#left_container').width();
	
	//Set the header, menu_bar, content right padding
	$('header, #menu_bar, #content').css({'width':left_container - 251, 'padding':'0px 251px 0px 0px'});
	
	var projectSidebarWidth = $('#project_sidebar').width();
	var projectSidebarContentWidth = $('#project_sidebar_content').width();
	
	$('#project_sidebar_click_area').toggle(
		function(){
			$('#project_sidebar').animate({'width':'10px'});
		},function(){
			$('#project_sidebar').animate({'width':projectSidebarWidth});				
		}
	);
});
	