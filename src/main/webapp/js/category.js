$(function(){
	
	$('.category_button').click(function(){
		
		var categoryButtonStatus = $(this).attr('id');
		
		if(!(categoryButtonStatus == "selected_category_button")){
			
			$(this).attr('id', 'selected_category_button');
			
			//$(this).siblings().removeAttr('id');
			
			$('.category_button').not(this).removeAttr('id');
			
			var categoryButtonDestination = $(this).attr('href');
			
			//alert(categoryButtonDestination);
			
			$(categoryButtonDestination).addClass('selected_category');
			
			$('.category').not(categoryButtonDestination).removeClass('selected_category');
			
		}
		
	});
	
});