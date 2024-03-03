// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
public class QueueUsingStack {
    public Stack inStack;
    public Stack outStack;

    public QueueUsingStack() {
        this.inStack = new Stack();
        this.outStack = new Stack();
    }

    public void push(int x) { // Time Complexity : O(1)
        // when pushing push to inStack
        inStack.push(x);
    }

    public int pop() {// Time Complexity : O(1) avg, shifting of elements will not happen everytime
        // first check if outStack is empty or not, if not pop from outStack directly.
        // but if it is empty then pop all items from inStack and push to outStack

        // if not empty
        if(!outStack.isEmpty()) {
            return (int) outStack.pop();
        }
        // empty
        while(!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return (int) outStack.pop();
    }

    public int peek() { // Time Complexity : O(1) avg, shifting of elements will not happen everytime
        // check if outStack is empty , if not empty directly peek from outStack
        // if not empty
        if(!outStack.isEmpty()) {
            return (int) outStack.peek();
        }
        // if outStack is empty, then pop all elements from inStack and push to outStack until inStack becomes empty
        while(!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return (int) outStack.peek();

    }

    public boolean empty() {// Time Complexity : O(1)
        if(inStack.isEmpty() && outStack.isEmpty()) return true;
        return false;
    }

}
