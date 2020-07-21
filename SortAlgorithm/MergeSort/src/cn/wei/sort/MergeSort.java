package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:17  2020/7/21
 * @Modified by:
 */
public class MergeSort {

    /*
     * <p>归并排序</p>
     * @param left 数组左索引
     * @param rigth 数组右索引
     * @param arr 数组
     * @param temp 用于交换的临时数组
     * @version 0.1.0
     * @return void
     * @author SunWei
     * @date 2020/7/21 22:57
     * @since 0.1.0
    */
    public void sort(int left, int rigth, int[] arr, int[] temp) {
        temp = new int[arr.length];
        if (left < rigth) {

            //计算中值
            int mid = (left+rigth)/2;

            //左递归分解
            sort(left,mid,arr,temp );

            //右递归分解
            sort(mid+1, rigth, arr, temp);

            //合并
            merge(left, rigth, mid, arr, temp);
        }
    }

    /*
     * <p>合并子项逻辑处理</p>
     * @param left 左索引
     * @param right 右索引
     * @param mid 中值
     * @param arr 原数组
     * @param temp 用于交换的数组
     * @version 0.1.0
     * @return void
     * @author SunWei
     * @date 2020/7/21 22:59
     * @since 0.1.0
    */
    public void merge(int left, int right, int mid, int arr[], int[] temp) {
        //初始化左右两子项起点
        int t = 0;
        int i = left;
        int j = mid+1;

        //对两子项进行排序，直到一边遍历完全则结束
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {//若左边值小于或等于右值，将左值放到交换数组
                temp[t] = arr[i];
                i++;
                t++;
            } else {//若左边值大于右值，将右值放到交换数组
                temp[t] = arr[j];
                j++;
                t++;
            }

        }

        //若左子项有剩余（此时剩余项已经排序了且是大数），将剩余部分按顺序放到交换数组后
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        //若右子项有剩余（此时剩余项已经排序了且是大数），将剩余部分按顺序放到交换数组后
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        //拷贝交换数组数据至原数组中，此时left~right之间的值已经排序且都在交换数组中了，将其拷贝到原数组即可
        t = 0;
        int l = left;
        while (l <= right) {
            arr[l] = temp[t];
            t++;
            l++;
        }
    }
}
