import java.util.Stack;

//Time Complexity O(1) and Space Complexity O(n) n= no.of elements stored

class MyQueue {

    Stack<Integer> stk1;

    Stack<Integer> stk2;
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();

    }

    public void push(int x) {
        stk1.push(x);

    }

    public int pop() {
        peek();
        return stk2.pop();
    }

    public int peek() {
        if(stk2.isEmpty()){
            while (!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }
        }
        return stk2.peek();
    }

    public boolean empty() {
        return stk1.isEmpty() && stk2.isEmpty();
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