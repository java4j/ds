package com.qianjin.ds;

/**
 * 链表
 *
 * @see java.util.LinkedList
 */
public class LinkList {
    /**
     * 头节点
     */
    private Node head;

    public LinkList() {

    }

    public LinkList(Node head) {
        this.head = head;
    }

    /**
     * 增加节点
     */
    public LinkList addNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node prev = head;
            Node next = prev.next;
            while (next != null) {
                prev = next;
                next = prev.next;
            }
            prev.next = node;
        }
        return this;
    }

    /**
     * 链表反转
     *
     * @return
     */
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node n1 = head;
        Node n2 = head.next;
        Node n3;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        head.next = null;
        head = n1;
    }

    /**
     * 打印
     */
    public void print() {
        Node next = head;
        while (next != null) {
            System.out.print(next.a);
            next = next.next;
            if (next != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    static class Node {
        int a;
        Node next;

        public Node(int a) {
            this.a = a;
        }

        public Node(int a, Node next) {
            this.a = a;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addNode(new Node(5)).addNode(new Node(7)).addNode(new Node(6));
        linkList.print();
        linkList.reverse();
        linkList.print();
    }
}
