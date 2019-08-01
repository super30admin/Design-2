
import java.util.Stack;
public class QueueUsingStack{
    Stack<Integer> in;
    Stack<Integer> out;

    public QueueUsingStack(){
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x){
        in.push(x);
    }

    public int pop(){
        if(empty())
            return -1;
        else if(out.isEmpty()){
            while(in.size() > 0){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek(){
        if(empty())
            return -1;
        else if(out.isEmpty()){
            while(in.size() > 0){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty(){
        if(in.isEmpty() && out.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        QueueUsingStack queue = new QueueUsingStack();
        queue.push(4);
        queue.push(-11);
        System.out.println("Peek element: " + queue.peek());
        queue.push(10);
        queue.push(3);
        System.out.println("Peek element: " + queue.peek());
        System.out.println("Popped 1st element: " + queue.pop());
        System.out.println("Peek element: " + queue.peek());
        System.out.println("Popped 2nd element: " + queue.pop());
        System.out.println("Popped 3rd element: " + queue.pop());
        System.out.println("Popped 4th element: " + queue.pop());
        System.out.println("Peek element: " + queue.peek());
    }

}