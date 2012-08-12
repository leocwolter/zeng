$(document).ready(function() {
	$("#login-form").validate({
		rules: {
			'user.email': {
				required: true,
				email: true
			},
			'user.password': {
				required: true,
				minlength: 10
			}
		},
		messages: {
			'user.email': {
				required: "",
				email: ""
			},
			'user.password': {
				required: "",
				minlength: ""
			}
		}
	});
	$("#register-user-form").validate({
		rules: {
			'user.name': {
				required: true,
				minlength: 5
			},
			'user.email': {
				required: true,
				email: true
			},
			'user.password': {
				required: true,
				minlength: 10
			},
			'user.confirmPassword': {
				required: true,
				equalTo: "#password"
			},
			'terms': {
				required: true
			}
		},
		messages: {
			'user.name': {
				required: "Please provide a name",
				minlength: "Your name must be at least 5 characters long"
			},
			'user.email': {
				required: "Please provide a email",
				email: "Please enter a valid email address"
			},
			'user.password': {
				required: "Please provide a password",
				minlength: "Your password must be at least 10 characters long"
			},
			'user.confirmPassword': {
				required: "Please confirm your password",
				equalTo: "Your password must be iqual to the first"
			},
			'terms': {
				required: "Please acept our terms, conditions and privacy policy"
			}
		}
	});
});