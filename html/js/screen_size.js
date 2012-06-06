// JavaScript Document

$(document).ready(function(){
	
	//Take the screen width
	left_container = $('#left_container').width();
	
	//Set the header, menu_bar, content right padding
	$('header, #menu_bar, #content').css({'width':left_container - 251, 'padding':'0px 251px 0px 0px'});
	
	$('#project_sidebar_click_area').click(
		function(){
			$('#project_sidebar').animate({ width:'0px'});
			$('#project_sidebar_click_area_return').show();
			
			//Set the header, menu_bar, content right padding
			$('header, #menu_bar, #content').css({'width':left_container - 12, 'padding':'0px 12px 0px 0px'});

		}
	);
	
	$('#project_sidebar_click_area_return').click(
		function(){
			$('#project_sidebar').animate({ width:'250px'});
			$('#project_sidebar_click_area_return').hide();
		}
	);
});