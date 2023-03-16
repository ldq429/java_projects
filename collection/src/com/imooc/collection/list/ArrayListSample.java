package com.imooc.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListSample {
    // psvm 自动生成
    public static void main(String[] args) {
        List<String> bookList = new ArrayList<String>();
        bookList.add("西游记"); // Ctrl + shift + 回车 补充当前末尾分号；
        bookList.add("三国演义");
        bookList.add("水浒传");
        bookList.add("红楼梦");
        System.out.println(bookList); // 快捷键 sout
        // remove 方法，返回值为被删除的项
        var res = bookList.remove(bookList.size() - 1);
        System.out.println("res的结果为：" + res);
        System.out.println(bookList);
        bookList.add(1, "红楼梦");
        System.out.println(bookList);
        bookList.set(0, "西游记后传");
        System.out.println(bookList);
//        bookList.get(10); // Ctrl + / 注释
        // 普通for循环来遍历ArrayList
        for (String book : bookList) {
            System.out.println(book);
        }
        // foreach + λ表达式
        bookList.forEach(book -> System.out.println(book));
        System.out.println("=====================迭代器效果");
        // 迭代器遍历
        Iterator<String> itr =  bookList.iterator();
        while(itr.hasNext()){
            String book = itr.next();
            System.out.println(book);
        }

        boolean isContains =  bookList.contains("水浒传");
        System.out.println(isContains);

    }
}
