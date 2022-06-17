package shopmart.dao;

import shopmart.models.*;
/*import java.sql.Connection;
import java.sql.SQLException;*/
import java.sql.*;

public class UserDao {
	String jdbcURL = "jdbc:postgresql://ec2-52-72-56-59.compute-1.amazonaws.com:5432/db6cov4baqcn1j";
	String username = "mqcztobfkzlmcp";
	String password = "67aa18559afb602ff8bd405a5e7dbca42a795456bfbdf551a20fe7fa655f6ff7";
	
	public User getUser(String email) {
		try{
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected");
			
			String sql = "SELECT * FROM \"user\"";
	        Statement statement = connection.createStatement();
	        ResultSet result = statement.executeQuery(sql);
	        if (result.next())
	        	return new User(result.getString("email"), result.getString("name"), result.getString("password"));
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return null;
	}
	public User newUser(String email, String name, String pass) {
		User user = new User(email, name, pass);
		//push to the database
		return user;
	}
}
