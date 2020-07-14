package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:53  2020/7/14
 * @Modified by:
 */
public class InsertionSort {

    /*
     * <p>插入排序实现</p>
     * 插入排序是将排序结果从原序列一步一步分离的排序,
     * 最开始先从原序列中取出队首元素,
     * 再缩小范围,从原序列中依次取出队首的元素放到新序列的对应位置上,
     * 这个过程中不断缩小取值范围
     * @param source source
     * @version 0.1.0
     * @return int[]
     * @author SunWei
     * @date 2020/7/14 23:02
     * @since 0.1.0
    */
    public int[] sort(int[] source){
        int[] result = source;
        for (int i = 0; i < source.length; i++) {
            if(i==0){
                result[i]=source[i];//最开始先从原序列中取出队首元素形成结果序列
            }else{
                for (int j = 0; j < i; j++) {
                    if(result[j]>source[i]){//将原序列中的队首元素放到指定位置上
                        int temp = result[j];
                        result[j] = source[i];
                        source[i]=temp;
                    }
                }
            }
        }
        return result;
    }
}
