package dao.context;

import java.util.ArrayList;

import dao.ProductsDAO;
import model.Product;

public class ProductsDAOImpl implements ProductsDAO {
	private Product whiteCupNo = new Product(1, "White Coffee Cup", 52.00, "whitecup.jpg", "Dette er den ultimate koppen for programutviklere som sitter sene kvelder og trenger litt å holde seg våken på.", "no_NO");
	private Product whiteCupEn = new Product(1, "White Coffee Cup", 52.00, "whitecup.jpg", "This is the ultimate cup for application developers who sit late nights and need something to stay awake on.", "en_US");
	private Product whiteCupEs = new Product(1, "White Coffee Cup", 52.00, "whitecup.jpg", "Este es el cáliz definitiva para los desarrolladores de aplicaciones que se sientan horas de la noche y necesitan algo para mantenerse despierto en.", "es_ES");
	
	private Product blackCupNo = new Product(2, "Black Coffee Cup", 38.00, "blackcup.jpg", "Dette er en kopp for de som liker den svarte fargen. Koppen er spesielt egnet til kaffe, te og melk, men kan også brukes til andre drikker.", "no_NO");
	private Product blackCupEn = new Product(2, "Black Coffee Cup", 38.00, "blackcup.jpg", "This is a cup for those who like the black color. The cup is especially suited to coffee, tea and milk, but can also be used for other beverages.", "en_US");
	private Product blackCupEs = new Product(2, "Black Coffee Cup", 38.00, "blackcup.jpg", "Esta es una copa para aquellos que les gusta el color negro. La copa es el indicado para el café, el té y la leche, pero también se puede utilizar para otras bebidas.", "es_ES");
	
	private Product prodList[] = {whiteCupNo, whiteCupEn, whiteCupEs, blackCupNo, blackCupEn, blackCupEs};
	
	public ProductsDAOImpl() {
		
	}
	
	public void addProduct(Product product) {
		
	}
	public void updateProduct(Product product) {
		
	}
	public void removeProduct(Product product) {
		
	}
	public Product getProduct(int pNo, String langCode) {
		for (int i=0; i<prodList.length; i++) {
			if (prodList[i].getNumber()==pNo && prodList[i].getLangCode().equalsIgnoreCase(langCode))
				return prodList[i];
		}
		return null;
	}
	public ArrayList<Product> getProducts(String langCode) {
		//Product list[] = new Product[prodList.length];
		ArrayList<Product> liste = new ArrayList<Product>();
		for (int i=0; i<prodList.length; i++) {
			if (prodList[i].getLangCode().equalsIgnoreCase(langCode)) {
				liste.add(prodList[i]);
			}
		}
		return liste;
	}
}
