package com.reid.syn;

/**
 * @author: ruibol
 * @packageName: com.reid.syn
 * @className: UnsafeBuyTicket
 * @createDate: 2021/5/4 19:22
 * @version: 1.0
 * @description: 并发：多个线程操作同一个对象
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

    private void buy() {
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