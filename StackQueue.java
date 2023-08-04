// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Created two integer stacks and originally push all elements into in.
//When I peek or pop, I am referencing the out stack. If the out stack is empty
//I pop all the in elements in "in" stack and pop them into the out stack.

class MyQueue {
    //Create two integer stacks
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    public void push(int x) {//O(1)
        in.push(x);
    }
    
    public int pop() { //O(1), worst case: O(n)
        peek();
        return out.pop();
    }
    
    public int peek() { //O(1)
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() { //O(1)
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