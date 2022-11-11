// Time Complexity : 
//      push(), empty(): O(1)
//      pop(), peek():   O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


class MyQueue {
stack<int> inStack;
stack<int> outStack;
public:
    // move all elements from inStack to outStack
    void pushToOut(){
        while(!inStack.empty()){
            outStack.push(inStack.top());
            inStack.pop();
        }
    }
    
    // just push to inStack
    void push(int x) {
        inStack.push(x);
    }
    
    // if outStack is empty, push all in elements from inStack to outStack
    int pop() {
        if(outStack.empty()){
            pushToOut();
        }

        // just return the popped element from outStack
        int res = outStack.top();
        outStack.pop();
        return res;
    }
    
    // same as pop, excpet don't pop
    int peek() {
        if(outStack.empty()){
            pushToOut();
        }
        return outStack.top();
    }
    
    // if both stacks are empty, queue is empty
    bool empty() {
        return (inStack.empty() and outStack.empty());
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