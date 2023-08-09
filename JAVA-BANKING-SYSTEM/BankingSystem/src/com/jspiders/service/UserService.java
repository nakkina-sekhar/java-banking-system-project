package com.jspiders.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jspiders.dao.TransactionDAO;
import com.jspiders.dao.UserDAO;
import com.jspiders.dto.RegistrationDTO;
import com.jspiders.dto.SenderDTO;

public class UserService{
	UserDAO dao = new UserDAO();
	public String userAccountNumber(RegistrationDTO dto) throws SQLException{
		Random random = new Random();
		int accno = random.nextInt();
		/* to convert negative into positive */
		if(accno < 0)
		{
			accno = accno * -1;
		}
		/*to convert 9 digit into 10 digit */
		if (accno < 1000000000) {
			accno += 1000000000;
		}
		String accountNumber;
		accountNumber = "JSP-"+accno;
		/* store accountNumber in RegistrationDTO */
		dto.setAccountNo(accountNumber);
		
		/* to check whether account number get store in database or not */
		accountNumber =  dao.registrationDAO(dto);
		return accountNumber;
	}
	/* transfer the account No and password into userDAO*/
	public RegistrationDTO userLoginService(String accNo, String pwd) throws SQLException
	{
		RegistrationDTO dto = dao.userLogin(accNo, pwd);
		return dto;
	}
	/* to transfer account info into userDAO*/
	public double viewBalanceService(String accNo) throws SQLException
	{
		return dao.viewBalanceDao(accNo);
	}
	public List<SenderDTO> viewTransactionHistory(String startdate,
			String enddate, String accountNo) throws SQLException {

		TransactionDAO dao = new TransactionDAO();

		List list = dao.retrieveAllTrasaction(startdate, enddate,
				accountNo);

		return list;

	}
}











