package com.reid.runnable;

/**
 * @packageName: com.reid.demo01
 * @className: Race
 * @description: 模拟龟兔赛跑
 * @author: ruibol
 * @createDate: 2021/4/20 16:23
 * @version: 1.0
 */
public class Race implements Runnable {
    //winner只有一个，是静态的，所有用static
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子休息：每走10步睡0.1秒
            if (Thread.currentThread().getName().equals("rabbit") && i % 10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag = gameOver(i);
            //如果比赛结束，停止程序
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " --> run " + i + "steps");
        }
    }

    //判断是否完成比赛
    private boolean gameOver(int steps) {
        //判断是否有胜利者
        if (winner != null) {
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("Winner is: " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "rabbit").start();
        new Thread(race, "turtle").start();
    }
}
