import java.util.Stack;

class MyQueue {

    Stack<Integer> enQueue;
    Stack<Integer> deQueue;

    public MyQueue() {
        this.enQueue = new Stack<>();
        this.deQueue = new Stack<>();
    }

    public void push(int x) {

        enQueue.push(x);

    }

    public int pop() {

        while(!enQueue.isEmpty()){
            deQueue.push(enQueue.pop());
        }
        int element = deQueue.pop();

        while(!deQueue.isEmpty()){
            enQueue.push(deQueue.pop());
        }
        return element;
    }

    public int peek() {

        while(!enQueue.isEmpty()){
            deQueue.push(enQueue.pop());
        }
        int element = deQueue.peek();

        while(!deQueue.isEmpty()){
            enQueue.push(deQueue.pop());
        }

        return element;
    }

    public boolean empty() {

        return enQueue.isEmpty() && deQueue.isEmpty();
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