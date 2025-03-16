// Time Complexity : push O(1), peek() and pop() -> O(n)   -> amortized complexity O(1) for all operations
// Space Complexity : O(n) -> store stacks
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no problems faced
// Approach - Two stacks are used. One for pushing new elements and other for pop and peek functions.


import java.util.Stack;

public class MyQueue {

    private Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(s2.empty()) {
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        } else {
            return s2.pop();
        }
    }

    public int peek() {
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        } else {
            return s2.peek();
        }
    }

    public boolean empty() {
        return (s1.empty() && s2.empty());
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Peek after pop: " + queue.peek());
        System.out.println("Is empty? " + queue.empty());
        System.out.println("Pop: " + queue.pop());
        System.out.println("Is empty? " + queue.empty());
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