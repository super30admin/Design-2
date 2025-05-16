//Problem1: Implement Queue using Stacks
// Time Complexity : push() - O(1), pop() - WC O(n), peek- O(n), isEmpty() - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using 2 stacks s1 and s2 where I'll be pushing element in s1 stack and for pop operation will be done from s2 stack
//During first pop() TC willl be O(n) but later for rest of pop() it will O(1)


class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
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
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
        
    }
}
