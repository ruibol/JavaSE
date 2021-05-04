package com.reid.runnable;

/**
 * @author: ruibol
 * @packageName: com.reid.demo01
 * @className: Race01
 * @createDate: 2021/4/21 14:07
 * @version: 1.0
 * @description:
 */
public class Race01 implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " --> 走了" + i + "步");
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        }
        {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("Winner is: " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race01 race01 = new Race01();
        new Thread(race01, "Rabbit").start();
        new Thread(race01, "Turtle").start();
    }
}
