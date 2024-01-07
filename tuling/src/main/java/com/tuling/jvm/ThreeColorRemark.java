package com.tuling.jvm;

/**
 * 垃圾收集算法细节之三色标记
 * 为了简化例子，代码写法可能不规范，请忽略
 * Created by 诸葛老师
 */
public class ThreeColorRemark {

    public static void main(String[] args) {
        A a = new A();
        //开始做并发标记
        D d = a.b.d;   // 1.读
        a.b.d = null;  // 2.写
        a.d = d;       // 3.写
    }
}
class C {
}

class D {
}