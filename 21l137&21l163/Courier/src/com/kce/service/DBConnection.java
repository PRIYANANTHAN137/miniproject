package com.kce.service;
import java.sql.*;
public class DBConnection {
	static Connection connection;
	public static Connection createConnection()
	{
	try
	{
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/COURIER","root","Nanthu@137");
	}
	catch(Exception e) {
	e.printStackTrace();
	}
	return connection;
	}
}