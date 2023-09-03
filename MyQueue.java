// Time complexity : push() --> O(1) 
// in case of pop() & peek() avg case its O(1)
// empty() -> O(1) 
// successfully submitted on leetcode

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in= new Stack<>();
        out= new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
       peek();
       return out.pop();
    }
    
    public int peek() {
        // keep pushing the elements from in stack to out stack, 
        // get the top element
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        // when both the stacks are empty 
        return in.isEmpty() && out.isEmpty();
    }
}