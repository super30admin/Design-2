// Time Complexity : pop,peek,empty - O(1) and for push its O(n)
// Space Complexity : O(n) -- not sure about this
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to brainstorm with regards to 2 stack method.
/* When we put something into stack1 to make it FIFO as Queue -- 
 * we need to always have the newly coming element at the very bottom of the stack and the oldest one at the very top.
 * Hence we try to empty the stack1 at the very first (by adding the popped elements one by one to stack2 - 
 * then push the new element to stack1 -- and then again push the elements back from stack2 to stack1 
 * newElement=3 - stack1=9 stack2=empty; -- stack2 = 9;stack1 = 3 -- stack1=3,9; stack2=empty ;
 * Basically swapping the elements using 2 stacks
 */


// Your code here along with comments explaining your approach


import java.util.*;
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int firstElement = -1;
public MyQueue() {
    stack1 = new Stack<Integer>();
    stack2 = new Stack<Integer>();
}

public void push(int x) {
    while(!stack1.empty()){
        stack2.push(stack1.pop());
    }
    stack2.push(x);
    while(!stack2.empty()){
        stack1.push(stack2.pop());
    }
    
}
public int pop() {
    
    return stack1.pop();
}

public int peek() {
    if(!stack1.empty()) return stack1.peek();
    return 0;
}

public boolean empty() {
    return stack1.empty();
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