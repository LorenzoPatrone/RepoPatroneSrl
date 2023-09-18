package model;

public class OrderBean extends ProductBean {
	
	private int order_id;
	private int user_id;
	private int order_qty;
	private String order_date;
	
	public OrderBean() {
	}
	
	public OrderBean(int order_id, int user_id, int order_qty, String order_date) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_qty = order_qty;
		this.order_date = order_date;
	}
	
	public OrderBean(int user_id, int order_qty, String order_date) {
		super();
		this.user_id = user_id;
		this.order_qty = order_qty;
		this.order_date = order_date;
	}

	public int getOrderID() {
		return order_id;
	}

	public void setOrderID(int order_id) {
		this.order_id = order_id;
	}

	public int getUserID() {
		return user_id;
	}

	public void setUserID(int user_id) {
		this.user_id = user_id;
	}

	public int getQty() {
		return order_qty;
	}

	public void setQty(int order_qty) {
		this.order_qty = order_qty;
	}

	public String getDate() {
		return order_date;
	}

	public void setDate(String order_date) {
		this.order_date = order_date;
	}
	
}
