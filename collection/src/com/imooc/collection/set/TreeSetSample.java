package com.imooc.collection.set;

import java.util.*;

public class TreeSetSample {

    class ComparableSort implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public void sort() {

        Set<Integer> set = new TreeSet(new ComparableSort());
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(3);
        System.out.println(set);
    }

    public static Integer random() {
        return  new Random().nextInt(2);
    }

    public static void main(String[] args) {
        new TreeSetSample().sort();
        for (int i = 0; i < 10; i++) {
            System.out.println(random());
        }

    }
}
