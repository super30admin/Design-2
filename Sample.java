// Time Complexity : O(n2)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : TLE


// Your code here along with comments explaining your approach
class MyQueue {

    private Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<Integer>();
    }
    //Tried to maintain FIFO order in Stack
    //For each operation need O(n) space, O(n) time
    public void push(int x) {
        if(stack.isEmpty())
        {
            stack.push(x);
            return;
        }
        //Temp stack
        Stack<Integer> temp = new Stack<Integer>();
        //Empty original Stack and push to temp
        while(!stack.isEmpty())
        {
            int val = stack.pop();
            temp.push(val);
        }
        //Once emptied push to original
        //so Last values goes to last
        stack.push(x);
        //Empty temp stack and push to original
        while(!temp.isEmpty())
        {
            int val = stack.pop();
            stack.push(val);
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
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


//Optimized
// Time Complexity : amoratized O(n)
// Space Complexity : amoratized O(n)
// Did this code successfully run on Leetcode : Yes
class MyQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;
    public MyQueue() {
        stackIn = new Stack<Integer>();
        stackOut = new Stack<Integer>();
    }

    //O(1)
    public void push(int x) {
        stackIn.push(x);
    }

    //Only transfer to stackOut if empty
    //StackOut maintians pop order for Queue
    //Same for peek
    //O(1)
    public int pop() {
        if(stackOut.isEmpty())
        {
            while(!stackIn.isEmpty())
            {
                int val = stackIn.pop();
                stackOut.push(val);
            }
            return stackOut.pop();
        }
        return stackOut.pop();
    }

    //O(1)
    public int peek() {
        if(stackOut.isEmpty())
        {
            while(!stackIn.isEmpty())
            {
                int val = stackIn.pop();
                stackOut.push(val);
            }
            return stackOut.peek();
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
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
