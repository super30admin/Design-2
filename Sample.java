//Problem 1(https://leetcode.com/problems/implement-queue-using-stacks/)
// Time Complexity :O(1) in best case and O(n) in worst case
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach


//used two stack to implement queue
class MyQueue {

    private Stack<Integer> st1;
    private Stack<Integer> st2;
   
    public MyQueue() {
     st1 = new Stack<>(); 
     st2 = new Stack<>();  
    }
    
    public void push(int x) {  
      st1.push(x);
    }
    
    public int pop() {
       peek();
       return st2.pop();
    }
    
    public int peek() {
        if(st2.isEmpty())
        {
           while(!st1.isEmpty())
           {
               st2.push(st1.pop());
           }
        }
       return st2.peek(); 
    }
    
    public boolean empty() {
      return st1.isEmpty() && st2.isEmpty(); 
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
