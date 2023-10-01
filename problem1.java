//time complexity-O(1){in the case of pop its ammortized o(1)}
//space complexity-O(n)
//passed all the test cases on leetcode
//the approach is to use to stacks and make them work as a queue by poping data from one stack and inserting into another 
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
