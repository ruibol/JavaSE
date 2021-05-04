package com.reid.runnable;

/**
 * @packageName: com.reid.demo01
 * @className: TestThread03
 * @description: 创建线程方式2，实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，再调用start
 * @author: ruibol
 * @createDate: 2021/4/20 15:48
 * @version: 1.0
 */
public class TestThread03 implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("This is run thread--" + i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        TestThread03 testThread03 = new TestThread03();
        //创建线程对象，通过线程对象来开启线程（代理）
        //Thread thread = new Thread(testThread03);
        //thread.start();
        new Thread(testThread03).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("This is main thread--" + i);
        }
    }
}
