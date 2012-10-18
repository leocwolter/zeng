// JavaScript Document

$(function() {
		// Set the content's top margin 
		var header = $('header');
		var headerHeight = header.height(), 
			headerPadding = parseInt(header.css("padding-top").replace("px","")) + parseInt(header.css("padding-bottom").replace("px","")),
			maxHeight = headerHeight+headerPadding;
		$('.content').css('margin-top', maxHeight);
	}
);