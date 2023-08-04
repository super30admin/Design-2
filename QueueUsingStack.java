// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes

class QueueUsingStack {
// Declaring two stack one for in and other for out.
// When we pop we will pop from out, if out is empty will fil out from popping in
    Stack<Integer> in;
    Stack<Integer> out;

    public QueueUsingStack() {
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
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */