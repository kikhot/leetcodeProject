package com.xtu;

import java.util.Stack;

public class LC232 {
    class MyQueue {

        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void push(int x) {
            pushStack.push(x);
        }

        public int pop() {
            if (popStack.empty()) {
                while (!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        public int peek() {
            if (popStack.empty()) {
                while (!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }

        public boolean empty() {
            return popStack.empty() && pushStack.empty();
        }
    }
}
