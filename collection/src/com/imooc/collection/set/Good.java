package com.imooc.collection.set;

public class Good {
    public String sn;
    public String name;

    public Good(String sn, String name) {
        this.name = name;
        this.sn = sn;
    }

    public Good() {
    }

    @Override
    public int hashCode() {
        System.out.println("hasCode方法执行了:" + this.sn.hashCode());
        return this.sn.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        System.out.println("super.equals(obj)的结果" + super.equals(obj));
//        return super.equals(obj);
        if (obj instanceof Good) {
            Good good = (Good) obj;
            System.out.println(this.name + "this.sn:" + this.sn);
            System.out.println(good.name + "good.sn:" + good.sn);
            System.out.println("this.sn.equals(good.sn)的结果" + this.sn.equals(good.sn));
            return this.sn.equals(good.sn);
        } else {
            return false;
        }
    }
}
