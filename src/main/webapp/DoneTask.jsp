<%@page import="com.Bean.TaskBean"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Done Tasks</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<jsp:include page="UserNavbar.jsp"></jsp:include>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Youre Task</th>
				<th scope="col">Discription</th>
				<th scope="col">Priority</th>
				<th scope="col">Status</th>
				<th scope="col">Create Date</th>
				<th scope="col">End Date</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${donetasks}" var="tasks">
				<tr>
					<th scope="row">${tasks.taskId}</th>
					<td>${tasks.taskName}</td>
					<td>${tasks.discription}</td>
					<td>${tasks.priority}</td>
					<td>${tasks.status}</td>
					<td>${tasks.creatAt}</td>
					<td>${tasks.endDate }</td>
					<td><a href="StatusDoneController?taskid=${tasks.taskId}"><span class="material-symbols-outlined">done </span></a>
					<a href="GetTaskByTaskId?taskid=${tasks.taskId}"><span class="material-symbols-outlined">edit_note</span></a>
					<a href="DeleteTaskController?TaskId=${tasks.taskId }"><span
							class="material-icons md-36" style="color: red;">
								delete_outline</span></a> 
								</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>