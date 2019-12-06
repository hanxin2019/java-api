package com.tedu.cn;

public class Test{
        public static void main(String[] args){
            //给出要进行比较的字符，封装在数组str中
            String[] str = {"abc","cad","f","m","fc","fb"};
            //利用冒泡排序进行排序
            for(int i=str.length-1;i>=1;i--){
                for(int j=0;j<=i-1;j++){
                    //如果str[j]小于str[j+1]，则进行交换位置
                    if(str[j].compareTo(str[j+1])<0){
                        String temp = str[j];
                        str[j] = str[j+1];
                        str[j+1] = temp;
                    }
                }
            }
            //输出排序后的字符串
            for(int a=0;a<str.length;a++){
                System.out.print(str[a]+"  ");
            }
        }


    }


