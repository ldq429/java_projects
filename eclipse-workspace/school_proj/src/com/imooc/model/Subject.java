package com.imooc.model;

import java.util.ArrayList;

/**
 * 学科名称，学制，学科编号
 * 
 * @author User
 *
 */
public class Subject {
	private String subjectName;
	private int duration;
	private String serialNumber;
	private static ArrayList<Student> studentArrayList;

	public Subject() {
	}

	public Subject(String subjectName, int duration, String serialNumber) {
		this.setSubjectName(subjectName);
		this.setDuration(duration);
		this.setSerialNumber(serialNumber);
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	protected void addStudent(Student studentInfo) {
		if (studentInfo == null)
			studentInfo = new Student();

		if (Subject.studentArrayList == null)
			Subject.studentArrayList = new ArrayList<Student>();

		Subject.studentArrayList.add(studentInfo);
	}

	public String info() {
		return "共计" + Subject.studentArrayList.size() + "学生报名了该专业...";
	}

}
