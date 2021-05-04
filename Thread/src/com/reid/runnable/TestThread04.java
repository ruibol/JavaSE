package com.reid.runnable;

/**
 * @packageName: com.reid.demo01
 * @className: TestThread04
 * @description: 多个线程同时操作同一个对象：买火车票
 * @author: ruibol
 * @createDate: 2021/4/20 16:09
 * @version: 1.0
 */

//发现问题：多个线程操作同一个资源时，线程不安全，数据紊乱
public class TestThread04 implements Runnable {
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                //模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //ticketNums--：每拿到一张票就--，ticketNums减少1
            System.out.println(Thread.currentThread().getName() + " --> got ticket: " + ticketNums--);
        }
    }

    public static void main(String[] args) {
        TestThread04 ticket = new TestThread04();
        //给线程起名字
        new Thread(ticket, "Tom").start();
        new Thread(ticket, "Jerry").start();
        new Thread(ticket, "Marry").start();
    }
}
