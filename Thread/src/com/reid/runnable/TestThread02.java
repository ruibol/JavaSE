package com.reid.runnable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @packageName: com.reid.demo01
 * @className: TestThread2
 * @description: 练习Thread，实现多线程同步下载图片
 * @author: ruibol
 * @createDate: 2021/4/20 15:07
 * @version: 1.0
 */

//总结：三张图片并非按顺序下载
//继承Thread变成线程类
public class TestThread02 implements Runnable {
    private String url; //img url
    private String name; //save file name

    public TestThread02(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println(name + " is downloaded");
    }

    public static void main(String[] args) {
        TestThread02 t1 = new TestThread02("https://img-home.csdnimg.cn/images/20210420015453.png", "1.jpg");
        TestThread02 t2 = new TestThread02("https://img-home.csdnimg.cn/images/20210420093345.png", "2.jpg");
        TestThread02 t3 = new TestThread02("https://img-home.csdnimg.cn/images/20210420092757.png", "3.jpg");

        //启动三条线程
//        t1.start();
//        t2.start();
//        t3.start();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

//下载器
class WebDownloader {
    //下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException, downloader method error");
        }
    }
}