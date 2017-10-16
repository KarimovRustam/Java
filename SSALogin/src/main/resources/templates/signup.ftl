<!DOCTYPE html>
<html>
<head>
	<title>Sign up</title>
	<meta name="viewport" http-equiv="Content-Type" content="charset=UTF-8; width=device-width, initial-scale=1"/>
	<link rel="stylesheet" type="text/css" href="/styles/bootstrap.min.css">
	<script src="/scripts/signup.js"></script>
</head>
<body>
<div class="container">
	<div class="row" style="margin:10% 0">
		<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<form action="/sign-up" onsubmit="return validateForm()" method="post">
				<h2 id="info">Create your account</h2>
				<#if error??>
					<h4 class="alert alert-danger">
						${error}
					</h4>
				</#if>
				<div class="form-group">
					<input type="text" name="login" id="login" class="form-control input-lg" placeholder="Login" required>
				</div>
				<div class="form-group">
					<input type="password" name="password" id="password" class="form-control input-lg" required
					       placeholder="Password">
				</div>
				<div class="form-group">
					<input type="password" name="password-confirm" id="password-confirm" class="form-control input-lg" required
					       placeholder="Repeat password">
				</div>
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<input type="submit" class="btn btn-lg btn-success btn-block" value="Sign Up">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>