<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<tags:basecss></tags:basecss>
<title>Add Doctor</title>
</head>
<body>
	<tags:header></tags:header>
	<div class="container">
		<div class="row main">
			<form:form method="POST" action=""	modelAttribute="addDoctor">
				<div class="form-group">
					<label for="firstName" class="cols-sm-2 control-label">First
						Name</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
								aria-hidden="true"></i></span>
							<form:input type="text" class="form-control" path="firstName"
								id="firstName" placeholder="First Name" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="lastName" class="cols-sm-2 control-label">Last
						Name</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
								aria-hidden="true"></i></span>
							<form:input type="text" class="form-control" path="lastName"
								id="lastName" placeholder="Last Name" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="speciality" class="cols-sm-2 control-label">Speciality</label>
					<div class="dropdown dropdown-lg">
						<div class="input-group">
							<form:select id="speciality" path="speciality"
								class="form-control">
								<form:option value="CARDIOLOGIST">CARDIOLOGIST</form:option>
								<form:option value="DERMATOLOGISTS">DERMATOLOGISTS</form:option>
								<form:option value="GASTROENTEROLOGIST">GASTROENTEROLOGIST</form:option>
								<form:option value="NEUROLOGIST">NEUROLOGIST</form:option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="cols-sm-2 control-label">Your
						Email</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-envelope fa" aria-hidden="true"></i></span>
							<form:input type="text" class="form-control" path="email"
								id="email" placeholder="Enter your Email" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="password" class="cols-sm-2 control-label">Password</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <form:input
								type="password" class="form-control" path="user.password"
								id="password" placeholder="Enter your Password" />
						</div>
					</div>
				</div>

				<div class="form-group ">
				<input type="submit" value="Save" class="btn btn-info"/>
					<!-- <a href="#" class="btn btn-info">Save</a> -->
					<a href="<c:url value='/admin/doctor'/>" class="btn btn-danger">Cancel</a>
				</div>
			</form:form>
		</div>
	</div>
	<tags:basejs></tags:basejs>

	<tags:footer></tags:footer>
</body>
</html>