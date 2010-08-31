package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

import dao.ProductsDAO;
import dao.context.ProductsDAOImpl;

public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Locale resLoc = (Locale) request.getAttribute("locale");
		
		ProductsDAO prodDAO = new ProductsDAOImpl();
		ArrayList<Product> products = prodDAO.getProducts(resLoc.toString());
		
		ResourceBundle res = ResourceBundle.getBundle("MessagesBundle", resLoc);
		String rateStr = (String) res.getObject("rate");
		double rate = Double.parseDouble(rateStr);
		for(int i=0; i<products.size(); i++) {
			products.get(i).setPrice(products.get(i).getPrice()*rate);
		}
		
		request.setAttribute("products", products);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/products.jsp");
	    dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String pNu = request.getParameter("pNumber");
		String cartContent = (String) session.getAttribute("cartContent");
        
		if (cartContent != null) {
        	cartContent = cartContent.concat("_" + pNu);
        } else {
            cartContent = pNu;
        }
		
        session.setAttribute("cartContent", cartContent);
        doGet(request, response);
	}

}
