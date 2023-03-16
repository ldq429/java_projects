package com.imooc.animal;

public class Animal {
	private String name;
	private int age;
	static {
		System.out.println("《Animal》 Static {} ...");
	}
	{
		System.out.println("《Animal》 {} ...");
	}
	public Animal() {
	};

	public Animal(String name, int age) {
		setName(name);
		setAge(age);
		System.out.println("《Animal》 Cat(){}...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
