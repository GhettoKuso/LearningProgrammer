package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:29  2020/7/14
 * @Modified by:
 */
public class SelectionSort {

    /*
     * <p>选择排序实现</p>
     * 选择排序是从一串数字中找到最小或者最大的值,再去和队首或队尾的值进行交换,
     * 这个过程中不断缩小比较大小的范围,从而实现排序
     * @param source 原数组
     * @version 0.1.0
     * @return int[]
     * @author SunWei
     * @date 2020/7/14 22:30
     * @since 0.1.0
     */
    public int[] sort(int[] source) {

        for (int i = 0; i < source.length; i++) {
            int index = i; //存储最小值的下标
            int value = source[i];//存储最小值
            for (int j = i + 1; j < source.length; j++) {
                if (source[j] < value){//如果比当前最小值还小则修改为当前最小值
                    value=source[j];
                    index=j;
                }
            }
            if(index!=i){ //遍历一轮后发现最小值有变化,则将最小值和比较范围的队首值进行交换
                int temp = source[i];
                source[i]=source[index];
                source[index]=temp;
            }
        }
        return source;
    }
}
