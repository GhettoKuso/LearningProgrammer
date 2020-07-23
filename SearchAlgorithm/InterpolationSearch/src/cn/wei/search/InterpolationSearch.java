package cn.wei.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 23:26  2020/7/23
 * @Modified by:
 */
public class InterpolationSearch {

    /*
     * <p>插值查找,对于较均匀的序列来说,速度会比二分快</p>
     * @param arr 源数据数组
     * @param left 左指针
     * @param right 右指针
     * @param target 目标值
     * @version 0.1.0
     * @return java.util.List
     * @author SunWei
     * @date 2020/7/23 23:51
     * @since 0.1.0
    */
    public List search(int[] arr, int left, int right, int target) {
        if (left > right) { //左指针比右指针大,说明已经找不到目标值了
            return null;
        } else {

            //值全一样
            if (target == arr[left] && left == 0 && right == arr.length - 1) {
                List list = new ArrayList<>();
                while(left<=right){
                    list.add(left);
                    left++;
                }
                return list;
            }

            //取中值
            int mid = left+(right-left)*(target - arr[left]) / (arr[right] - arr[left]);
            if (arr[mid] == target) {
                List list = new ArrayList<>();
                list.add(mid);
                int temp = mid;
                while (arr[--temp] == target) {
                    list.add(temp);
                }
                temp = mid;
                while (arr[++temp] == target) {
                    list.add(temp);
                }
                return list;
            } else if (arr[mid] > target) {
                return search(arr, left, mid - 1, target); //向左递归
            } else {
                return search(arr, mid + 1, right, target); //向右递归
            }
        }
    }
}
