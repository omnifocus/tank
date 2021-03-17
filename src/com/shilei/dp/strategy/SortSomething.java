package com.shilei.dp.strategy;

import java.util.Arrays;

public class SortSomething {
    //int型数组排序
    public static void sort(int[] a) {
        for (int i=0;i<a.length;i++) {
            for (int j=i+1;j<a.length;j++) {
                if (a[j] < a[i])
                    swap(a,i,j);
            }
        }
    }
    //double型数组排序
    public static void sort(double[] a) {
        for (int i=0;i<a.length;i++) {
            for (int j=i+1;j<a.length;j++) {
                if (a[j] < a[i])
                    swap(a,i,j);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void swap(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,5,3};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
