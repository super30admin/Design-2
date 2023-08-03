import java.util.Stack;

// Time Complexity : push: O(1); pop: O(1) amortized best case,O(N) worst case; peek: O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
FIFO
or we can do it with linked list also
method 1: two stacks one for pushing value(instack) and other for popping values(outstack). 
while pop if(outstack is empty) -> we can copy all the elements from instack to outstack -> pop it.
 */

public class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();

    }
    public void push( int x){
        in.push(x);
    }
    public int pop(){
        peek(); // copying
        return out.pop();
    }
    public int peek() {
        // copying: instack to outstack if outStack is empty
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty(){
        // copying: instack to outstack if outStack is empty
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.isEmpty();
    }
    
}
