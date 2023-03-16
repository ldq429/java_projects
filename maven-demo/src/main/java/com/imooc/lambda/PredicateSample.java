package com.imooc.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateSample {
    public static void main(String[] args) {
        Predicate<Integer> predicate = a -> a > 4;
        System.out.println(predicate.test(5));
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        filter(list, a -> a > 4);
        filter(list, a -> a % 2 == 1);
        filter(list, a -> a % 2 == 1 && a > 5);
    }

    public static void filter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) System.out.print(n + " ");
        }
        System.out.println();
    }
}
