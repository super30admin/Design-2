import java.util.*;
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s = new Stack<>();
    Stack<Integer> t = new Stack<>();
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return  t.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(t.isEmpty()){
            while(!s.isEmpty()){
                t.push(s.pop());
            }
        }
        return t.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s.isEmpty() && t.isEmpty();
    }
    public static void main (String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}

