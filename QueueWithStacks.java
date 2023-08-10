// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 2 stacks, namely in and out are used, firstly all the elements that are to be pushed will be added onto the in stack and when the pop
// command is encountered, and if out stack is empty, the elements are pushed from in stack to out stack and the top element in out stack is
// popped. For peek, the same process as pop is followed, except that the element is not removed from out stack.

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {   // O(1)
        in.push(x);
    }
    
    public int pop() {        // amortized O(1)
        peek();

        return out.pop();
    }
    
    public int peek() {       // amortized O(1)
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }

        return out.peek();
    }
    
    public boolean empty() {           // O(1)
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