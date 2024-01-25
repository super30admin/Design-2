//https://leetcode.com/problems/implement-queue-using-stacks/

// Time Complexity : O(1) for all operations except pop and peek have ammortized O(1), explained in comments
// Space Complexity : Constant space is used apart from the space used to store input elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.Stack;

class Problem1 {
    // One stack acts as an inlet to input items, or back of the queue
    // The other one acts as outlet for output items, or front of the queue
    private Stack<Integer> in;
    private Stack<Integer> out;

    public Problem1() {
        in=new Stack<Integer>();
        out=new Stack<Integer>();
    }

    // We will be rearranging items in stack to maintain one as front of queue and the other back
    // We have two options for this rearrangement:
    // 1. Do them in push -- this will give O(N) for push, and O(1) for pop
    // 2. Do them in pop -- this will give ammortized O(1) for pop, and O(1) for push
    // We'll go with the second option
    // Note that peek will also do this re-arrangement when out is empty, and is ammortized O(1)
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        // The re-arrangement as explained before, only done when out gets empty
        if(out.isEmpty()){
            while(!in.isEmpty())    out.push(in.pop());
        }
        return out.pop();
    }
    
    public int peek() {
        // The re-arrangement as explained before, only done when out gets empty
        if(out.isEmpty()){
            while(!in.isEmpty())    out.push(in.pop());
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}