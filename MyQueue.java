import java.util.Stack;

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
        peek();
        return out.pop();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(10); //[10]
        myQueue.push(20); //[10,20]
        System.out.println(myQueue.peek()); // ans =  10
        myQueue.pop(); // now queue is [20]
        System.out.println(myQueue.peek()); // ans =  20
        System.out.println(myQueue.empty()); // ans= false
    }
}