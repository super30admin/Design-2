// Time Complexity : o(n) in worst case as e have to shifting for pop operation, this is my understanding, I have dont have idea
//of average time complexity. Please correct me with explanation so that next i acn use it and will give you correct ans.
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no i understood the algo in class and then implemented it but earlier i was
// not aware of the fact that we need to use to stacks but sir told me i got it. I am hoping that in future if i will get
// this issue then i may be able to do it by myself and able to figure out ya here i have to use two stack approach.
//Guide me if i am going in wrong direction.


// Your code here along with comments explaining your approach
//created two stacks(in and out):
//1. when push i am simply pushing to in stack.
//2. pop(): I am first checking if out stack is empty or not if yes then i am poping the contents from in to out stack
// then poping the top element and in the else part i am going when my out is not empty at first place and returing the
// top of out tack.
//peek(): doing same whatever is there in pop except popping i am just returning the top value.
//empty(): if my both in and out are empty then i am returning true else false.


import java.util.Stack;

class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in=new Stack<Integer>();
        out=new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
            return out.pop();
        }else{
            return out.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
            return out.peek();
        }else{
            return out.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty()){
            return true;
        }else{
            return false;
        }
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