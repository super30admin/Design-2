Problem 1: 
// Time Complexity : Amortized O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {

    private Stack<Integer> qStack;
    private Stack<Integer> tempStack;
    private int peek; //using variable to store the peek

    public MyQueue() { //intialize
        qStack = new Stack<>();
        tempStack = new Stack<>();
    }
    
    public void push(int x) {     
        if(qStack.isEmpty()){
            peek = x; //store the peek if the stack is main stack is empty
        }
        qStack.push(x); 
    }
    
    public int pop() {

        while(!qStack.isEmpty()){
            tempStack.push(qStack.pop());
        }//move the main stack to temp stack to get the first value

        int popElement = tempStack.pop(); // pop the element
        
        if(!tempStack.isEmpty()) // update the peek
            peek = tempStack.peek();

        while(!tempStack.isEmpty()){ // update the main stack after pop
            qStack.push(tempStack.pop());
        }
        return popElement;
    }
    
    public int peek() {
        return peek; //return peek
    }
    
    public boolean empty() {
        return qStack.isEmpty(); // check if the main stack is empty
        
    }
}
