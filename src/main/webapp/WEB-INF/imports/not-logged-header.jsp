<header class="top">
	<div class="container">
		<a href="${linkTo[ProjectController].listProjects}" class="small-logo">Zeng</a>
		<form class="login-form" action="${linkTo[UserController].logIn}" method="post">
			<input class="text-input" type="email" name="user.email" placeholder="email@zeng.com" autofocus="autofocus" />
			<input class="text-input" type="password" name="user.password" placeholder="Password" />
			<input class="button normal-button" type="submit" value="Login" />
		</form>
	</div>
</header>