package com.reid.simpleJunit;

/**
 * 2、使用注解
 *
 * 和平时使用Junit测试时一样
 */
public class EmployeeDAOTest {
    @MyBefore
    public void init(){
        System.out.println("初始化...");
    }

    @MyAfter
    public void destroy(){
        System.out.println("销毁...");
    }

    @MyTest
    public void testSave(){
        System.out.println("save...");
    }

    @MyTest
    public void testDelete(){
        System.out.println("delete...");
    }
}
