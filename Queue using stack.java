
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :no
//aaproach: Always push in to In stack if peek or pop operation came transfer all values to out stack so we can easily pop or peek and no need to push again to in stack if we get a new push it will store in in stack and again peek or pop transfer to out.
import java.util.Stack;
class MyQueue {
    Stack<Integer>in;
    Stack<Integer>out;

    public MyQueue() {
        this.in= new Stack<>();
        this.out=new Stack<>();
        
    }
    
    public void push(int x) {
        this.in.push(x);// Push the values in to in stack always
        
    }
    
    public int pop() {
        peek(); //same as peek
        return this.out.pop();
        
    }
    
    public int peek() {
        if(this.out.isEmpty()){ //To get peek check that out stack is empty then do a push operation to out stack from in stack untill in stack gets empty
            while(!this.in.isEmpty()){
                this.out.push(this.in.pop());
            }
        }
        return this.out.peek();
        
    }
    
    public boolean empty() {
        return this.in.isEmpty() && this.out.isEmpty();//return true if both stacks are empty
        
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
