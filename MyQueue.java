
// Here we are using two stacks: one for 'in' and another for 'out'.  
// New elements are always pushed onto the 'in' stack.  
// When we need to pop, we first check if 'out' is empty.  
// If 'out' is empty, we move all elements from 'in' to 'out', reversing their order.  
// Then we pop the element from the 'out' stack.  
// This ensures the queue order (FIFO) is maintained.
import java.util.*;
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in= new Stack<>();
        this.out= new Stack<>();
        
    }
    //O(1)
    public void push(int x) {
        in.push(x);
        
    }
    
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                int x= in.pop();
                out.push(x);
            }
        }
        return out.pop();
        
        
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                int x= in.pop();
                out.push(x);
            }
        }
        return out.peek();

        
    }
    
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
        
    }
}

