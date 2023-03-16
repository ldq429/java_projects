package com.imooc.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.imooc.animal.Cat;

/**
 * 继承关系中，程序的顺序是这样的： 1. 首先加载类，从根部开始加载，加载过程中先对父类 对static成员进行赋值或者执行，进而在对子类进行 2.
 * 进行构造方法的执行，先对父类构造方法执行 在对子类构造方法执行
 * 
 * @author User
 *
 */
public class Test {

	public static void main(String[] args) {
		Cat cat = new Cat("大黑", 1, "吃东西，玩耍...");
		Cat cat1 = new Cat("大黑", 1, "吃东西，玩耍...");
		String str1 = "123";
		String str2 = "123";
		System.out.println(cat.equals(cat1));
		System.out.println(str1.equals(str2));
		cat.eat("肉");

		Scanner scanner = new Scanner(System.in);
		try {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			System.out.println("n1/n2的值为" + (n1 / n2));
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("输入异常...");
			e.printStackTrace();
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("出现算数异常...");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("程序结束...");
		}

	}

}
