package com.imooc.lambda;

import java.util.function.Consumer;

public class ConsumerSample {
    public static void main(String[] args) {
//        System.out.println(consumer) 是对其处理，比如打印到控制台，或者通过网络发送等等，需要进一步根据需求实现
        output(consumer -> System.out.println(consumer));
    }

    public static void output(Consumer<String> consumer) {
        String s = "天将降大任于斯人也，必先苦其心志劳其筋骨饿其体肤空乏其身，行拂乱其所为！";
        consumer.accept(s);
    }
}
