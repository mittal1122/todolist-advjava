<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body style="background-color: black;">
	<%
	String genderValue = (String) request.getAttribute("genderValue");
	%>

	<div class="container" style="margin-top: 30px;">
		<div class="col-md-10 col-md-offset-1">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<strong>Sign in </strong>
					</h3>

				</div>

				<div class="panel-body">
					<form role="form" action="SignupController" method="post">

						<div class="row">
							<div class="col-xs-12 col-sm-4 col-md-4">
								<div class="form-group">
									<input type="text" name="firstname" id="first_name"
										class="form-control" placeholder="First Name" tabindex="1"
										value="${firstnameValue }"> ${firstnameError}
								</div>
							</div>

							<div class="col-xs-12 col-sm-4 col-md-4">
								<div class="form-group">
									<input type="text" name="lastname" id="last_name"
										class="form-control " placeholder="Last Name" tabindex="2"
										value="${lastnamevalue }">${lastnameError}
								</div>
							</div>
						</div>

						<div class="form-group">
							<input type="email" name="email" id="email" class="form-control "
								placeholder="Email Address" tabindex="4" value="${emailValue }">${emailError }
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="password" id="password"
										class="form-control " placeholder="Password" tabindex="5">${passwordError}
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									Gender :- Male : <input type="radio" name="gender" value="male">
									<%=genderValue != null && genderValue.equals("male") ? "checked" : ""%>
									Female : <input type="radio" name="gender" value="female">
									<%=genderValue != null && genderValue.equals("female") ? "checked" : ""%>
								</div>
								${genderError}
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-8">
						<div class="input-group">
							<label class="label">Security Question</label> <select
								class="input--style-4" name="sQuestion"
								aria-label="Default select example"
								style="height: 3em; width: 34em;">
								<option selected disabled>Select Question</option>
								<option value="What's Your Birth Year ?">What's Your
									Birth Year ?</option>
								<option value="What's Your Nick Name ?">What's Your
									Nick Name ?</option>
								<option value="What's Your BestFriend's Name ?">What's
									Your BestFriend's Name ?</option>
							</select>
						</div>
						<br>
						<div class="row row-space">  
                                <div class="input-group">
                                    <label class="label">Security Answer</label>
                                    <input class="input--style-4" type="text" name="sAnswer" value="${sAnswerValue}" style="height: 3em;width: 34em;"><span class="error">${sAnswerError}</span>
                                </div>
                            </div>
						</div>
						<button type="submit" class="btn btn-success">Sign in</button>

						<hr style="margin-top: 10px; margin-bottom: 10px;">


						<div class="form-group">
							<div style="font-size: 85%">
								i have an account <a href="Login.jsp"> Login Here </a>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>