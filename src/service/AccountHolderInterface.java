package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

import entity.Bank;

public interface AccountHolderInterface {
	public void accountHolder() throws NumberFormatException, IOException,InputMismatchException,NullPointerException, ClassNotFoundException, SQLException;
}
