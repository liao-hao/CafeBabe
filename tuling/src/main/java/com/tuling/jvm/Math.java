package com.tuling.jvm;

public class Math {

    public static int initData = 66;
    public static User user = new User();

    public int compute() { // 一个方法对应一块栈针内存空间
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }

}
