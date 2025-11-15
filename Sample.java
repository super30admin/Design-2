// Time Complexity : O(1) amortized for push, pop, peek
// Space Complexity : O(n) where n is the number of elements in the queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach

I created two stacks and
used one staack for pushing and other for poping and peeking.
When pop or peek is called, I checked if the outStack is empty.If it is empty, I transferred all elements from inStack to outStack.

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack= new Stack<Integer>();
        outStack= new Stack<Integer>();
    }

    public void push(int x) {
        inStack.push(x);

    }

    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        if(outStack.isEmpty()&&inStack.isEmpty()){
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
