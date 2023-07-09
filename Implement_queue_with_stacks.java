class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);

    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                int stack1Pop = stack1.pop();
                stack2.push(stack1Pop);
            }

        }
        return stack2.pop();
    }

    public int peek() {
        //     if(!stack2.empty()){
        //         stack2.peek();
        //     }else {
        // while(!stack1.empty()){
        //     int stack1Pop = stack1.pop();
        //     stack2.push(stack1Pop);
        // }
        //         return stack2.peek();
        if(stack2.empty()){
            while(!stack1.empty()){
                int stack1Pop = stack1.pop();
                stack2.push(stack1Pop);
            }
        }
        return stack2.peek();



    }

    public boolean empty() {
        return (stack2.empty() && stack1.empty());

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