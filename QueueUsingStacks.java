//Time Complexity: O(n) for pop(), O(1) for push(), peek(), empty()
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : yes

//https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {

    Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();
    int f;
    public MyQueue() {  
    }
    public void push(int x) {
        if(s1.isEmpty())
        {
            f=x;
        }
        s1.push(x);        
    }
    
    public int pop() {
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if(!s2.isEmpty())
            return s2.peek();
        return f;
    }
    
    public boolean empty() {
        return (s2.isEmpty() && s1.isEmpty());
        
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