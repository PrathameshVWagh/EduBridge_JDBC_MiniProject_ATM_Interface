package service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dao.impl.BankDaoImpl;

import UI.ATMMain;
import entity.Bank;

import service.AtmInterface;


public class ATMImplementation implements AtmInterface{
	ArrayList<Bank>list5=new ArrayList<Bank>();
	@Override
	public void Withdraw(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException {
		try {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter  Amount in Rs. which you want to withdraw :");
		double id=sc.nextDouble();
		
	    int flag=0,index = 0;
	    Bank s=null;
	    for(Bank e:list)
	    {
	    	if(id<=e.getAmount()&&userId.equals(e.getUserId()))//1001=1001
	    	{
	    		flag=1;
	    		
	    		index=list.indexOf(e);//1001
	    		s=e;
	    		
	    		break;
	    	}
	    }
	    
	    if(flag==1)
	    {	
	    	double bal = s.getAmount();
	    	double updatedbal = bal-id;
			  
			s.setAmount(updatedbal);
			s.setOperation("Withdraw");
			
			list.set(index,s);
			
			
			
			String name = s.getAccountholdername();
			double amount = s.getAmount();
			String bName=s.getBankName();
			String ope =s.getOperation();
			String uid=s.getUserId();
			
			Bank bw = new Bank(uid,bName,name,amount,ope);
			new  BankDaoImpl().updateBank(bw);
			System.out.println("Balance Updated!!");
			bw.history();
			new  BankDaoImpl().insertTransaction(bw);
			
			
			
	    }
	    else {
	    	System.out.println("You have not enough balance to proceed this transaction ..");
	    }
		}catch(NumberFormatException | InputMismatchException | NullPointerException e) {
			System.out.println("Enter proper response");	
		}
	    

		
	}

	@Override
	public void Deposit(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException  {
		try {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter  Amount in Rs. which you want to Deposit :");
		double id=sc.nextDouble();
	    int flag=0,index = 0;
	    Bank s=null;
	    for(Bank e:list)
	    {
	    	if((id<=e.getAmount()||id>=e.getAmount())&&userId.equals(e.getUserId()))//1001=1001
	    	{
	    		flag=1;
	    		
	    		index=list.indexOf(e);
	    		s=e;
	    		
	    		break;
	    	}
	    }
	    
	    if(flag==1)
	    {	
	    	double bal = s.getAmount();
	    	double updatedbal = bal+id;
			 
	    	
	    	
	    	
			s.setAmount(updatedbal);
			s.setOperation("Deposit");
			
			list.set(index,s);
			
			
			
			
			String name = s.getAccountholdername();
			double amount = s.getAmount();
			String bName=s.getBankName();
			String ope =s.getOperation();
			String uid=s.getUserId();
			String upin = s.getUserPin();
			
			Bank bd = new Bank(uid,bName,name,amount,ope);
			
			new  BankDaoImpl().updateBank(bd);
			System.out.println("Balance Updated!!");
			bd.history();
			new  BankDaoImpl().insertTransaction(bd);
			
			
	    }
	    else {
	    	System.out.println("You have not enough balance to proceed this transaction ..");
	    }
		}catch(NumberFormatException | InputMismatchException | NullPointerException  e) {
			System.out.println("Enter proper response");	
		}

		
	}
	

	@Override
	public void Transfer(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException, ClassNotFoundException, SQLException{
		try {
		
		Bank b3 =null;
		int index2 = 0;
		Bank b = new Bank();
		b.setUserId(userId);
		new BankDaoImpl().getHolder(b);
		
		new BankDaoImpl().RaccountHolder(b);
		
		List<Bank>liw = new  BankDaoImpl().getHolder(b);
		
		
		System.out.println("Please enter user id from following list to transfer money : ");
		System.out.println("=================================================");
		System.out.println("           All User ID in Student Bank          " );
		System.out.println("=================================================");
		List<Bank>listw = new  BankDaoImpl().RaccountHolder(b);
		
		
		for(Bank i:listw)
		{
			System.out.println(i.getUserId());
			
		}
		
		
		System.out.println("=================================================");
		System.out.println("==Please Enter user Id Properly from above list==");
		System.out.println("=================================================");
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter recepient User Id : ");
		String ruserid = sc.next();
		
		Bank r = new Bank();
		r.setUserId(ruserid);
		
		double bal=0;
		String an1 = null;
		double useramt =0;
		for(Bank i:liw)
		{
			System.out.println(i.getAccountholdername());
			useramt= i.getAmount();
			an1 = i.getAccountholdername();
			
			
			
			
		}
		
	 
		
		
		
		new  BankDaoImpl().getHolder(r);
		String bn = null;
		String an =null;
		ArrayList<Bank>liw2 = (ArrayList<Bank>) new  BankDaoImpl().getHolder(r);
		for(Bank i2:liw2)
		{
			an = i2.getAccountholdername();
			bal = i2.getAmount();
			bn = i2.getBankName();
			
		}
		
		
	if(useramt>=0) {
			System.out.println("Enter amount in Rs. that you want to transfer : ");
			double transferamt = sc.nextDouble();
			if(transferamt<useramt) {
			double updatedbal = bal+transferamt;
			
			double firstuseramt = useramt - transferamt;
		
			r.setAmount(updatedbal);
			r.setOperation("Transfered from : "+b.getUserId());
			r.setBankName(bn);
			r.setAccountholdername(an);
			b.setAmount(firstuseramt);
			b.setOperation("Transfer to : "+r.getUserId());
			b.setBankName(bn);
			b.setAccountholdername(an1);
			
			
			
			String name = r.getAccountholdername();
			double amount = r.getAmount();
			String bName=r.getBankName();
			String ope =r.getOperation();
			String uid=r.getUserId();
			
			Bank bt1 = new Bank(uid,bName,name,amount,ope);
			
			new  BankDaoImpl().updateBank(bt1);
			
			
			bt1.history();
			new  BankDaoImpl().insertTransaction(bt1);
			
			String name2 = b.getAccountholdername();
			double amount2 = b.getAmount();
			String bName2=b.getBankName();
			String ope2 =b.getOperation();
			String uid2=b.getUserId();
			
			Bank bt2 = new Bank(uid2,bName2,name2,amount2,ope2);
			
			
			new  BankDaoImpl().updateBank(bt2);
			bt2.history();
			new  BankDaoImpl().insertTransaction(bt2);
			System.out.println("Balance Updated!!");
			}
			else {
				System.out.println("After this transaction you have zero balance");
			}
	}else {
		System.out.println("You have not enough balance to proceed this transaction!!");
	}
			
		
		}catch(NumberFormatException | InputMismatchException | NullPointerException e) {
			System.out.println("Enter proper response");	
		}
	}

	
	@Override
	public void quit() throws NumberFormatException, IOException,InputMismatchException {
		System.out.println("Redircting to main page...");
		System.out.println(".");
		System.out.println(".....");
		System.out.println("...........");
		System.out.println("................");
		System.out.println("For Go Back to Main Dashboard Please enter <yes>");
		
		ATMMain atm = new ATMMain();
		
		
	}

	@Override
	public void showTransactionHistory() throws NumberFormatException, IOException,InputMismatchException, ClassNotFoundException, SQLException{
		List<Bank>list=new  BankDaoImpl().transactionfindAll();
		
		for(Bank s1:list)
		{
			System.out.println(s1.history());
			
		}	
	}

	
		
}

	
	
	
	


