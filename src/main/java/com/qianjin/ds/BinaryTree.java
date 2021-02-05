package com.qianjin.ds;

import java.util.LinkedList;

/**
 * 二叉树的各种操作，是纯的二叉树
 */
public class BinaryTree {
    private Node root;

    BinaryTree(Node root) {
        this.root = root;
    }

    public void print() {

    }

    /**
     * 获取树的深度
     *
     * @param node
     * @return
     */
    public static int getDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getDepth(node.left), getDepth(node.right));
        }
    }

    /**
     * 前序遍历， 根->左->右
     *
     * @param node
     */
    public static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "\t");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历， 左->根->右
     *
     * @param node
     */
    public static void middleOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        middleOrderTraverse(node.left);
        System.out.print(node.val + "\t");
        middleOrderTraverse(node.right);
    }

    /**
     * 后序遍历，左->右->根
     *
     * @param node 二叉树节点
     */
    public static void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val + "\t");
    }

    /**
     * 层序遍历，每层从左往右依次遍历
     *
     * @param node 二叉树节点
     */
    public static void levelOrderTraverse(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.pop();
            System.out.print(node.val + "\t");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void addLeftNode(Node parent, Node child) {
        parent.left = child;
    }

    public static void addRightNode(Node parent, Node child) {
        parent.right = child;
    }

    protected static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node setLeft(int val) {
            return setLeft(new Node(val));
        }

        public Node setRight(int val) {
            return setRight(new Node(val));
        }

        public Node setLeft(Node node) {
            this.left = node;
            return node;
        }

        public Node setRight(Node node) {
            this.right = node;
            return node;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.setLeft(6).setLeft(7).setLeft(8);
        root.setRight(10).setRight(11).setRight(12).setRight(12);
        System.out.println(getDepth(root));

        preOrderTraverse(root);

        levelOrderTraverse(root);
    }
}
