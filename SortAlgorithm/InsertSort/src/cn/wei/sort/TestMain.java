package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 23:00  2020/7/14
 * @Modified by:
 */
public class TestMain {

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] result = sort.sort(new int[]{-1, 0, 5, 4, 5, 48, 12 , 12});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}
