package com.imooc.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * stream流对象创建的五种方式
 */
public class StreamGenerator {
    //    1. 基于数组创建Stream
    @Test
    public void generator1() {
        String[] array = {"Lily", "Andy"};
        Stream<String> stream = Stream.of(array);
        stream.forEach(s -> System.out.println(s));
    }

    //    2.基于集合创建Stream
    @Test
    public void generator2() {
        List<String> l = new ArrayList<>();
        l.add("Lily");
        l.add("Andy");
        Stream<String> stream = l.stream();
        stream.forEach(s -> System.out.println(s));
    }
}
