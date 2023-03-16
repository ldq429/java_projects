package com.imooc.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 创建方式2：使用继承Runnable接口实现重写run方法，此时没有this，可以使用Thread.currentThread().getName()来获取名称
 * 把继承Runnable的class传递给创建线程作为参数 new Thread(继承Runnable接口的类)
 * t.start();启动线程
 */
public class ThreadSample3 {
    class Runner implements Callable<Integer> {
        public String name;
        @Override
        public Integer call() throws Exception {
            Integer s = new Random().nextInt(100);
            Integer res = 0;
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(this.name+ " 速度为 " + s + " m/s" + "当前距离为 " + s * i + " m");
//                System.out.println(Thread.currentThread().getName() + " 速度为 " + s + " m/s" + "当前距离为 " + s * i + " m");
                res = s * i;
            }
            return res;
        }
    }

    public void start() throws ExecutionException, InterruptedException {
//        创建3个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        实例化线程
        Runner r1 = new Runner();
        Runner r2 = new Runner();
        Runner r3 = new Runner();
        r1.name = "参赛者Q";
        r2.name = "参赛者W";
        r3.name = "参赛者E";
//        线程放进线程池

        Future<Integer> run1 = executorService.submit(r1);
        Future<Integer> run2 = executorService.submit(r2);
        Future<Integer> run3 = executorService.submit(r3);

        executorService.shutdown();
//        在关闭线程池后在进行获取结果才是最终结果
        System.out.println("r1结果为：" + run1.get());
        System.out.println("r2结果为：" + run2.get());
        System.out.println("r3结果为：" + run3.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadSample3 t = new ThreadSample3();
        t.start();

    }
}
