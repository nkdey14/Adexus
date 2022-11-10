package invt_control_system_2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import invt_control_system_2.services.DAOImpl;

@WebServlet("/verifyLogin")
public class VerifyLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VerifyLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			DAOImpl dao = new DAOImpl();
			dao.connectDB();
			
			boolean status = dao.verifyUser(email, password);
			
			if(status == true) {
				
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(50);
				
				session.setAttribute("email", email);
				
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/createReg.jsp");
				rd.forward(request, response);
			}
			else {
				
				request.setAttribute("error", "Invalid Username or Password!");
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("error", "Session timed out! Please Login again");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}
}
