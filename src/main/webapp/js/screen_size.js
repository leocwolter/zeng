// JavaScript Document

$(document).ready(
		function() {
			var SideBar = function(data){
				console.log("instanciei");
				this.closedSidebar = data.closedSidebar;

				// Get Width of elements on the load
				this.element = data.element;
				this.clickArea = data.clickArea;

				this.setToggleFunctions();
			}
			
			SideBar.prototype.setToggleFunctions = function(){
				if(this.closedSidebar == "true"){
					this.firstToggleFunction = openSideBar;
					this.secondToggleFunction = closeSideBar;
					this.element.css('width', this.clickArea.width());
				}else{
					this.firstToggleFunction = closeSideBar;
					this.secondToggleFunction = openSideBar;
					$('.resizable').addClass('opened-sidebar');
				}

			}
			
			SideBar.prototype.toggle = function(){
				this.clickArea.toggle(this.firstToggleFunction, this.secondToggleFunction);
			}


			var sideBarElement = $('#project-sidebar'), sideBarWidth = sideBarElement.width();
			var clickArea = $('#project-sidebar-click-area'), clickAreaWidth = clickArea.width();
			
			//Animation to close sidebar
			var closeSideBar = function(){
				localStorage.closedSidebar = true;
				$('#project-sidebar').animate({
					'width' : clickAreaWidth
				}, function() {
					$('.resizable').addClass('closed-sidebar').removeClass('opened-sidebar');
				});
			};
			
			//Animation to open sidebar
			var openSideBar = function(){
				localStorage.closedSidebar = false;
				$('#project-sidebar').animate({
					'width' : sideBarWidth
				}, function() {
					$('.resizable').addClass('opened-sidebar').removeClass('closed-sidebar');
				});
			};
			
			var sideBar = new SideBar({
					closedSidebar: localStorage.closedSidebar,
					element: sideBarElement,
					clickArea: clickArea
			});
			sideBar.toggle();
		}
);