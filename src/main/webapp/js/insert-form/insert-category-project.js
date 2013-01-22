$(function () {
	function appendLinkToMenu(data) {
		link = $.nano("<a href='{href}' title='{name}'>{name}</a>", data),
		menuItem = $("<li>").append(link);
		appendInApropriatedContainer(menuItem);
	}
	
	function appendInApropriatedContainer(menuItem){
		var page = $(parent.document);
		var target = page.find("#menu");
		if($('#menu li').size() >= 4){
			console.log("entrei");
			target = page.find(".other-itens").first();
			document.location.reload(true);
		}
		$(menuItem).appendTo(target);
	}

	//Project & Category insertion
	$(".simple-insert-form").submit(function (event) {
		event.preventDefault();
		var form = $(this);
		var url = form.find("[name='showUrl']").val();
		submitForm(form,  function (data) {
			appendLinkToMenu({"href":url+data.insertedElement.url, "name":data.insertedElement.name});
		});
	});
	
});