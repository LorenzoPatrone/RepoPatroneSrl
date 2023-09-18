package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CartBean;

@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			
			String product_id  = request.getParameter("id");
			if (product_id != null) {
				@SuppressWarnings("unchecked")
				ArrayList<CartBean> cart_list = (ArrayList<CartBean>) request.getSession().getAttribute("cart-list");
				if (cart_list != null) {
					for (CartBean c : cart_list) {
						if (c.getProductID() == Integer.parseInt(product_id)) {
							cart_list.remove(cart_list.indexOf(c));
							break;
						}
					}
				}
				response.sendRedirect("cart.jsp");
			} else {
				response.sendRedirect("cart.jsp");
			}
		}
			
	}
	
	private static final long serialVersionUID = 1L;
	
}
