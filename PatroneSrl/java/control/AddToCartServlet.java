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
import javax.servlet.http.HttpSession;

import model.CartBean;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			
			List<CartBean> cartList = new ArrayList<>();
			int product_id = Integer.parseInt(request.getParameter("id"));
			CartBean c = new CartBean();
			c.setProductID(product_id);
			c.setQuantity(1);
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			ArrayList<CartBean> cart_list = (ArrayList<CartBean>) session.getAttribute("cart-list");
			if (cart_list == null) {
				cartList.add(c);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("products.jsp");
			} else {
				cartList = cart_list;
				boolean exist = false;
				for (CartBean cart : cart_list) {
					if (cart.getProductID() == product_id) {
						exist = true;
					}
				}
				if (!exist) {
					cartList.add(c);
					response.sendRedirect("products.jsp");
				} else {
					response.sendRedirect("products.jsp");
				}
			}
		}
	}
	
	private static final long serialVersionUID = 1L;
	
}
