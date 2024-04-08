package com.xtu;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode node = new ListNode(0);
        node.next = head;
        while (node.next != null) {
            ListNode temp = node.next;
            node.next = node.next.next;
            temp.next = result.next;
            result.next = temp;
        }
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
