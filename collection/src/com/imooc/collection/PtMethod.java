package com.imooc.collection;


import java.util.ArrayList;
import java.util.List;

public class PtMethod {
    public static void main(String[] args) {
        Integer[] numArray = new Integer[]{1, 2, 3};
        PtMethod pt = new PtMethod();
        List<Integer> list = pt.arrayConversionColl(numArray);
        System.out.println(list);
    }

    public <T> List<T> arrayConversionColl(T[] array) {
        List<T> list = new ArrayList();
        for (T item : array) list.add(item);
        return list;
    }

}
