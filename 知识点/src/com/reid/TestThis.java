package com.reid;

public class TestThis {

    public static void main(String[] args) {
        /**
        * new一个子类对象
        * 我们知道，子类对象实例化时，会隐式调用父类的无参构造
        * 所以Father()里的System.out.println()会执行
        * 猜猜打印的内容是什么？
        */
        Son son = new Son();

        Daughter daughter = new Daughter();
    }
}

class Father {
    /**
     * 父类构造器
     */
    public Father() {
        //打印当前对象所属class的名字
        System.out.println(this.getClass().getName());
    }
}

class Son extends Father {
    /**
     * 以下代码为Java自动隐藏的代码，可以不写
     * 隐式调用
     */
    public Son() {
        //显示调用父类的无参构造器Father()
        super();
    }
}

class Daughter extends Father {
}