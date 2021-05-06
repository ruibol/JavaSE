package com.reid.reflection;

/**
 * @author: ruibol
 * @packageName: com.reid.reflection
 * @className: Test03
 * @createDate: 2021/5/6 20:51
 * @version: 1.0
 * @description: 测试Class类的创建方式由哪些
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("This is " + person.name);

        //方式一：通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二：forname获得
        Class c2 = Class.forName("com.reid.reflection.Student");
        System.out.println(c2.hashCode());

        //方式三：通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
    }
}

class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "Student";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "Teacher";
    }
}