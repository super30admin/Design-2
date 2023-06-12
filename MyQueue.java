import java.util.*;
public class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        // pop all the items from stack1 and push it into stack2
        while(s1.isEmpty() == false) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(s2.isEmpty() == false) {
            s1.push(s2.pop());
        }

    }

    public int pop() {
        int x = s1.pop();
        return x;
    }

     public int peek() {
        return (s1.peek());
        
    }
    
    public boolean empty() {
        return (s1.isEmpty());
    }

   
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        obj.push(7);

        int poppedElement = obj.pop();
        System.out.println("Popped Element :: "+poppedElement);

        int topElement = obj.peek();
        System.out.println("Peek Element :: "+topElement);

        boolean check = obj.empty();
        System.out.println("Check if Queue is Empty or not  :: "+check);

    }
    
}
