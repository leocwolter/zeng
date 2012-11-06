//Modal Bind
$(".modal").click(function(event){
	var url = $(this).attr("href");
	Messi.load(url,{modal:true, modalOpacity:0.4});
	event.preventDefault();
});