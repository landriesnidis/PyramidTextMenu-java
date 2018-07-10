package pers.landriesnidis.ptm4j.user;

public class User<T>{
	private String userId;
	private String userName;
	private T attribute;
	 
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public T getAttribute() {
		return attribute;
	}
	public void setAttribute(T attribute) {
		this.attribute = attribute;
	}
}
