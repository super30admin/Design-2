
/*
Time Complexity
push() O(1)
pop() O(n) as worst but  average is O(1) because the popping will happen only if the out stack is empty.
peek() O(n) at worst but average will be O(1), worst case scenario would be same as pop if out stack is empty we would have to pop all the elements from in stack and in that case it will be O(n)
empty() O(1)

Space Complexity
Space O(1)
*/

//Implementing the queue using two stacks. 
// The first stack is used to store the elements in the order they are pushed, and the second stack is used to reverse the order of the elements when popping or peeking.


import java.util.Stack;

class MyQueue {
    private final Stack<Integer> in;
    private final Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
        
    }
    
    public void push(int x) {
        in.push(x);
        
    }
    
    public int pop() {
        peek();
        return out.pop();
        
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
        
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */