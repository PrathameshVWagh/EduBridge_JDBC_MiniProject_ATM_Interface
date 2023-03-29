package UI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.impl.BankDaoImpl;

import service.impl.BankImplementation;


public class ATMMain {

	public static void main(String[] args) throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException{
		
		try {
		String s;
		String s2 = null;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		
		System.out.println("=======================================================");
		System.out.println("                     ATM Interface                     ");
		System.out.println("=======================================================");
		
		System.out.println("--- Enter the numbers for do the operations in ATM ---");
		BankImplementation b = new BankImplementation();
		BankDaoImpl b1 = new BankDaoImpl();
		do{
		System.out.println("=======================================================");
			System.out.println("1. Bank Info ");
			System.out.println("2. Add Account Holder");
			
			System.out.println("3. See all Account Holder");
			System.out.println("4. Login with user ID and User Pin");
			System.out.println("5. For leave the Student Bank ATM");
			System.out.println("=======================================================");
			System.out.println("Enter the choice : ");
			int choice=sc1.nextInt();
			switch(choice) 
			{
				case 1:
					b.bankInfo();
					break;
				case 2:
					b.addAccountHolder();
					break;
				case 3:
					b.allAccountHolder();
					//b1.findAll();
					break;
				
				case 4:
					
					b.accountHolder();
					
					break;
				case 5:
					System.out.println("Thank you visit Again !!");
					break;
				
					
	    	  }
	    	  System.out.println("Do you want to continue? <yes/no>");
	    	  s=sc.next();
	    	  if(s.equals("no")) {
	    		  System.out.println("Thank you visit Again !!");
	    		  System.out.println("Do you want to continue? <yes>");
	    		  s2 =sc3.next();
	    	  }
		}while(s.equals("yes")||s2.equals("yes"));
		}catch(NumberFormatException | IOException | InputMismatchException | NullPointerException e) {
			System.out.println("Enter proper response");
			
		}
	
	}
}

                       