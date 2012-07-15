$(function() {

	$('.category_button').click(
			function() {

				var categoryButtonStatus = $(this).attr('id');

				if (!(categoryButtonStatus == "selected_category_button")) {

					$(this).attr('id', 'selected_category_button');

					// $(this).siblings().removeAttr('id');

					$('.category_button').not(this).removeAttr('id');

					var index = $(".category_button").index(this) + 1;

					var categoryButtonDestination = "#category_"+index;

					console.log(categoryButtonDestination);
					// alert(categoryButtonDestination);

					$(categoryButtonDestination).addClass('selected_category');

					$('.category').not(categoryButtonDestination).removeClass(
							'selected_category');

				}

			});

});