package cn.wei.sort;

import java.util.Arrays;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 0:06  2020/7/17
 * @Modified by:
 */
public class TestMain {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] arr = {6, 1, 3, 1, 3, 4, 7, 8, 0, 1, -7};
        sort.sort(arr, 0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
