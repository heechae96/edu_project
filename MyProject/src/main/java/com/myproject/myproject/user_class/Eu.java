package com.myproject.myproject.user_class;

public class Eu {
	
	private int indexNum;
	private String classNumber;	// 학번
	private int num;	// 과목코드	
	private double userGrade;	// 학점
	
	public Eu() {}

	public Eu(int indexNum, String classNumber, int num, double userGrade) {
		super();
		this.indexNum = indexNum;
		this.classNumber = classNumber;
		this.num = num;
		this.userGrade = userGrade;
	}

	public int getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(int indexNum) {
		this.indexNum = indexNum;
	}

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(double userGrade) {
		this.userGrade = userGrade;
	}

	@Override
	public String toString() {
		return "Eu [indexNum=" + indexNum + ", classNumber=" + classNumber + ", num=" + num + ", userGrade=" + userGrade
				+ "]";
	}

}
