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

import com.jspiders.dto.ReceiverDTO;
import com.jspiders.dto.SenderDTO;
import com.jspiders.service.MoneyTransactionService;

@WebServlet("/MoneyTransferController")
public class MoneyTransferController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 RequestDispatcher dispatcher = null;
		 HttpSession session = null;
		 String transactionId = null;
		 
		 //fetch data
		 String accountNo = req.getParameter("an");
		 String temp = req.getParameter("amt");
		 double amount = Double.parseDouble(temp);
		 String description = req.getParameter("description");
		 
		 SenderDTO senderDTO = new SenderDTO();
		 ReceiverDTO receiverDTO = new ReceiverDTO();
		 MoneyTransactionService transferService = new MoneyTransactionService();
		 
		 session = req.getSession();
		 
		 if (session != null)
		 {
			 //store sender data in senderdto object 
			 //to get sender account number ---> session object 
			 String senderAccNo = (String)session.getAttribute("an"); 
			 senderDTO.setAccountNo(senderAccNo); senderDTO.setDescription(description); 
			 //store receiver data in recieverdto object 
			 receiverDTO.setAccountNo(accountNo); 
			 receiverDTO.setDescription(description); 
		} 
		
		 try {
			 transactionId = transferService.moneyTransferService(senderDTO, receiverDTO, amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 if (transactionId != null) {
			 
			session.setAttribute("tid", transactionId);
			req.setAttribute("valid", transactionId);
			dispatcher = req.getRequestDispatcher("Transaction.jsp");
		}
		 else
		 {
			 req.setAttribute("msg", "Money Transfer Failed!!");
			 dispatcher = req.getRequestDispatcher("Transaction.jsp");
		 }
		 dispatcher.include(req, resp);
	}
}




















