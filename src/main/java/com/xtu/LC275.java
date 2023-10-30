package com.xtu;

public class LC275 {
    public static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int len = citations.length;
        //左闭右开
        while (left <= right) {
            int mid = (right + left) / 2;
            if (citations[mid] > len - mid) {
                right = mid - 1;
            } else if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                return len - mid;
            }
        }
        return len - left;
    }

    public static void main(String[] args) {
        hIndex(new int[]{1, 3, 100});
    }
}
