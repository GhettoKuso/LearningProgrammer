package cn.wei.ds.demo;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 16:11  2020/7/4
 * @Modified by:
 */
public class TestMain {

    public static void main(String[] args) {
        StackCalculator calculator = new StackCalculator();
        try {
            double value = calculator.calculate("12+5/10+8-4*8*1");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
