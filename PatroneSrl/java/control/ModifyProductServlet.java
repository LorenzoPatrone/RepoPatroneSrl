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
import model.ProductBean;

@WebServlet("/mod-product")
public class ModifyProductServlet extends HttpServlet {
	
    public ModifyProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("modifyproduct.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			ProductBean product = new ProductBean();
			Double price = Double.parseDouble(request.getParameter("product-price"));
			int id = Integer.parseInt(request.getParameter("product-id"));
			
			product.setProductID(id);
			product.setProductName(request.getParameter("product-name"));   
			product.setCategory(request.getParameter("product-category"));  
			product.setPrice(price);   
			product.setImage(request.getParameter("product-image"));
			
			try {
				ProductDao pdao = new ProductDao(ConPool.getConnection());
				boolean result = pdao.modifyProduct(product);
				if (result) {
					response.sendRedirect("index.jsp");
				} else {
					out.print("Modifica fallita. Controlla i campi inseriti.");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static final long serialVersionUID = 1L;
}
