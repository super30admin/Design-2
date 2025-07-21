//Time Complexity : O(1) for push and amortized O(1) for pop and peek
// Space Complexity : O(n) where n is the number of elements in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
// 1. We use two stacks to implement the queue functionality.
// 2. Elements are pushed onto the 'in' stack, and popped from the 'out' stack.
// 3. When the 'out' stack is empty, we transfer elements from the 'in' stack to maintain the correct order.
class MyQueue {
    // Implementing a queue using two stacks
    // The 'in' stack is used for pushing elements, and the 'out' stack is used for popping elements
    private Stack<Integer> in;
    private Stack<Integer> out;
    public MyQueue() {
        this.in=new Stack<>();
        this.out=new Stack<>();
    }
    // Push an element onto the 'in' stack
    // This is the main stack where elements are added
    public void push(int x) {
        in.push(x);
    }
    //
    public int pop() {
        // Ensure that the 'out' stack has elements to pop
        //we are using the peek method to ensure that the 'out' stack has elements
        peek();
        // If the 'out' stack is not empty, we can pop the top element
        return out.pop();
    }
    // to pop an element, we first ensure that the 'out' stack has elements
    public int peek() {
        // If the 'out' stack is empty, we transfer all elements from the 'in' stack to the 'out' stack
        // This reverses the order of elements, allowing us to pop them in the correct order
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        // The top element of the 'out' stack is the next element to be popped
        return out.peek();
    }
    
    public boolean empty() {
        // The queue is empty if both stacks are empty
        // This means there are no elements left to pop or peek
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