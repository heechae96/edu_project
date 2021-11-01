package com.myproject.myproject.edu_user;

public class User {
	private int num;	// 구분 번호
	private String userId;	// 아이디
	private String password;	// 비밀번호
	private String classNumber;	// 학번
	private String userName;	// 이름
	private int userYear;	// 학생 학년
	
	
	
	public User() {}

	public User(int num, String userId, String password, String classNumber, String userName, int userYear) {
		super();
		this.num = num;
		this.userId = userId;
		this.password = password;
		this.classNumber = classNumber;
		this.userName = userName;
		this.userYear = userYear;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserYear() {
		return userYear;
	}

	public void setUserYear(int userYear) {
		this.userYear = userYear;
	}

	@Override
	public String toString() {
		return "User [num=" + num + ", userId=" + userId + ", password=" + password + ", classNumber=" + classNumber
				+ ", userName=" + userName + ", userYear=" + userYear + "]";
	}
			
}
