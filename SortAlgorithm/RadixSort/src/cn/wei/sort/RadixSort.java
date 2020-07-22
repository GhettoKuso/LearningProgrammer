package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 23:08  2020/7/22
 * @Modified by:
 */
public class RadixSort {

    //用于存放数组的桶
    public int temp[][];

    /*
     * <p>基数排序</p>
     * @param arr 待排序数组
     * @version 0.1.0
     * @return void
     * @author SunWei
     * @date 2020/7/22 23:59
     * @since 0.1.0
     *
    */
    public void sort(int[] arr) {
        temp = new int[20][arr.length];

        //用于标识每个桶中元素的数组,ex:tempIndex[5]=2,表示下标为5的桶中有两个元素
        int[] tempIndex = new int[20];
        int mod = 10;
        int div = 1;

        //求出数组中最大位数
        int maxLength = getMaxLength(arr);

        for (int i = 0; i < maxLength; i++) {

            //重置标识数组
            for (int j = 0; j < tempIndex.length; j++) {
                tempIndex[j]=0;
            }

            for (int j = 0; j < arr.length; j++) {

                //求出指定位的值(个位数十位数百位数....),其中负数位于(0-9)正数位于(10-19)
                int digitValue = (arr[j]%mod)/div+10;
                int index = tempIndex[digitValue];

                //将值放到指定桶中
                temp[digitValue][index]=arr[j];

                //标识数组标识
                tempIndex[digitValue]=++index;
            }

            //切换位
            mod*=10;
            div*=10;

            int index =0;
            //将桶中元素由数组下标依次取出,放回原数组
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < tempIndex[j]; k++) {
                    arr[index]=temp[j][k];
                    index++;
                }
            }
        }
    }

    /*
     * <p>用于获取数组中最大位数</p>
     * @param arr arr
     * @version 0.1.0
     * @return int
     * @author SunWei
     * @date 2020/7/23 0:06
     * @since 0.1.0
    */
    private int getMaxLength(int arr[]) {
        int value = Math.abs(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (value < Math.abs(arr[i])) {
                value = Math.abs(arr[i]);
            }
        }
        if (value == 0) {
            return 1;
        }
        int lenght = 0;
        for (int temp = value; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }
}
