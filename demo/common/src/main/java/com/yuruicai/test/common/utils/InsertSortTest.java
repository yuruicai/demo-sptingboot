package com.yuruicai.test.common.utils;
/**
 * 插入排序
 * */
public class InsertSortTest {
     static int[] sort(int[] arr ){
        int j;
        for (int i = 1; i < arr.length; i++){
            //当前值
            int tmp = arr[i];
            // 从当前值开始依次递减，判断前一个是否比当前值大，如果是 则将当前值等于n-1 ，否则不进行交换
            for (j = i; j >0 && arr[j-1] > tmp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
        return arr;
    }
    /**
     * 泛型方法实现
     * */
    static <AnyType extends Comparable<? super AnyType>> void insertSort(AnyType[] a){
         int j;
         for (int p = 1; p<a.length;p++){
             AnyType tmp = a[p];
             for (j = p ; j>0 && tmp.compareTo(a[j-1])<0 ;j--){
                 a[j] = a[j-1];
             }
         }
    }
    public static void main(String[] args) {
        int[] arr = {34,8,64,51,32,21};
        int[] sort = InsertSortTest.sort(arr);
        //InsertSortTest.insertSort(arr);
    }


}
