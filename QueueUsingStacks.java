// Time Complexity : O(1) for push and O(n) for pop in worst case
// Space Complexity : O(n) number of elements added to stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes initially had problem with coming up with peek as s2 returned null when checking

public class QueueUsingStacks {
    Stack<Integer> s1;
    Stack<Integer> s2;

    private int front;

    public MyQueue() {
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();

    }

    public void push(int x) {
        if(s1.isEmpty()){
            front = x;
        }
        s1.push(x);

    }

    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
