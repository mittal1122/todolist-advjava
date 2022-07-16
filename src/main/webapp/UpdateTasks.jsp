<%@page import="com.Bean.TaskBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Task</title>


</head>
<body>
	<%
	TaskBean tasks = (TaskBean) request.getAttribute("tasks"); 
	String priority =tasks.getPriority();
	String status = tasks.getStatus();
	%>

	<jsp:include page="UserNavbar.jsp"></jsp:include>
	<div
		style="background-color: black; color: white; width: 100%; height: 500px;">
		<div class="container" style="margin-top: 30px;">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<strong>Update Task </strong>
						</h3>

					</div>

					<div class="panel-body">
						<form role="form" action="UpdateTaskController" method="post">
							<input type="hidden" name="taskid" value="${tasks.taskId }"/>
							<div class="row">
								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<div class="mb-3">
											<label class="mb-1"><strong>Task Name</strong></label> <input
												type="text" name="taskName" class="form-control"
												value="${tasks.taskName }" placeholder="Add Task">
										</div>
									</div>

								</div>

								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<div class="mb-3">
											<label class="mb-1"><strong>Task Description</strong></label>
											<input type="text" name="taskDescription"
												class="form-control" placeholder="discription"
												value="${tasks.discription }">

										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<label class="mb-1"><strong>Set Priority</strong></label>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="priority"
												value="high"<%=priority != null && priority.equals("high") ? "checked":""%>>
												 <label
												class="form-check-label"> High</label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="priority"
												value="medium"<%=priority != null && priority.equals("medium") ? "checked":""%>>
											<label class="form-check-label"> Medium </label>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<label class="mb-1"><strong>Status</strong></label>
										<div class="form-check">
											<input class="form-check-input" type="radio" 
												name="status" value="pending"<%=status != null && status.equals("pending") ?"checked":""%>> <label
												class="form-check-label"> Pending</label>
										</div>

										<div class="form-check">
											<input class="form-check-input"  type="radio"
												name="status" value="done"<%=status != null && status.equals("done") ?"checked":""%>> <label
												class="form-check-label"> Done</label>
										</div>
									</div>
								</div>
								<div class="col-xs-12 col-sm-4 col-md-4">
									<div class="form-group">
										<div class="mb-3">
											<label class="mb-1"><strong>End Date</strong></label> <input
												type="date" name="endDate" class="form-control" value="${tasks.endDate}">
										</div>
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