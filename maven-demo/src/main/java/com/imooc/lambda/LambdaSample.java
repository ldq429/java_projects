package com.imooc.lambda;

public class LambdaSample {
    public static void main(String[] args) {
        // (double a, double b) -> a + b 此部分是重写operator方法的视线
        IMathOperation operationAdd = (a,  b) -> a + b;
        System.out.println(operationAdd.operator(10, 20));
    }
}
