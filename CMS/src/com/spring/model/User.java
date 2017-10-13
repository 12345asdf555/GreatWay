package com.spring.model;

/**
 * 用户
 *
 *
 */
public class User {
	private int id;
	private String userName;
	private String userPassword;
	private String userLoginName;
	private String userPhone;
	private String userEmail;
	private String userInsframework;
	private String userPosition;
	private int status;
	private String roleName;
	private String authorityName;
	public User(){
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserLoginName() {
		return userLoginName;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserInsframework() {
		return userInsframework;
	}
	public void setUserInsframework(String userInsframework) {
		this.userInsframework = userInsframework;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	public User(int id, String userName, String userPassword, String userLoginName,String userPhone,String userEmail,String userInsframework,String userPosition,int status,String roleName,String authorityName) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userLoginName = userLoginName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userInsframework = userInsframework;
		this.userPosition = userPosition;
		this.status = status;
		this.roleName = roleName;
		this.authorityName = authorityName;
	}
}
