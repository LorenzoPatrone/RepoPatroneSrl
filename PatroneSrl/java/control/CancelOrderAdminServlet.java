package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConPool;
import dao.OrderDao;

@WebServlet("/cancel-order-admin")
public class CancelOrderAdminServlet extends HttpServlet {
	   
    public CancelOrderAdminServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			String id = request.getParameter("user_id");
			if(id == null) {
				OrderDao orderDao = new OrderDao(ConPool.getConnection());
				orderDao.cancelOrder(Integer.parseInt(id));
			}
			response.sendRedirect("gestorders.jsp");
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private static final long serialVersionUID = 1L;
	
}
