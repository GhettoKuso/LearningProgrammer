package cn.wei.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:41  2020/7/23
 * @Modified by:
 */
public class BinarySearch {

    /*
     * <p>二分查找</p>
     * @param arr 源数据数组
     * @param left 左指针
     * @param right 右指针
     * @param target 目标值
     * @version 0.1.0
     * @return int
     * @author SunWei
     * @date 2020/7/23 22:45
     * @since 0.1.0
    */
    public int search(int arr[],int left,int right,int target){
        if(left>right){ //左指针比右指针大,说明已经找不到目标值了
            return -1;
        }else{
            int mid = (left+right)/2; //取中值
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                return search(arr, left, mid-1, target); //向左递归
            }else{
                return search(arr, mid+1, right, target); //向右递归
            }
        }
    }


    public List searchEnhance(int arr[],int left,int right,int target){
        if(left>right){ //左指针比右指针大,说明已经找不到目标值了
            return null;
        }else{
            int mid = (left+right)/2; //取中值
            if(arr[mid]==target){
                List list = new ArrayList<Integer>();
                list.add(mid);
                int temp = mid;
                while (arr[--temp]==target){
                    list.add(temp);
                }
                temp = mid;
                while (arr[++temp]==target){
                    list.add(temp);
                }
                return list;
            }else if(arr[mid]>target){
                return searchEnhance(arr, left, mid-1, target); //向左递归
            }else{
                return searchEnhance(arr, mid+1, right, target); //向右递归
            }
        }
    }
}
