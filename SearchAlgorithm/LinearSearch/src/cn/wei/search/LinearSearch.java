package cn.wei.search;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:32  2020/7/23
 * @Modified by:
 */
public class LinearSearch {

    /*
     * <p>在数组中找出一个目标值,返回下标.不存在则返回-1</p>
     * @param arr 数组
     * @param exp 目标值
     * @version 0.1.0
     * @return int
     * @author SunWei
     * @date 2020/7/23 22:36
     * @since 0.1.0
    */
    public int search(int arr[],int exp){
        for (int i = 0; i < arr.length; i++) {
            if(exp==arr[i]){
                return i;
            }
        }
        return -1;
    }
}
