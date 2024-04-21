package com.xtu;

public class LC92 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode node = result;
        // 将 node 移到 left 的位置
        for (int i = 0; i < left - 1; i++) {
            node = node.next;
        }

        ListNode leftHeadNode = node;
        ListNode insertNode = node.next;
        ListNode tailNode = null;
        for (int i = left; i <= right; i++) {
            //头插法
            if (i == left) {
                tailNode = node.next;
            }
            ListNode tempNode = insertNode;
            insertNode = insertNode.next;
            tempNode.next = leftHeadNode.next;
            leftHeadNode.next = tempNode;
        }

        if (tailNode != null) {
            tailNode.next = insertNode;
        }

        return result.next;

    }

}
