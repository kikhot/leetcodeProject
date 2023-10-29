package com.xtu;

public class LC100102 {
    public long minSum(int[] nums1, int[] nums2) {
        // 遍历nums1,nums2，统计nums1和nums2中有多少个0
        long zero1 = 0;
        long zero2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0)
                zero1++;
            else
                sum1 += nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0)
                zero2++;
            else
                sum2 += nums2[i];
        }

        //如果nums1或者nums2没有0,则没有0的那个数组只能大于有0数组加上0的个数
        if (zero1 == 0 && zero2 == 0) {
            if (sum1 == sum2)
                return sum1;
            else
                return -1;
        }
        if (zero1 == 0) {
            if (sum1 < sum2 + zero2)
                return -1;
            else
                return sum1;
        }
        if (zero2 == 0) {
            if (sum2 < sum1 + zero1)
                return -1;
            else
                return sum2;
        }

        //如果nums1和nums2都有0，则比较nums1和nums2中加上0个数之后最大的数
        return (sum1 + zero1) > (sum2 + zero2) ? sum1 + zero1 : sum2 + zero2;
    }
}
