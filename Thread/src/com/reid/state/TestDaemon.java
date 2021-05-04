package com.reid.state;

/**
 * @author: ruibol
 * @packageName: com.reid.state
 * @className: TestDaemon
 * @createDate: 2021/5/4 19:11
 * @version: 1.0
 * @description: 虚拟机必须确保用户线程执行完毕，
 * 不用等待守护线程执行完毕（如后台记录操作日志、监控内存、垃圾回收）
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        //需要thread对象时就需要new一个对象
        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认false表示用户线程，true表示守护线程

        thread.start(); //god daemon thread start

        new Thread(you).start();    //you client thread start
    }
}

//god
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("God bless you");
        }
    }
}

//you
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("Happy live");
        }
        System.out.println("=====goodbye! world=====");
    }
}