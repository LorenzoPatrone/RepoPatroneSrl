package model;

public class ProductBean {
	
	private int product_id;
	private String product_name;
	private String category;
	private double price;
	private String image;
	
	public ProductBean() {
	}
	
	public ProductBean(int product_id, String product_name, String category, double price, String image) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.image = image;
	}

	public int getProductID() {
		return product_id;
	}
	public void setProductID(int product_id) {
		this.product_id = product_id;
	}
	public String getProductName() {
		return product_name;
	}
	public void setProductName(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	
	@Override
	public String toString() {
	    return "Product [product_id=" + product_id + ", product_name = " + product_name + ", category = " + category + ", price = " + price + ", image = " + image + "]";
	}

}
