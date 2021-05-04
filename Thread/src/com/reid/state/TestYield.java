package com.reid.state;

/**
 * @author: ruibol
 * @packageName: com.reid.state
 * @className: TestYield
 * @createDate: 2021/4/27 11:00
 * @version: 1.0
 * @description: 测试礼让线程（礼让不一定成功，看CPU心情）
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }
}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" --> START");
        Thread.yield(); //礼让
        System.out.println(Thread.currentThread().getName()+" --> END");
    }
}