package com.tedu.cn;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class StringApi {
    @Test
   public void testTrim(){
        String str1="    8888888    ";
        System.out.println(str1);
        str1=str1.trim();        //去掉左右两边的空格
        System.out.println(str1);
    }
    @Test
    public void testLetterCHG(){
        String str="i love you";
        str=str.toUpperCase();     //将字符转换为大写
        System.out.println(str);
        str=str.toLowerCase();
        System.out.println(str);    //将字符转换为小写
    }
    @Test
    public void testIndexOf(){
        String str="I love you";
        System.out.println(str.indexOf("o"));//找第一次出现的位置索引
        System.out.println(str.lastIndexOf("o"));//找最后一次出现的位置索引
        System.out.println(str.indexOf("m"));//没有找到该值就返回-1
    }
    @Test
    public void testContains(){
        String str="I LOVE YOU";
        System.out.println(str.contains("LOVE"));
        //查看字符是否含有相应字符，返回值是布尔类型
    }
    @Test
    public  void testConcat(){
        String str="I LOVE";
        str=str.concat(" YOU");//字符串的拼接
        System.out.println(str);
    }
    @Test
    public void testEndWith(){
        //测试字符串是否以某一后缀结尾，如果是返回TRUE，否则返回FALSE
        String str="i love you";
        System.out.println(str.endsWith("ou"));
    }
    @Test
    public void testStartWith(){
        //测试字符串是否以某一字符开头，如果是返回TRUE，否则返回FALSE
        String str="i love you";
        System.out.println(str.endsWith("i"));
    }
   @Test
    public void testEqualsAndIgnoreCase(){
        String str1="abc";
        String str2="abc";
        String str3="ABC";
        System.out.println(str1.equals(str2));//比较内容是否相等
        System.out.println(str1.equalsIgnoreCase(str3));//忽略大小写再比较内容
   }
   @Test
    public void testGetBytes() throws UnsupportedEncodingException {
        //将给定字符转换为byte数组
        byte[] b="i love you".getBytes(StandardCharsets.UTF_8);
       System.out.println(b);
       for(int i=0;i<b.length;i++){
           System.out.println(b[i]);
       }
   }
   @Test
    public void testSubString(){
        //取字符切片
        String str="i love you";
       System.out.println(str.substring(2,6));//含头不含尾
       System.out.println(str.substring(2)); //从指定位置取到结尾
       String s="haigfjapoifpau.baidu.comfuabfnuoaiofaup9uf";
       String d="baidu.com";
       System.out.println(s.substring(s.indexOf(d),s.lastIndexOf(d)+d.length()));
   }


}
