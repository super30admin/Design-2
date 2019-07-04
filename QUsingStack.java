import java.util.Stack;

public class QUsingStack {
 Stack<Integer> stack;
    Stack<Integer> dupe;
    //int length;
    //int dlength;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
        dupe = new Stack<Integer>();
        //length = 0;
        //dlength = 0;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
        //length++;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!stack.isEmpty() && dupe.isEmpty()){
        //int x = length;
        while(!stack.isEmpty()){
            //int y = stack.pop();
            dupe.push(stack.pop());
            //length--;
            //dlength++;
            //x--;
        }
            //dlength--;
        return dupe.pop();
    }
    else if(!dupe.isEmpty()){
        //dlength--;
        return dupe.pop();
    }
    else {
        System.out.println("Queue Underflow");
        return -1;
    }

    }
    
    /** Get the front element. */
    public int peek() {
         if(!stack.isEmpty() && dupe.isEmpty()){
            //int x = length;
            while(!stack.isEmpty()){
                //int y = stack.pop();
                dupe.push(stack.pop());
                //length--;
                //dlength++;
                //x--;
            }
            return dupe.peek();
        }
        else if(!dupe.isEmpty()){
            return dupe.peek();
        }
        else {
            System.out.println("Queue Underflow");
            return -1;
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack.isEmpty() && dupe.isEmpty())
        return true;
    else
        return false;
    }
}

    public static void main(String[] args) {
        QUsingStack q = new QUsingStack();
        q.push(2);
        q.push(1);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}
