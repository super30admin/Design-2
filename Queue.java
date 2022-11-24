class MyQueue {
    private Stack<Integer>stIn;
    private Stack<Integer>stOut;
    

    public MyQueue() {
    stIn = new Stack<>();
    stOut = new Stack<>();
    }
    
    public void push(int x) {
        stIn.push(x);//O(1)
       
    }
    
    public int pop() {//O(1)
        peek();
        return stOut.pop();
    }
    
    public int peek() {//O(1)
         if(stOut.isEmpty()){

            while(!stIn.isEmpty()){
            stOut.push(stIn.pop());    
            }
            
        }
        return stOut.peek();
    }
    
    public boolean empty() {
        return (stIn.isEmpty() && stOut.isEmpty());
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

// Time Complexity : O(1), Push, pop operations are o(1). Transfering to out stack when it is empty will happen rarely. So Ignoring that
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Taking instack and Outstack. pusing all the elements from Instack to Outstack whenever Outstack is empty. This will make push and pop easy O(1). We can pop first element from Outstack. Insert new element into Instack. This satisfys FIFO.