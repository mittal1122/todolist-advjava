<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Score</title>
</head>
<body>
	<jsp:include page="UserNavbar.jsp"></jsp:include>
	<div class="container">${taskPending}</div>
	<div class="container card text-white bg-dark mb-3"
		style="max-width: 18rem;">
		<div class="card-header">Priority</div>
		<div class="card-body">
			<h5 class="card-title">${marks}%</h5>

		</div>
	</div>


</body>
</html>