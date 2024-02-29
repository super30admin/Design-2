// Time Complexity : O(1) for all operations, since we're considerting the avg TC
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    * Take two stacks - in and out.
    * For push, push the value to in-stack
    * For pop, if the outStack is not empty, pop the element or push all elements into out and then pop
    * isEmpty() - Check if both stacks are empty
 */
import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public QueueUsingStacks() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int val) {
        inStack.push(val);
    }

    public int pop() {
        peek();
        return outStack.pop();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public static void main(String[] args) {
        QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
        queueUsingStacks.push(5);
        queueUsingStacks.push(6);
        queueUsingStacks.push(7);
        System.out.println(queueUsingStacks.pop());
        System.out.println(queueUsingStacks.pop());
        System.out.println(queueUsingStacks.pop());
        queueUsingStacks.push(-1);
        System.out.println(queueUsingStacks.isEmpty());
        System.out.println(queueUsingStacks.pop());
        System.out.println(queueUsingStacks.isEmpty());
    }
}
