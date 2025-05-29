import java.util.Stack;
// Time Complexity : push - O(n), pop - O(1), peek - O(1), empty - O(1)
// Space Complexity : O(n) - due to usage of two stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// -> Initially, understanding how to reverse elements to simulate queue behavior with a stack was tricky,
//    but using two stacks makes it manageable by inverting order twice.
// Approach:
// Use two stacks (s1 and s2) to simulate a queue.
// We maintain s1 such that its top always represents the front of the queue.
// To achieve this, during each push:
// 1. Move all elements from s1 to s2.
// 2. Push the new element onto s1 (it becomes the last in line).
// 3. Move all elements back from s2 to s1 so that the queue order is preserved.
// This makes push O(n), but allows O(1) pop and peek operations.

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push element to the back of queue
    // Time Complexity: O(n) - because all elements are moved twice
    public void push(int x) { 
        // Move all elements from s1 to s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        // Push new element onto the empty s1
        s1.push(x);
        // Move elements back to s1 to maintain queue order
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        // Print s1 for debugging
        System.out.println("Current queue (as stack s1): " + s1);
    }
    
    // Remove the element from front of queue
    // Time Complexity: O(1)
    public int pop() { 
        return s1.pop();
    }
    
    // Get the front element
    // Time Complexity: O(1)
    public int peek() { 
        return s1.peek();
        
    }
    
    // Check if queue is empty
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
    
        //Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);

        int param_2 = obj.pop();
        System.out.println("Popped Parameter : " + param_2);

        // Print s1 for debugging
        System.out.println("After Popping: " + obj.s1);
        
        int param_3 = obj.peek();
        System.out.println("Peeked Parameter : " + param_3);
        
        boolean param_4 = obj.empty();
        System.out.println("Is Stack Empty? : " + param_4);
    }
}

