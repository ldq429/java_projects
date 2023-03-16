package com.imooc.reflect.entity;

public class Employee {
    private Integer eno;
    public String ename;
    private String dname;

    {
        System.out.println("普通代码块执行了..");
    }

    public Employee() {
        System.out.println("default构造方法执行了..");
    }

    public Employee(Integer eno, String ename, String dname) {
        this.setEno(eno);
        this.setEname(ename);
        this.setDname(dname);
        System.out.println("带参构造方法执行了...");
    }


    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Employee updateEName(String ename){
        this.setEname(ename);
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }
}
