package com.imooc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SyncSample {

    public class Printor {
        Object lock = new Object();

        //        public void print() throws InterruptedException {
//            synchronized (lock) {
//                System.out.print("魑");
//                Thread.sleep(500);
//                System.out.print("魅");
//                Thread.sleep(500);
//                System.out.print("魍");
//                Thread.sleep(500);
//                System.out.print("魉");
//                System.out.println();
//            }
//        }


//        相当于对this进行加锁
        public synchronized void print() throws InterruptedException {
            System.out.print("魑");
            Thread.sleep(500);
            System.out.print("魅");
            Thread.sleep(500);
            System.out.print("魍");
            Thread.sleep(500);
            System.out.print("魉");
            System.out.println();
        }


        //        相当于对Printor.getClass()进行加锁
//        public static synchronized void print() throws InterruptedException {
//            System.out.print("魑");
//            Thread.sleep(500);
//            System.out.print("魅");
//            Thread.sleep(500);
//            System.out.print("魍");
//            Thread.sleep(500);
//            System.out.print("魉");
//            System.out.println();
//        }
    }


    public void start() throws ExecutionException, InterruptedException {
//        争抢同一个对象才有同步锁来保证顺序执行
        Printor printor = new Printor();
        class Task implements Callable<Integer> {
            @Override
            public Integer call() throws Exception {
                printor.print();
                return 1;
            }
        }
        List<Future<Integer>> res = new ArrayList();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Task task = new Task();
            Future<Integer> r = executorService.submit(task);
            res.add(r);
        }
        executorService.shutdown();
        for (Future<Integer> r : res) {
            System.out.println(r.get());
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SyncSample syncSample = new SyncSample();
        syncSample.start();
    }
}
