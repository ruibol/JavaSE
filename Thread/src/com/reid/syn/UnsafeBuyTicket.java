package com.reid.syn;

/**
 * @author: ruibol
 * @packageName: com.reid.syn
 * @className: UnsafeBuyTicket
 * @createDate: 2021/5/4 19:22
 * @version: 1.0
 * @description: 并发：多个线程操作同一个对象
 * 每个线程都在自己的工作内存交互，内存控制不当会造成数据不一致，如出现负数
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "Jerry").start();
        new Thread(station, "Tom").start();
        new Thread(station, "Marry").start();
    }
}

class BuyTicket implements Runnable {
    //票数，为了安全加private
    private int ticketNums = 10;
    boolean flag = true;    //外部停止方式

    @Override
    public void run() {
        //买票
        while (flag) {
            buy();
        }
    }

    //synchronized 同步方法，实现锁。锁的是this（该方法所在的类的对象）
    // 只读代码安全不需要，只有修改的时候需要锁确保安全性，但牺牲效率
    private synchronized void buy() {
        //判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        //模拟延时，放大问题的发生性
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //买票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}