package com.xtu;



import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TXTest1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回节点权值1个数比0的个数多一的路径数
     *
     * @param root TreeNode类 权值为0和1的二叉树根节点
     * @return int整型
     */

    public Stack<Integer> path;
    public int result = 0;

    public int pathNumber(TreeNode root) {
        // write code here
        path.add(root.val);
        countPath(root);
        return result;
    }

    public void countPath(TreeNode root) {
        if (root.left == null && root.right == null) {
            if (isTrue(path)) {
                result++;
            }
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            countPath(root.left);
            path.pop();
        }
        if (root.right != null) {
            path.add(root.right.val);
            countPath(root.right);
            path.pop();
        }
    }

    public boolean isTrue(Stack<Integer> path) {
        Stack<Integer> tempPath = path;
        int count = 0;
        while (!tempPath.empty()) {
            int temp = path.pop();
            if (temp == 1) {
                count++;
            } else if (temp == 0) {
                count--;
            }
        }
        if (count == 1) {
            return true;
        }
        return false;
    }
}
