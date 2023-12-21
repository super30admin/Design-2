// Accepted on leetcode
// So the idea i had in start was i took 2 stacks when ever i had to pop i shifted all elements from stack 1 to stack 2 ; poped the top and re-shifted the elements back to stack 1. Later i went to optimize it by maintining 2 stacks in such a way that evey time I dont need to shift all elements back and forth.
// Time complexites Push O(1) , peek and pop is O(1) amotized empty is O(1)




import java.util.Stack;

class MyQueue {
    Stack<Integer> x;
    Stack<Integer> y;

    public MyQueue() {
        this.x = new Stack<>();
        this.y = new Stack<>();

        
    }
    
    public void push(int n) {
        x.push(n);
 
        
    }
    
    public int pop() {
        peek();
        return y.pop();
        
    }
    
    public int peek() {
        if(y.empty()){
            while(!x.empty()){
                y.push(x.pop());

            }
        }
        return y.peek();
    }
    
    public boolean empty() {
        if(x.empty() && y.empty()){
            return true;
        }
        else{
            return false;
        }
        
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