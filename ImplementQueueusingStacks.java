// Time Complexity : Amortized O(1) average case, worst case - O(n) for pop & peek
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
Maintain 2 stacks one for push operation and other for pop, peek operations. Whenever pop/peek happens,
push all the elements from inStack to outStack if outStack is empty, this way, we can have queue property
satisfied whenever peek or pop are called. As per question, all calls to pop and peek are valid, so
we need not check explicitly, if not, we need to validate inStack is not empty in those methods and return
-1 if so.
 */

class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
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