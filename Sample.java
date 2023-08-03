// Time Complexity :o(1)
// Space Complexity : length of the stack , avg case o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :none


// Your code here along with comments explaining your approach

"""
Declaration of 2 stacks
"""
class MyQueue {
    Stack<Integer>s1;
    Stack<Integer>s2;
    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    """
    push elements into stack1
    """

    public void push(int x) {
        s1.push(x);
    }

    """
    whenever an element is about to be popped, pop the elements from stack1 and push it to stack2 , get the peek from stack2, to get queue effetct
    """
    public int peek() {
        if(s2.isEmpty())
        {
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        }
        return s2.peek();
    }
    """
    get the peek element from s2, and pop it about"""

    public int pop() {
        peek();
        return s2.pop();
    }

    """
    check whether s1 and s2 are present
    """

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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