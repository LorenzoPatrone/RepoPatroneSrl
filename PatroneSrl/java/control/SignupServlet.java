package control;

import connection.ConPool;
import dao.UserDao;
import model.UserBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	public SignupServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("signin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()){
			UserBean user = new UserBean();
			
			user.setFirstname(request.getParameter("firstname"));
			user.setLastname(request.getParameter("lastname"));
			user.setAddress(request.getParameter("address"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			
			try {
				UserDao udao = new UserDao(ConPool.getConnection());
				boolean result = udao.createUser(user);
				
				if(result) {
				
					response.sendRedirect("index.jsp");
				}else {
					out.print("registrazione fallita");
				}
			} catch (ClassNotFoundException | SQLException e) {
	
				e.printStackTrace();
			}
		}
	}
	
	private static final long serialVersionUID = 1L;
}
