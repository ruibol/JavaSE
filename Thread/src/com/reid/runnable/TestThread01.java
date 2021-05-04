package com.reid.runnable;

/**
 * @packageName: com.reid.demo01
 * @className: TestThread01
 * @description: 创建线程方式一：继承Thread类，重写run()，调用start开启线程
 * @author: ruibol
 * @createDate: 2021/4/20 14:48
 * @version: 1.0
 */

//总结：线程开启不一定立即执行，由CPU调度执行。调用start()开启线程，main()和run()交替执行。一个CPU同一时间只能做一件事情。
public class TestThread01 extends Thread {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("This is run thread--" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        //创建一个线程对象
        TestThread01 testThread01 = new TestThread01();
        //调用start()开启线程，main()和run()交替执行。一个CPU同一时间只能做一件事情
        testThread01.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("This is main thread--" + i);
        }
    }
}
