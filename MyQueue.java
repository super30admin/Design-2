// Time Complexity : 
//   push()     -> O(1)
//   pop()      -> Amortized O(1)
//   peek()     -> Amortized O(1)
//   isEmpty()  -> O(1)
// Space Complexity : O(n), where n is the number of elements in the queue

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// - Implemented a queue using two stacks (inputStack and outputStack).
// - All elements are pushed into inputStack.
// - For pop() and peek(), elements are transferred from inputStack to outputStack only when outputStack is empty.
//   This ensures that the oldest element is always on top of outputStack for queue-like behavior.

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue(){
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x){
        inputStack.push(x);
    }

    public int pop(){
        peek();
        return outputStack.pop();
    }

    public int peek(){
        if(outputStack.isEmpty()){
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean isEmpty(){
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
