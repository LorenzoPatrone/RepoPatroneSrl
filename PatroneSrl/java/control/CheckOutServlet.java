package control;

import java.io.IOException;
import java.io.PrintWriter;
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
import dao.OrderDao;
import model.CartBean;
import model.OrderBean;
import model.UserBean;

@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	
    public CheckOutServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			
			@SuppressWarnings("unchecked")
			ArrayList<CartBean> cart_list = (ArrayList<CartBean>) request.getSession().getAttribute("cart-list");
			UserBean auth = (UserBean) request.getSession().getAttribute("auth");
			
			if (auth != null && cart_list != null) {
				
            	OrderDao oDao = new OrderDao(ConPool.getConnection());
            	
            	boolean orderSuccess = true;
            	
            	for(CartBean c:cart_list) {
            		
					OrderBean order = new OrderBean();
					
					order.setProductID(c.getProductID());
					order.setUserID(auth.getUserID());
					order.setQty(c.getQuantity());
					order.setDate(formatter.format(date));
					
					if(!oDao.insertOrder(order)) {
						orderSuccess = false;
						break;
					}
	            }
            	
            	if (orderSuccess) {
            		cart_list.clear();
            		response.sendRedirect("orders.jsp");
            	} else {
            		out.print("Ordine non andato a buon fine.");
            	}
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private static final long serialVersionUID = 1L;
	
}
