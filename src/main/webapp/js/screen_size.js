$(document).ready(function() {
	var SideBar = function(data){
		this.closedSidebar = data.closedSidebar;

		this.closeSidebar = data.closeSidebar;
		this.openSidebar = data.openSidebar;
		
		this.element = data.element;
		this.clickArea = data.clickArea;

		this.setToggleFunctions();
	}
	
	SideBar.prototype.setToggleFunctions = function(){
		if(this.closedSidebar == "true"){
			this.firstToggleFunction = this.openSidebar;
			this.secondToggleFunction = this.closeSidebar;
			this.element.css('width', this.clickArea.width());
		}else{
			this.firstToggleFunction = this.closeSidebar;
			this.secondToggleFunction = this.openSidebar;
			$('.resizable').addClass('opened-sidebar');
		}

	}
	
	SideBar.prototype.toggle = function(){
		this.clickArea.toggle(this.firstToggleFunction, this.secondToggleFunction);
	}

	var sideBarElement = $('#project-sidebar');
	var clickArea = $('#project-sidebar-click-area');
	if(sideBarElement !== undefined) toggleSideBar(sideBarElement, clickArea);
	
	function toggleSideBar(sideBarElement, clickArea){
		var sideBarWidth = sideBarElement.width();
		var clickAreaWidth = clickArea.width();
		
		//Animation to close sidebar
		var closeSidebar = function(){
			localStorage.closedSidebar = true;
			$('#project-sidebar').animate({
				'width' : clickAreaWidth
			}, function() {
				$('.resizable').addClass('closed-sidebar').removeClass('opened-sidebar');
			});
		};
		
		//Animation to open sidebar
		var openSidebar = function(){
			localStorage.closedSidebar = false;
			$('#project-sidebar').animate({
				'width' : sideBarWidth
			}, function() {
				$('.resizable').addClass('opened-sidebar').removeClass('closed-sidebar');
			});
		};
		
		var sideBar = new SideBar({
				closedSidebar: localStorage.closedSidebar,
				closeSidebar: closeSidebar,
				openSidebar: openSidebar,
				element: sideBarElement,
				clickArea: clickArea
		});
		sideBar.toggle();
	}
});