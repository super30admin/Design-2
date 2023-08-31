// Time Complexity : O(n) for worst case scenario average scenario O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No


//Question: https://leetcode.com/problems/implement-queue-using-stacks/description/

// Your code here along with comments explaining your approach
//Queue works as First in first out
// push in in stack transfer to out stack then pop or peek

class MyQueue {
    //defining two stacks in stack and out stack
    Stack<Integer> in;
    Stack<Integer> out;

    //initializing the stack
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    //insert into stack
    //Time complexity O(1)
    public void push(int x) {
        in.push(x);
    }
    
    //Time complexity O(1)
    public int pop() {
        peek();
        return out.pop();
    }
    
    /*
     * peek the top element in stack, we have two stacks in and out
     * if out is empty trasnfer elements from in to out to peek the stack
     * Time Complexity : O(n) for worst case scenario average scenario O(1)
     */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
     //Time complexity O(1)
    public boolean empty() {
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