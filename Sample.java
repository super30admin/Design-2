// Time Complexity : Amortized - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* 
Implemented using two stack approach where in stack keeps pushing the elements to bottom of stack and when peek/pop is being
called we transfer the elements to out stack and retrieve the elements
*/
class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x); //push element x to the instack
    }
    
    public int pop() {
        if (empty()) return -1; //nothing to be popped when intack and outstacks are empty
        peek();  //to retrieve the element at the top of outstack
        return outStack.pop();  //remove the element at the top of outstack
    }
    
    public int peek() {
        if (outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop()); //push the elements from instack to outstack
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();   
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
