package com.imooc.thread;

import java.util.Random;

/**
 * 创建方式1：继承Thread类重写run方法进而实现创建，其中 在run方法中的this指代当前线程，this.getName(),获取当前线程名称
 */
public class ThreadSample1 {

    class Runner extends Thread{
        @Override
        public void run() {
            Integer s = new Random().nextInt(100);
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(this.getName() + " 速度为 " + s + " m/s" + "当前距离为 " + s * i +" m");
            }
        }
    }
    public void start(){
        Runner r1 = new Runner();
        Runner r2 = new Runner();
        Runner r3 = new Runner();

        r1.setName("线程 1");
        r2.setName("线程 2");
        r3.setName("线程 3");

        r1.start();
        r2.start();
        r3.start();
    }
    public static void main(String[] args) {
        ThreadSample1 t = new ThreadSample1();
        t.start();

    }
}
