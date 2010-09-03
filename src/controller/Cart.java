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

import dao.ProductsDAO;
import dao.context.ProductsDAOImpl;

import model.CartProduct;
import model.Product;

public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Hente session
		HttpSession session = request.getSession(true);
		
		//Opprette variabler
		String cartContent = "";
		String tom = null;
		ArrayList<CartProduct> cartList = null;
		double totalPrice = 0;
		Locale resLoc = (Locale) request.getAttribute("locale");
		
		//Hente varer i kurven
		try {
			if(!session.getAttribute("cartContent").equals(null)) //Hvis cartContent ikke er tom
				cartContent = (String) session.getAttribute("cartContent"); //Hente cartContent til lokal variabel
		} catch (Exception e) { //Hvis henting av attributen eller castingen går galt
			tom = "Handlekurven er tom"; //Opplyse om at cartContent er tom
		}
		if (!cartContent.equals("")) { //Hvis kurven ikke er tom hentes alle produktene
			String[] content;
			content = cartContent.split("_");
			
			Locale currentLocale = (Locale) request.getAttribute("locale");
			ProductsDAO prodDAO = new ProductsDAOImpl();
			cartList = new ArrayList<CartProduct>();
			for (int i=0; i<content.length; i++) { //Iterere over listen med produktnummere
				Product prod = prodDAO.getProduct(Integer.parseInt(content[i]), currentLocale.toString());
				boolean finnes = false;
				for (int j=0; j<cartList.size(); j++) { //Sjekke om produktet allerede er i listen
					if (prod.getName().equalsIgnoreCase(cartList.get(j).getProduct().getName())) { //Antall +1 hvis produktet er i listen
						finnes = true;
						cartList.get(j).addQuantity(1);
						break;
					}
				}
				if(!finnes) { //Legge til produktet hvis det ikke allerede finnes i listen
					cartList.add(new CartProduct(prod, 1));
				}
				totalPrice+=prod.getPrice();
			}
			CurrencyChanger.setCartPrices(cartList, resLoc); //Sette riktig lokal pris for hvert produkt
		}
		request.setAttribute("tom", tom);
		request.setAttribute("cart", cartList);
		request.setAttribute("total", CurrencyChanger.convertPrice(totalPrice, resLoc));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cart.jsp");
	    dispatcher.forward(request, response);
	}

}
