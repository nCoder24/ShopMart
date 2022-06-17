package shopmart.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopmart.dao.UserDao;
import shopmart.models.User;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(request.getParameter("email"), request.getParameter("name"), request.getParameter("password"));
		
		UserDao dao = new UserDao();
		boolean registered = dao.registerUser(user);
		
		if (registered) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}
		else {
			response.getWriter().println("Sorry! Internal Error Occored");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
