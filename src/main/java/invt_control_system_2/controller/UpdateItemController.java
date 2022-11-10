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

@WebServlet("/update")
public class UpdateItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateItemController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(30);
			
			if(session.getAttribute("email") != null) {
				
				int id = Integer.parseInt(request.getParameter("id"));
				int stock = Integer.parseInt(request.getParameter("stock"));
				int price = Integer.parseInt(request.getParameter("price"));
				
				request.setAttribute("id", id);
				request.setAttribute("stock", stock);
				request.setAttribute("price", price);
				
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/updateItem.jsp");
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
	
		int id = Integer.parseInt(request.getParameter("id"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		DAOImpl dao = new DAOImpl();
		dao.connectDB();
		
		dao.updateItem(id, stock, price);
		
		request.setAttribute("msg", "Item updated successfully!");
		
		ResultSet list = dao.getItemsList();
		
		request.setAttribute("result", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/listItems.jsp");
		rd.forward(request, response);
	}

}
