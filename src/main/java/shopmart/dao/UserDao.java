package shopmart.dao;

import shopmart.models.User;
import java.sql.*;

public class UserDao{
	public User getUser(String email) throws Exception {
		User user = new User();
		Connection connection = new Connectivity().connect();
		String query = "SELECT * FROM \"user\" WHERE email='" + email + "';";
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		if (result.next()) {
			user.setEmail(result.getString("email"));
			user.setName(result.getString("name"));
			user.setPassword(result.getString("password"));
		}
		return user;
	}
	
	public boolean registerUser(User user) throws Exception {	
		Connection connection = new Connectivity().connect();
		if(getUser(user.getEmail()).getEmail().equals("")) {	
			String query = "INSERT INTO \"user\" VALUES (?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getName());
			statement.setString(3, user.getPassword());
			statement.executeUpdate();
		} 
		else return false;
		return true;
	}
}
