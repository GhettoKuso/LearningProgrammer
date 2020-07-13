package cn.wei.ds;
public class Node {
    private int index;
    private Node next;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int index, Node next) {
        this.index = index;
        this.next = next;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                "next=" + next.index +
                '}';
    }
}
