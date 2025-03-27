// Time Complexity : O(1) amortized for all operations.
// Space Complexity : O(n) , where n is the number of elements pushed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach
// Implemented queue using two stacks
// Push happens in inStack
// Pop and peek transfer elements into outStack only if OutStack is empty and then pop or peek.
import java.util.Stack;
class MyQueue {

    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();

    }

    public void push(int x) {
        inSt.push(x);
    }

    public int pop() {
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();
    }

    public int peek() {
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
    }

    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
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