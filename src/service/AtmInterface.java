package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import entity.Bank;

public interface AtmInterface {
	
	public void Withdraw(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException;
	public void Deposit(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException;
	public void Transfer(ArrayList<Bank> list,String userId) throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException;
	public void showTransactionHistory() throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException;
	public void quit() throws NumberFormatException, IOException,InputMismatchException,NullPointerException;

}
