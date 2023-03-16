package com.imooc;

import java.util.Scanner;

public class HelloImooc {
	public static void main(String[] args) {
		// 定义一个整型变量n，并从键盘接收数据
	    int n = new Scanner(System.in).nextInt();
		//判断n是否同时能被5和7整除，如果满足条件输出yes，否则输出no
		String res = n % 5 == 0 && n % 7 == 0 ? "yes" : "no";
		System.out.print(res);
	}
}
