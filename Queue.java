// Time Complexity : push, isEmpty-O(1), pop, peek-O(n)(worstcase),-O(1)(avg case)
// Space Complexity :O(2n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Initialized two arrays one to store the original order and the other to extract the 1st element when needed for pop and peek



class MyQueue {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();        
    }
    
    public void push(int x) {
        inSt.push(x);
        
    }
    
    public int pop() {
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();
        
    }
    
    public int peek() {
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
        
    }
    
    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
        
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