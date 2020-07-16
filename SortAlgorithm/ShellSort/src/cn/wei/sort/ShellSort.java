package cn.wei.sort;

import java.util.Arrays;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:20  2020/7/16
 * @Modified by:
 */
public class ShellSort {
    /*
     * <p>希尔排序之交换法</p>
     * @param arr 待排序的数组
     * @version 0.1.0
     * @return int[]
     * @author SunWei
     * @date 2020/7/16 22:21
     * @since 0.1.0
     */
    public int[] sort(int[] arr) {

        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >0; j -= gap) {
                    if (arr[j] > arr[j+gap]) {
                        temp = arr[j+gap];
                        arr[j+gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }

        return arr;
    }
}
