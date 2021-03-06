package com.reid.state;

/**
 * @author: ruibol
 * @packageName: com.reid.state
 * @className: TestStop
 * @createDate: 2021/4/22 17:10
 * @version: 1.0
 * @description: 停止线程
 */

//1.建议线程正常停止：利用次数，不建议死循环
//2.标志位
public class TestStop implements Runnable {
    //1.设置标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("Run...Thread" + i++);
        }
    }

    //2.设置一个公开的方法停止线程，转换标志位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900) {
                testStop.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
