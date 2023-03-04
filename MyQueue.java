/*
* The following is implementation of queue using stack
* I have used two stacks to perform push() and pop() operations in a queue
* The time complexity of all the operations is O(1)*/

import java.util.Stack;
public class MyQueue {
    private Stack<Integer> inputstack;
    private Stack<Integer> outputstack;

    public MyQueue(){
        inputstack = new Stack<>();
        outputstack = new Stack<>();

    }

    public void push(int x){
        inputstack.push(x);

    }

    public int pop(){
        peek();
        return outputstack.pop();
    }

    public int peek(){
        if(outputstack.isEmpty()){
            while(!inputstack.isEmpty()){
                outputstack.push(inputstack.pop());
            }
        }
        return outputstack.peek();
    }

    public boolean empty(){
        return inputstack.isEmpty() && outputstack.isEmpty();
    }
        public static void main(String[] args){
            MyQueue queue = new MyQueue();

            queue.push(1);
            queue.push(2);
            System.out.println(queue.peek());
            System.out.println(queue.pop());
            System.out.println(queue.empty());

        }
}
