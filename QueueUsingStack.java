// Time Complexity :O(1) for push,empty. O(n) for pop, peek
// Space Complexity : O(1)  for push,pop,peek,empty
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
       this.s1 = new Stack<>();
       this.s2 = new Stack<>(); 
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
