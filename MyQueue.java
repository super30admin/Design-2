// Time Complexity : Average case timecomplexity O(1) for push(), pop() and peek(). Worst case time complexity for pop() peek() is O(n)
// Space Complexity : O(2n) ----> O(n) as two stacks are being used
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);        
    }
    
    public int pop() {
        peek();
        return out.pop();        
    }
    
    public int peek() {
        if(out.empty())
        {
            while(!in.empty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return (in.empty() && out.empty());
}  

public static void main(String[] args)
{
    MyQueue mq = new MyQueue();
    mq.push(5);
    mq.push(3);
    mq.push(4);
    System.out.println(mq.peek());
    System.out.println(mq.pop());
}
}
