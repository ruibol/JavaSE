package com.reid.annotation;

import java.lang.annotation.*;

/**
 * @author: ruibol
 * @packageName: com.reid.annotation
 * @className: Test02
 * @createDate: 2021/5/6 10:04
 * @version: 1.0
 * @description: 四个元注解 meta annotation
 */
@MyAnnotation
public class Test02 {
    @MyAnnotation
    public void test() {

    }
}

//用@interface自定义一个注解
//四个元注解，重点是Target和Retention，基本是必写
//Target 表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})
//Retention 表示我们的注解在什么地方有效
// runtime>class>sources 一般都用runtime
@Retention(value = RetentionPolicy.RUNTIME)
//Documented 表示是否将我们的注解生成在JAVAdoc中
@Documented
//Inherited 子类可以继承父类的注解
@Inherited
//interface 自定义注解
@interface MyAnnotation {

}