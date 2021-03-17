package com.shilei.dp.strategy;

import java.util.Arrays;
import java.util.Comparator;

public class SortSomething {
    //int型数组排序
    public static <T>  void sort(T[] a , Comparator<T> t) {
        for (int i=0;i<a.length;i++) {
            for (int j=i+1;j<a.length;j++) {
                if (t.compare(a[j],a[i]) < 0)
                    swap(a,i,j);
            }
        }
    }


    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
//        Integer[] a = {1,5,3};
//        System.out.println(Arrays.toString(a));
//        sort(a);
//        System.out.println(Arrays.toString(a));

        Cat[] cs = {new Cat(1,3),new Cat(5,6), new Cat(3,1)};
        sort(cs, new Comparator<Cat>() {

            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.food - o2.food;
            }
        });
        System.out.println(Arrays.toString(cs));
    }
}
