import java.util.Stack;


// Time Complexity : amortized O(1) for both po and peek O(1) for push and empty
// Space Complexity : O(1)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No

// Queue is FIFO based and Stack is LIFO based.
// Pop and peek have to be the oldest elements so always have to be from outStack and
// before applying pop or peek need to check whether outStack is not empty, if empty pop all the elements from
// inStack and then do pop or peek from outStack.



public class MyQueue {

   private  Stack<Integer> inStack;
   private  Stack<Integer> outStack;

    public MyQueue(){
        inStack = new Stack<>();
        outStack = new Stack<>();

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
       if(!outStack.isEmpty()) {
           return outStack.pop();
       }else{
           while(!inStack.isEmpty()) {
               outStack.push(inStack.pop());
           }
       }
       return outStack.pop();
    }

    public int peek() {
       if(outStack.isEmpty()){
           while(!inStack.isEmpty()){
               outStack.push(inStack.pop());
           }
       }
        return outStack.peek();
    }

    public boolean empty() {
     return outStack.isEmpty() && inStack.isEmpty();
    }
}
