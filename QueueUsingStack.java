//Time Complexity O(1)
//Space Complexity O(n)
//Yes
//No

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        this.stack1.push(x);
    }
    
    public int pop() {
        peek();
        return this.stack2.pop();
    }
    
    public int peek() {

        if(this.stack2.isEmpty()){    //If stack2 is empty pop the elements from stack1 and push the elements to stack2 till stack1 is not empty
            while(!stack1.isEmpty()){
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2.peek();
    }
    
    public boolean empty() {
        if(this.stack1.isEmpty()&&this.stack2.isEmpty()){
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
