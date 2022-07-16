<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>


</head>
<body>

	<jsp:include page="UserNavbar.jsp"></jsp:include>
	<div
		style="background-color: black; color: white; width: 100%; height: 500px;">
		<div class="container" style="margin-top: 30px;">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<strong>Add Task </strong>
						</h3>

					</div>

					<div class="panel-body">
						<form role="form" action="AddTaskController" method="post">

							<div class="row">
								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<div class="mb-3">
											<label class="mb-1"><strong>Task Name</strong></label> <input
												type="text" name="taskName" class="form-control"
												placeholder="Add Task"> ${taskErrorMsg }
										</div>
									</div>

								</div>

								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<div class="mb-3">
											<label class="mb-1"><strong>Task Description</strong></label>
											<input type="text" name="taskDescription"
												class="form-control" placeholder="discription">

										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<label class="mb-1"><strong>Set Priority</strong></label>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="priority"
												value="high"> <label class="form-check-label">
												High</label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="priority"
												value="medium"> <label class="form-check-label">
												Medium </label>
										</div>
										${prorityErrorMsg }
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<label class="mb-1"><strong>Status</strong></label>
										<div class="form-check">
											<input class="form-check-input" type="radio" checked name="status"
												value="pending"> <label class="form-check-label">
												Pending</label>
										</div>
										
										<div class="form-check">
											<input class="form-check-input" disabled type="radio" name="status"
												value="done"> <label class="form-check-label">
												Done</label>
										</div>
										${statusErrorMsg }
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<div class="mb-3">
											<label class="mb-1"><strong>End Date</strong></label> <input
												type="date" name="endDate" class="form-control">
										</div>
										${endDateErrorMsg }
									</div>
								</div>
							</div>

							<button type="submit" class="btn btn-success">Add</button>

							<hr style="margin-top: 10px; margin-bottom: 10px;">


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>