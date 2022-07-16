package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Bean.TaskBean;
import com.Bean.UserBean;
import com.util.DbConnection;

public class TaskDao {
	
	public void insertTask(TaskBean taskBean) {
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into tasks (taskname,discription,priority,status,creatAt,endDate,user_id) values(?,?,?,?,?,?,?) ")){
			pstmt.setString(1, taskBean.getTaskName());
			pstmt.setString(2, taskBean.getDiscription());
			pstmt.setString(3, taskBean.getPriority());
			pstmt.setString(4, taskBean.getStatus());
			pstmt.setString(5, taskBean.getCreatAt());
			pstmt.setString(6, taskBean.getEndDate());
			pstmt.setInt(7, taskBean.getUserId());
			
			
			int insertTask = pstmt.executeUpdate();
			System.out.println("insertTask : "+insertTask);
		}catch(Exception e) {
			System.out.println("SMW in TaskDao :: inserTask()");
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<TaskBean> taskList(int userId) {
		ArrayList<TaskBean> taskList = new ArrayList<>();
		 try(Connection con = DbConnection.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("select * from tasks where user_id = ?")){
			 pstmt.setInt(1, userId);
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 TaskBean tasks = new TaskBean();
				 tasks.setTaskName(rs.getString("taskname"));
				 tasks.setDiscription(rs.getString("discription"));
				 tasks.setCreatAt(rs.getString("creatAt"));
				 tasks.setEndDate(rs.getString("endDate"));
				 tasks.setPriority(rs.getString("priority"));
				 tasks.setStatus(rs.getString("status"));
				 tasks.setTaskId(rs.getInt("taskid"));
				 taskList.add(tasks);
				 
			 }
		 }catch(Exception e) {
			 System.out.println("SMW in TaskDao :: taskList()");
			 e.printStackTrace();
		 }return taskList;
	}
	
	
	public boolean deleteTask(int taskId) {
		boolean flag = false;
		try(Connection con = DbConnection.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("delete from tasks where taskid = ?")){
			 pstmt.setInt(1, taskId);
			 int deletedTask = pstmt.executeUpdate();
			 if (deletedTask == 1) {
					flag = true;
					System.out.println(deletedTask + "   --Deleted..........");
				}
			
		}catch(Exception e) {
			 System.out.println("SMW in TaskDao :: deleteTask()");
			 e.printStackTrace();
		}
		return flag;
	}

	public boolean UpdateStatus(int taskId) {
		boolean flag = false;
	
		try(Connection con = DbConnection.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("update tasks set status = ? where taskid = ? and status = ?")){
			 pstmt.setString(1, "done");
			 pstmt.setInt(2, taskId);
			 pstmt.setString(3, "pending");
			 int UpdateTask = pstmt.executeUpdate();
		}catch(Exception e) {
			 System.out.println("SMW in TaskDao :: UpdateStatus()");
			 e.printStackTrace();
		}return flag;
	}
	
	public TaskBean getTasksByTaskId(int taskId) {
		TaskBean bean = null;
		try(Connection con = DbConnection.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("select * from tasks where taskid = ?")){
			 pstmt.setInt(1, taskId);
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 bean = new TaskBean();
				 bean.setTaskId(rs.getInt("taskid"));
				 bean.setTaskName(rs.getString("taskname"));
				 bean.setDiscription(rs.getString("discription"));
				 bean.setStatus(rs.getString("status"));
				 bean.setPriority(rs.getString("priority"));
				 bean.setEndDate(rs.getString("endDate"));
				 
			 }
		}catch(Exception e) {
			System.out.println("SMW in TaskDao :: getTasksByTaskId()");
			e.printStackTrace();
		}return bean;
	}
	
	
	
	
	public boolean UpdateTask(TaskBean taskBean) {
		boolean flag = false;
	
		try(Connection con = DbConnection.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("update tasks set taskname=?, discription = ?,priority = ?, endDate = ?, status = ? where taskid = ? ")){
			 
			 pstmt.setString(1, taskBean.getTaskName());
			 pstmt.setString(2, taskBean.getDiscription());
			 pstmt.setString(3, taskBean.getPriority());
			 pstmt.setString(4, taskBean.getEndDate());
			 pstmt.setString(5, taskBean.getStatus());
			 pstmt.setInt(6, taskBean.getTaskId());
			 
			 
			 int UpdateTask = pstmt.executeUpdate();
		}catch(Exception e) {
			 System.out.println("SMW in TaskDao :: UpdateStatus()");
			 e.printStackTrace();
		}return flag;
	}
	
	public ArrayList<TaskBean> pendingtaskList(int userId) {
		
		ArrayList<TaskBean> taskList = new ArrayList<>();
		 try(Connection con = DbConnection.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("select * from tasks where user_id = ? and status = ?")){
			 pstmt.setInt(1, userId);
			 pstmt.setString(2,"pending");
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 TaskBean tasks = new TaskBean();
				 tasks.setTaskName(rs.getString("taskname"));
				 tasks.setDiscription(rs.getString("discription"));
				 tasks.setCreatAt(rs.getString("creatAt"));
				 tasks.setEndDate(rs.getString("endDate"));
				 tasks.setPriority(rs.getString("priority"));
				 tasks.setStatus(rs.getString("status"));
				 tasks.setTaskId(rs.getInt("taskid"));
				 taskList.add(tasks);
				 
			 }
		 }catch(Exception e) {
			 System.out.println("SMW in TaskDao :: pendingtaskList()");
			 e.printStackTrace();
		 }return taskList;
		
	}
	
	public ArrayList<TaskBean> donetaskList(int userId) {
		ArrayList<TaskBean> taskList = new ArrayList<>();
		 try(Connection con = DbConnection.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("select * from tasks where user_id = ? and status = ?")){
			 pstmt.setInt(1, userId);
			 pstmt.setString(2,"done");
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 TaskBean tasks = new TaskBean();
				 tasks.setTaskName(rs.getString("taskname"));
				 tasks.setDiscription(rs.getString("discription"));
				 tasks.setCreatAt(rs.getString("creatAt"));
				 tasks.setEndDate(rs.getString("endDate"));
				 tasks.setPriority(rs.getString("priority"));
				 tasks.setStatus(rs.getString("status"));
				 tasks.setTaskId(rs.getInt("taskid"));
				 taskList.add(tasks);
				 
			 }
		 }catch(Exception e) {
			 System.out.println("SMW in TaskDao :: pendingtaskList()");
			 e.printStackTrace();
		 }return taskList;
	}
}
