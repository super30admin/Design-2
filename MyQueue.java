import java.util.Stack;
class MyQueue {
    Stack<Integer> front;
    Stack<Integer> back;

    public MyQueue() {
        front = new Stack();
        back = new Stack();
    }

    public void push(int x) {
        front.push(x);
    }

    public int pop() {
        int x;
        if(back.isEmpty()){
            while(!front.isEmpty()) {
                back.push(front.pop());
            }
        }
        x= back.pop();
        if(!back.isEmpty()){
            while (!back.isEmpty()){
                front.push(back.pop());
            }
        }
        return x;
    }

    public int peek() {
        int x;
        if(back.isEmpty()){
            while(!front.isEmpty()) {
                back.push(front.pop());
            }
        }
        x= back.peek();
        if(!back.isEmpty()){
            while (!back.isEmpty()){
                front.push(back.pop());
            }
        }
        return x;

    }

    public boolean empty() {
        return front.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(5);
        obj.push(4);
        obj.push(9);
        obj.push(3);
        int param_2 = obj.pop();
        System.out.println("Popped element ---" + param_2);
        obj.push(12);
        int param_3 = obj.peek();
        System.out.println("Peeked element ---" + param_3);
        boolean param_4 = obj.empty();
        System.out.println("Is empty??? " + param_4);

    }
}