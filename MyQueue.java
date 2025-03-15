import java.util.Stack;

public class MyQueue1 {
     Stack<Integer> inStack;
    Stack<Integer> outStack;
    public MyQueue1(){
        this.inStack = new Stack<Integer>();
        this.outStack = new Stack<Integer>();
    }

    public void push(int x){
        inStack.push(x);
    }

    public int pop(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek(){
        if(outStack.isEmpty()){
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
      }
        return outStack.peek();
    }

    public boolean empty(){
        return outStack.isEmpty() && inStack.isEmpty();
    }


    public static void main(String args[]){
        MyQueue1 myQueue = new MyQueue1();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
    }
}
