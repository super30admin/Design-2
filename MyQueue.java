// Time Complexity : O(N) to pop O(1) to push
// Space Complexity : O(N) where n of integers in any of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: using two stacks in and out. 


import java.util.Stack;

class MyQueue {
    
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
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
    }

    public static void main(String args[]){
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
        
    }
}

