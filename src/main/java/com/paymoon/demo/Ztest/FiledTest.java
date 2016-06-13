package com.paymoon.demo.Ztest;

import java.lang.reflect.Field;

public class FiledTest
{
    public static void main(String[] args) throws Exception
    {
        Field field=A.class.getDeclaredField("fild");
        int a= (Integer)field.get(new A()) ;
//        int c= (Integer)field.get(null) ; //不是静态字段不能传null
        System.out.println(a);

        Field staticfield=A.class.getDeclaredField("staticFild");
        int b= (Integer)staticfield.get("") ;
        int d= (Integer)staticfield.get(null) ;
        int e= (Integer)staticfield.get("staticFild") ;
        System.out.println(staticfield.getName()+b);
        System.out.println(d);
        System.out.println(e);
    }

}

class A {
     int fild=3;
    static int staticFild=4;
}
