import java.util.Stack;

class MyQueue {
    //Implementation of Queue using two stacks. We'll use stack's standard operations to imitate queue.
//Overall Time complexity will be O(1) except in the worst case scenario where pop and peek are called after each element i.e O(N).
    Stack<Integer> in;  //Stack to store values before pop fxn is called
    Stack<Integer> out; //Stack to store values once pop fxn is called and will pop the value from out stack. As queue is based on FIFO(First In First Out) and stack is LIFO based so we'll move the elements to the out stack to implement queue using stack operation.

    public MyQueue() {
        in =new Stack<>(); //declaration of in stack
        out=new Stack<>(); //Declaration of out stack
    }

    public void push(int x) {
        in.push(x);    //Push Fxn will take constant time i.e O(1)
    }

    public int pop() {
        peek();              // On average Pop fxn will take O(1) time.
        return out.pop();   //Pop will take O(N) time as we are moving all the elements from in stack to out stack.
                            // But this will happen only in worst case scenario where pop fxn is called after each element.

    }

    //Peek method in Stack returns the top element of the stack while in Queue it returns the first element
    // entered to the queue. So we need to move all the elements to the out stack for both peek and pop.
    public int peek() {
        if (out.isEmpty()){  //Condn to check if out stack is Empty, so that we can shift the elements from out stack to in stack
            while(! in.isEmpty()){ //Condn to push elements in out stack using pop fxn on in stack(as pop fxn returns the value)
                out.push(in.pop()); //peek will take O(N) time as we are moving all the elements from in stack to out stack. But this will happen only in worst case scenario where pop fxn is called after each element. On average Pop fxn will take O(1) time.
            }
        }
        return out.peek(); //Now it will return the first value in the queue
    }

    public boolean empty() {    //Fxn to check if queue is empty or not, will return boolean value.
                                // True when empty and False when not empty.
        return in.isEmpty() && out.isEmpty(); //It will take constant time i.e O(1)
    }

    public static void main(String[] args){
        MyQueue q= new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());
        q.push(67);
        System.out.println(q.empty());


    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */