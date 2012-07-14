/*$(function() {
		var $tab_title_input = $( "#tab_title"),
			$tab_content_input = $( "#tab_content" );
		var tab_counter = 2;

		// tabs init with a custom tab template and an "add" callback filling in the content
		var $tabs = $( "#menu_bar").tabs({
			tabTemplate: "<li><a href='#{href}' title='#{label}'>#{label}</a></li>",
			add: function( event, ui ) {
				var tab_content = $tab_content_input.val() || "Tab " + tab_counter + " content.";
				$( '#category_'+tab_counter ).append( "<p>" + tab_content + "</p>" );
			}
		});

		// modal dialog init: custom buttons and a "close" callback reseting the form inside
		var $dialog = $( "#dialog" ).dialog({
			autoOpen: false,
			modal: true,
			buttons: {
				Add: function() {
					addTab();
					$( this ).dialog( "close" );
				},
				Cancel: function() {
					$( this ).dialog( "close" );
				}
			},
			open: function() {
				$tab_title_input.focus();
			},
			close: function() {
				$form[ 0 ].reset();
			}
		});

		// addTab form: calls addTab function on submit and closes the dialog
		var $form = $( "form", $dialog ).submit(function() {
			addTab();
			$dialog.dialog( "close" );
			return false;
		});

		// actual addTab function: adds new tab using the title input from the form above
		function addTab() {
			var tab_title = $tab_title_input.val() || "Tab " + tab_counter;
			$tabs.tabs( "add", "#category_" + tab_counter, tab_title );
			tab_counter++;
		}

		// addTab button: just opens the dialog
		$( "#add_tab" )
			.button()
			.click(function() {
				$dialog.dialog( "open" );
			});

		// close icon: removing the tab on click
		// note: closable tabs gonna be an option in the future - see http://dev.jqueryui.com/ticket/3924
		$( "#tabs span.ui-icon-close" ).live( "click", function() {
			var index = $( "li", $tabs ).index( $( this ).parent() );
			$tabs.tabs( "remove", index );
		});
	});
*/
$(document).ready(function(){
	
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