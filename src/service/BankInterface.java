package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;

public interface BankInterface {

	public void addAccountHolder() throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException;
	public void bankInfo() throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException;
	public void allAccountHolder() throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException;
	
}
