package com.reid.simpleJunit;

import java.awt.geom.AffineTransform;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 3、使用注解：通过反射机制读取注解并操作
 *
 * 平时使用Junit看不见的那部分，帮助我们执行标注了@Test的方法
 *
 * 来源：https://www.zhihu.com/question/24401191
 */
public class MyJunitFramework {
    public static void main(String[] args) throws Exception {
        //1、先找到测试类的字节码：EmployeeDAOTest
        Class clazz = EmployeeDAOTest.class;
        Object obj = clazz.newInstance();

        //2、获取EmployeeDAOTest类中的所有公共方法
        Method[] methods = clazz.getMethods();

        //3、迭代出每一个Method对象，判断哪些方法上使用了@MyBefore/@MyAfter/@MyTest注解
        List<Method> myBeforeList = new ArrayList<>();
        List<Method> myAfterList = new ArrayList<>();
        List<Method> myTestList = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyBefore.class)) {
                myBeforeList.add(method);
            } else if (method.isAnnotationPresent(MyTest.class)) {
                myTestList.add(method);
            } else if (method.isAnnotationPresent(MyAfter.class)) {
                myAfterList.add(method);
            }
        }

        //执行方法测试
        for (Method testMethod : myTestList) {
            //先执行标注了@MyBefore的方法
            for (Method beforeMethod : myBeforeList) {
                beforeMethod.invoke(obj);
            }
            //然后执行标注了@MyTest的测试方法
            testMethod.invoke(obj);
            //最后执行标注了@MyAfter的方法
            for (Method afterMethod : myAfterList) {
                afterMethod.invoke(obj);
            }
        }
    }
}
