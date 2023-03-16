package com.example.demo.controller.daqing.lu;

class Person implements Person1 {
    protected String name = "默认名字";
    public int age;

    public Person() {

    }

    public Person(String name) {
        this.setName(name);
    }


    /**
     * 由于构造方法是如此特殊，所以构造方法的名称就是类名。构造方法的参数没有限制，在方法内部，也可以编写任意语句。但是，和普通方法相比，构造方法没有返回值（也没有void），调用构造方法，必须用new操作符。
     *
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.setName(name);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 10) {
            this.name = name;
        }
    }

    @Override
    public void run() {
//        ...
    }

    @Override
    public String getName1() {
        return this.getName();
    }
}
