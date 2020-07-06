package cn.wei.ds;

public class Joseph {
    private Node first;
    private Node helper;
    private int length;

    public Node generateLinkedList(int length) {
        if (length < 1) {
            return null;
        }
        this.length = length;
        Node current = null;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                first = new Node(0, first);
                current = first;
            } else {
                Node node = new Node(i, first);
                current.setNext(node);
                current = node;
            }
        }
        return first;
    }

    public void printList() {
        Node next = first;
        while (next != first) {
            System.out.println("node = [" + next + "]");
            next = next.getNext();
        }
    }

    public void resolveJoseph(int startIndex, int interval) {
        if (startIndex > length) {
            return;
        }
        for (int i = 0; i < startIndex; i++) {
            if (first.getIndex() == startIndex) {
                break;
            }
            helper = first;
            first = first.getNext();
        }
        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < interval - 1; i++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.println(first.getIndex());
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

class Node {
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
