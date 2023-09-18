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
import dao.UserDao;
import model.UserBean;

@WebServlet("/mod-profile")
public class ModifyProfileServlet extends HttpServlet {
	
	
    public ModifyProfileServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("profile.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			UserBean user = new UserBean();
			 
			int id = Integer.parseInt(request.getParameter("id"));
			
			user.setUserID(id);
			user.setFirstname(request.getParameter("firstname"));
			user.setLastname(request.getParameter("lastname"));
			user.setAddress(request.getParameter("address"));  
			user.setEmail(request.getParameter("email"));   
			user.setPassword(request.getParameter("password"));	
		
			try {
				UserDao udao = new UserDao(ConPool.getConnection());
				boolean result = udao.updateUser(user);
				if(result) {
					if(request.getSession().getAttribute("auth") != null) {
						request.getSession().removeAttribute("auth");
						response.sendRedirect("login.jsp");
					} else {
						response.sendRedirect("index.jsp");
					}
				} else {
					out.print("Qualcosa è andato storto. La modifica del profilo non è andata a buon fine.");
				}
			} catch (ClassNotFoundException | SQLException e) {
	
				e.printStackTrace();
			}
		}
	}
	
	private static final long serialVersionUID = 1L;
}
