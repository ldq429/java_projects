package com.example.demo.controller.daqing.lu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.example.demo.controller.daqing.lu.*;


@RestController
@RequestMapping("/hello")
public class HelloWorld {
    /**
     * 相除
     *
     * @param doubleValA
     * @param doubleValB
     * @param scale      除不尽时指定精度
     * @return
     */
    public static double div(String doubleValA, String doubleValB, int scale) {
        BigDecimal a2 = new BigDecimal(doubleValA);
        BigDecimal b2 = new BigDecimal(doubleValB);
        return a2.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public byte[] toGBK(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");
    }

    @RequestMapping("/world")
    public List<Student> helloWorld() throws UnsupportedEncodingException {

        double[] a = {0.1, 1 - 0.9};
//        return div(String.valueOf(a[0]), String.valueOf(a[1]), 12) + "";
        boolean res = false;
//        if (a[1] - 0.1 < 0.00001) {
//            res = true;
//        }
        String s1 = null;
        String s2 = "123";
        if (s1 != null && s1.equals(s2)) res = true;

        String fruit = "pear";
        int resStr = switch (fruit) {
            case "apple" -> 1;
            case "pear", "mango" -> 2;
            default -> 0;
        };
//        return (resStr) + "";

        byte[] bs = this.toGBK("中文");

        Integer[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        Arrays.sort(ns, Collections.reverseOrder());
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        t1.start();
        t2.start();
        try {
            t1.interrupt();
            t2.interrupt();
            Thread.sleep(1);
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        return Arrays.toString(s);
        Student ming = new Student("小张", 18, 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        ming.date = dtf.format(LocalDateTime.now());

        Map<String, Student> m = new HashMap<>();
        m.put("m1", ming);
        m.put("m2", ming);
        List<Student> ls = List.of(m.get("m1"), m.get("m2"));
        System.out.println("主线程结束...");
        return ls;
    }
}

