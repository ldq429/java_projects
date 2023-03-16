package com.example.demo.controller.daqing.lu;

class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        this.print();
    }

    public void print() {
        while (!isInterrupted()) {
            synchronized (Counter.lock) {
                Counter.count++;
                System.out.println("1" + "              " + Counter.count);
            }
        }
    }
}
