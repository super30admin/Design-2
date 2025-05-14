// Time Complexity :
// push(): O(n) – because each push may involve reversing all elements
// pop(): O(1) – top element is always ready
// peek(): O(1)
// empty(): O(1)

// Space Complexity :
// O(n) – for storing n elements using two stacks

// Did this code successfully run on Leetcode :
// Yes

// Any problem you faced while coding this :
// Yes – I couldn't figure out how to reduce the time complexity for push and pop.
// I always ended up moving all the elements back and forth between the two stacks
// during each push, which caused every operation to take longer.
// I didn’t realize there’s a way to only move elements *when needed*, 
// and keep push O(1).

// Your code here along with comments explaining your approach

/*
 * This implementation simulates a queue (FIFO) using two stacks (LIFO).
 *
 * - `first` holds the main stack where elements are kept in queue order.
 * - `temp` is a temporary stack used to reverse order during push.
 *
 * push(x):
 *   - If the queue is empty, simply push to `first`.
 *   - If not, we pop all elements to `temp`, push `x`, and then push all elements back.
 *   - This ensures that the oldest element remains at the top of `first`, maintaining FIFO.
 *
 * pop() and peek():
 *   - Directly operate on `first`, since the front of the queue is always at the top.
 *
 * empty():
 *   - Just checks if `first` is empty.
 *
 * Limitation:
 *   - This implementation always moves elements for every `push()`, which makes it inefficient.
 *   - A more optimized approach avoids this by only moving elements during `pop()` or `peek()`, and **only when necessary**.
 *   - That reduces the average cost per operation to **amortized O(1)**.
 */


class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> temp;

    public MyQueue() {
        first= new Stack<>();
        temp = new Stack<>();
    }
    
    public void push(int x) {
        if(empty()){
            first.push(x);
        }
        else{
            while(!first.isEmpty()){
                temp.push(first.pop());
            }
            first.push(x);
            while(!temp.isEmpty()){
                first.push(temp.pop());
            }
        }
    }
    
    public int pop() {
        return first.pop();
    }
    
    public int peek() {
        return first.peek();
    }
    
    public boolean empty() {
        return first.isEmpty();
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
