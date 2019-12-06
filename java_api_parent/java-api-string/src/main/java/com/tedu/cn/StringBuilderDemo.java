package com.tedu.cn;

import org.junit.Test;
public class StringBuilderDemo {
    @Test
    public void m1(){
        //相当于一个容器，append可以添加任意东西
        StringBuilder b=new StringBuilder();
        b.append("湖人总冠军 ");
        b.append(666666);
        System.out.println(b.toString());
    }

}
