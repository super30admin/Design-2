// Time Complexity :O(n)
// Space Complexity :
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

import java.util.*;

class MyQueue {
    Stack<Integer> stkQueue;
    Stack<Integer> queue;

    public MyQueue() {
        stkQueue = new Stack<>();
        queue = new Stack<>();
    }

    public void push(int x) {
        System.out.println("push value " + x);
        stkQueue.push(x);
    }

    public int pop() {
        peek();
        int x = queue.pop();
        System.out.println("pop value " + x);
        return x;

    }

    public int peek() {
        if (queue.isEmpty()) {
            while (!stkQueue.isEmpty()) {
                int n = stkQueue.pop();//popping from the original stack to reverse the order as acceptible by in a queue
                queue.push(n);
                System.out.println("Pop push value " + n);
            }
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty() && stkQueue.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */