<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="list-group" style="width:250px">
<a class="list-group-item" href="<c:url value="/patient/appointment/create" />">Make Appointment</a>
<a class="list-group-item" href="<spring:url value="/patient/appointment/status"></spring:url>">View Appointment Status</a>
<a class="list-group-item" href="<spring:url value="/patient/medicalReport"></spring:url>">View Medical History</a>
<a class="list-group-item" href="<spring:url value="/patient/details"></spring:url>">View Your Details</a>
</div>