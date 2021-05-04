package com.reid.syn;

/**
 * @author: ruibol
 * @packageName: com.reid.syn
 * @className: UnsafeBank
 * @createDate: 2021/5/5 0:06
 * @version: 1.0
 * @description: 两个人去取钱，账户
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");
        //两条线程取钱
        Drawing you = new Drawing(account, 50, "你");
        Drawing girlfriend = new Drawing(account, 100, "女朋友");

        you.start();
        girlfriend.start();
    }
}

//账户
class Account {
    int money;  //remaining money
    String name;    //card name

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
//不涉及多个线程操作同一个对象，所以继承Thread
class Drawing extends Thread {
    Account account;
    int drawingMoney;   //取了多少钱
    int nowMoney;   //现在手里多少钱

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);    //传入线程名
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    @Override
    public void run() {
        //判断有没有钱
        if (account.money - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
            return;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //余额
        account.money -= drawingMoney;
        //手里的钱
        nowMoney += drawingMoney;

        System.out.println(account.name + "余额为：" + account.money);
        //Thread.currentThread().getName() = this.getName()
        System.out.println(this.getName() + "手里的钱：" + nowMoney);
    }
}