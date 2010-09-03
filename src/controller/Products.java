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

import util.CurrencyChanger;

import model.Product;

import dao.ProductsDAO;
import dao.context.ProductsDAOImpl;

public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductsDAO prodDAO = new ProductsDAOImpl();
		Locale resLoc = (Locale) request.getAttribute("locale");
		ArrayList<Product> products = prodDAO.getProducts(resLoc.toString());
		
		CurrencyChanger.setPrices(products, resLoc);
		
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
		
		ProductsDAO prodDAO = new ProductsDAOImpl();
		String added = prodDAO.getProduct(Integer.parseInt(pNu), request.getAttribute("locale").toString()).getName();
		session.setAttribute("added", added);
		
        session.setAttribute("cartContent", cartContent);
        doGet(request, response);
	}

}
