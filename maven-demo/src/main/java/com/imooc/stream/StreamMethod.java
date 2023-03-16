package com.imooc.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethod {
    /*
     * 提取集合中所有偶数并求和
     * */
    @Test
    public void case1() {
        List<String> list = Arrays.asList("1", "2", "3", "4");
        Integer sum = list.stream()
                .mapToInt(n -> Integer.parseInt(n))
                .filter(n -> n % 2 == 0).sum();
        System.out.println(sum);
    }

    /**
     * 所有英文名字首字母大写
     */
    @Test
    public void case2() {
        List<String> list = Arrays.asList("lily", "smith", "jackson");
        List<String> newList = list.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.toList());
        System.out.println(newList);
    }

    /**
     * 所有奇数从大到小排序不可重复
     */
    @Test
    public void case3() {
        List<Integer> list = Arrays.asList(1, 2, 5, 8, 4, 8, 4, 8, 4, 1, 5, 4, 15, 12, 15);
        List<Integer> newList = list.stream()
                .distinct() //去重重复的数据流
                .filter(n -> n % 2 == 1)
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
        System.out.println(newList);
    }

}
