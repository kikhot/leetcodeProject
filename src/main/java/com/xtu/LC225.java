package com.xtu;

import java.util.LinkedList;
import java.util.Queue;

public class LC225 {
    class MyStack {

        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.poll());
            }
            return queue.poll();
        }

        public int top() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.poll());
            }
            int result = queue.peek();
            queue.add(queue.poll());
            return result;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
