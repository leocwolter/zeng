// JavaScript Document

$(document).ready(
		function() {
			// Get Width of elements on the load
			var projectSidebarWidth = $('#project-sidebar').width();
			var projectSidebarClickAreaWidth = $('#project-sidebar-click-area')
					.width();
			// Set the header, menu_bar, content right padding and width
			adjustsSizes();
			// Readjusts size of elements on resize event.
			$(window).resize(function() {
				adjustsSizes();
			});
			// Minimize / Maximize Sidebar and readjusts elements
			$('#project-sidebar-click-area').toggle(
				function() {
	
					$('#project-sidebar').animate({
						'width' : projectSidebarClickAreaWidth
					}, function() {
						adjustsSizes();
					});
	
				}, function() {
	
					$('#project-sidebar').animate({
						'width' : projectSidebarWidth
					}, function() {
						adjustsSizes();
					});
	
				}
			);

			// Set the width and padding of elements with resizable class
			function adjustsSizes() {

				var leftContainerWidth = $('#left-container').width();

				var projectSidebarWidth = $('#project-sidebar').width();

				var paddingRight = projectSidebarWidth + 10;

				var paddingLeft = 10;

				var width = leftContainerWidth - (paddingRight + paddingLeft);
				
				if(width <= 0){
					width = "100%";
				}

				$('.resizable').animate({
					'width' : width,
					'padding-right' : paddingRight,
					'padding-left' : paddingLeft
				});

			}
			
			// Set the content's top margin 
			var headerHeight = $('header').height();
			
			$('#content').css('margin-top', headerHeight);
			
		}
);