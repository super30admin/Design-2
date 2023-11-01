//time complexity-O(1)
//space complexity-O(n)
// Use stacks and make them works as queue by poping data from one stack to push it into another.
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.size() == 0) {
            while (in.size() > 0) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if (out.size() == 0) {
            while (in.size() > 0) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.size() == 0 && out.size() == 0;
    }
}