package com.xtu;

public class LC203 {
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


    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        if (head == null) {
            return null;
        }
        node.next = head;
        ListNode result = node;
        while (node != null && node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return result.next;
    }
}
