import java.util.Stack;

class MyQueue {
    Stack<Integer> queueEntry;
    Stack<Integer> queueExit;

    public MyQueue() {
        this.queueEntry = new Stack<Integer>();
        this.queueExit = new Stack<Integer>();
    }
    
    public void push(int x) {
        queueEntry.push(x);
    }
    
    public int pop() {
        this.peek();
        return queueExit.pop();
    }
    
    public int peek() {
        if(queueExit.isEmpty()){
            while(!queueEntry.isEmpty()){
                queueExit.push(queueEntry.pop());
            }
        }
        return queueExit.peek();
    }
    
    public boolean empty() {
        return queueEntry.isEmpty() && queueExit.isEmpty();
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