// Time Complexity : O(1) For Push, Pop & Empty operations
// Space Complexity : O(1) For Push, Pop & Empty operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyQueue {

    Stack<Integer> inStack = new Stack();
    Stack<Integer> outStack = new Stack();

    public MyQueue() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop()
    {
        this.peek();
        return outStack.pop();
    }

    public int peek()
    {
        if(outStack.isEmpty())
        {
            while(!inStack.isEmpty())
            {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty()
    {
        return outStack.isEmpty() & inStack.isEmpty();
    }
}
