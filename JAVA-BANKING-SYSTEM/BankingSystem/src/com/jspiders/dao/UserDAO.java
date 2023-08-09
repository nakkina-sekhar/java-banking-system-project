package com.jspiders.dao;
/* jdbc code */
import java.sql.*;

import com.jspiders.dto.ReceiverDTO;
import com.jspiders.dto.RegistrationDTO;
import com.jspiders.dto.SenderDTO;
public class UserDAO 
{
	public String registrationDAO(RegistrationDTO dto) throws SQLException
	{
		String query = "insert into onlinebankmanagement.bankaccountdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		SingleTon singleTon = SingleTon.getObject();
		/* establish connection */
		Connection connection = singleTon.getConnection();
		System.out.println("Established " + connection);
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, dto.getAccountNo());
		pstmt.setString(2, dto.getFirstName());
		pstmt.setString(3, dto.getLastName());
		pstmt.setString(4, dto.getMobile());
		pstmt.setString(5, dto.getPancard());
		pstmt.setString(6, dto.getAadharNo());
		pstmt.setString(7, dto.getEmail());
		pstmt.setString(8, dto.getAddress());
		pstmt.setString(9, dto.getDob());
		pstmt.setString(10, dto.getGender());
		pstmt.setString(11, dto.getAccountType());
		pstmt.setString(12, dto.getPassword());
		pstmt.setDouble(13, dto.getAmount());
		
		/* to store account number */
		String accountNumber;
		int record = pstmt.executeUpdate();
		if (record > 0) 
		{
			accountNumber = dto.getAccountNo();
		}
		else
		{
			accountNumber = null;
		}
		return accountNumber;
	}
	/* to store values from database */
	String firstName;
	String lastName;
	String accountNo;
	public RegistrationDTO userLogin(String accNo, String password) throws SQLException
	{
		/* store values in dto*/
		RegistrationDTO dto = null;
		String query = "select * from onlinebankmanagement.bankaccountdetails where accountNo = ? and password = ?";
		SingleTon singleTon = SingleTon.getObject();
		Connection connection = singleTon.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, accNo);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			/* record is present - store value in registrationdto object */
			dto = new RegistrationDTO();
			firstName = rs.getString("firstName");
			lastName = rs.getString("lastName");
			accountNo = rs.getString("accountNo");
			System.out.println("FirstName = " + firstName);
			dto.setFirstName(firstName);
			dto.setLastName(lastName);
			dto.setAccountNo(accountNo);
		}
		else{
			dto = null;
		}
		return dto;
	}
	/* logic to view user account balance */
	public double viewBalanceDao(String accNo) throws SQLException
	{
		double balance = 0;
		String query = "select * from onlinebankmanagement.bankaccountdetails where accountNo = ?";
		SingleTon singleTon = SingleTon.getObject();
		Connection connection = singleTon.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, accNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			//fetch balance from db
			balance = rs.getDouble("amount");
		}
		return balance;
		
	}
	/* to update balance of sender account and receiver account in bankdetails table*/
	public String moneyTransferUpdation(SenderDTO senderDTO, ReceiverDTO receiverDTO) throws SQLException
	{
		String query = "Update onlinebankmanagement.bankaccountdetails set amount = ? where accountNo = ?";
		
		SingleTon singleTon = SingleTon.getObject();
		Connection connection = singleTon.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(query);
		
		//to update balance in sender account
		pstmt.setDouble(1, senderDTO.getBalance());
		pstmt.setString(2, senderDTO.getAccountNo());
		pstmt.addBatch();
		
		//to update balance in receiver account
		pstmt.setDouble(1, receiverDTO.getBalance());
		pstmt.setString(2, receiverDTO.getAccountNo());
		pstmt.addBatch();
		
		//to execute records
		 int [] recordStatus = pstmt.executeBatch();
		 String tid = null;
		 if (recordStatus[1] != 0) 
		 {
			TransactionDAO trDao = new TransactionDAO();
			tid = trDao.insertTransaction(senderDTO, receiverDTO, connection);
		 }
		 
		 return tid;
	}
}























