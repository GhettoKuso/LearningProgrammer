package cn.wei.search;

import java.util.List;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:47  2020/7/23
 * @Modified by:
 */
public class MainTest {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = new int[]{-1,4,4,4,4,7,9,88,452,464,2000,2100};
        int search = binarySearch.search(arr, 0, arr.length - 1, 8);
        if(search==-1){
            System.out.println("can't find this target");
        }else{
            System.out.println("find target : "+search);
        }

        List list = binarySearch.searchEnhance(arr, 0, arr.length - 1, 4);
        if(list==null){
            System.out.println("can't find this target");
        }else{
            System.out.print("find target : ");
            list.stream().forEach((i)-> System.out.print(i+" "));
        }
    }
}
