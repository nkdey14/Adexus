package invt_control_system_2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(30);
			
			if(session.getAttribute("email") != null) {
				
				session.invalidate();
				
				RequestDispatcher rd = request.getRequestDispatcher("logout.jsp");
				rd.forward(request, response);
			}
			else {
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("error", "Session timed out! Please Login again");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
