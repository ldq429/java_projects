package com.imooc.methods;

public class MethodOverload {
	/**
	 * 方法重载, 构造函数也是可以方法重载的，不写构造函数 默认为无参构造函数，编写有参构造函数后，会覆盖无参构造函数，那么如果两个都想要，可以私用方法重载.
	 */
	public int add(int a, int b) {
		return a + b;
	}

	public float add(float a, float b) {
		return a + b;
	}

	public double add(double[] d) {
		double sum = 0;
		for (double e : d) {
			sum += e;
		}
		return sum;
	}
}
