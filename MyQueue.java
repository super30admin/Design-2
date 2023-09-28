
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyQueue {
    private Stack<Integer> front;
    private Stack<Integer> rear;
    public MyQueue() {
        front = new Stack<>();
        rear = new Stack<>();
    }
    
    public void push(int x) {
       rear.push(x); 
    }
    
    public int pop() {
        if(front.isEmpty()){
            while(!rear.isEmpty()){
                front.push(rear.peek());
                rear.pop();
            }
            if(front.isEmpty())
                return -1;
            
        }
        
        return front.pop();
    }
    
    public int peek() {
        if(front.isEmpty()){
            while(!rear.isEmpty()){
                front.push(rear.peek());
                rear.pop();
            }
            if(front.isEmpty())
                return -1;
            
        }
        
        return front.peek();
    }
    
    public boolean empty() {
        return front.isEmpty() && rear.isEmpty();
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