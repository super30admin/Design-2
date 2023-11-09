//Time Complexity - amoritized O(1) for push,pop,peek operations
//Space Complexity - O(n) for push,pop,peek operations
class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(empty()) return -1;
        peek();
        return outStack.pop();
    }
    
    public int peek() {
        if(empty()) return -1;
        if(!outStack.isEmpty()) return outStack.peek();
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
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