// JavaScript Document

$(document).ready(function(){
	
	//Get Width of elements on the load
	var projectSidebarWidth = $('#project_sidebar').width();
	
	var projectSidebarClickAreaWidth = $('#project_sidebar_click_area').width();

	//Set the header, menu_bar, content right padding
	adjustsSizes();

	//Readjusts size of elements on resize event.
	$(window).resize(function(){
		adjustsSizes();
	});
	
	//Minimize / Maximize Sidebar and readjusts elements
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
		
		var paddingRight = projectSidebarWidth + 10;
		
		var paddingLeft = 10;
		
		var width = leftContainerWidth - (paddingRight + paddingLeft);

		$('.resizeble').animate({'width':width, 'padding-right':paddingRight, 'padding-left':paddingLeft});
		
	}
	
});