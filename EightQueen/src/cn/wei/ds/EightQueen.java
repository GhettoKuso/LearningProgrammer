package cn.wei.ds;

import java.awt.*;
import java.nio.charset.CharsetEncoder;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:27  2020/7/9
 * @Modified by:
 */
public class EightQueen {
    private int max = 8;
    /*
    * array 表示棋盘,array的下标表示行,array的值表示列
    */
    private int[] array = new int[max];
    private int resultNum;

    public void run() {
        resultNum = 0;
        runInner(0);
        System.out.println("the Number of resolver is " + resultNum);
    }

    /**
     * <p>走棋实现</p>
     * @param num (下标)表示是第几个皇后
     * @version 0.1.0
     * @return void
     * @author SunWei
     * @date 2020/7/9 22:41
     * @since 0.1.0
    */
    private void runInner(int num) {
        if (num == max) { //如果已经走到下标为8说明是第9个皇后了,表示找到一种解法.
            printResult();
            resultNum++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[num] = i; //从0到max分别放置皇后
            if (check(num)) {//检查皇后是否合规
                runInner(num + 1);//合规则放下一个皇后
            }
            //如果不合规,则再移动列 即i++
        }
    }

    private void printResult() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * <p>判断当前皇后的位置是否合规</p>
     *
     * @param num 表示第几个皇后
     * @return boolean
     * @version 0.1.0
     * @author SunWei
     * @date 2020/7/9 22:44
     * @since 0.1.0
     */
    private boolean check(int num) {
        for (int row = 0; row < num; row++) {
            /*
             * array[row] == array[num]
             * 表示有皇后在同一列
             *
             * Math.abs(num - row) == Math.abs(array[num] - array[row])
             * Math.abs(num - row):行距
             * Math.abs(array[num] - array[row]):列距
             * 行距=列距表示有皇后在斜线上，斜率为1
             */
            if (array[row] == array[num] || Math.abs(num - row) == Math.abs(array[num] - array[row])) {
                return false;
            }
        }
        return true;
    }

}
