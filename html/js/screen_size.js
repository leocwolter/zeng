// JavaScript Document

$(document).ready(function(){
	var projectSidebarWidth = $('#project_sidebar').width();
	var projectSidebarClickAreaWidth = $('#project_sidebar_click_area').width();

	//Set the header, menu_bar, content right padding
	adjustsSizes();

	//Readjusts size of elements on resize event.
	$(window).resize(function(){
		adjustsSizes();
	});
	
	//Minimize/Maximize Sidebar and readjusts elements
	$('#project_sidebar_click_area').toggle(
		function(){
			$('#project_sidebar').animate({'width':projectSidebarClickAreaWidth}, function(){
				adjustsSizes();
			});
		},function(){
			$('#project_sidebar').animate({'width':projectSidebarWidth}, function(){
				adjustsSizes();
			});				
		}
	);
	
	function adjustsSizes(){
		var leftContainerWidth = $('#left_container').width();
		var projectSidebarWidth = $('#project_sidebar').width();
		var projectSidebarContentWidth = $('#project_sidebar_content').width();		
		
		var menuWidth = $('#menu').width();
		
		var width = leftContainerWidth - projectSidebarWidth;
		var padding = projectSidebarWidth+2;
		
		$('#left_container').children().css({'width':width, 'padding-right':padding});	
	}
	
});
