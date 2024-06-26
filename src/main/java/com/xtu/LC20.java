package com.xtu;

import java.util.Stack;

public class LC20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (!stack.empty() && stack.peek() == s.charAt(i))
                        stack.pop();
                    else
                        return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        isValid("()");
    }
}
