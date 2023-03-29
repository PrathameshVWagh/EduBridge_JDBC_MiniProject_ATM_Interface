package entity;

public class Bank {
	
	private String userPin;
	private String userId;
	private String bankName;
	private String accountholdername;
	private double amount;
	private String operation;
	
	
	

	public Bank() {
		
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getUserPin() {
		return userPin;
	}
	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccountholdername() {
		return accountholdername;
	}

	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Bank(String userPin, String userId, String bankName, String accountholdername, double amount,String operation) {
		super();
		this.userPin = userPin;
		this.userId = userId;
		this.bankName = bankName;
		this.accountholdername = accountholdername;
		this.amount = amount;
		this.operation = operation;
		
	}
	public Bank(String userId, String bankName, String accountholdername, double amount,
			String operation) {
		super();
		
		this.userId = userId;
		this.bankName = bankName;
		this.accountholdername = accountholdername;
		this.amount = amount;
		this.operation = operation;
	}
	
	
	

	@Override
	public String toString() {
		return "Bank [userPin=" + userPin + ", userId=" + userId + ", bankName=" + bankName + ", accountholdername="
				+ accountholdername + ", amount=" + amount + ", operation=" + operation +"]";
	}

	public String history() {
		return "Bank [userId=" + userId + ", bankName=" + bankName + ", accountholdername="
				+ accountholdername + ", amount=" + amount + ", operation=" + operation + "]";
	
		
	}
	

	
	
	

	
	
	
	
	
	
	

}
