$(function(){
	$(".colorbox").colorbox({
		iframe:true,
		width:"305px",
		height:"230px",
		onClosed:function(){window.location.reload();}
	});
});

$(window).scroll(function () {
	var scrollProsition = $(document).scrollTop();
	
    $('#top').animate({
    	
        top: scrollProsition+'px'
        
        },{duration:500,queue:false}
        
    );
    
});

$(function() {
	$( ".task_area" ).children().sortable({
		connectWith: ".task_list"
	}).disableSelection();
});