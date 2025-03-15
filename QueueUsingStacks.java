import java.util.Stack;

class MyQueue {
    Stack<Integer> inSt;
    Stack<Integer> outSt;

    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
    }
    
    public void push(int x) {
        inSt.push(x);
    }
    
    public int pop() {
        if (outSt.isEmpty()) {
            while (!inSt.isEmpty()) {
                outSt.push(inSt.pop());
            }
        }
        return outSt.pop();
    }
    
    public int peek() {
        if (outSt.isEmpty()) {
            while (!inSt.isEmpty()) {
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();       
    }
    
    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
    }
}

public class QueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        
        System.out.println("Peek: " + myQueue.peek()); // Should return 1
        System.out.println("Pop: " + myQueue.pop());   // Should return 1
        System.out.println("Peek: " + myQueue.peek()); // Should return 2
        
        myQueue.push(4);
        System.out.println("Pop: " + myQueue.pop());   // Should return 2
        System.out.println("Pop: " + myQueue.pop());   // Should return 3
        System.out.println("Empty: " + myQueue.empty()); // Should return false
        System.out.println("Pop: " + myQueue.pop());   // Should return 4
        System.out.println("Empty: " + myQueue.empty()); // Should return true
    }
}
