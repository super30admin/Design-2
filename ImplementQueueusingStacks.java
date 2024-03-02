// Time Complexity : Push: O(1), Pop: O(1) avg case, Peek: O(1) avg case, Empty:O(1)
// Space Complexity : O(n) because we are using extra stack to store the elements
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/implement-queue-using-stacks/
// Any problem you faced while coding this : No



class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
         if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
