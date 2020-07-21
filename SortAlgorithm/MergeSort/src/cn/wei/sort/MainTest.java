package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:37  2020/7/21
 * @Modified by:
 */
public class MainTest {

    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        int[] arr = new int[]{4,5,1,7,8,-4,-1,0,0,4};
        int[] temp = new  int[arr.length];
        mergeSort.sort(0, arr.length-1, arr, temp);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
