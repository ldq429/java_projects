package com.imooc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool3 {

    public void start() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "—>" + finalI);
                }
            });
        }

        executorService.shutdown();
    }

    public static void main(String[] args) {
        new ThreadPool3().start();
    }
}
