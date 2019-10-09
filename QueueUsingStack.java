/*
Author: Akhilesh Borgaonkar
Approach: I am using two stacks here. The main stack maintains the sequence in which elements were pushed in queue at any given time.
    Reverse stack is used for poping out the elements from main stack and getting the first element in the main stack.
Time Complexity: O(1) for push() & O(n) for pop() and peek() methods
Space Complexity: O(n)  where n is number of elements pushed in stack
LC verified
*/

class MyQueue {

    Stack<Integer> mainStack = new Stack<>();   //main stack to store elements
    Stack<Integer> revStack = new Stack<>();    //stack for reversing the elements while getting first element in mainStack
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        mainStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int popElement = -1;                    //default value if stack is empty
        
        if(!mainStack.empty()){
            while(!mainStack.empty())
                revStack.push(mainStack.pop()); //getting all elements from mainStack and putting in revStack to reverse the order and get the first element pushed in mainStack
            
            popElement = revStack.pop();        //poping the first element in queue
            
            while(!revStack.empty())            //reverting the sequence to mainStack
                mainStack.push(revStack.pop());
        }
        return popElement;
    }
    
    /** Get the front element. */
    public int peek() {
        int peekElement = -1;                   //default value if stack is empty
        
        if(!mainStack.empty()){
            while(!mainStack.empty())
                revStack.push(mainStack.pop()); //getting all elements from mainStack and putting in revStack to reverse the order and get the first element pushed in mainStack
            
            peekElement = revStack.peek();      //peeking the first element in queue w/o poping
            
            while(!revStack.empty())        
                mainStack.push(revStack.pop()); //reverting the sequence to mainStack
        }
        return peekElement;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainStack.empty();               //return true if stack is empty
    }
}