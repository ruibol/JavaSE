package com.reid.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: ruibol
 * @packageName: com.reid.annotation
 * @className: Test03
 * @createDate: 2021/5/6 13:29
 * @version: 1.0
 * @description: 自定义注解
 */
public class Test03 {
    //定义了注解的参数String name(); 所以要写name = "reid"
    //有默认值default "" 的话就不用写
    //参数没有顺序要求
    @MyAnnotation2(age = 25)
    public void test() {}

    //参数是value就可以省略 value="reid" --> "reid"
    @MyAnnotation3("reid")
    public void test2() {}
}

//定义好元注解：目标、定义域
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    //注解的参数：参数类型+参数名();
    String name() default "";

    int age() default 0;

    int id() default -1;    // -1代表不存在。（indexof如果找不到就返回-1）

    String[] schools() default {"monash", "utas"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    //如果只有一个参数，建议用value命名
    String value();
}