// Time Complexity : 
//          push -> 0(1)
//          pop -> 0(1) average case and 0(n) worst case
//          peek -> 0(1) average case and 0(n) worst case
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Push elements in a stack. 
//            When pop or peek function is called, put all the elements of the stack into a second stack
//            to store them in reverse order for 'First Out' functionality

// Your code here along with comments explaining your approach
class MyQueue {
    Stack<Integer> st;
    Stack<Integer> rev;

    public MyQueue() {
        this.st = new Stack<>(); // original stack
        this.rev = new Stack<>(); // reverse stack for 'First Out'
    }

    public void push(int x) {
        st.push(x);
    }

    public int pop() {
        peek();
        return rev.pop();
    }

    public int peek() {
        if (rev.isEmpty()) {
            while (!st.isEmpty()) {
                rev.push(st.pop()); // put elements of original stack into reverse stack
            }
        }
        return rev.peek();
    }

    public boolean empty() {
        return st.isEmpty() && rev.isEmpty();
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
