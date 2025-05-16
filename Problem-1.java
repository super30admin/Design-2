// Time Complexity - push, pop, peek, empty O(1) 
// Space complexity - O(1)
// Exceuted on leetcode- yes
// Problems faced during implementation - No

// To implement queue using stack, we are using 2 stacks, if we wanted to remove an element we are reversing the stack into other stack and removing top most element
// Hence using a helper "shiftStacks" method and reusing it.
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
        shiftStacks();
        return out.pop();
    }
    
    public int peek() {
        shiftStacks();
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void shiftStacks() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
