package cn.wei.ds.demo;

import cn.wei.ds.ArrayStack;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 15:25  2020/7/4
 * @Modified by:
 */
public class StackCalculator {

    private ArrayStack<Double> numberStack;
    private ArrayStack<String> operatonStack;

    /**
     * <p>一个有优先级的简单数字运算实现</p>
     * @param equation 计算式
     * @version 0.1.0
     * @return double
     * @author SunWei
     * @date 2020/7/4 16:59
     * @since 0.1.0
    */
    public double calculate(String equation) throws Exception {
        if (equation == null || equation.length() < 1) {
            throw new Exception("equation is invalid");
        }
        numberStack = new ArrayStack(equation.length());
        operatonStack = new ArrayStack(equation.length());
        int aheadFlag = 0;
        //将算式拆分成一个一个的字符
        String[] arr = equation.split("|");
        //将夹在低优先级中的高优先级运算全部做完
        for (int i = 0; i < arr.length; i++) {

            //操作符和数字个数关系不正确,算式不正确
            if (numberStack.length() < operatonStack.length()) {
                throw new Exception("equation is invalid");
            }

            if (priority(arr[i]) == -1) {//为数字
                double value = Double.valueOf(arr[i]);
                if (aheadFlag == 0 && numberStack.get() != null) {//前一个字符也是数字,做组合
                    double numer = numberStack.pop();
                    value = numer * 10 + Double.valueOf(arr[i]);
                }
                numberStack.push(value);
                aheadFlag = 0;
            } else {
                if (aheadFlag == 1) {//前一个字符是运算符,这里抛出错误,+-10这种的暂时认为错误
                    throw new Exception("equation is invalid");
                }
                String obj = operatonStack.get();
                if (obj == null) {//目前没有运算符,直接入栈
                    operatonStack.push(arr[i]);
                } else if (priority(obj) > priority(arr[i])) {//当前运算符的优先级比上一个运算符低,需要做完上一个运算
                    String operation = operatonStack.pop();
                    double num1 = numberStack.pop();
                    double num2 = numberStack.pop();
                    double result = computer(num1, num2, operation);
                    numberStack.push(result);
                    operatonStack.push(arr[i]);
                }else{//当前运算符的优先级比上一个运算符高或者相等,直接入栈
                    operatonStack.push(arr[i]);
                }
                aheadFlag = 1;
            }
        }
        //运算优先级分割的运算,最终只留下了一个值就是最终结果
        while(true){
            if(numberStack.length()==1){
                break;
            }
            Double num1 = numberStack.pop();
            Double num2 = numberStack.pop();
            String operation = operatonStack.pop();
            double result = computer(num1, num2, operation);
            numberStack.push(result);
        }
        return numberStack.get();
    }

    /**
     * <p>判断是否为运算符</p>
     * @param oper oper
     * @version 0.1.0
     * @return boolean
     * @author SunWei
     * @date 2020/7/4 16:59
     * @since 0.1.0
    */
    public boolean isOperation(String oper) {
        return priority(oper) != -1;
    }

    /**
     * <p>获取运算符优先级</p>
     * @param oper oper
     * @version 0.1.0
     * @return int
     * @author SunWei
     * @date 2020/7/4 17:00
     * @since 0.1.0
    */
    public int priority(String oper) {
        if ("+".equals(oper) || "-".equals(oper)) {
            return 0;
        } else if ("*".equals(oper) || "/".equals(oper)) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * <p>数字运算</p>
     * @param num1 num1
     * @param num2 num2
     * @param operation operation
     * @version 0.1.0
     * @return double
     * @author SunWei
     * @date 2020/7/4 17:00
     * @since 0.1.0
    */
    public double computer(double num1, double num2, String operation) throws Exception {
        switch (operation) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
            default:
                throw new Exception("operation is invalid");
        }
    }
}
