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
import dao.ProductDao;

@WebServlet("/remove-product")
public class RemoveProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			int id = Integer.parseInt(request.getParameter("id"));
			ProductDao pd = new ProductDao(ConPool.getConnection());
			pd.removeProduct(id);
			response.sendRedirect("products.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static final long serialVersionUID = 1L;
	
}
