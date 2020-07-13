package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 23:27  2020/7/13
 * @Modified by:
 */
public class TestMain {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] result = sort.sort(new int[]{1, 5, 7, 11, 12, 14, 77});
//        int[] result = sort.sort(new int[]{1, -5, 7, -11, 12, -14, 77,-5});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "  ");
        }
        System.out.println();
        System.out.println("=================优化后==============");
        int[] optResult = sort.sortOptimalize(new int[]{1, 5, 7, 11, 12, 14, 77});
//        int[] optResult = sort.sortOptimalize(new int[]{1, -5, 7, -11, 12, -14, 77,-5});
        for (int i = 0; i < optResult.length; i++) {
            System.out.print(optResult[i] + "  ");
        }
    }
}
