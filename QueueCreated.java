
//QueueCreate
// Time Complexity :
//O(n)
// Space Complexity :
//O(n)
// Did this code successfully run on Leetcode :
//yes
// Any problem you faced while coding this :
//syntax errors

//Declaring class and 2 stacks
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }
    //pusing value into 1st stack
    public void push(int x) {
        in.push(x);

        
    }
    //While popping calling peek() method and returning output
    public int pop() {
        peek();
        return out.pop();
        
    }
    //if in stack is not empty then push its elements to out stack
    public int peek() {
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    //returning true if in and out both are empty
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
        
    }
}

// **
//  * Your MyQueue object will be instantiated and called as such:
//  * MyQueue obj = new MyQueue();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.peek();
//  * boolean param_4 = obj.empty();
//  */