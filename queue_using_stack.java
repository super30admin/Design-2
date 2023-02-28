import java.util.Stack;

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
class MyQueue {
    int count;
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
        count = 0;
    }
    
    // Time Complexity: O(n)
    public void push(int x) {
        while (!s2.empty()) {
            s1.push(s2.pop());
        }

        s1.push(x);
        count += 1;
    }
    
    // Time Complexity: O(n)
    public int pop() {
        // Empty s1 content into s2
        // to achieve FIFO order
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        
        int top = s2.pop();
        count -= 1;

        return top;
    }
    
    // Time Complexity: O(n)
    public int peek() {
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        
        return s2.peek();
    }
    
    // Time Complexity: O(1)
    public boolean empty() {
        return count == 0;
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