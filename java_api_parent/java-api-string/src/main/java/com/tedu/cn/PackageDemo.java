package com.tedu.cn;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PackageDemo {
    @Test
    public void m1(){
        //包装类
//        int a=8;
//        Integer b=a;
//        System.out.println(Integer.toHexString(a));
//        System.out.println(Integer.toOctalString(a));
//        System.out.println(Integer.toBinaryString(a));
//        try {
//            min();
//        } catch (FileNotFoundException e) {
//            System.out.println("异常捕获。。。。");
////            e.printStackTrace();
//        }
//        ex();
        try {
            m3();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("解决异常");
        }
    }
    public static void ex(){
        try{
            System.out.println(1/0);
            InputStream inputStream=new FileInputStream("tts.txt");
            String str=null;
            System.out.println(str.indexOf("a"));
        }catch (NullPointerException e3){
            System.out.println("空指针异常");
        } catch(ArithmeticException e1){
            System.out.println("文件未找到");
        }catch (FileNotFoundException e2){
            System.out.println("除数不能为0");
        }finally {
            System.out.println("程序运行完毕");//程序无论是否异常都会运行FINALLY
        }
    }
//    public static void min() throws FileNotFoundException {
//        InputStream inputStream=new FileInputStream("tts.txt");
//    }
    public static void m3() throws Exception {
//        Exception e=new Exception("我创建的异常");
//        throw e;
        throw new Exception("创建异常");
    }
    @Test
    public void m4(){
        //自定义异常
        String psd="888888888";
        if(psd.length()<8){
            throw new PasswordException(2,"密码安全系数不够");
        }
        if(!psd.matches("\\d{4,8}&&\\w{4,8}")){
            throw new PasswordException(1,"密码不匹配");
        }
        if(!psd.equals("88888888")){
            throw new PasswordException(3,"密码错误");
        }

    }

}
