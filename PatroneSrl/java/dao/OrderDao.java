package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OrderBean;
import model.ProductBean;

public class OrderDao {
	
	private Connection conn;
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public OrderDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean insertOrder(OrderBean model) {
		boolean result = false;
		try {
			query = "INSERT INTO orders (product_id, user_id, order_qty, order_date) VALUES(?,?,?,?)";
			ps = this.conn.prepareStatement(query);
			ps.setInt(1, model.getProductID());
			ps.setInt(2, model.getUserID());
			ps.setInt(3, model.getQty());
			ps.setString(4, model.getDate());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public List<OrderBean> userOrders(int id){
		List<OrderBean> list = new ArrayList<>();
		try {
			query = "SELECT * FROM orders WHERE user_id=? ORDER BY orders.order_id DESC";
			ps = this.conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				OrderBean order = new OrderBean();
				ProductDao pdao = new ProductDao(this.conn);
				int pid = rs.getInt("product_id");
				ProductBean product = pdao.getSingleProduct(pid);
				order.setOrderID(rs.getInt("order_id"));
				order.setProductID(pid);
				order.setProductName(product.getProductName());
				order.setCategory(product.getCategory());
				order.setPrice(product.getPrice()*rs.getInt("order_qty"));
				order.setQty(rs.getInt("order_qty"));
				order.setDate(rs.getString("order_date"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public void cancelOrder(int order_id) {
        try {
            query = "DELETE FROM orders WHERE order_id=?";
            ps = this.conn.prepareStatement(query);
            ps.setInt(1, order_id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
    }
	
	public List<OrderBean> getAllOrders(){
		List<OrderBean> list = new ArrayList<OrderBean>();
		
		try {
			query = "SELECT * FROM orders";
			ps = this.conn.prepareStatement(query);
			rs = ps.executeQuery();
			 while (rs.next()) {
				 OrderBean order = new OrderBean();
				 ProductDao productDao = new ProductDao(this.conn);
				 int pid = rs.getInt("product_id");
				 ProductBean product = productDao.getSingleProduct(pid);
				 order.setOrderID(rs.getInt("order_id"));
				 order.setProductID(pid);
				 order.setProductName(product.getProductName());
				 order.setPrice(product.getPrice()*rs.getInt("order_qty"));
				 order.setQty(rs.getInt("order_qty"));
				 order.setDate(rs.getString("order_date"));
				 list.add(order);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
