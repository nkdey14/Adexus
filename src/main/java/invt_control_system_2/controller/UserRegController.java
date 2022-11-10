package invt_control_system_2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import invt_control_system_2.services.DAOImpl;

@WebServlet("/userReg")
public class UserRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cnf_password = request.getParameter("cnf_password");
		
		if(password.equals(cnf_password)) {
			
			DAOImpl dao = new DAOImpl();
			dao.connectDB();
			
			dao.registerUser(email, password);
			
			request.setAttribute("status", "User Registration Successful!");
			
			RequestDispatcher rd = request.getRequestDispatcher("registerUser.jsp");
			rd.forward(request, response);
		}
		else  {
			
			request.setAttribute("status", "Error! Password and Confirm Password should be same");
			
			RequestDispatcher rd = request.getRequestDispatcher("registerUser.jsp");
			rd.forward(request, response);
		}
	}
}
