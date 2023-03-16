package com.imooc.methods;

public class Method {
	/**
	 * 根据传入价格获取折扣后价格
	 * 
	 * @param price
	 * @return
	 */
	public float queryDiscountByPrice(float price) {
		if (price < 100)
			return price;
		return price >= 199 ? price * 0.85f : price * 0.95f;
	}

	public static void main(String[] args) {
		Method method = new Method();
		float price = 1000f;
		float getPrice = method.queryDiscountByPrice(price);
		System.out.println("折后商品价格为：" + getPrice);
		System.out.println("以下为构造方法的测试：");
		System.out.println();
		var constructionMethod = new ConstructionMethod("小李", 33);
		System.out.println(constructionMethod.getName());

		System.out.println("以下为方法重载的测试：");
		System.out.println();
		var methodOverload = new MethodOverload();
		double[] d = { 10d, 20d, 35d, 101.2d };
		double n1 = methodOverload.add(d);
		float n2 = methodOverload.add(10.1f, 20.5f);
		int n3 = methodOverload.add(10, 20);
		System.out.println("n1的值为: " + n1);
		System.out.println("n2的值为: " + n2);
		System.out.println("n3的值为: " + n3);
		
		// 可变参数
		var variableParams = new VariableParams();
		int sum = variableParams.add(1,2,3,4,5);
		System.out.println(sum);
	}

}
