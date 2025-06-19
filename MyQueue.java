// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


import java.util.Stack;
class MyQueue {
    int size;
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        size = 0;
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {

        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }

        st1.push(x);
        while(!st2.isEmpty())
        {
            st1.push(st2.pop());
        }
        size++;
    }

    public int pop() {
        if(empty())
        {
            return -1;
        }
        else
        {
            int x = st1.pop();
            size--;
             return x;
        }


    }
    public int peek() {
        if(empty())
        {
            return -1;
        }
        else
        {
            int x = st1.peek();
            return x;
        }

    }
    public boolean empty() {
        return size == 0;
    }
}

