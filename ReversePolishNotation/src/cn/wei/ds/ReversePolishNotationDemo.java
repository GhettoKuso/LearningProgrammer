package cn.wei.ds;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class ReversePolishNotationDemo {
    private Stack<Double> numberStack;

    public double calculate(String expresion) throws Exception {
        String[] arr = expresion.split(" ", -1);
        List<String> list = Arrays.asList(arr);
        numberStack = new Stack<>();
        for (String str:list) {
            if (isNumber(str)) {
                numberStack.push(Double.valueOf(str));
            } else {
                Double num1 = numberStack.pop();
                Double num2 = numberStack.pop();
                double result = compute(num1, num2, str);
                numberStack.push(result);
            }
        }
        return numberStack.pop();
    }

    private boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(str).find();
    }

    private double compute(Double num1, Double num2, String operation) throws Exception {
        double result = 0;
        switch (operation) {
            case "+":
                result = num2 + num1;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num2 * num1;
                break;
            case "/":
                result = num2 / num1;
                break;
            default:
                throw new Exception("operation is invalid, can't calculate!");
        }
        return result;
    }
}
