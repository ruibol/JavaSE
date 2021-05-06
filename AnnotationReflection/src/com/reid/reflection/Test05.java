package com.reid.reflection;

/**
 * @author: ruibol
 * @packageName: com.reid.reflection
 * @className: Test05
 * @createDate: 2021/5/6 22:21
 * @version: 1.0
 * @description: 类是怎么加载的
 */
public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}

class A {
    //静态代码块
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    //静态变量
    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}