package shopmart.dao;

import shopmart.models.*;

public class UserDao {
	public User getUser(String email) {
		/*
		 * This is written just for testing...
		 * Overwrite this and fetch data from the database (Achyut)
		 */
		User user = new User(email, "Admin", "admin");
		return user;
	}
}
