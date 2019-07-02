import java.util.*;
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // while(!s1.empty()){
        //     s2.push(s1.pop());
        // }
        // s1.push(x);
        // while(!s2.empty()){
        //     s1.push(s2.pop());
        // }
        s1.push(x);

        System.out.println("Stack " + s1);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        int x = s2.pop();
        return x;
        //return s1.pop();
        
       // return 0;
    }
    
    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty();    
    }

    public static void main(String[] args){
        System.out.println("Queue to Stack Implementation");
        MyQueue q = new MyQueue();  
    q.push(1);  
    q.push(2);  
    q.push(3);  
  
    System.out.println(q.pop());  
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