package com.wei.ds;

/**
 * @Project: CircularArrayQueue
 * @Description: 循环队列基于数组的实现, 通过模运算来达到循环的效果
 * @Creator: sunwei
 * @CreatDate: 2020/6/20
 * @Modifier:
 */
public class CircularArrayQueue {

    //队列尾部指针,指向的是最后一个元素的下一个位置(下标),这样总会空出一个位置来,是为了判断队列是否已满.
    private int rear;
    //队列头部指针,指向第一个元素的位置(下标).
    private int front;
    //存储用的数组
    private int arr[];
    //最大容量
    private int maxSize;

    //由于总会空出一个位置,所有maxSize要比期望的大一个单位
    public CircularArrayQueue(int maxSize) {
        this.maxSize = maxSize + 1;
        arr = new int[maxSize + 1];
    }

    /**
     * <p>判断队列是否已满</p>
     *
     * @return boolean
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/20 0:41
     * @since 0.1.0
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * <p>判断队列是否为空</p>
     *
     * @return boolean
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/20 0:41
     * @since 0.1.0
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * <p>从队列获取数据</p>
     *
     * @param
     * @return int
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/20 0:46
     * @since 0.1.0
     */
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty,can't get value");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;//由于front也可能会越界,所以通过模运算来达到循环的效果
        return value;
    }

    /**
     * <p>添加数据到队列</p>
     *
     * @param value 添加的值
     * @return void
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/20 0:51
     * @since 0.1.0
     */
    public void add(int value) {
        if (isFull()) {
            throw new RuntimeException("queue is full,can't add value");
        }
        arr[rear] = value;
        rear = (rear + 1) % maxSize;//移动指针到下一个位置
    }

    /**
     * <p>返回队列中有效个数</p>
     *
     * @return int
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/20 1:05
     * @since 0.1.0
     */
    public int size() {
        //1.当rear>front时,有效数就是front到rear之间的数
        //2.当rear<front时,已经开始循环,有效数是去掉front到rear的其他数
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * <p>打印队列</p>
     *
     * @return void
     * @version 0.1.0
     * @author SunWei
     * @date 2020/6/20 1:05
     * @since 0.1.0
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return;
        }
        //只需要知道循环多少个数,至于循环发生时下标的位置,同理也是用模运算来取得
        for (int i = front; i < front + size(); i++) {
            //由于如果队列发生循环,i就可能会超过maxsize,所以取模 i % maxSize;
            System.out.println("arr[" + (i - front) % maxSize + "]=" + arr[i % maxSize]);
        }

    }

    public int arrUsefulSize(){
        int count =0;
        for (int i = 0; i < maxSize; i++) {
            if(arr[i]!=0){
                count++;
            }
        }
        return count;
    }

}
