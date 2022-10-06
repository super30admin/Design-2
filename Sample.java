// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyQueue {
Stack<Integer> stack1 = new Stack<>();
Stack<Integer> stack2 = new Stack<>();
    public MyQueue() {

    }
    public void move(){
        while (!stack1.isEmpty()){
      int y = stack1.pop();
        stack2.push(y);
        move();}
    }
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if (stack2.isEmpty()){move();}
        return stack2.pop();
    }
    
    public int peek() {
        if (stack2.isEmpty()){move();}
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
