<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clinic Appointment System</title>
<tags:basecss></tags:basecss>
<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet" />
</head>
<body>
	<tags:header></tags:header>
	<div id="main">
		<form action="<spring:url value="/login"></spring:url>" method="post">
			<h1>Login</h1>
			<p>
				<label for="username" class="field-label">Username</label>
				<input type="text" id="username" name="username" maxlength="50" required="required" />
			</p>
			<p>
				<label for="password" class="field-label">Password</label>
				<input type="password" id="password" name="password" maxlength="50" required="required" />
			</p>
			<p>
				<label id="remember-me"><input type="checkbox" id="rememberMe" name="rememberMe" /> Remember Me?</label>
			</p>
			<p>
				<input type="submit" value="Login" />
			</p>
			<security:csrfInput />
		</form>
		<c:if test="${not empty error}">
			<p class="error">
				<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
			</p>
		</c:if>
	</div>
	<tags:footer></tags:footer>
	<tags:basejs></tags:basejs>
</body>
</html> --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clinic Appointment System</title>
<tags:basecss></tags:basecss>
<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>
	<tags:header></tags:header>
	<div id="main">
		<!-- <h1>Clinic Appointment Login</h1> -->


		<div class="login-section">
			<h2>Login</h2>
			<form id="loginForm"
				action="<spring:url value="/login"></spring:url>" method="post">

				<div class="form-group">
					<label for="username" class="field-label">User Name</label> <input
						type="text" name="username" class="form-control" id="username"
						placeholder="Username" maxlength="50">
				</div>

				<div class="form-group">
					<label for="password" class="field-label">Password</label> <input
						type="password" id="password" name="password" class="form-control"
						placeholder="Password" maxlength="50" />
					<!-- pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,})" -->
				</div>
				<!--  <div class="form-check">
                <label class="form-check-label"> 
                <input type="checkbox" name="remember" class="form-check-input"> Remember Me </label>
            </div> -->
				<button type="submit" name="login-btn" class="btn btn-primary">Login</button>

				<!-- <a href="#" name="signup-btn" class="btn btn-info">Sign up</a> -->
				<security:csrfInput />
			</form>
		</div>
		<c:if test="${not empty error}">
			<p class="error">
				<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
			</p>
		</c:if>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<tags:footer></tags:footer>
	<tags:basejs></tags:basejs>
</body>
</html>