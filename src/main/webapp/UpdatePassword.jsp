<%@page import="com.Bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Password</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body style="background-color: black;">
	<%
	String sQuestion = (String) request.getAttribute("sQuestion");
	%>

	<div class="container" style="margin-top: 30px;">
		<div class="col-md-10 col-md-offset-1">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<strong>Update Password </strong>
					</h3>

				</div>

				<div class="panel-body">
					<form role="form" action="UpdatePasswordController" method="post">

						<div class="form-group">
							<input type="email" name="email" id="email" class="form-control "
								placeholder="Email Address" disabled tabindex="4"
								value="${email }">
								<input type="hidden" name="email" id="email" class="form-control "
								placeholder="Email Address"  tabindex="4"
								value="${email }">
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="password" id="password"
										class="form-control " placeholder="Enter New Password" tabindex="5">
								</div>
							</div>

						</div>
						


						<button type="submit" class="btn btn-success">Submit</button>

						<hr style="margin-top: 10px; margin-bottom: 10px;">


					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>