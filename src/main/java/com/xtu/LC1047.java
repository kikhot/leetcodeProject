package com.xtu;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class LC1047 {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
