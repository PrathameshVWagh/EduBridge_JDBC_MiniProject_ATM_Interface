package service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dao.impl.BankDaoImpl;


import UI.ATMMain;
import entity.Bank;

import service.AccountHolderInterface;
import service.BankInterface;

public class BankImplementation implements BankInterface,AccountHolderInterface{
	Scanner sc = new Scanner(System.in);
	ArrayList<Bank>list1=new ArrayList<Bank>();
	List<Bank>list;
	String id;
	String pin;
	
	 
	 
	@Override
	public void addAccountHolder() throws NumberFormatException, IOException,InputMismatchException, NullPointerException, ClassNotFoundException, SQLException{
		try {
			
		Scanner sc= new Scanner(System.in);
		System.out.println("Ënter your Name : ");
		String name = sc.nextLine();
		System.out.println("Ënter your User ID : ");
		String id = sc.nextLine();
		System.out.println("Ënter your User Pin : ");
		String pin = sc.nextLine();
		System.out.println("Enter your Amount in RS. : ");
		double amt = sc.nextDouble();
		
		String bname = "Student Bank";
		String acc = "Account Created";
		Bank b1 = new Bank(pin,id,bname,name,amt,acc);
		
		new BankDaoImpl().insertAccount(b1);
		System.out.println("Account Holder Successfully Added");
		
		
	}catch(NumberFormatException | InputMismatchException | NullPointerException e) {
			System.out.println("Enter proper response");
		}
		
	}
	

	@Override
	public void bankInfo() throws NumberFormatException, IOException,InputMismatchException, ClassNotFoundException, SQLException{
		new BankDaoImpl().bankInfo();
		
	}
	
	
	
	@Override
	public void allAccountHolder() throws NumberFormatException, IOException,InputMismatchException, ClassNotFoundException, SQLException {
		
	
		List<Bank>list=new  BankDaoImpl().findAll();
	
		for(Bank s1:list)
		{
			System.out.println(s1);
			
		}	
		
	
	}

	@Override
	public void accountHolder() throws NumberFormatException, IOException,InputMismatchException, ClassNotFoundException, SQLException {

		try {
			
		Bank bb = new Bank();
		System.out.println("Enter your id :");
		id=sc.nextLine();//101
		System.out.println("Enter your Pin :");
		pin=sc.nextLine();
		bb.setUserId(id);
		bb.setUserPin(pin);
		new BankDaoImpl().accountHolder(bb);
		
		String name= null;
		List<Bank>list = new  BankDaoImpl().accountHolder(bb);
		for(Bank i:list)
		{
			name = i.getAccountholdername();
		}
		list1.addAll(list);
		//System.out.println(name);
		
		
		int index=0,flag=0;
		Bank s=null;
		
		
		
		
		
		if(name.equals(null))
		{
			System.out.println("User does not exist!!");
		}
		else
		{
			
			String s1;
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			
			System.out.println("=======================================================");
			System.out.println("               Welcome to Student Bank ATM             ");
			System.out.println("=======================================================");
			
			System.out.println("--- Enter the numbers for do the operations in ATM ---");
			ATMImplementation a = new ATMImplementation();
		
			
			do{
			System.out.println("=======================================================");
				System.out.println("1. Deposit ");
				System.out.println("2. Withdraw");
				System.out.println("3. Transfer");
				System.out.println("4. Transaction History ");
				System.out.println("5. Quit");
				
			System.out.println("=======================================================");
				System.out.println("Enter the choice : ");
				int choice=sc1.nextInt();
				switch(choice) 
				{
					case 1:
						a.Deposit(list1,id);
						break;
					case 2:
						a.Withdraw(list1,id);
						break;
					case 3:
						a.Transfer(list1,id);
						break;
					
					case 4:
						a.showTransactionHistory();
						break;
					case 5:
						System.out.println("For Logout please enter <no>");
						break;
		    	  }
		    	  System.out.println("Do you want to continue? <yes/no>");
		    	  s1=sc.next();
		    	  
		    	  if(s1.equals("no")){
		    		  
		    		  a.quit();
		    		  break;
		    	  }
			}while(s1.equals("yes"));

			
			
			
		}
		
	}catch(NumberFormatException | IOException | InputMismatchException | NullPointerException e) {
		System.out.println("Enter proper response");
	}
		
	}

		
	    
		
}

	

	

	
	
	


