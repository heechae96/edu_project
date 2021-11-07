package com.myproject.myproject.user_class;

// 추가한 교과목 리스트를 보여주기 쉽게 클래스를 추가로 생성한것.
public class EuList {
	private int num;	// 과목코드
	private String className;	// 과목명
	private double userGrade;	// 학점
	
	public EuList(int num, String className, double userGrade) {
		super();
		this.num = num;
		this.className = className;
		this.userGrade = userGrade;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public double getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(double userGrade) {
		this.userGrade = userGrade;
	}

	@Override
	public String toString() {
		return "EuList [num=" + num + ", className=" + className + ", userGrade=" + userGrade + "]";
	}
	
	
}
