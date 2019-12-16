package com.tedu.cn;

import com.tedu.cn.entity.Emp;
import org.junit.Test;

import java.io.*;

public class IOTest {
    /**
     * 流的概念
     * 流就是一根水管
     * 运输数据，由于运输方向，有输入方向和输出方向
     * 分为标准的输入流和输出流两种
     *
     * JAVA语言里面有一个抽象类叫做InputStream，是所有输入流的父类
     * 提供3个重载的方法读取数据，分别是
     * 1、int read(),   每次读取1字节
     * 2、int read(byte[] bf),   每次读取bf的长度
     * 3、int read(byte[] bf,int off,int len)
     *
     * OutputStream是所有输出流的父类，提供3个write方法：
     * 1、write(int b)
     * 2、write(byte[] b)
     * 3、write(byte[] b,int off,int len)
     */
    @Test
    public void m1() throws IOException {
        //创建一个输入流  连接对象t1.txt
        InputStream i=new FileInputStream("t1.txt");
        //创建一个输出流  连接对象t3.txt
        OutputStream o=new FileOutputStream(new File("t3.txt"));
        byte[] bs=new byte[1024];
        long len=0;
        //从对象i (t1.txt)中读取bs字节 长度为len的数据
        while ((len=i.read(bs))!=-1){
            o.write(bs);  //写入 o(t3.txt)中
        }
        i.close();
        o.close();
    }

    /**
     * 基于包装流（缓冲流的文件复制）
     * BufferedInputStream 一个高级输入流（包装流，不能和文件直接打交道）
     * BufferedOutputStream 一个高级输出流（包装流，不能和文件直接打交道）
     */
    @Test
    public void m2() throws IOException {
        //创建一个输入流  连接对象t1.txt
        InputStream i=new FileInputStream("t1.txt");
        //创建一个输出流  连接对象t3.txt
        OutputStream o=new FileOutputStream(new File("t4.txt"));
        //创建一个高级输入流（包装流，不能和文件直接打交道）
        BufferedInputStream b=new BufferedInputStream(i);
        //创建一个高级输出流（包装流，和文件直接打交道的叫低级流）
        BufferedOutputStream o1=new BufferedOutputStream(o);
        byte[] bs=new byte[1024];
        long len=0;
        while ((len=b.read(bs))!=-1){
            o1.write(bs);
        }
        o1.flush();  //处理数据完毕，需要的数据已提取。处理剩下的
        b.close();
        o1.close();  //只关闭高级流即可
    }
    @Test
    //测试序列化和反序列化
    //将对象写入磁盘中叫序列号
    //将磁盘对象写入叫反序列化
    public void m3() throws IOException {
        //先创建一个对象
        Emp e=new Emp("jems",'男',18,888.0);
        //创建一个低级输出流
        OutputStream os=new FileOutputStream("emp.obj");
        //创建一个高级输出流包装低级流
        ObjectOutputStream oo=new ObjectOutputStream(os);
        //写入磁盘
        oo.writeObject(e);
        oo.close();
    }
    @Test
    public void m4() throws IOException, ClassNotFoundException {
        //创建一个低级输入流
        InputStream i=new FileInputStream("emp.obj");
        //创建一个高级输入流包装低级输入流
        ObjectInputStream in=new ObjectInputStream(i);
        //从磁盘中反序列对象 写入对象
        Emp e=(Emp) in.readObject();
        System.out.println(e);
        in.close();
    }

}
