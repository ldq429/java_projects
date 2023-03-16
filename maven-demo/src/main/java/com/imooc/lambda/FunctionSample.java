package com.imooc.lambda;

import java.util.Random;
import java.util.function.Function;

/**
 * 生成定长随机字符串
 */
public class FunctionSample {

    private static final String origin = "abcdefghijklmnopqrstuvwsyz0123456789";
    public static String getString(Integer length) {
        Function<Integer, String> stringFunction = (l) -> {
            StringBuffer stringBuffer = new StringBuffer();
            Random random = new Random();
            for (int i = 0; i < l; i++) {
                Integer index = random.nextInt(origin.length());
                stringBuffer.append(origin.charAt(index));
            }
            return stringBuffer.toString();
        };
        return stringFunction.apply(length);
    }

    public static void main(String[] args) {
        System.out.println(getString(16));
    }

}
