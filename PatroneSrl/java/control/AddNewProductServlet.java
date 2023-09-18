package control;

import java.io.*;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConPool;
import dao.ProductDao;
import model.ProductBean;

@WebServlet("/new-product")
public class AddNewProductServlet extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getLogger(AddNewProductServlet.class.getName());
	
    public AddNewProductServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("newproduct.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			ProductBean product = new ProductBean();
			Double price = Double.parseDouble(request.getParameter("product-price"));
			
			product.setProductName(request.getParameter("product-name"));   
			product.setCategory(request.getParameter("product-category"));  
			product.setPrice(price);
			product.setImage(request.getParameter("product-image"));
			
			try {
				ProductDao pdao = new ProductDao(ConPool.getConnection());
				boolean result = pdao.insertProduct(product);
				if (result) {
					response.sendRedirect("products.jsp");
				} else {
					out.print("Inserimento prodotto fallito. Controlla i campi immessi.");
				}
			} catch (ClassNotFoundException | SQLException e) {
				LOGGER.severe("An exception occurred: " + e.getMessage());
			}
		}
	}
	
	private static final long serialVersionUID = 1L;
}
