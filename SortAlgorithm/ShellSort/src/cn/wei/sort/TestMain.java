package cn.wei.sort;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:28  2020/7/16
 * @Modified by:
 */
public class TestMain {
    public static void main(String[] args) {
        ShellSort shellSort= new ShellSort();
        shellSort.sort(new int[]{-1,1,5,1,2,6,99,7,-5,2});
    }
}
