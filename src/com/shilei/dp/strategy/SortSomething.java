package com.shilei.dp.strategy;

import java.util.Arrays;

public class SortSomething {
    //int型数组排序
    public static  void sort(Comparable[] a) {
        for (int i=0;i<a.length;i++) {
            for (int j=i+1;j<a.length;j++) {
                if (a[j].compareTo(a[i]) < 0)
                    swap(a,i,j);
            }
        }
    }


    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] a = {1,5,3};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));

        Cat[] cs = {new Cat(1),new Cat(5), new Cat(3)};
        sort(cs);
        System.out.println(Arrays.toString(cs));
    }
}
