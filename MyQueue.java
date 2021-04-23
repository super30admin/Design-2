// Time Complexity :  push()-O(1),
//                    pop()-O(1)-amortize time complexity,
//                    peek()-O(1)-amortize time complexity,
//                    empty()-O(1)
// Space Complexity : O(n) where n is the input
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : before I could only come up with O(n) time complexity solution
//                                           but after it was explained in class I could do it in O(1) and amortize O(1) for some.
class MyQueue {
    // stack for pushing items
    Stack<Integer> in;
    //stack for popping items
    Stack<Integer> out;
    //initializing our stacks
    public MyQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    // Push element to the back of queue.
    public void push(int x) {
        //add item to in stack
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //add item in the out stack if it is empty
        peek();
        //pop from out stack
        return out.pop();
    }

    // Get the front element.
    public int peek() {
        // check if queue is empty
        if(out.isEmpty()){
            //push all the items in in stack to out stack
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        // return the top elemnt of out stack
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // return true if both in and out stack is empty
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