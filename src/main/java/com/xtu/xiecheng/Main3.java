package com.xtu.xiecheng;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            stack.push(num);
        }
        int resultCount = 0;
        while (!stack.empty()) {
            int num = stack.pop();
            if (!isSu(num)) {
                resultCount++;
            } else {
                // 是素数，将后面的两个数取出来
                if (stack.size() >= 1) {
                    int num1 = stack.pop();
                    if (!isSu(num1)) {
                        resultCount = resultCount + 2;
                    } else {
                        if (stack.size() >= 1) {
                            int num2 = stack.pop();
                            if (!isSu(num2)) {
                                stack.push(num2);
                                int sum = num1 + num;
                                stack.push(sum);
                            } else {
                                int sum1 = num1 + num;
                                int sum2 = num1 + num2;
                                if (isSu(sum2)) {
                                    stack.push(sum2);
                                    stack.push(num);
                                } else {
                                    stack.push(num2);
                                    stack.push(sum1);
                                }
                            }
                        } else {
                            int sum = num1 + num;
                            stack.push(sum);
                        }
                    }
                } else {
                    resultCount++;
                }
            }
        }

        System.out.println(resultCount);

    }


    public static boolean isSu(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
