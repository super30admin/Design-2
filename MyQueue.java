import java.util.Stack;

/* Time Complexity:
push(x): O(1)
pop(): Amortized O(1)
peek(): Amortized O(1)
empty(): O(1)
Space Complexity:
O(n), where n is the number of elements currently stored in the queue. Both stacks (s1 and s2) hold the elements of the queue.

Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.peek();
    }

    public boolean empty() {
        return s2.isEmpty() && s1.isEmpty();
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