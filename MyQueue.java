import java.util.*;

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue(){
        in = new Stack<>();
        out = new Stack<>();
    }
  // Time complexity O(1)
  // Space complexity O(1)
    public void push(int x) {
        in.push(x);
    }
    //Time complexity O(n) 
    // space complexity O(n)
    public int pop() {
        peek();
        return out.pop(); 
    }
    //Time complexity O(n) 
    // space complexity O(n)
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
       return out.peek();
    }
      //Time complexity O(n) 
    // space complexity O(1)
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args){
        MyQueue obj = new MyQueue();
        obj.push(0);
        obj.push(1);

    }
}
