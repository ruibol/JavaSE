package com.reid.lambda;

/**
 * @author: ruibol
 * @packageName: com.reid.lambda
 * @className: TestLambda01
 * @createDate: 2021/4/22 16:01
 * @version: 1.0
 * @description: 推导lambda表达式
 */
public class TestLambda01 {
    //4.把实现类放入静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    //3.main()
    public static void main(String[] args) {
        //用接口创建接口对象，然后new一个实现类
        ILike like = new Like();
        //调用方法
        like.lambda();

        like = new Like2();
        like.lambda();

        //5.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        like = new Like3();
        like.lambda();

        //6.匿名内部类，直接new一个接口。没有类的名称，必须借助接口或父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        //7.用lambda简化
        like = () -> {
            System.out.println("I like lambda5");
        };
        like.lambda();
    }
}

//1.定义一个函数式接口
interface ILike{
    void lambda();
}

//2.实现类：用类实现接口
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}