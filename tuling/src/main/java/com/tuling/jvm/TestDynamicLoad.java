package com.tuling.jvm;

/**
 * 动态加载
 */
public class TestDynamicLoad {

    static {
        System.out.println("*************load TestDynamicLoad************");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("*************load test************");
        B b = null;  //B不会加载，除非这里执行 new B()
    }
}

