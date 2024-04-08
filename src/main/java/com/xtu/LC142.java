package com.xtu;

public class LC142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode != null && slowNode == fastNode) {
                ListNode node1 = head;
                ListNode node2 = slowNode;
                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
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
