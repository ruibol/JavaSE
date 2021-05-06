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

        /*
         1.加载到内存，会产生一个类对应Class对象
         2.链接，链接结束后m=0
         3.初始化
            <clinit>(){
                System.out.println("A类静态代码块初始化");
                m = 300;
                m = 100;
            }
            代码块合并所以m=100
         **/
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