/* two stack approach, if stack is not specified could use linkedlist
TC:
Push: O(1)
Pop: Amortized O(1), Worst-case O(n)
Peek: Amortized O(1), Worst-case O(n)
Empty: O(1)

SC: O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

class MyQueue {
    //keep track of elements as they are added
    private Stack<Integer> in;
    // output stack to reverse the order of elements from the input stack
    private Stack<Integer> out;


    public MyQueue() {
        //initialization
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        //simply add it to the input stack
        in.push(x);
    }
    
    public int pop() {
        // call peek to tranfer elements from input to output and return top element from output stack
        peek();
        return out.pop();
    }
    
    public int peek() {
        // if the output stack is empty, trasfer elements from input to output and pop the element from output stack 
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        //return true if both stacks are empty
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