// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
// took 2 stacks and moved them one to another during push and pop
class MyQueue {

    Stack<Integer> pushSt;
    Stack<Integer> popSt;
    public MyQueue() {
        pushSt = new Stack<Integer>();
        popSt = new Stack<Integer>();
    }
    
    public void push(int x) {
        while(!popSt.isEmpty()){
            pushSt.push(popSt.pop());
        }
        pushSt.push(x);
    }
    
    public int pop() {    
        while(!pushSt.isEmpty()){
            popSt.push(pushSt.pop());
        }
        return popSt.pop();
    }
    
    public int peek() {
         while(!pushSt.isEmpty()){
            popSt.push(pushSt.pop());
        }
        return popSt.peek();
    }
    
    public boolean empty() {
        return pushSt.isEmpty() && popSt.isEmpty();
    }
}
