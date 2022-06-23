// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
        
    }
    //just push it in the stacck
    public void push(int x) {
        in.push(x);
        
    }
    //after that pop
    public int pop() {
        peek();
        return out.pop();
    }
    //if pop comes put all elements in out stack 
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
            out.push(in.pop());
            }
        }
        return out.peek();
    }
    //checking if both stacks are empty
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