import java.util.Stack;
/*
 * Approach was to use two stacks (s1 and s2) and do all the push operations into s1. For peek operation ie for
 * the front of a queue we pop the contents for s1 into s2 so the element order is reversed and s2 stores data in FIFO order.
 * If s2 is popped the initial value pushed at s1 is removed (ie front of the queue) and again the contents of s2 are 
 * emptied into s1 by popping and pushing.
 * 
 * Time Complexity :
 * push() - O(1)
 * pop(), peek()-  O(N) as content of one stack has to be popped into another stack and vice versa
 * 
 * Space Complexity :
 * Space complexity is O(2N)
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : None
 */
class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();

    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        while(!s1.isEmpty())
            s2.push(s1.pop());
        
        int poppedVal= s2.pop();

         while(!s2.isEmpty())
            s1.push(s2.pop());
       return poppedVal;
    }
    
    public int peek() {
         while(!s1.isEmpty())
            s2.push(s1.pop());
        
         int peekVal= s2.peek();

         while(!s2.isEmpty())
            s1.push(s2.pop());

       return peekVal;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
