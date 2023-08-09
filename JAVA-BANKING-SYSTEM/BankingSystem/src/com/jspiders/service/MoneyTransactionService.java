package com.jspiders.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.jspiders.dao.UserDAO;
import com.jspiders.dto.ReceiverDTO;
import com.jspiders.dto.SenderDTO;

public class MoneyTransactionService 
{
	public int trasactionNumber()
	{
		Random random = new Random();
		
		int id =  random.nextInt();
		
		if (id < 0) {
			id = id * -1;
		}
		if (id < 1000000000) {
			id += 1000000000;
		}
		return id;
	}
	public String moneyTransferService(SenderDTO senderDTO, ReceiverDTO receiverDTO , double amount) throws SQLException
	{
		//generate transaction id
		int id = trasactionNumber();
		String tid = null;
		
		//change format of date
		Date date = new Date(); //to get current system data for transaction
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
		String transactionDate = dateformat.format(date);
		System.out.println("TransactionDate " + transactionDate);
		
		UserService service = new UserService();
		
		//check balance of sender account
		double balance = service.viewBalanceService(senderDTO.getAccountNo());
		double balance2 = service.viewBalanceService(receiverDTO.getAccountNo());
		
		if (balance >= 1500) 
		{
			//store date and transaction id in sender account
			senderDTO.settDate(transactionDate); //set date
			senderDTO.setTid("TID-"+id); //set id
			double finalBalance = balance - amount;
			senderDTO.setBalance(finalBalance); //set balance after deduction
			
			
			//store date and transaction id in receiver account
			receiverDTO.settDate(transactionDate); //set date
			receiverDTO.setTid("TID-"+id*2); //set id
			double finalBalance2 = balance2 + amount; 
			receiverDTO.setBalance(finalBalance2);//set balance after adding
			
			UserDAO dao = new UserDAO();
			tid = dao.moneyTransferUpdation(senderDTO, receiverDTO);
		}
		return tid;
	}
}
















