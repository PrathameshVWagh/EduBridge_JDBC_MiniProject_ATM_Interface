package entity;

public class AccountHolder {
	public String userId;
	public String userPin;
	public String uname;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPin() {
		return userPin;
	}
	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public AccountHolder(String userId, String userPin, String uname) {
		super();
		this.userId = userId;
		this.userPin = userPin;
		this.uname = uname;
	}
	
	@Override
	public String toString() {
		return "AccountHolder [userId=" + userId + ", userPin=" + userPin + ", uname=" + uname + "]";
	}
	
	

}
