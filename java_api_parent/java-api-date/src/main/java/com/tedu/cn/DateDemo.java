package com.tedu.cn;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    @Test
    public void m1(){
        //获取日历对象
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar);
}
    @Test
    public void m2(){
        Date date=new Date();
        System.out.println(date.getTime());

    }
    @Test
    public void m3(){
        //日期转换成字符串
        SimpleDateFormat format=new SimpleDateFormat("yyyy年-MM月-dd日 hh:mm:ss");
        String date=format.format(new Date());
        System.out.println(date);
    }
    @Test
    public void m4() throws ParseException {
        //字符串转换日期
        String date="2019-12-04";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date d=format.parse(date);
        System.out.println(d);
    }
}
