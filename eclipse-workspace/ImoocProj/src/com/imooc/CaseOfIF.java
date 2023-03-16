package com.imooc;

import java.util.Scanner;

//import java.util.Scanner;

public class CaseOfIF {

	public static void main(String[] args) {

		// 猜数字游戏
		System.out.print("请输入一个 0-10 之间的数字：");
		int target = 5;
		String reString;
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		int inNum = scanner.nextInt();

		while (flag) {
			if (target > inNum) {
				reString = "太小";
			} else if (target < inNum) {
				reString = "太大"; 
			} else {
				reString = "猜中了...";
				scanner.close();
				flag = false;
			}
			System.out.println(reString);
			if (flag == true)
				inNum = scanner.nextInt();

		}

	}

}
