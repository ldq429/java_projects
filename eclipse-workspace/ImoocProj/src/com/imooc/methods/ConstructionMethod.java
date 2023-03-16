package com.imooc.methods;

/**
 * 构造方法： 在class被调用new时执行的方法，一般用于初始化内部变量的值
 * public class名(){ ... } 
 * 该方法无需写返回值
 * @author daqing.lu
 */
public class ConstructionMethod {
	private String name;
	private int age;

	public ConstructionMethod(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
