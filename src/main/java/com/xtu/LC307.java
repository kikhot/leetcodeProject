package com.xtu;

/**
 * 使用树状数组的数据结构进行处理
 */
public class LC307 {

    class NumArray {

        private int[] tree;
        private int[] primNums;

        public NumArray(int[] nums) {
            tree = new int[nums.length + 1];
            primNums = nums;
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            add(index + 1, val - primNums[index]);
            primNums[index] = val;
        }

        public int sumRange(int left, int right) {
            return prefixSum(right + 1) - prefixSum(left);
        }

        /**
         * 计算一个数二进制数为 1 的最小位数
         *
         * @param num
         * @return
         */
        private int lowBit(int num) {
            return num & -num;
        }

        private void add(int index, int val) {
            while (index < tree.length) {
                tree[index] += val;
                index += lowBit(index);
            }
        }

        private int prefixSum(int index) {
            int result = 0;
            while (index > 0) {
                result += tree[index];
                index -= lowBit(index);
            }
            return result;
        }
    }
}
