import java.util.Stack;

public class D2_QueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      //Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
            obj.push(10);
            obj.push(20);
            obj.push(30);
            int param_2 = obj.pop();
            int param_3 = obj.peek();
            boolean param_4 = obj.empty();
            System.out.print(param_2);
            System.out.print(param_3);
            System.out.print(param_4);
	}

}

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        // Move all elements from s1 to s2
        while (!s1.isEmpty())
        {
            s2.push(s1.pop());
            //s1.pop();
        }

        // Push item into s1
        s1.push(x);

        // Push everything back to s1
        while (!s2.isEmpty())
        {
            s1.push(s2.pop());
            //s2.pop();
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // if first stack is empty
        if (s1.isEmpty())
        {
            System.out.println("Q is Empty");
            System.exit(0);
        }

        // Return top of s1
        int x = s1.peek();
        s1.pop();
        return x;

    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
