// Push to s1 (O(1))  
// Pop from s2, move s1 to s2 if empty (O(1) amortized)  
// Peek first element from s2, move s1 to s2 if empty (O(1) amortized)  
// Check if both stacks are empty (O(1))  

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        if(s1.isEmpty()){
            front = x;
        }
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
            return front;
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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