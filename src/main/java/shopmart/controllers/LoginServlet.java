package shopmart.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopmart.dao.UserDao;
import shopmart.models.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		UserDao dao = new UserDao();
		HttpSession session = request.getSession();
		
		User user = dao.getUser(email);
		
		if (user.validate(pass)) {
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
		}
		else {
			request.setAttribute("msg", "Email or password error! Please try again.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
