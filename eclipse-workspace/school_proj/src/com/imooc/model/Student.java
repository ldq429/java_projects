package com.imooc.model;

public class Student {
	private String name;
	private int age;
	private Subject subject;

	public Student() {
	}

	/**
	 * 初始化学生信息
	 * 
	 * @param name    学生姓名
	 * @param age     学生年龄
	 * @param subject 学科信息对象
	 */
	public Student(String name, int age, Subject subject) {
		this.setName(name);
		this.setAge(age);
		this.setSubject(subject);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		if (age >= 18 && age < 60) {
			this.age = age;
		} else {
			this.age = 18;
			System.out.println("输入的学生年龄于实际不相符，应该在18-60岁之间，系统已默认为18岁...");
		}

	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		if (subject == null) {
			subject = new Subject();
		}
		this.subject = subject;
		this.addStudentToSubject();
	}

	private void addStudentToSubject() {
		subject.addStudent(this);
	}

	public String introduce() {
		String introString = "姓名：" + this.getName() + "\n" + "年龄:" + this.getAge() + "\n" + "专业名称："
				+ this.getSubject().getSubjectName() + "\n" + "专业编号：" + this.getSubject().getSerialNumber() + "\n"
				+ "学制：" + this.getSubject().getDuration() + "年制";
		return introString;
	}

}
