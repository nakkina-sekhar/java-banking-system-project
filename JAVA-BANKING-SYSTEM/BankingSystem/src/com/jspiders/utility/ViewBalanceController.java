package com.jspiders.utility;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspiders.service.UserService;
@WebServlet("/ViewBalanceController")
public class ViewBalanceController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session;
		RequestDispatcher dispatcher = null;
		UserService service = new UserService();
		session = req.getSession();
		
		if (session != null) {
			String accNo = (String)session.getAttribute("an");
			try {
				double balance = service.viewBalanceService(accNo);
				req.setAttribute("balance", balance);
				dispatcher = req.getRequestDispatcher("viewBalance.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			req.setAttribute("msg", "Invalid User");
			dispatcher = req.getRequestDispatcher("Login.jsp");
		}
		dispatcher.include(req, resp);
	}
}
























