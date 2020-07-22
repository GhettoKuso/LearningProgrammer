package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 23:38  2020/7/22
 * @Modified by:
 */
public class MainTest {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] arr = new  int []{4,-1,4,4,5,7,10,-7,52,6,3};
        radixSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
    }
}
