package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductsDAO;
import dao.context.ProductsDAOImpl;

import model.Product;

public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String cartContent = (String) session.getAttribute("cartContent");
		String[] content;
		content = cartContent.split("_");
		
		Locale currentLocale = (Locale) request.getAttribute("locale");
		ProductsDAO prodDAO = new ProductsDAOImpl();
		ArrayList<Product> cartList = new ArrayList<Product>();
		
		for (int i=0; i< content.length; i++) {
			cartList.add(prodDAO.getProduct(Integer.parseInt(content[i]), currentLocale.toString()));
		}
		request.setAttribute("cart", cartList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cart.jsp");
	    dispatcher.forward(request, response);
	}

}
