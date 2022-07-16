<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgor Password</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<%
	String emailErrorMsg = (String) request.getAttribute("emailErrorMsg");
	
	
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
		<div class="row">
			<div class="col-md-6">
				Enter Email For Verifying<br> <br>
				<form method="POST" action="ForgotPasswordController" >

					<div class="form-group">
						<input class="form-control" placeholder="Email" type="email"
							name="VerifyEmail" required /><br> <br>
						<%=emailErrorMsg == null ? "" : emailErrorMsg%><br>
					</div>
					
				
					<div>
						<input type="submit"  class="btn btn-primary"
							value="Check">
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>