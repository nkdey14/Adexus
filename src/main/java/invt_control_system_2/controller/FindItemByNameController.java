package invt_control_system_2.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import invt_control_system_2.services.DAOImpl;

@WebServlet("/findItemByName")
public class FindItemByNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindItemByNameController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(30);
			
			if(session.getAttribute("email") != null) {
				
				String name = request.getParameter("name");
				
				DAOImpl dao = new DAOImpl();
				dao.connectDB();
				
				ResultSet item = dao.findItemByName(name);
				
				if(item != null) {
					
					request.setAttribute("item", item);
					
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/getItem.jsp");
					rd.forward(request, response);
				}else {
					
					request.setAttribute("msg", "No item found!");
					
					RequestDispatcher rd = request.getRequestDispatcher("findItemByName.jsp");
					rd.forward(request, response);
				}
				
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

}
