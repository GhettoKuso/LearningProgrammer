package cn.wei.ds;

public class TestMain {

    public static void main(String[] args) {
        ReversePolishNotationDemo demo = new ReversePolishNotationDemo();
        try {
            System.out.println(demo.calculate("3 4 + 5 * 6 -"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        InfixTransToSuffix trans = new InfixTransToSuffix();
        String convert = trans.convert("1 + ( ( 2 + 3 ) * 4 ) - 5");
        System.out.println(convert);

        try {
            double value = demo.suffixCalculate("1 + ( ( 2 + 3 ) * 4 ) - 5");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
