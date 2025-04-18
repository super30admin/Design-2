// Time Complexity : O(1) amortized for push, pop, and peek
// Space Complexity : O(n), n-number of elements in queue
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use two stacks one to add elements, the other to remove them in correct order.
// When we want to remove or see the front element, we move all items from st1 to st2, only if st2 is empty.
// The last element added becomes the first to be removed.


import java.util.*;

class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
public MyQueue() {
    this.st1=new Stack<>();
    this.st2=new Stack<>();
}

public void push(int x) {
    st1.push(x);
}

public int pop() {
    if(st2.isEmpty()){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
    }
    return st2.pop();
}

public int peek() {
    if(st2.isEmpty()){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
    }
    return st2.peek();
}

public boolean empty() {
    if (st1.isEmpty() && st2.isEmpty()){
        return true;
    }
    return false;
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