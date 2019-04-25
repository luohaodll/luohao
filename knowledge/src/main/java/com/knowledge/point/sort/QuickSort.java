package com.knowledge.point.sort;


import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3, 2, 5, 1, 4,6,0};
        System.out.println(Arrays.toString(a));
        quickSort1(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }


    public static void quickSort1(int[] a, int start, int end) {
        if (start >= end){
            return;
        }
        int m = a[start];
        int i = start, j = end;
        while (i < j) {
            while (a[j] > m && i < j) {
                j--;
            }
                if (i < j) {
                    a[i++] = a[j];
                }

            while (a[i] < m && i < j) {
                i++;
            }
                if (i < j) {
                    a[j--] = a[i];
                }

        }
        a[i] = m;
        quickSort1(a, start, i - 1);
        quickSort1(a, i + 1, end);
    }

}