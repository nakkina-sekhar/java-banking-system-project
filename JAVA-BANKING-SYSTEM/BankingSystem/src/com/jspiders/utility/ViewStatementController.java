package com.jspiders.utility;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspiders.dto.SenderDTO;
import com.jspiders.service.UserService;
@WebServlet("/ViewStatementController")
public class ViewStatementController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;

		HttpSession session = req.getSession();
		String startdate = req.getParameter("std");
		System.out.println(startdate);
		String enddate = req.getParameter("end");
		System.out.println(enddate);
		if (session != null) {
			resp.setHeader("cache-control", "no-cache,no-store,must-revalidate");
			resp.setHeader("pragma", "no-cache");
			resp.setDateHeader("expires", 0);
			/*  Getting  the A/c no from session*/
			String AccountNo = (String) session.getAttribute("an");
			UserService service = new UserService();
			List<SenderDTO> list = null;
			try {
				
				
				list = service.viewTransactionHistory(startdate, enddate,
						AccountNo);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			if (list != null)
			{
				System.out.println("list ; " + list);
				req.setAttribute("startDate", startdate);
				req.setAttribute("endDate", enddate);
				req.setAttribute("list", list);
				for (SenderDTO senderdto : list) {
					System.out.println(senderdto.getTid() + "/n amount:  "
							+ senderdto.getBalance());

					rd = req.getRequestDispatcher("ViewStatement.jsp");

				}

			}
			else
			{
				req.setAttribute("msg", "No Records Found");
				rd = req.getRequestDispatcher("TransactionHistroy.jsp");
			}
			rd.forward(req, resp);
		}
		

	}

}
