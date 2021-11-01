package com.myproject.myproject.edu_class;

public class UserClass {
	
	private int num;	// 구분 번호
	private String track;	// 트랙
	private int year;	// 과목의 해당 학년
	private String className;	// 과목명
	private int credit;	// 해당 학점
	private double userGrade;
	
	// 기본 생성자
	public UserClass() {}
	
	// 생성자
	// 새로 추가!
	public UserClass(int num, String track, int year, String className, int credit, double userGrade) {
		super();
		this.num = num;
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
	

	public double getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(double userGrade) {
		this.userGrade = userGrade;
	}

	// toString
	@Override
	public String toString() {
		return "UserClass [num=" + num + ", track=" + track + ", year=" + year + ", className=" + className
				+ ", credit=" + credit + ", userGrade=" + userGrade + "]";
	}

		
}
