package com.jspiders.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/* to get a connection while writing jdbc program*/
public class SingleTon 
{
	private Connection connection = null;
	
	/* static & final (constant variable) --> uppercase */
	private static final SingleTon ONLY_ONE = new SingleTon();
	
	private SingleTon()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* to get connection of database*/
	public Connection getConnection()
	{
		return connection;
	}
	/* to get object of singleton class */
	public static SingleTon getObject()
	{
		return ONLY_ONE;
	}

	@Override
	protected void finalize() throws Throwable {
			/* to close connection */
			if (connection != null) {
				connection.close();
			}
	}

	
	
}













