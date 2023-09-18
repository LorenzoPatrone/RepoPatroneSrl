package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CartBean;
import model.ProductBean;

public class ProductDao {
	
	private Connection conn;
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ProductDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<ProductBean> getAllProducts() {
		
		List<ProductBean> product = new ArrayList<>();
		
		try {
			query = "SELECT * FROM product";
			ps = this.conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductBean p = new ProductBean();
				p.setProductID(rs.getInt("product_id"));
				p.setProductName(rs.getString("product_name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getDouble("price"));
				p.setImage(rs.getString("image"));
				
				product.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public List<CartBean> getCartProduct(ArrayList<CartBean> cartList){
		
		List<CartBean> product = new ArrayList<>();
		
		try {
			if(cartList.size() > 0) {
				for (CartBean item : cartList) {
					query = "SELECT * FROM product WHERE product_id=?";
					ps = this.conn.prepareStatement(query);
					ps.setInt(1, item.getProductID());
					rs = ps.executeQuery();
					
					while (rs.next()) {
						CartBean c = new CartBean();
						c.setProductID(rs.getInt("product_id"));
						c.setProductName(rs.getString("product_name"));
						c.setCategory(rs.getString("category"));
						c.setPrice(rs.getDouble("price")*item.getQuantity());
						c.setQuantity(item.getQuantity());
						product.add(c);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return product;
	}
	
	public double getTotalCartPrice(ArrayList<CartBean> cartList) {
		double sum = 0;
		try {
			if (cartList.size() > 0) {
				for (CartBean item : cartList) { 
					query = "SELECT price FROM product WHERE product_id=?";
					ps = this.conn.prepareStatement(query);
					ps.setInt(1, item.getProductID());
					rs = ps.executeQuery();
					while(rs.next()) {
						sum += rs.getDouble("price")*item.getQuantity();
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return sum;
	}
	
	public ProductBean getSingleProduct(int product_id) {
		 ProductBean p = null;
	        try {
	            query = "SELECt * FROM product WHERE product_id=? ";

	            ps = this.conn.prepareStatement(query);
	            ps.setInt(1, product_id);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	p = new ProductBean();
	                p.setProductID(rs.getInt("product_id"));
	                p.setProductName(rs.getString("product_name"));
	                p.setCategory(rs.getString("category"));
	                p.setPrice(rs.getDouble("price"));
	                p.setImage(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return p;
	}
	
	public List<ProductBean> getByCategory(String categoria){
		List<ProductBean> products = new ArrayList<ProductBean>();
		try {
			query = "SELECT * FROM product WHERE category=?";
			ps = this.conn.prepareStatement(query);
			ps.setString(1, categoria);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductBean p = new ProductBean();
				p.setProductID(rs.getInt("product_id"));
				p.setProductName(rs.getString("product_name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getDouble("price"));
				p.setImage(rs.getString("image"));
				
				products.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<ProductBean> getByPrice(int price) {
		List<ProductBean> products = new ArrayList<ProductBean>();
		try {
			query = "SELECT * FROM product WHERE price<=?";
			ps = this.conn.prepareStatement(query);
			ps.setInt(1, price);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductBean p = new ProductBean();
				p.setProductID(rs.getInt("product_id"));
				p.setProductName(rs.getString("product_name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getDouble("price"));
				p.setImage(rs.getString("image"));
				
				products.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	
	public boolean removeProduct(int product_id) {
		boolean result = false;
		try {
	        query = "DELETE FROM product WHERE product_id=?";
	        ps = this.conn.prepareStatement(query);
	        ps.setInt(1, product_id);
	        ps.execute();
	        result = true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
	    return result;
	}
	
	public boolean insertProduct(ProductBean model) {
	    boolean result = false;
	    try {
	        query = "INSERT INTO product "
	        		+ "(product_id, product_name, category, price, image) "
	        		+ "values(?,?,?,?,?)";
	        ps = this.conn.prepareStatement(query);
	        ps.setInt(1, model.getProductID());
	        ps.setString(2, model.getProductName());
	        ps.setString(3, model.getCategory());
	        ps.setDouble(4, model.getPrice());
	        ps.setString(5, model.getImage());
	        ps.executeUpdate();
	        result = true;
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return result;
	}
	
	public boolean modifyProduct(ProductBean model) {
	    boolean result = false;
	    try {
	        query = "UPDATE product SET product_name=?, category=?, price=?, image=? WHERE product_id = ?";
	        ps = this.conn.prepareStatement(query);
	        ps.setString(1, model.getProductName());
	        ps.setString(2, model.getCategory());
	        ps.setDouble(3, model.getPrice());
	        ps.setString(4, model.getImage());
	        ps.setInt(5, model.getProductID());
	        ps.executeUpdate();
	        result = true;
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return result;
	}
	
}
