package com.reid.runnable;

/**
 * @packageName: com.reid.demo01
 * @className: TestThread
 * @description:
 * @author: ruibol
 * @createDate: 2021/4/20 22:32
 * @version: 1.0
 */
public class TestThread implements Runnable {
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("turtle")){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + " runs: " + i + "steps");
        }
    }

    public boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("Winner is : " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        new Thread(testThread, "rabbit").start();
        new Thread(testThread, "turtle").start();
    }
}
