package com.yuruicai.test.common.utils;

import java.util.ArrayList;
import java.util.List;
/**
 *  快速排序
 * */
public class QuickSortTest {
    public static <AnyType extends Comparable<? super AnyType>> void quickSort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> samaller = new ArrayList<>();//小的
            List<Integer> same = new ArrayList<>();//相同的
            List<Integer> larger = new ArrayList<>();//较大的

            int index = items.size() / 2;
            Integer chosentItem = items.get(items.size() / 2);
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) < chosentItem) {
                    samaller.add(items.get(i));
                } else if (items.get(i) > chosentItem) {
                    larger.add(items.get(i));
                } else {
                    same.add(items.get(i));
                }

            }
            quickSort(samaller);
            quickSort(larger);

            items.clear();
            items.addAll(samaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(9);
        objects.add(1);
        objects.add(10);
        objects.add(944);
        objects.add(0);
        objects.add(-1);
        objects.add(6);
        objects.add(9);
        objects.add(9);
        quickSort(objects);
    }
}
