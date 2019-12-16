package com.tedu.cn;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FiletTest {
    @Test
    public void m1() throws IOException {
        File f=new File("files");
        if(f.exists()){ //判断这个文件是否存在
            System.out.println("文件存在");
        }else{
            System.out.println("文件不存在");
            boolean flag=f.mkdir(); //创建一个位置（相当于文件夹）
            System.out.println(flag?"创建成功":"创建失败");
        }
        f=new File(f,"tt.txt");
        if(f.exists()){
            System.out.println("文件存在");
        }else{
            System.out.println("文件不存在");
            f.createNewFile();  //创建文件
        }
//        File f=new File("D:\\ff\\f");
////        f.mkdirs(); //创建多层
        System.out.println("分隔符是："+File.separator);
    }
    @Test
    public void m2(){
        File f=new File("D:\\");  //表示一个目录，不是文件。返回false
        System.out.println(f.isDirectory());//判断是否为目录
        System.out.println(f.isFile()); //判断是否为文件
    }
    @Test
    public void m3(){
        File f=new File("t.txt");
        System.out.println(f.length());  //输出多少个字节
        if(f.exists()){
            f.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void m4() throws IOException {
        File f=new File("t1.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        if(f.exists()){
            f.renameTo(new File("t2.txt")); //更改名字
        }
    }
    @Test
    public void m5(){
        File f=new File("t"+File.separator+"t1"+File.separator+"t2"+File.separator+"tt.txt");
        System.out.println(f.getName());
        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getAbsolutePath());//获取绝对路径
    }
    @Test
    public void m6(){
        File f=new File("D:\\qiannan-parent");
        File[] fs=f.listFiles();  //获取文件下的目录
        for(int i=0;i<fs.length;i++){
            System.out.println(fs[i].getName());
        }
    }
    @Test
    public void m7(){
        File f=new File("D:\\qiannan-parent");
        File[] fs=f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return f.isDirectory();
            }
        });
        for(int i=0;i<fs.length;i++){
            System.out.println(fs[i].getName());
        }
    }
   @Test
   public  void m8()throws IOException{
        File f=new File("E:\\5555");  //传入文件路径
        reversDel(f);
}
//  递归方法删除所有文件
   public static void reversDel(File file){
       if(file.isFile()||file.list().length==0){
           file.delete();
       }
       else{
           File[] files=file.listFiles();
           for(int i=0;i<files.length;i++){
               reversDel(files[i]);
               file.delete();
               System.out.println(files[i].getName()+"已删除");
           }
       }
   }
   @Test
    public void m9() throws IOException {
        File f=new File("t2.txt");
       RandomAccessFile rw=new RandomAccessFile(f,"rw"); //r是可读 ，rw是可读可写
       String first_line=rw.readLine();
       System.out.println(new String(first_line.getBytes("iso8859-1"),
               StandardCharsets.UTF_8));//乱码  转换为utf-8输出
       rw.close();
   }
   @Test
    public void m10() throws IOException { //读取内容
        File f=new File("t2.txt");
        RandomAccessFile ff=new RandomAccessFile(f,"rw");
       System.out.println("当前指针位置："+ff.getFilePointer());
       byte[] bs=new byte[3];
       int i=ff.read(bs);
       System.out.println(new String(bs));
       System.out.println("当前指针位置："+ff.getFilePointer());
       i=ff.read(bs);
       System.out.println(new String(bs));//指针会接着上次位置往下读（重新开始读需重置指针位置为0）
       System.out.println("当前指针位置："+ff.getFilePointer());
       ff.seek(0);  //重置指针位置
       System.out.println("当前指针位置："+ff.getFilePointer());
       ff.close();
    }
    @Test
    public void m11() throws IOException { //读取内容
        File f=new File("t2.txt");
        RandomAccessFile ff=new RandomAccessFile(f,"rw");
        byte[] bs=new byte[1024];
        long len=0;
        String str ="";
        while((len=ff.read(bs))!=-1){
            str+=new String(bs);
        }
        System.out.println(str);
        ff.close();
    }
    @Test
    public void m12() throws IOException {  //写入内容
        File f=new File("t2.txt");
        RandomAccessFile ff=new RandomAccessFile(f,"rw");
        ff.seek(ff.length());  //改变指针位置
        ff.write("\n".getBytes());
        ff.write("你好!!!".getBytes());
        ff.close();
    }
    @Test
    public void m13() throws IOException {
        File f=new File("t2.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        RandomAccessFile fs=new RandomAccessFile(f,"rw");
        File f1=new File("t1.txt");
        RandomAccessFile ff=new RandomAccessFile(f1,"rw");
        byte[] bs=new byte[1024];
        long len=0;
        while ((len=ff.read(bs))!=-1){//读取t1的内容
            fs.write(bs);  //写入t2实现拷贝
        }
        ff.close();//切记关闭流
        fs.close();
    }
}
