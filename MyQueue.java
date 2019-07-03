import java.util.*;
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {                
        if(out.empty()){
            while(!in.empty()){
                out.push(in.pop());
            }
        }        
        return out.pop();        
    }
    
    /** Get the front element. */
    public int peek() {
        if(out.empty()){
            while(!in.empty()){
                out.push(in.pop());
            }
        } 
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty() && out.empty();    
    }

    public static void main(String[] args){
        System.out.println("Queue to Stack Implementation");
        MyQueue q = new MyQueue();  
    q.push(1);  
    q.push(2);  
    q.push(3);  
  
    System.out.println(q.pop());  
    System.out.println(q.peek());  

    System.out.println(q.pop()); 
    System.out.println(q.pop()); 
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