//Time complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
/*
 Instack is used to store values that are pushed.
 OutStack is used to store values that will be popped
 Whenever the OutStack is empty, we will push all the elements of
 InStack into outStack and pop them in InStack.
 */
class MyQueue {
public:
    /** Initialize your data structure here. */
    stack<int> inStack, outStack;
    MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        int temp = peek();
        outStack.pop();
        return temp;
    }
    
    /** Get the front element. */
    int peek() {
        if(outStack.empty()){
            while(!inStack.empty()){
                outStack.push(inStack.top());
                inStack.pop();
            }
        }
        return outStack.top();
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        return (inStack.empty() && outStack.empty());
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
