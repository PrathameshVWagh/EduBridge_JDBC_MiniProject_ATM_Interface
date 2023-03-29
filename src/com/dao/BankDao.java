package com.dao;



import java.util.List;
import entity.Bank;

public interface BankDao 
{	
	public void bankInfo();
	public List<Bank>findAll();
	public List<Bank> accountHolder(Bank i);
	public List<Bank> RaccountHolder(Bank i);
	
	public void insertAccount(Bank i);
	public void updateBank(Bank i);
	public void deleteIPL(Bank i);
}