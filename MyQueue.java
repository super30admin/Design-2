// Time Complexity :O(1)
// Space Complexity :O(n)
//Approach: Queue implementation using two stacks inStack and outStack, inStack is for enqueue(push) and  outStack for dequeue(pop) and peek. When outStack is empty moving elements to outStack from inStack so it reverses the order of elements so that the oldest (front) element is always on top of outStack, which ensures pop and peek always returns the front of the queue efficiently.

import java.util.Stack;

class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    // Initializing stacks
    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    // pushing elements to inStack
    public void push(int x) {
        inStack.push(x);
    }

    // popping element from outStack
    public int pop() {
        if (outStack.isEmpty()) {// returning -1 if both stacks are empty(queue is empty).
            return -1;
        }
        peek();// calling peek function and getting top/front element
        return outStack.pop();// removes the top/front element
    }

    // Returning top/front element from outStack
    public int peek() {
        if (outStack.isEmpty()) { // checking if outstack is empty
            while (!inStack.isEmpty()) {// checking if inStack is not empty
                outStack.push(inStack.pop());// pushing elements intp outStack by popping elements from inStack
            }
        }
        return outStack.peek();// returning top/front element.
    }

    public boolean empty() {
        return (inStack.isEmpty() && outStack.isEmpty());// Checking both stacks are empty(queue is empty).
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