// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//We are using 2 stacks. One to pop and peek to work like queues
//to push the element



class MyQueue {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public MyQueue() {
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int x = s2.pop();
       while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return x;
    }
    
    public int peek() {
           while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int x = s2.peek();
       while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return x;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}