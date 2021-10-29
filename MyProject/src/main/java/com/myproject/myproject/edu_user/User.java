package com.myproject.myproject.edu_user;

public class User {
	private int num;	// 구분 번호
	private String userId;	// 아이디
	private String password;	// 비밀번호
	private String classNumber;	// 학번
	private String userName;	// 이름
	private int userYear;	// 학생 학년
	private String track;	// 트랙
	private int year;	// 과목의 해당 학년
	private String className;	// 과목명
	private int credit;	// 해당 학점
	private String userGrade;	// 성적
	
	// 기본 생성자
	public User() {}
	
	// 생성자
	public User(int num, String userId, String password, String classNumber, String userName, int userYear,
			String track, int year, String className, int credit, String userGrade) {
		super();
		this.num = num;
		this.userId = userId;
		this.password = password;
		this.classNumber = classNumber;
		this.userName = userName;
		this.userYear = userYear;
		this.track = track;
		this.year = year;
		this.className = className;
		this.credit = credit;
		this.userGrade = userGrade;
	}
	
	// getters and setters
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

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	// toString
	@Override
	public String toString() {
		return "User [num=" + num + ", userId=" + userId + ", password=" + password + ", classNumber=" + classNumber
				+ ", userName=" + userName + ", userYear=" + userYear + ", track=" + track + ", year=" + year
				+ ", className=" + className + ", credit=" + credit + ", userGrade=" + userGrade + "]";
	}
		
}
