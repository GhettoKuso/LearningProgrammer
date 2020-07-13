package cn.wei.ds;

public class Joseph {
    //头节点
    private Node first;
    //辅助节点,位于头节点之后
    private Node helper;
    private int length;

    /*
     * <p>构建一个单向循环链表</p>
     * @param length 链表长度
     * @version 0.1.0
     * @return cn.wei.ds.Node 头节点
     * @author SunWei
     * @date 2020/7/14 0:11
     * @since 0.1.0
    */
    public Node generateLinkedList(int length) {
        if (length < 1) {
            return null;
        }
        this.length = length;
        Node current = null;
        for (int i = 0; i < length; i++) {
            if (i == 0) { //第一个节点自己指向自己
                first = new Node(0, first);
                current = first;
            } else {//插入节点
                Node node = new Node(i, first);
                current.setNext(node);
                current = node;
            }
        }
        return first;
    }

    /*
     * <p>打印链表情况</p>
     * @param
     * @version 0.1.0
     * @return void
     * @author SunWei
     * @date 2020/7/14 0:15
     * @since 0.1.0
    */
    public void printList() {
        Node next = first;
        while (next != first) {
            System.out.println("node = [" + next + "]");
            next = next.getNext();
        }
    }

    /*
     * <p>约瑟夫问题实现</p>
     * @param startIndex 起始位置
     * @param interval 计数间隔
     * @version 0.1.0
     * @return void
     * @author SunWei
     * @date 2020/7/14 0:15
     * @since 0.1.0
    */
    public void resolveJoseph(int startIndex, int interval) {
        if (startIndex > length) {
            return;
        }
        //找到起始位置,将头节点指向起始位置,辅助节点指向头节点之前
        for (int i = 0; i < startIndex; i++) {
            if (first.getIndex() == startIndex) {
                break;
            }
            helper = first;
            first = first.getNext();
        }

        while (true) {
            if (helper == first) {//头结点和辅助节点都指向同一位置,表示链表中只有一个元素了
                break;
            }
            for (int i = 0; i < interval - 1; i++) {//遍历链表,移动头节点和辅助节点
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.println(first.getIndex());//当前节点需要剔除
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("last:" + first.getIndex());
    }

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        joseph.generateLinkedList(10);
        joseph.printList();
        joseph.resolveJoseph(2, 3);
    }
}

