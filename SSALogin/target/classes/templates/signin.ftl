<!DOCTYPE html>
<html>
<head>
	<title>Sign in</title>
	<meta name="viewport" http-equiv="Content-Type" content="charset=UTF-8; width=device-width, initial-scale=1"/>
	<link rel="stylesheet" type="text/css" href="/styles/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="row" style="margin:10% 0">
		<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<form action="/sign-in" method="post">
				<h2>Please Sign In</h2>
				<#if error??>
					<h4 class="alert alert-danger">
					${error}
					</h4>
				</#if>
				<div class="form-group">
					<input type="text" name="username" id="login" class="form-control input-lg" autofocus required
					       placeholder="Login" value="<#if login??>${login}</#if>">
				</div>
				<div class="form-group">
					<input type="password" name="password" id="password" class="form-control input-lg" required
					       placeholder="Password">
				</div>
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6">
						<a href="/sign-up" class="btn btn-lg btn-primary btn-block">Register</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>