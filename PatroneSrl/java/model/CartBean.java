package model;

public class CartBean extends ProductBean {
	
	private int cart_qty;
	
	public CartBean() {
	}
	
	public int getQuantity() {
		return cart_qty;
	}
	
	public void setQuantity(int quantity) {
		this.cart_qty = quantity;
	}
	
}
