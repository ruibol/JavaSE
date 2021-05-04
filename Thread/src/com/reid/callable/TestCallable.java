package com.reid.callable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author: ruibol
 * @packageName: com.reid.demo02
 * @className: TestCallable
 * @createDate: 2021/4/22 13:41
 * @version: 1.0
 * @description:
 */
//callable好处：1.可以定义返回值 2.可以抛出异常
public class TestCallable implements Callable<Boolean> {
    private String url; //img url
    private String name; //save file name

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println(name + " is downloaded");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://img-home.csdnimg.cn/images/20210420015453.png", "1.jpg");
        TestCallable t2 = new TestCallable("https://img-home.csdnimg.cn/images/20210420093345.png", "2.jpg");
        TestCallable t3 = new TestCallable("https://img-home.csdnimg.cn/images/20210420092757.png", "3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        ser.shutdownNow();
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
