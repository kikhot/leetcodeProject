package com.xtu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TXTest11 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode solve(ListNode[] a){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            ListNode node = a[i];
            while(node != null){
                list.add(node.val);
                node = node.next;
            }
        }
        System.out.println("hello");
        Collections.sort(list);
        ListNode result = new ListNode(1);
        ListNode pre = result;
        for(Integer num : list){
            pre.val = num;
            pre = pre.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode[] a = new ListNode[3];
        a[0] = new ListNode(1);
        a[0].val = 1;
        a[0].next.val = 3;
        a[0].next.next.val = 5;
        a[1].val = 2;
        a[1].next.val = 4;
        a[1].next.next.val = 6;
        a[2].val = 1;
        a[2].next.val = 2;
        a[2].next.next.val = 3;
        a[2].next.next.next.val = 4;
        a[2].next.next.next.next.next.val = 5;
        a[2].next.next.next.next.next.next.val = 6;
        solve(a);
    }

}
