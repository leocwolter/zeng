// JavaScript Document

$(document).ready(function(){
	var projectSidebarWidth = $('#project_sidebar').width();
	
	//Set the header, menu_bar, content right padding
	adjustsSizes();

	$(window).resize(function(){
		adjustsSizes();
	});
	
	$('#project_sidebar_click_area').toggle(
		function(){
			$('#project_sidebar').animate({'width':'10px'});
		},function(){
			$('#project_sidebar').animate({'width':projectSidebarWidth});				
		}
	);
	
	
	function adjustsSizes(){
		var leftContainerWidth = $('#left_container').width();
		var projectSidebarWidth = $('#project_sidebar').width();
		var projectSidebarContentWidth = $('#project_sidebar_content').width();		
		
		var menuWidth = $('#menu').width();
		
		var width = leftContainerWidth - projectSidebarWidth;
		var padding = projectSidebarWidth+2;
		
		$('header, #menu_bar, #content').css({'width':width, 'padding-right':padding});	
	}
	
});
	