package cn.wei.search;

import java.util.List;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 23:30  2020/7/23
 * @Modified by:
 */
public class MainTest {
    public static void main(String[] args) {
        InterpolationSearch search = new InterpolationSearch();
        int [] arr1= new int[]{1,1,1,1,1,1,1,1,1};
        int [] arr2 = new int[]{-4,-4,-1,0,5,8,9,15,45,65,87,114,223,332,550,1000,1000};
        List search1 = search.search(arr1, 0, arr1.length-1, 1);
        if(search1==null){
            System.out.println("can't find this target");
        }else{
            System.out.print("find target : ");
            search1.stream().forEach((i)-> System.out.print(i+" "));
        }
        System.out.println();
        List search2 = search.search(arr2, 0, arr2.length-1, 0);
        if(search2==null){
            System.out.println("can't find this target");
        }else{
            System.out.print("find target : ");
            search2.stream().forEach((i)-> System.out.print(i+" "));
        }
    }
}
