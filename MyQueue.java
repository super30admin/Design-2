// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: We have 2 stack in and out.
// For push operations we push the elements in the instack. Out stack is empty until a pop operation comes.
// When there is a Pop operation, check if outstack is empty, if empty, then remove
// all elements from instack to outstack. 
// If a pop operation occurs and the outstack is full, pop the topmost element of the outstack.
class MyQueue {
    
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        // if outstack is empty call all elements from instack else
        // get the first element of the outstack
        peek(); 
        return out.pop();
    }
    
    public int peek() {  //front of the outstack is the head of the queue
        if(out.isEmpty()){ //but if outstack is empty
            while(!in.isEmpty()){
                out.push(in.pop()); //pop from instack push in outstack
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}