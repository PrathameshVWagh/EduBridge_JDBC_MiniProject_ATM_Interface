package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Bank;

//data access object

public class BankDaoImpl {
	
	public void bankInfo() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMInterface","root","rootpvw");
		
        PreparedStatement statement=con.prepareStatement("select * from bankinfo");
        ResultSet rs=statement.executeQuery();
        String info=null;
        while(rs.next()) {
        	info = rs.getString(1);
        }
        System.out.println(info);
		
		
	}
	
	public List<Bank>  findAll() throws ClassNotFoundException, SQLException
	{
		ArrayList<Bank> list=new ArrayList<Bank>();
				Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMInterface","root","rootpvw");
		
        PreparedStatement statement=con.prepareStatement("select * from bank");
        ResultSet rs=statement.executeQuery();
        while(rs.next())
        {
        	Bank e=new Bank();
        	e.setUserPin(rs.getString(1));
        	e.setUserId(rs.getString(2));
        	
        	e.setBankName(rs.getString(3));
        	e.setAccountholdername(rs.getString(4));
        	e.setAmount(rs.getDouble(5));
        	e.setOperation(rs.getString(6));
        
        
        
        	list.add(e);
        }
        con.close();
        
        return list;
        
        
        
		
		
		
		
	}
	public List<Bank>  transactionfindAll() throws ClassNotFoundException, SQLException
	{
		ArrayList<Bank> list=new ArrayList<Bank>();
				Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMInterface","root","rootpvw");
		
        PreparedStatement statement=con.prepareStatement("select * from banktransaction");
        ResultSet rs=statement.executeQuery();
        while(rs.next())
        {
        	Bank e=new Bank();
        	
        	e.setUserId(rs.getString(1));
        	
        	e.setBankName(rs.getString(2));
        	e.setAccountholdername(rs.getString(3));
        	e.setAmount(rs.getDouble(4));
        	e.setOperation(rs.getString(5));
        
        
        
        	list.add(e);
        }
        con.close();
        
        return list;
        
        
        
		
		
		
		
	}
	public List<Bank> accountHolder(Bank i) throws ClassNotFoundException, SQLException
	{
		ArrayList<Bank> list=new ArrayList<Bank>();
				Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMInterface","root","rootpvw");
		
        PreparedStatement statement=con.prepareStatement("select * from bank where userId=? and userPin=?");
        statement.setString(1,i.getUserId());
        statement.setString(2,i.getUserPin());
        ResultSet rs=statement.executeQuery();
       
        while(rs.next())
        {
        	Bank e=new Bank();
        	e.setUserPin(rs.getString(1));
        	e.setUserId(rs.getString(2));
        	
        	e.setBankName(rs.getString(3));
        	e.setAccountholdername(rs.getString(4));
        	e.setAmount(rs.getDouble(5));
        	e.setOperation(rs.getString(6));
        
        
        
        	list.add(e);
        }
        con.close();
        
        return list;
        
		
	}
	
	public List<Bank> getHolder(Bank i) throws ClassNotFoundException, SQLException
	{
		ArrayList<Bank> list=new ArrayList<Bank>();
				Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMInterface","root","rootpvw");
		
        PreparedStatement statement=con.prepareStatement("select * from bank where userId=?");
        statement.setString(1,i.getUserId());
       
        ResultSet rs=statement.executeQuery();
       
        while(rs.next())
        {
        	Bank e=new Bank();
        	e.setUserPin(rs.getString(1));
        	e.setUserId(rs.getString(2));
        	
        	e.setBankName(rs.getString(3));
        	e.setAccountholdername(rs.getString(4));
        	e.setAmount(rs.getDouble(5));
        	e.setOperation(rs.getString(6));
        
        
        
        	list.add(e);
        }
        con.close();
        
        return list;
        
		
	}
	public List<Bank> RaccountHolder(Bank i) throws ClassNotFoundException, SQLException
	{
		ArrayList<Bank> list=new ArrayList<Bank>();
				Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMInterface","root","rootpvw");
		
        PreparedStatement statement=con.prepareStatement("select userId from bank where userId<>?");
        statement.setString(1,i.getUserId());
       
        ResultSet rs=statement.executeQuery();
       
        while(rs.next())
        {
        	Bank e=new Bank();
        	
        	e.setUserId(rs.getString(1));
        	
        	
        
        
        	
        	list.add(e);
        }
        con.close();
        
        return list;
        
		
	}
	
	public void insertAccount(Bank i) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMInterface","root","rootpvw");
       
        PreparedStatement statement=con.prepareStatement("insert into bank values(?,?,?,?,?,?)");
        
        statement.setString(1,i.getUserPin());
        statement.setString(2,i.getUserId());
    	
    	statement.setString(3,i.getBankName());
    	statement.setString(4,i.getAccountholdername());
    	statement.setDouble(5,i.getAmount());
    	statement.setString(6,i.getOperation());
    
        statement.executeUpdate();
        con.close();
		
	}
	
	public void insertTransaction(Bank i) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMInterface","root","rootpvw");
       
        PreparedStatement statement=con.prepareStatement("insert into bankTransaction values(?,?,?,?,?)");
        
        statement.setString(1,i.getUserId());
    	
    	statement.setString(2,i.getBankName());
    	statement.setString(3,i.getAccountholdername());
    	statement.setDouble(4,i.getAmount());
    	statement.setString(5,i.getOperation());
    
        statement.executeUpdate();
        con.close();
		
	}

	
	
	
	public void updateBank(Bank i) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATMInterface","root","rootpvw");
       
        PreparedStatement statement=con.prepareStatement("update bank set amount=?,operation=? where userId=?");

    	statement.setDouble(1,i.getAmount());
    	statement.setString(2,i.getOperation());
    	statement.setString(3, i.getUserId());
       
        statement.executeUpdate();
        con.close();
		
	}
	
	
}
