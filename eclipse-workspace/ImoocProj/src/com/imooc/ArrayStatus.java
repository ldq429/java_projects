package com.imooc;

import java.util.Iterator;

public class ArrayStatus {

	public static void main(String[] args) {
		// 数组的创建
		/**
		 * 格式一： 类型[] 数组名称 = new 类型[length]; long[] arrLong = new long[10];
		 * 
		 * 格式二： 数组初始化 类型[] 名称 = {,,};
		 * 
		 * 
		 */
		// 冒泡排序
		int[] arrInt = { 11, 2, 17, 4, 5, 1 };
		for (int i = 0; i < arrInt.length; i++) {
			for (int j = i; j < arrInt.length - 1; j++) {
				if (arrInt[i] < arrInt[j + 1]) {
					int temp = arrInt[i];
					arrInt[i] = arrInt[j + 1];
					arrInt[j + 1] = temp;
				}
			}
		}
		for (int i : arrInt) {
			System.out.print(i + "  ");
		}
		System.out.println();
		/**
		 * 二维数组创建 行数为必填项
		 */
		int[][] arr2 = new int[3][5];
		int[][] arr1 = new int[3][];
		
		/**
		 * 二维数组创建后并初始化
		 */
		int[][] arr = { { 1, 2, 3 }, { 1, 2, 3, 4 }, { 1, 2 } };
		
		for (int i = 0; i < arr.length; i++) {
			for (int is : arr[i]) {
				System.out.print(is + " ");
			}
			System.out.println();
		}

	}

}
