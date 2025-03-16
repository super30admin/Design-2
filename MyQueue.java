// Time Complexity:
// push() - O(1) → Direct insertion into the input stack
// pop() - O(1) average case, O(n) worst case → If output stack is empty, we need to reverse input stack
// peek() - O(1) average case, O(n) worst case → Same reason as pop
// empty() - O(1) → Just checks if both stacks are empty

// Space Complexity:
// O(n) → Maximum size of the queue (total elements in both stacks)

import java.util.Stack;

public class MyQueue {
    Stack<Integer> inSt;
    Stack<Integer> outSt;
    public MyQueue(){
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
    }
    public void push(int x){
        inSt.push(x);
    }
    public int pop(){
        if (empty()) return -1;
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();
    }
    public int peek(){
        if(empty()) return -1;
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
    }
    public boolean empty(){
        return(inSt.isEmpty() && outSt.isEmpty());
    }

    
}
