package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 23:22  2020/7/13
 * @Modified by:
 */
public class BubbleSort {

    /*
     * <p>冒泡排序</p>
     * 要点,双层嵌套,内层嵌套循环需要不断缩小,
     * 内层循环范围为外层循环的i到length
     * @param source 原数组
     * @version 0.1.0
     * @return int[]
     * @author SunWei
     * @date 2020/7/13 23:34
     * @since 0.1.0
     */
    public int[] sort(int[] source) {
        int count = 0;
        for (int i = 0; i < source.length; i++) {
            for (int j = i; j < source.length; j++) {
                if (source[i] > source[j]) {
                    int temp = source[i];
                    source[i] = source[j];
                    source[j] = temp;
                }
                count++;
            }
        }
        System.out.println(count);
        return source;
    }

    /*
     * <p>冒泡排序算法的优化,如果一次内循环中没有发生交换
     * ,则直接结束排序,因为没有交换说明这时已经排序好了.</p>
     * @param source source
     * @version 0.1.0
     * @return int[]
     * @author SunWei
     * @date 2020/7/13 23:46
     * @since 0.1.0
    */
    public int[] sortOptimalize(int[] source) {
        int count = 0;
        for (int i = 0; i < source.length; i++) {
            boolean flag = true;
            for (int j = i; j < source.length; j++) {
                if (source[i] > source[j]) {
                    int temp = source[i];
                    source[i] = source[j];
                    source[j] = temp;
                    flag = false;
                }
                count++;
            }
            if(flag){
                break;
            }
        }
        System.out.println(count);
        return source;
    }
}
