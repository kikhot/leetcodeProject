package com.xtu;

public class LC19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode();
        node.next = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        ListNode slowNode = new ListNode();
        slowNode.next = head;
        ListNode result = slowNode;
        while (node != null && node.next != null) {
            node = node.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return result.next;
    }

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
}
