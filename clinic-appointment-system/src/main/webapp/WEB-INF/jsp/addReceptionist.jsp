<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>Add Receptionist</title>
<tags:basecss></tags:basecss>
<link href="<c:url value='/resources/css/receptionist.css'/>"
	rel="stylesheet" />
</head>
<body>
	<tags:header></tags:header>
	<div class="container">
		<div class="col-md-5">
			<div class="form-area">
				<form:form method="post" action="" modelAttribute="addReceptionist">
					<br style="clear: both">
					<h3 style="margin-bottom: 25px; text-align: center;">Add New
						Receptionist</h3>
					 <div class="form-group">
						<label for="firstname">FirstName</label>
						<form:input type="text" class="form-control" path="firstName"></form:input>
					</div> 
					<div class="form-group">
						<label for="lastname">LastName</label>
						<form:input type="text" class="form-control" path="lastName"></form:input>
					</div>

					<div class="form-group">
						<label for="email">Email</label>
						<form:input type="text" class="form-control" id="email" path="email"></form:input>
					</div>
					 <div class="form-group">
						<label for="password">Password</label>
						<form:input type="password" class="form-control" id="password" path="user.password"></form:input>
					</div> 

					<button name="submit"
						class="btn btn-primary pull-right">Save</button>
						<a href="<c:url value='/admin/receptionist'/>" class= "btn btn-primary pull-right">Cancel</a>
				</form:form>
			</div>
		</div>
	</div>
	<tags:footer></tags:footer>
	<script type="text/javascript"
		src="<c:url value='/resources/js/receptionist.js'/>"></script>
</body>
</html>

