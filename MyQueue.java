/*
* Time Complexity: O(n)
* Space Complexity: O(n)
* Did this code run successfully on leetcode: Yes
* Any problem faced while coding this: I want to optimise pop method however, I am not able to do it
* */
class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()){
            front = x;
        }

        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res = -1;
        if(!s1.isEmpty()){

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            res = s2.pop();

            if(!s2.isEmpty()){
                front = s2.peek();
            } else {
                front = -1;
            }

            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.size() == 0;
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