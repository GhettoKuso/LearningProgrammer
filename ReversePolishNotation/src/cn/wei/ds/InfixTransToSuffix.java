package cn.wei.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 *
 */
public class InfixTransToSuffix {

    public Stack<String> tempStack = new Stack<>();
    public Stack<String> resultStack = new Stack<>();

    /**
     * <p>中缀表达式转后缀表达式 </p>
     * 步骤如下:
     * 1.首先需要有两个栈s1,s2
     * 2.从左到右遍历表达式
     * 3.遇到数字直接入s2
     * 4.遇到字符
     * 4.1 如果s1为空或者s1栈顶为'('直接入s1
     * 4.2 如果字符为运算法,比较优先级,如果栈顶优先级更高或者一样,将s1栈顶元素弹出压入s2,再进行4操作.
     * 4.3 如果字符为运算法,比较优先级,如果当前运算符比栈顶优先级高,将运算符压入s1
     * 5.遇到括号
     * 5.1 '('直接压入s1
     * 5.2 是')'则依次弹出s1中元素并压入s2中,直到遇到')'就将')'弹出
     * 6.重复2-5步骤,直到遍历到最后,
     * 7.将s1中元素依次弹出并压入s2
     * 8.将s2中元素逆序排列得出结果
     *
     * @param expression : 表达式
     * @return : String
     * @author : sunwei
     * @date : 2020/7/7 22:44
     **/
    public String convert(String expression) {
        if (expression == null || expression.length() < 1) {
            throw new RuntimeException("expression is empty");
        }
        /**
         * 为了简化操作,这里输入的字符串默认已经做了数字和字符分割
         */
        String[] array = expression.split(" ", -1);
        List<String> list = Arrays.asList(array);
        for (String str : list) {
            if (isNumber(str)) {
                resultStack.push(str);
            } else if (isOperation(str)) {
                priorityOperation(tempStack, resultStack, str);
            } else{
                if (isBrackets(str)==1){
                    tempStack.push(str);
                }
                if(isBrackets(str)==-1){
                    while(true){
                        String item = tempStack.pop();
                        if(isBrackets(item)==1) {
                            break;
                        }else{
                            resultStack.push(item);
                        }
                    }
                }
            }
        }
        while(!tempStack.empty()&&tempStack.peek()!=null){
            String item = tempStack.pop();
            resultStack.push(item);
        }
        StringBuilder builder = new StringBuilder();
        while(!resultStack.empty()&&resultStack.peek()!=null){
            String item = resultStack.pop();
            builder.insert(0," ");
            builder.insert(0,item);
        }
        String substring = builder.substring(0, builder.length() - 1);
        return substring.toString();
    }

    private void priorityOperation(Stack<String> tempStack, Stack<String> resultStack, String str) {
        if (tempStack.empty() || "(".equals(tempStack.peek())) {
            tempStack.push(str);
        } else {
            if (priority(tempStack.peek()) >= priority(str)) {
                String item = tempStack.pop();
                resultStack.push(item);
                priorityOperation(tempStack, resultStack, str);
            } else {
                tempStack.push(str);
            }
        }
    }

    private boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(str).find();
    }

    private boolean isOperation(String str) {
        return !isNumber(str) && priority(str) > 0;
    }

    private int isBrackets(String str) {
        if ("(".equals(str)) {
            return 1;
        }
        if (")".equals(str)) {
            return -1;
        }
        return 0;
    }

    private int priority(String oper) {
        switch (oper) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

}
