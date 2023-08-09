package com.jspiders.utility;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.jspiders.dto.RegistrationDTO;
import com.jspiders.service.UserService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//fetch data
		String accountNo = req.getParameter("an");
		String pwd = req.getParameter("pwd");
		/* perform login service */
		UserService service = new UserService();
		try {
			RegistrationDTO dto = service.userLoginService(accountNo, pwd);
			RequestDispatcher dispatcher;
			HttpSession session;
			if (dto != null) {
				session = req.getSession();
				
				/* retrieve user name by using registration dto*/
				String username = dto.getFirstName().toUpperCase() + " " + dto.getLastName().toUpperCase();
				String accountNumber = dto.getAccountNo();
				
				session.setAttribute("un", username);
				session.setAttribute("an", accountNumber);
				
				session.setMaxInactiveInterval(450);
				dispatcher = req.getRequestDispatcher("DisplayName.jsp");
			}
			else{
				req.setAttribute("msg", "Invalid Credentials");
				dispatcher = req.getRequestDispatcher("Login.jsp");
			}
			dispatcher.include(req, resp);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
















