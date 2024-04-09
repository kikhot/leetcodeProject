package com.xtu;

import java.util.Objects;
import java.util.Stack;

public class LC150 {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String ch = tokens[i];
            if (Objects.equals(ch, "+") || Objects.equals(ch, "-")
                    || Objects.equals(ch, "*") || Objects.equals(ch, "/")) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int sum = 0;
                switch (ch) {
                    case "+":
                        sum = a + b;
                        break;
                    case "-":
                        sum = a - b;
                        break;
                    case "*":
                        sum = a * b;
                        break;
                    case "/":
                        sum = a / b;
                        break;
                }
                stack.push(String.valueOf(sum));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        evalRPN(new String[]{"4","13","5","/","+"});
    }
}
