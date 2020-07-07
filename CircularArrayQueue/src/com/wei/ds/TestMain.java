package com.wei.ds;/**
 * @Author :sunwei
 * @Description:
 * @Date create in 1:07  2020/6/20
 * @Modified by:
 */

import java.util.zip.CheckedInputStream;

/**
 * @Project: CircularArrayQueue
 * @Description:
 * @Creator: sunwei
 * @CreatDate: 2020/6/20
 * @Modifier:
 */
public class TestMain {
    public static void main(String[] args) {
        CircularArrayQueue queue = new CircularArrayQueue(7);
        System.out.println("queue.isEmpty():"+queue.isEmpty());
//        queue.get();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println("-----add five value");
        System.out.println("arrUsefulSize:"+queue.arrUsefulSize());
        queue.showQueue();
        System.out.println("-----continue add two value");
        queue.add(60);
        queue.add(70);
        queue.showQueue();
        System.out.println("queue.isFull():"+queue.isFull());
        System.out.println("arrUsefulSize:"+queue.arrUsefulSize());
        queue.get();
        queue.get();
        System.out.println("-----get two value");
        queue.showQueue();
        System.out.println("arrUsefulSize:"+queue.arrUsefulSize());
        queue.add(1);
        queue.add(2);
        System.out.println("-----continue add two value");
        queue.showQueue();
        System.out.println("arrUsefulSize:"+queue.size());
    }
}
