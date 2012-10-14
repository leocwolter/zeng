<header id="top" class="header resizable">
	<a href="${linkTo[ProjectController].listProjects}" id="small-logo">Zeng</a>
	<form action="${linkTo[UserController].logIn}" method="post" id="login-form">
		<input type="email" name="user.email" placeholder="email@zeng.com" autofocus="autofocus" />
		<input type="password" name="user.password" placeholder="Password" />
		<input type="submit" value="Login" class="button normal-button" />
	</form>
</header>