package com.imooc.test;

import com.imooc.model.Student;
import com.imooc.model.Subject;

public class Test {

	public static void main(String[] args) {
		Subject subject = new Subject("计算机科学与技术", 4, "N01");
		Student student1 = new Student("张三", 0, subject);
		Student student2 = new Student("李四", 0, subject);
		Student student3 = new Student("王五", 0, subject);
		
		System.out.println(student1.introduce()); 
		System.out.println(subject.info());
	}
}; 