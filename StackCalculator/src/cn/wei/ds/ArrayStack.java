package cn.wei.ds;

import java.util.List;

/**
 * @Project: StackCalculator
 * @Description: 一个简单的基于数组的栈实现
 * @Creator: sunwei
 * @CreatDate: 2020/7/4
 * @Modifier:
 */
public class ArrayStack<T> {
    private int top = -1;
    private Object[] data;
    private int maxSize;

    /**
     * <p>Your Description about this Method</p>
     * @param maxSize 栈大小
     * @version 0.1.0
     * @return
     * @author SunWei
     * @date 2020/7/4 16:56
     * @since 0.1.0
    */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize];
        top = -1;
    }

    /**
     * <p>入栈</p>
     * @param obj 要压入的数据
     * @version 0.1.0
     * @return void
     * @author SunWei
     * @date 2020/7/4 16:56
     * @since 0.1.0
    */
    public void push(T obj) throws Exception {
        if (isFull()) {
            throw new Exception("stack is full");
        }
        top++;
        data[top] = obj;
    }

    /**
     * <p>出栈</p>
     * @param
     * @version 0.1.0
     * @return T
     * @author SunWei
     * @date 2020/7/4 16:57
     * @since 0.1.0
    */
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }
        T value = (T)data[top--];
        return value;
    }

    /**
     * <p>判断是否为空</p>
     * @param
     * @version 0.1.0
     * @return boolean
     * @author SunWei
     * @date 2020/7/4 16:57
     * @since 0.1.0
    */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * <p>判断是否已满</p>
     * @param
     * @version 0.1.0
     * @return boolean
     * @author SunWei
     * @date 2020/7/4 16:57
     * @since 0.1.0
    */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * <p>获取栈的长度</p>
     * @param
     * @version 0.1.0
     * @return int
     * @author SunWei
     * @date 2020/7/4 16:57
     * @since 0.1.0
    */
    public int length() {
        return top + 1;
    }

    /**
     * <p>获取栈顶元素</p>
     * @param
     * @version 0.1.0
     * @return T
     * @author SunWei
     * @date 2020/7/4 16:58
     * @since 0.1.0
    */
    public T get() {
        return isEmpty() ? null : (T)data[top];
    }
}

