package com.etoak.java;

/*
    Java中的最简单的设计模式：
        单例模式！
        这个世界上本来没有设计模式，写的人多了，就变成了一种设计模式
 */
public class TestSingleInstance {
    public static void main(String[] args){
        Student stu1 = Student.getOnly();
        Student stu2 = Student.getOnly();
        System.out.println(stu1 == stu2);
    }
}
// 饿汉式 early create
class Student{
    // 1.私有化构造方法
    private Student(){

    }
    private static Student only = new Student();

    public static Student getOnly(){
        return only;
    }
}

// 懒汉式 lazy create
class Teacher{
    // 1.私有化构造方法
    private Teacher(){}
    // 2.创建对象
    private static Teacher only = null;

    public static Teacher getOnly(){
        if(only == null){
            return new Teacher();
        }else{
            return only;
        }
    }
}
