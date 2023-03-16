package com.example.demo.controller.daqing.lu;

class Student extends Person {
    public int gender;
    public String date;

    public Student() {
    }

    public Student(int gender) {
        super();
        this.gender = gender;
    }

    public Student(String name, int gender) {
        super(name);
        this.gender = gender;
    }

    public Student(String name, int age, int gender) {
        super(name, age);
        this.gender = gender;
    }

}
