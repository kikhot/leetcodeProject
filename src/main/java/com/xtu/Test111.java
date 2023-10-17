package com.xtu;

public class Test111 {
    //快速排序
    public static void quickSort(int nums[], int left, int right) {
        if (left > right) {
            return;
        }
        int flag = nums[0];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[j] >= flag) {
                j--;
            }
            while (nums[i] <= flag) {
                i++;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4,5,2};
        quickSort(nums, 0, 5);
        System.out.println("h");
    }
}
