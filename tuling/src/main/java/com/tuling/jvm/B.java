package com.tuling.jvm;

class B {
    static {
        System.out.println("*************load B************");
    }
    C c = new C();
    D d = new D();
    public B() {
        System.out.println("*************initial B************");
    }
}
