package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ConPool;
import dao.UserDao;
import model.UserBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			try {
				UserDao udao = new UserDao(ConPool.getConnection());
				UserBean user = udao.loginUser(email, password);
				if(user != null) {
					// Store user information in a secure way in the session.
					HttpSession session = request.getSession();
					session.setAttribute("auth", user);
					
					// Set a session timeout to, for example, 30 minutes (1800 seconds).
					session.setMaxInactiveInterval(1800);
					
					// Redirect to the home page.
					response.sendRedirect("index.jsp");
				} else {
					// Display an error message to the user.
					response.sendRedirect("403.jsp");
					//out.println("Accesso negato, verifica email e password.");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				// Display a generic error message to the user.
				out.println("Errore durante l'accesso. Si prega di riprovare più tardi.");
			}
		}
    }
	
	private static final long serialVersionUID = 1L;
	
}