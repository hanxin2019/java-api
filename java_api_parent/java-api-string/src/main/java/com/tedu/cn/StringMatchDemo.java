package com.tedu.cn;

import org.junit.Test;

import java.util.Scanner;

public class StringMatchDemo {
    @Test
    public void  m1(){
        String regex="[a-z]";//a-z之间任何一个字符
        System.out.println("a".matches(regex));//校验a是否匹配
        regex="[a-zA-Z0-9]";//a-z A-Z 0-9之间的任何一个字符
        System.out.println("0".matches(regex));//校验0是否匹配
        regex="[^(a-zA-Z0-9)]";// ^表示除开这些字符以外的字符
        System.out.println("—".matches(regex));
    }
    @Test
    public void  m2(){
        /**
         *   . 表示任意一个字符
         *   |d 表示任意一个数字字符  相当于 [0-9]
         *   \w 表示任意一个单词字符  相当于[a-zA-Z0-9]
         *   \s 表示任意一个空白字符
         *   \D 任意非数字字符
         *   \W  任意一个非单词字符
         *   \S  任意一个非空白字符
         */
        /**
         * 数量词：
         * X?  表示前面的X出现的次数0次或1次
         * X+  表示前面的X出现的次数1次或多次
         * X* 表示前面的X出现的次数0次或多次
         * X{n}  表示X出现n次
         * X{n,} 表示X至少出现n次
         * X{m,n} 表示X出现m到n之间次
         */
        String reg="\\d?";
        System.out.println("9".matches(reg));
        reg="\\d+";
        System.out.println("888".matches(reg));
        reg="\\d*";
        System.out.println("1".matches(reg));
        reg="\\d{8}";
        System.out.println("88888888".matches(reg));
        reg="\\d{3,}";
        System.out.println("8888".matches(reg));
        reg="\\d{3,8}";
        System.out.println("88888888".matches(reg));
    }

    public  void  m3(){
        //匹配手机号码
        String number="(\\+86)?\\s?\\d{11}";
        String phone="+86 13916888888";
        if(phone.matches(number)){
            System.out.println("验证成功");
        }else{
            System.out.println("验证失败");
        }

    }
}
