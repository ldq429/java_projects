package com.imooc.animal;

public class Cat extends Animal implements Eat {
	static {
		System.out.println("《Cat》 Static {} ...");
	}
	private String skill;

	public Cat() {
	}

	{
		System.out.println("《Cat》 {} ...");
	}

	public Cat(String name, int age, String skill) {
		super(name, age);
		setSkill(skill);
		System.out.println("《Cat》 Cat(){}...");
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	};

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		Cat tempObjCat = (Cat) obj;
		boolean nameSame, ageSame, skillSame;
		nameSame = this.getName().equals(tempObjCat.getName());
		ageSame = this.getAge() == tempObjCat.getAge();
		skillSame = this.getSkill().equals(tempObjCat.getSkill());
		return nameSame & ageSame & skillSame;
	}

	@Override
	public void eat(String food) {
		// TODO Auto-generated method stub
		Eat.super.eat(food);
		System.out.println("小猫爱吃" + food + "...");
	}

}
