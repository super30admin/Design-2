import java.util.Stack;

//Implement Queue using  2 stacks
//Time Complexity:o(1)
//Space Complexity:o(n)
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
        int itemToPop=peek();
        return out.pop();
    }

    public int peek() {
        if(out.isEmpty())
        {
            while(!in.isEmpty())
            {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        if(out.isEmpty())
        {
            if(in.isEmpty())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
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