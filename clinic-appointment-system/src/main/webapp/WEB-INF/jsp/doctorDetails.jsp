<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clinic Appointment System</title>
<tags:basecss></tags:basecss>
</head>
<body>
	<tags:header></tags:header>
	<div id="main">
		<div class="page-tools">
			<a class="go-back" href="<c:url value='/home' />">Go Back</a>
		</div>
		<h3>Your details</h3>
		<hr>
		
		
			<div id="PassportSizePhoto">
				<p>
					<img  class="imgRounded" width="150px" height="150px" src="<c:url value="/resources/images/${doctor.lastName}_${doctor.id}.jpg"></c:url>" alt=""/> 
				
				</p>
			</div>
			
			<div id="account-info">
				
				<p>
					<label class="field-label">First Name</label>
					<span>${doctor.firstName}</span>
				</p>
				<p>
					<label class="field-label">Last Name</label>
					<span>${doctor.lastName}</span>
				</p>

				<p>
					<label class="field-label">Email</label>
					<span>${doctor.email}</span>
				</p>
			</div>
			
			<p id="button-panel">
			
			<!-- <hr> -->
			</p>
		
	</div>
	<tags:footer></tags:footer>
	<tags:basejs></tags:basejs>
</body>
</html>