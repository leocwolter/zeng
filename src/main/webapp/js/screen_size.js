// JavaScript Document

$(document).ready(function() {
	var SideBar = function(data){
		this.closedSidebar = data.closedSidebar;

		this.closeSidebar = data.closeSidebar;
		this.openSidebar = data.openSidebar;
		
		// Get Width of elements on the load
		this.element = data.element;
		this.clickArea = data.clickArea;

		this.setToggleFunctions();
	}
	
	SideBar.prototype.setToggleFunctions = function(){
		if(this.closedSidebar == "true"){
			this.firstToggleFunction = this.openSideBar;
			this.secondToggleFunction = this.closeSideBar;
			this.element.css('width', this.clickArea.width());
		}else{
			this.firstToggleFunction = this.closeSideBar;
			this.secondToggleFunction = this.openSideBar;
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
				closeSideBar: closeSideBar,
				openSideBar: openSideBar,
				element: sideBarElement,
				clickArea: clickArea
		});
		sideBar.toggle();
	}
});