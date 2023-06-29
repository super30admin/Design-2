/*
 * Time Complexity
 * push -- O(1)
 * pop, peek -- Ammortized O(1)
 * empty --- O(1)
 * Space Complexity
 * O(N)
 */

import java.util.Stack;
class MyQueue {
    Stack<Integer> stk1;
    Stack<Integer> stk2;
    public MyQueue() {
        this.stk1 = new Stack<>();
        this.stk2 = new Stack<>();
    }
    
    public void push(int x) {
        this.stk1.push(x);   
    }
    
    public int pop() {
        if(this.stk2.isEmpty()){
            while(!this.stk1.isEmpty()){
                this.stk2.push(this.stk1.pop());
            }
        }
        return this.stk2.pop();
    }
    
    public int peek() {
        if(this.stk2.isEmpty()){
            while(!this.stk1.isEmpty()){
                this.stk2.push(this.stk1.pop());
            }
        }
        return this.stk2.peek();
    }
    
    public boolean empty() {
        return this.stk1.isEmpty() && this.stk2.isEmpty();
    }

    public static void main(String[] args){
        MyQueue obj = new MyQueue();
        obj.push(10);
        obj.push(11);
        obj.push(12);
        obj.pop();
        System.out.println(obj.peek());
        System.out.println(obj.empty());
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