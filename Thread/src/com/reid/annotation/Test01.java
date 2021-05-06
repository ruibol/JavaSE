package com.reid.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ruibol
 * @packageName: com.reid.annotation
 * @className: Test01
 * @createDate: 2021/5/6 10:04
 * @version: 1.0
 * @description: 三个内置注解
 */
@SuppressWarnings("all")
public class Test01 extends Object{
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    //镇压警告
    @SuppressWarnings("all")
    public void test02(){
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
