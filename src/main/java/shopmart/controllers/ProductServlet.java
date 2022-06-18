package shopmart.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopmart.dao.ProductDao;
import shopmart.models.Product;


public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("productId"));
		PrintWriter out = response.getWriter();
		try {
			ProductDao dao = new ProductDao();
			Product product = dao.getProduct(pid);
		
			request.setAttribute("product", product);
			request.getRequestDispatcher("view-product.jsp").forward(request, response);
		} catch (Exception e) {out.print(e);}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
