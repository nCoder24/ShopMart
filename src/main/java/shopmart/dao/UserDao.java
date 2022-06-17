package shopmart.dao;

import shopmart.models.User;
import java.sql.*;

public class UserDao{
	String jdbcURL = "jdbc:postgresql://ec2-52-72-56-59.compute-1.amazonaws.com:5432/db6cov4baqcn1j";
	String username = "mqcztobfkzlmcp";
	String password = "67aa18559afb602ff8bd405a5e7dbca42a795456bfbdf551a20fe7fa655f6ff7";
	
	public User getUser(String email) {
		User user = new User();
		try{
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			String sql = "SELECT * FROM \"user\" WHERE email='" + email +"';";
	        Statement statement = connection.createStatement();
	        ResultSet result = statement.executeQuery(sql);
	        
	        if (result.next()) {
	        	user.setEmail(result.getString("email"));
	        	user.setName(result.getString("name"));
	        	user.setPassword(result.getString("password"));
	        }
		} catch (SQLException e) {
			return null;
		}
		return user;
	}
	
	public boolean registerUser(User user) {
		String email = user.getEmail();
		String name = user.getName();
		String pass = user.getPassword();
		
		try{
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			String sql = "INSERT INTO \"user\" VALUES ('" + email +"', '" + name + "', '" + pass + "');";
	        Statement statement = connection.createStatement();
	        statement.executeQuery(sql);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}
