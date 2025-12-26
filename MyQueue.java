//Here we will approach this problem with 2 stacks, lets say inStack and outStack
//In inStack stack we will push the elements 
//If outStack is empty then we will store popped elements from inStack to our outStack
//We will then pop from outStack to reach FIFO state


class MyQueue {
    Stack <Integer> inStack;
    Stack <Integer> outStack;

    public MyQueue() {
        this.inStack=new Stack<>();
        this.outStack=new Stack<>();
    }


    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
              outStack.push(inStack.pop());
            }
        }
        return outStack.pop();

    }
    
    public int peek() {
        
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
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