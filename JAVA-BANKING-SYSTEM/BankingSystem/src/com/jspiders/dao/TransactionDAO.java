package com.jspiders.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jspiders.dto.ReceiverDTO;
import com.jspiders.dto.SenderDTO;

public class TransactionDAO {

	public String insertTransaction(SenderDTO senderDTO, ReceiverDTO receiverDTO, Connection connection) 
			throws SQLException{
		String query = "insert into onlinebankmanagement.transactiondetails values(?,?,?,?,?)";
		
		PreparedStatement pstmt = connection.prepareStatement(query);
		//add transaction details of receiver.
		pstmt.setString(1, receiverDTO.getTid());
		pstmt.setString(2, receiverDTO.getAccountNo());
		pstmt.setString(3, receiverDTO.getDescription());
		pstmt.setDouble(4, receiverDTO.getBalance());
		pstmt.setString(5, receiverDTO.gettDate());
		//to add record in table
		pstmt.addBatch();
		
		//add transaction details of sender
		pstmt.setString(1, senderDTO.getTid());
		pstmt.setString(2, senderDTO.getAccountNo());
		pstmt.setString(3, senderDTO.getDescription());
		pstmt.setDouble(4, senderDTO.getBalance());
		pstmt.setString(5, senderDTO.gettDate());
		//to add
		pstmt.addBatch();
		//to insert all records in db
		int [] recordStatus = pstmt.executeBatch();
		
		String tid = null;
		
		if (recordStatus[1] != 0) {
			//get transaction id of sender
			tid = senderDTO.getTid();
			System.out.println("Sender Tid = " + tid);
		}
		
		return tid;
	}
	/* to fetch all transaction of user */
	public List retrieveAllTrasaction(String startDate, String endDate, String AccountNo) throws SQLException
	{
		String query = "select * from onlinebankmanagement.transactiondetails where accountNumber = ? and TransactionDate between ? and ?";
		SingleTon singleTon = SingleTon.getObject();
		Connection connection = singleTon.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, AccountNo);
		pstmt.setString(2, startDate);
		pstmt.setString(3, endDate);
		
		List<SenderDTO> list = new ArrayList<SenderDTO>();
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.last()) 
		{
			rs.beforeFirst();
			while (rs.next()) {
				SenderDTO dto = new SenderDTO();
				//retrieve value and store in sender dto
				dto.setTid(rs.getString("TransactionId"));
				dto.settDate(rs.getString("TransactionDate"));
				dto.setDescription(rs.getString("Description"));
				dto.setBalance(rs.getDouble("balance"));
				
				//add senderdto object in list object
				list.add(dto);
			}
		}
		else
		{
			list = null;
		}
		
		return list;
	}
}
































