package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter()){
			if(request.getSession().getAttribute("auth") != null) {
				// Clear the session.
				request.getSession().invalidate();
				
				// Redirect to the login page after logout.
				response.sendRedirect("login.jsp");
			} else {
				// Redirect to the index page if not authenticated.
				response.sendRedirect("index.jsp");
			}
		}
	}
	
	private static final long serialVersionUID = 1L;
	
}
