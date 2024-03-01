// Time Complexity : O(1) averagely for all operations, pop ad peek might take O(n) in worst case
// Space Complexity : O(n) where n is size of s1+s2
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Use two stacks, keep pushing to stack1 till a pop occurs, as soon as pop occurs see if stack 2 has elements in it, if yes, pop from there.
// If stack 2 is empty push all the elements from stack 1 to stack 2 and pop from stack2
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
            s1.push(x);
    }
    
    public int pop() {
        if (!s2.isEmpty()){
            return s2.pop();
        }
        else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        return s2.pop();
        }
    }
    
    public int peek() {
        if (!s2.isEmpty()){
            return s2.peek();
        }
        else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        return s2.peek();
        }
    }
    
    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());  
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