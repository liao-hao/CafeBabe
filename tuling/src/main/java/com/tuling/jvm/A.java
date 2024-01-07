package com.tuling.jvm;

class A {
    static {
        System.out.println("*************load A************");
    }
    B b = new B();
    D d = null;
    public A() {
        System.out.println("*************initial A************");
    }
}
