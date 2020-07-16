package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 23:13  2020/7/16
 * @Modified by:
 */
public class QuickSort {

    public void sort(int[] arr, int left, int right) {
        //左指针
        int low = left;
        //右指针
        int high = right;
        //用于交换的临时变量
        int temp = 0;

        if (low > high) {
            return;
        }
        //以最左的值为基准值
        int standard = arr[low];

        while (low < high) {

            //先移动右指针,找到一个比基准值小的值,
            //若右指针比左指针小,说明左指针右侧没有比基准值小的值(全是比基准值大的值)
            while (arr[high] >= standard && low < high) {
                high--;
            }
            //移动左指针,找到一个比基准值大的值,
            //若左指针比右指针大,说明右指针左侧没有比基准值大的值(全是比基准值小的值)
            while (arr[low] <= standard && low < high) {
                low++;
            }

            if (low < high) {//两个指针没有相遇,交换值
                temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }

        //跳出while循环说明左指针和右指针已经相遇了,交换当前值和基准值
        arr[left] = arr[low];
        arr[low] = standard;

        //左递归
        sort(arr, left, high - 1);

        //右递归
        sort(arr, low + 1, right);
    }
}
