// JavaScript Document

$(document).ready(
		function() {
			// Get Width of elements on the load
			var projectSidebarWidth = $('#project-sidebar').width();
			var projectSidebarClickAreaWidth = $('#project-sidebar-click-area').width();
			
			if($('#project-sidebar')[0]){
				$('.resizable').addClass('opened-sidebar');
			}

			// Minimize / Maximize Sidebar and readjusts elements class setting
			$('#project-sidebar-click-area').toggle(
				function() {
	
					$('#project-sidebar').animate({
						'width' : projectSidebarClickAreaWidth
					}, function() {
						$('.resizable').addClass('closed-sidebar').removeClass('opened-sidebar');
					});
	
				}, function() {
	
					$('#project-sidebar').animate({
						'width' : projectSidebarWidth
					}, function() {
						$('.resizable').addClass('opened-sidebar').removeClass('closed-sidebar');
					});
	
				}
			);

		}
);