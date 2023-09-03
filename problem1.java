//Time complexity on average O(1)

class MyQueue {
     Stack<Integer> in;
     Stack<Integer> out; 

    public MyQueue() {
       in = new Stack<>();
       out = new Stack<>();
        
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
}
public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.empty());
        int front = queue.peek();
        System.out.println(front);
        int poppedElement = queue.pop();
        System.out.println(poppedElement);
        System.out.println(queue.empty());
    }
}
