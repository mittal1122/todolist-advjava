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
						<strong>Answer The Follow Question </strong>
					</h3>

				</div>

				<div class="panel-body">
					<form role="form" action="CheckQAController" method="post">

						<div class="form-group">
							<input type="email" name="email" id="email" class="form-control "
								placeholder="Email Address" disabled tabindex="4"
								value="${user }"> <input type="hidden" name="email"
								id="email" class="form-control " placeholder="Email Address"
								tabindex="4" value="${user }">
						</div>

						<div class="input-group">
							<label class="label">Question : </label> <select
								class="input--style-4" name="sQuestion"
								aria-label="Default select example"
								style="height: 3em; width: 34em;">
								<option selected>Select Question</option>
								<option value="What's Your Birth Year ?"
									<%=sQuestion != null && sQuestion.equals("What's Your Birth Year ?") ? "selected" : ""%>>What's
									Your Birth Year ?</option>
								<option value="What's Your Nick Name ?"
									<%=sQuestion != null && sQuestion.equals("What's Your Nick Name ?") ? "selected" : ""%>>What's
									Your Nick Name ?</option>
								<option value="What's Your BestFriend's Name ?"
									<%=sQuestion != null && sQuestion.equals("What's Your BestFriend's Name ?") ? "selected" : ""%>>What's
									Your BestFriend's Name ?</option>
							</select>
						</div>
						<br>
						<div class="row row-space">
							<div class="input-group">
								<label class="label">Security Answer</label> <input
									class="input--style-4" type="text" name="sAnswer"
									value="${sAnswerValue}" placeholder="Answer"
									style="height: 3em; width: 34em;"><span class="error">${sAnswerError}</span>
							</div>
						</div>
						<button type="submit" class="btn btn-success">Submit</button>
						${ansError }
						<hr style="margin-top: 10px; margin-bottom: 10px;">


					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>