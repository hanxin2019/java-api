package com.tedu.cn;

import org.junit.Test;

public class PackageDemo {
    @Test
    public void m1(){
        //包装类
        int a=8;
        Integer b=a;
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toOctalString(a));
        System.out.println(Integer.toBinaryString(a));
    }
}
