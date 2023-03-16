package com.imooc.methods;

public class VariableParams {
	/**
	 * 1.如果是多个参数，那么可变参数需要最后一位，可变参数列表只能有一个，同数组处理; 2.可变参数优先级最低；
	 * @param n
	 * @return
	 */
	public int add(int... n) {
		int sum = 0;
		for (int i : n) {
			sum += i;
		}
		return sum;
	}
}
