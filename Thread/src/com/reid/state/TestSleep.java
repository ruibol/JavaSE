package com.reid.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: ruibol
 * @packageName: com.reid.state
 * @className: TestSleep
 * @createDate: 2021/4/26 22:29
 * @version: 1.0
 * @description: 模拟倒计时
 */
public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        Date time = new Date(System.currentTimeMillis());   //get time
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(time));
            time = new Date(System.currentTimeMillis());    //update time
        }
    }
}
