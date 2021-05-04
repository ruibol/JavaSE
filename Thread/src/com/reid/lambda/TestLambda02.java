package com.reid.lambda;

/**
 * @author: ruibol
 * @packageName: com.reid.lambda
 * @className: TestLambda02
 * @createDate: 2021/4/22 16:34
 * @version: 1.0
 * @description:
 */
public class TestLambda02 {

    public static void main(String[] args) {

        ILove love = null;

//        ILove love = (int a) -> {
//            System.out.println("I love you -->" + a);
//        };
//
//        //1.简化参数类型
//        love = (a) -> {
//            System.out.println("I love you -->" + a);
//        };
//
//        //2.简化括号
//        love = a -> {
//            System.out.println("I love you -->" + a);
//        };

        //3.简化花括号
        love = a -> System.out.println("I love -->" + a);

        //总结：
            //lambda表达式 只有一行代码的时候可以简化成一行，否则只能简化到代码块
            //前提式函数式接口
        //多个参数也可以去掉参数类型，但是要加括号

        love.love(521);
    }
}

interface ILove {
    void love(int a);
}