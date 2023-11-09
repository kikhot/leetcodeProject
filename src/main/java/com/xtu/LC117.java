package com.xtu;

public class LC117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        return null;
    }

    public static void main(String[] args) {
        LC2103 temp = new LC2103(null);
        System.out.println(temp.getA());
    }
}
