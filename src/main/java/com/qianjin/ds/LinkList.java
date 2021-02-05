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
            head.addNext(node);
        }
        return this;
    }

    /**
     * 链表反转
     *
     * @return
     */
    public void reverse() {
        head = reverse(head);
    }

    /**
     * 打印
     */
    public void print() {
        print(head);
    }

    /**
     * 链表反转静态方法
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 需要定义三个临时变量
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
        return head;
    }

    /**
     * 打印静态方法
     *
     * @param head
     */
    public static void print(Node head) {
        Node next = head;
        while (next != null) {
            System.out.print(next.val);
            next = next.next;
            if (next != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    /**
     * 合并两个有序的列表，使用递归的方式
     *
     * @return 合并后的头结点
     */
    public static Node mergeSequentialLists(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        Node head = null;
        if (n1.val <= n2.val) {
            head = n1;
            head.next = mergeSequentialLists(n1.next, n2);
        } else {
            head = n2;
            head.next = mergeSequentialLists(n1, n2.next);
        }
        return head;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node addNext(int val) {
            Node node = new Node(val);
            return addNext(node);
        }

        public Node addNext(Node node) {
            Node prev = this;
            Node next = prev.next;
            while (next != null) {
                prev = next;
                next = prev.next;
            }
            prev.next = node;
            return this;
        }
    }


    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.addNode(new Node(5)).addNode(new Node(6)).addNode(new Node(7));
        linkList.print();
        linkList.reverse();
        linkList.print();

        Node n1 = new Node(1);
        n1.addNext(2).addNext(5).addNext(7);
        Node n2 = new Node(3);
        n2.addNext(4).addNext(6).addNext(9);
        Node n = mergeSequentialLists(n1, n2);
        print(n);
    }
}
