// Time Complexity : O(1) for push & empty, O(1) average for pop & peek
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: 2 Stacks are maintained with one storing the input and one storing the queue
// 2: When a pop/peek operation is done, the elements are transferred from st1 to st2
// 3: Transferring of elements only occurs when st2 is empty to maintain correct queue order
class MyQueue {

    private Stack<Integer> st1;
    private Stack<Integer> st2;
    public MyQueue() {
        this.st1 = new Stack<Integer>();
        this.st2 = new Stack<Integer>();
    }

    public void push(int x) {
        st1.push(x);

    }

    private void transferElements(){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
    }

    public int pop() {
        if(st2.isEmpty()){
            transferElements();
        }
        return st2.pop();

    }

    public int peek() {
        if(st2.isEmpty()){
            transferElements();
        }
        return st2.peek();

    }

    public boolean empty() {
        return (st1.isEmpty() && st2.isEmpty());
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