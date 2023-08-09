package com.jspiders.utility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 RequestDispatcher rd=null;
			HttpSession  session=req.getSession(false);
			
			if(session!=null)
			{
				resp.setHeader("cache-control", "no-cache,no-store,must-revalidate");
				resp.setHeader("pragma", "no-cache");
				resp.setDateHeader("expires", 0);
				/* To destory session object */
				session.invalidate();
				session=null;
				rd=req.getRequestDispatcher("Login.jsp");
			}
			else
			{
				rd=req.getRequestDispatcher("Login.jsp");
				
			}
			rd.forward(req, resp);
	}

}
