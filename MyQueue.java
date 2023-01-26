// Time Complexity : push and isEmpty have time complexity O(1), pop and peek have average time complexity of O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


import java.util.Stack;

class MyQueue 
{
    Stack<Integer> in; // Two stacks in and out are declared and initialised in the constructor
    Stack<Integer> out;

    public MyQueue() 
    {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) // this function pushes element into the in stack 
    {
        in.push(x); 
    }
    
    public int pop() // the pop function removes elements from the start of the queue as follows : if out stack is empty, all elements of in are popped and pushed into out, then the topmost element is popped off. If out is not empty, we straight away pop the topmost element in the stack
    {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    public int peek() // prints topmost element if out is not empty, if so, all elements from in are popped and added to the out stack and the top most element is returned
    {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() // returns true if both in and out are empty else false is returned.
    {
        return out.isEmpty() && in.isEmpty();
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