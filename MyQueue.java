// Time Complexity : O(1)
// Space Complexity : O(1)
/* Get two stacks and simply push elements in one until you get pop. 
 * For pop we store elements in the second array and pop the top.
 * the same is followed for peek and return the top.
 */
import java.util.Stack;

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    
    public MyQueue() {
        this.in = new Stack<Integer>();
        this.out = new Stack<Integer>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
        if (out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        if (in.isEmpty() && out.isEmpty()){
            return true;
        }
        return false;
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