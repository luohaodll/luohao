package com.knowledge.point.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    static int[] num={1,0,9,2,3,5,6,7,8};
    public static void main(String[] args) {

        sort(num);
    }
    public static void  sort(int[] num){

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length-1-i; j++) {
                int a = num[j];
                if (num[j]>num[j+1]){
                    num[j]=num[j+1];
                    num[j+1]=a;
                }

            }


        }
        System.out.println(Arrays.toString(num));
    }


}
