package com.oumuanode.mybatis.pojo;

import java.util.Arrays;
import java.util.Scanner;

import java.util.*;                  // P1116 车厢重组
public class Main{                  //冒泡排序计数
    public static void main(String[] args){
        Scanner rd=new Scanner(System.in);
        int a=rd.nextInt();
        int[]arr=new int[a];
        int count=0;
        for(int i=0;i<a;i++) {
            arr[i]=rd.nextInt();
        }
        for(int j=0;j<arr.length;j++) {
            for(int k=0;k<arr.length-j-1;k++) {
                int t=0;
                if(arr[k]>arr[k+1]) {
                    t=arr[k];
                    arr[k]=arr[k+1];
                    arr[k+1]=t;
                    count++;
                }

            }
        }
        System.out.println(count);
    }
}
