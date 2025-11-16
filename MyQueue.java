import java.util.Stack;

// Implement Queue using stacks.
// Time complexity: O(1) Amortized, O(N) in worst case.
// Space complexity: O(N) for both inStack and outStack combined.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            return -1;
        }
        if (outStack.isEmpty()) {
            addElementsToOutStack();
        }
        return outStack.pop();
    }
    
    public int peek() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            return -1;
        }
        if (outStack.isEmpty()) {
            addElementsToOutStack();
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void addElementsToOutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.empty()); // return true
        System.out.println(myQueue.peek()); // return -1 since queue is empty
        System.out.println(myQueue.pop()); // return -1 since queue is empty
        myQueue.push(1); // queue = [1]
        System.out.println(myQueue.empty()); // return false
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue = []
        System.out.println(myQueue.empty()); // return true since queue is empty
        myQueue.push(1); // queue = [1]
        myQueue.push(2); // queue = [1, 2]
        myQueue.push(3); // queue = [1, 2, 3]
        myQueue.push(4); // queue = [1, 2, 3, 4]
        System.out.println(myQueue.peek()); // return 1, which is the leftmost in array and first element in the queue.
        System.out.println(myQueue.pop()); // removes 1, queue = [2, 3, 4], first element is removed.
        System.out.println(myQueue.peek()); // return 2, leftmost element in the array and first element in the queue.
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