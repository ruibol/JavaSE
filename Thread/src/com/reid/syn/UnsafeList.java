package com.reid.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ruibol
 * @packageName: com.reid.syn
 * @className: UnsafeList
 * @createDate: 2021/5/5 1:01
 * @version: 1.0
 * @description: 线程不安全的集合
 */
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //锁不安全的、需要增删改的对象
                //把list锁住线程就安全了
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
