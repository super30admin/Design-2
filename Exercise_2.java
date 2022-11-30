// Implement Queue using Stacks
// Time Complexity : O(1)
//{which is O(1) + O(n)(not always, sometimes when we need to shift elements from in to out) + O(1)}
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Approach
// Create 2 stacks; in stack & out stack. All push happens in in stack.
// When a pop happens, transfer all elements from in stack to out stack and then pop the element.
// In some cases, when the out stack is empty and we need to do pop, then again push all the elements from in to out stack if in stack is not empty.

class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;


    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        //push happens in in stack
        in.push(x);
    }

    public int pop() {
        //pop happens in out stack
        //peek function
        if(out.isEmpty()){
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        //when out stack is empty, put all elements from in to out (if in stack is not empty)
        if(out.isEmpty()){
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        //have to chcek both stack
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