// Time Complexity : push = O(1), pop = amortized O(1)
// Space Complexity : O(n) to keep all the elements of the ques in both the stacks. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        

        if(out.isEmpty()){
            while(!in.isEmpty()){
                int transfer = in.pop();
                out.push(transfer);
            }
        }

        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                int transfer = in.pop();
                out.push(transfer);
            }
        }

        return out.peek();
    }
    
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty()){
            return true;
        }

        return false;
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
