// Time Complexity : O(1) for push, O(n) for pop and peek
// Space Complexity : O(n) for storing elements in the stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//push-->push to instack
//pop--> when outstack is not empty pop else put all
//elements from instack to outstack and pop from outstack



class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
            return out.pop();
        }else
            return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
            return out.peek();
        }else
            return out.peek();
    }
    
    public boolean empty() {
        if(in.isEmpty()&&out.isEmpty())
            return true;
        else
            return false;
    }
}