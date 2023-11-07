// Time Complexity : Enqueue - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I am not able to 
//understand time complexity of pop operation here

//Implementing Queue using two stacks with amortized cost of each operation O(1)
class MyQueue {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    //Once you get front element from peek, just pop it from Output
    public int pop() {
        int value = peek();
        output.pop();
        return value;
    }

    //Peek is popping from input and pushing to output stack so that sequence is reversed
    //and peek shows the front element as Queue is FIFO
    public int peek() {
        if(output.empty())
            while(!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    //Return true only if both the stacks are empty
    public boolean empty() {
        return input.empty() && output.empty();
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