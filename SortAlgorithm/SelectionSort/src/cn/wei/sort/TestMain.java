package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:36  2020/7/14
 * @Modified by:
 */
public class TestMain {
    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] result = sort.sort(new int[]{-1, 5, 12, 4, 0, 6, 74, 1, 0});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
