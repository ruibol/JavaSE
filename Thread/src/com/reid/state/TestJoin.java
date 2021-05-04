package com.reid.state;

/**
 * @author: ruibol
 * @packageName: com.reid.state
 * @className: TestJoin
 * @createDate: 2021/4/27 11:56
 * @version: 1.0
 * @description: Join 插队
 */
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("VIP is here"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        //thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if (i==200){
                thread.start();
                thread.join();
            }
            System.out.println("Main"+i);
        }
    }
}
