package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConPool;
import dao.*;
import model.*;

@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            UserBean auth = (UserBean) request.getSession().getAttribute("auth");
            
            if (auth != null) {
            	String id = request.getParameter("id");
            	int qty = Integer.parseInt(request.getParameter("quantity"));
            	if (qty <= 0) {
            		qty = 1;
            	}
            	OrderBean order = new OrderBean();
            	order.setOrderID(Integer.parseInt(id));
            	order.setUserID(auth.getUserID());
            	order.setQty(qty);
            	order.setDate(formatter.format(date));
            	
            	OrderDao odao = new OrderDao (ConPool.getConnection());
            	boolean result = odao.insertOrder(order);
            	if (result) {
            		@SuppressWarnings("unchecked")
					ArrayList<CartBean> cart_list = (ArrayList<CartBean>) request.getSession().getAttribute("cart-list");
            		if (cart_list != null) {
            			for (CartBean c : cart_list) {
            				if (c.getProductID() == Integer.parseInt(id)) {
            					cart_list.remove(cart_list.indexOf(c));
            					break;
            				}
            			}
            		}
            		response.sendRedirect("orders.jsp");
            	} else {
            		out.print("Ordine Fallito.");
            	}
            } else {
            	response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private static final long serialVersionUID = 1L;
}
