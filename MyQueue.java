// Time Complexity : Push: O(1), Pop: O(1), Peek: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Maintain two stack inStk and outStk
// For every push operation, push element into inStk
// For every pop operation,
//     check whether both the stack are empty or not. 
//        if its empty return -1
//        else
//             if outStk is not empty, pop element from outStk
//             else pop all elements form inStk and push it to outStk. Then pop the element from outStk.

class MyQueue {
    Stack<Integer> inStk;
    Stack<Integer> outStk;

    public MyQueue() {
        inStk = new Stack<>();
        outStk = new Stack<>();
    }
    
    public void push(int x) {  
        inStk.push(x);        
    }
    
    public int pop() {
        if(empty()) return -1;
        peek();
        return outStk.pop();
    }
    
    public int peek() {
        if(empty()) return -1;
        if(!outStk.isEmpty()) return outStk.peek();
        while(!inStk.isEmpty()){
            outStk.push(inStk.pop());
        }
        return outStk.peek();
    }
    
    public boolean empty() {
        return inStk.isEmpty() && outStk.isEmpty();
    }
}
