$(function() {

	$('.category-button').click(
			function() {
				var categoryButtonStatus = $(this).attr('id');
				if (!(categoryButtonStatus == "selected-category-button")) {
					$("#selected-category-button").removeAttr('id');
					$(this).attr('id', 'selected-category-button');
					var index = $(".category-button").index(this) + 1;
					var categoryButtonDestination = "#category-" + index;
					$(categoryButtonDestination).addClass('selected-category');
					$('.category:not('+categoryButtonDestination+')').removeClass(
							'selected-category');
				}
			});

});