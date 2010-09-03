package model;

public class Product {
	private int number;
	private String name;
	private double price;
	private String image;
	private String desc;
	private String langCode;
	
	public Product(int number, String name, double price, String image, String desc, String langCode) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.image = image;
		this.desc = desc;
		this.langCode = langCode;
	}
	
	public Product() {
		
	}
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	
}
