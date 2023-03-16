package com.imooc.collection.set;

import com.sun.source.tree.UsesTree;

import java.util.HashSet;
import java.util.Set;

/**
 * Set 如何确保内部的唯一性？
 * 1. Set在调用add方法时候进行hasCode()的比对,如果hascode为true说明已经存在，那么则停止add天极爱，否则进入到第2步
 * 2. 为了防止极小概率的哈希碰撞，如果存在则执行equals()进行比较
 * 3. 在set.add(new Good("01","米1"))，会调用Good继承自Object的hasCode、equals方法，由于是引用数据类型不能确保引用类型的值是唯一的，所以需要重写 hasCode、equals方法
 *  重写hascode方法 return 唯一标识
 *  重写equals方法 ，首先进行 instanceOf进行判别对象类型，如果不属于则 return false
 *  如果符合那么需要区分this以及传递进来的obj，
 *  obj是之前的数据，this是当前数据，内部应该是轮询的方式与this的唯一属性标识进行equals对比的；
 */
public class HashSetSample {
    public static void main(String[] args) {
        Set<Good> set = new HashSet<Good>();
        set.add(new Good("01","米1"));
        set.add(new Good("01","米2"));
        set.add(new Good("03","米3"));
    }
}
