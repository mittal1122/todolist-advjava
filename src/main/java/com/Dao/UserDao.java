package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public UserBean login(String email, String password) {
		UserBean user = null;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			// read select
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserBean();
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("firstname"));
				user.setUserType(rs.getString("user_type"));
				System.out.println("rs.getString(user_type)"+rs.getString("user_type"));
			}
		} catch (Exception e) {
			System.out.println("SMW in LOgin :: DAO");
			e.printStackTrace();
		}
		return user;
	}
	
	public UserBean checkForgotEmail(String VerifyEmail) {
		UserBean userbean=null ;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from users where email = ?")){
			System.out.println(VerifyEmail +" : VerifyEmail");
			pstmt.setString(1, VerifyEmail);
			
			ResultSet rsn = pstmt.executeQuery();
			System.out.println("rs :"+ rsn);
			while(rsn.next()) {
				 userbean = new UserBean();
			userbean.setEmail(rsn.getString("email"));
			System.out.println("rsn.getString(email) : "+rsn.getString("email"));
			
			userbean.setFirstName(rsn.getString("firstname"));
			userbean.setLastName(rsn.getString("lastname"));
			userbean.setGender(rsn.getString("gender"));
			userbean.setPassword(rsn.getString("password"));
			System.out.println(userbean);
		
			}
			
		}catch(Exception e) {
			System.out.println("SMW in USerDao :: checkForgotEmail()");
			e.printStackTrace();
		}
		return userbean;
	}
	
	public void insertUser(UserBean userBean) {
		try(Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into users (firstname, lastname, email, password, gender, user_type, squestion, sanswer) values(?,?,?,?,?,?,?,?) ")){
			
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2,userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());
			pstmt.setString(6, userBean.getUserType());
			pstmt.setString(7, userBean.getsQuestion());
			pstmt.setString(8, userBean.getsAnswer());
			int records = pstmt.executeUpdate();
			System.out.println("inserUser() :: records  -:" + records);
			
		}catch(Exception e) {
			System.out.println("SMW in UserDao ::inserUser()");
			e.printStackTrace();
		}
	}
	
	public UserBean sQuestionAnswer(String email,String sQuestion, String sAnswer) {
		UserBean userBean = null;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and sanswer = ? ")){
			pstmt.setString(1, email);
			pstmt.setString(2, sAnswer);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				 userBean = new UserBean();
				userBean.setEmail(rs.getString("email"));
				userBean.setsAnswer(rs.getString("sanswer"));
				userBean.setsQuestion(rs.getString("squestion"));
				
				
			}
		}catch(Exception e) {
			System.out.println("SMW in UserDao ::sQuestionAnswer()");
			e.printStackTrace();
		}return userBean;
	}
	
	public boolean updatePassword(String email,String password) {
		boolean flag = false;
		try(Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update users set password = ?  where email = ? ")){
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			int updateCount = pstmt.executeUpdate();
			if(updateCount == 1) {
				flag = true;
			}
		}catch(Exception e) {
			System.out.println("SMW UserDao :: updatePassword() ");
			e.printStackTrace();
		}return flag;
	}
	
	
}
