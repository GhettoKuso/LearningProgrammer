package cn.wei.ds;

public class TestMain {

    public static void main(String[] args) {
        ReversePolishNotationDemo demo = new ReversePolishNotationDemo();
        try {
            System.out.println(demo.calculate("3 4 + 5 * 6 -"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
