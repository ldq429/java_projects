package com.imooc.thread;

import java.util.Random;

/**
 * 创建方式2：使用继承Runnable接口实现重写run方法，此时没有this，可以使用Thread.currentThread().getName()来获取名称
 * 把继承Runnable的class传递给创建线程作为参数 new Thread(继承Runnable接口的类)
 * t.start();启动线程
 */
public class ThreadSample2 {
    class Runner implements Runnable {

        @Override
        public void run() {
            Integer s = new Random().nextInt(100);
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " 速度为 " + s + " m/s" + "当前距离为 " + s * i + " m");
            }
        }
    }

    public void start() {
        Runner r1 = new Runner();
        Runner r2 = new Runner();
        Runner r3 = new Runner();

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        Thread thread3 = new Thread(r3);
        thread1.setName("线程 1");
        thread2.setName("线程 2");
        thread3.setName("线程 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) {
        ThreadSample2 t = new ThreadSample2();
        t.start();

    }
}
