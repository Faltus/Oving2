package dao;

import java.util.ArrayList;

import model.Product;

public interface ProductsDAO {
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void removeProduct(Product product);
	public Product getProduct(int Pno, String langCode);
	public ArrayList<Product> getProducts(String langCode);
}
