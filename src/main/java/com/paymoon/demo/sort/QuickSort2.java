package com.paymoon.demo.sort;

import java.util.Arrays;

public class QuickSort2 {
    public static void sort(int a[], int low, int hight) {
        int lowi, hightj, index;
        if (low > hight) {
            return;
        }
        lowi = low;
        hightj = hight;
        index = a[lowi]; // 用子表的第一个记录做基准
        while (lowi < hightj) { // 从表的两端交替向中间扫描
            while (lowi < hightj && a[hightj] >= index)
                hightj--;
            if (lowi < hightj)
                a[lowi++] = a[hightj];// 用比基准小的记录替换低位记录
            while (lowi < hightj && a[lowi] < index)
                lowi++;
            if (lowi < hightj) // 用比基准大的记录替换高位记录
                a[hightj--] = a[lowi];
        }
        a[lowi] = index;// 将基准数值替换回 a[i]
        sort(a, low, lowi - 1); // 对低子表进行递归排序
        sort(a, lowi + 1, hight); // 对高子表进行递归排序

    }

    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {

        int a[] = { 49, 8, 65 };
//        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}