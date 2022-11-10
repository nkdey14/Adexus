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

@WebServlet("/saveReg")
public class SaveRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveRegController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/createReg.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(30);
			
			if(session.getAttribute("email") != null) {
				
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				int stock = Integer.parseInt(request.getParameter("stock"));
				int price = Integer.parseInt(request.getParameter("price"));
				
				DAOImpl dao = new DAOImpl();
				dao.connectDB();
				
				dao.saveItemDetails(id, name, stock, price);
				
				request.setAttribute("msg", "Item saved successfully!");
				
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/createReg.jsp");
				rd.include(request, response);
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
