package dao;

import model.UserBean;
import model.OrderBean;

import javax.sql.DataSource;

import connection.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends UserBean {
	
	private Connection conn;
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UserDao(Connection conn) {
		this.conn = conn;
	}
	
	public UserBean loginUser(String email, String password) {
		UserBean user = null;
		try {
			query = "SELECT * FROM user WHERE email=? AND password=?";
			ps = this.conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new UserBean();
				user.setUserID(rs.getInt("user_id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return user;
	}
	
	public boolean createUser(UserBean user) throws SQLException {
		
		boolean result = false;
		
		try {
			query = "INSERT INTO user (user_id, firstname, lastname, address, email, password) VALUES (?,?,?,?,?,?)";
			ps = this.conn.prepareStatement(query);
			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getFirstname());
			ps.setString(3, user.getLastname());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPassword());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
    }
	
	public boolean updateUser(UserBean user) {
		
		boolean result = false;
		
		try {
			query = "UPDATE user SET firstname=?, lastname=?, address=?, email=?, password=? WHERE user_id=?";
			ps = this.conn.prepareStatement(query);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			ps.setInt(6, user.getUserID());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}