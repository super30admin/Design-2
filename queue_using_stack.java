// We implement queue using two stacks. One is inStack - which  handles all insertions
// During pop(), if outStack is empty, we transfer all elements from inStack to outStack and pop the top element
// peek() similar to pop, we insert all elements to outStack if outStack is empty and then return the top element
// Time Complexity: Insertions - O(1) Pop() - only when stack is empty we insert,. worst case - push, pop, push pop - O(n) else, O(1)
// Space Complexity - O(n) - each element is stored only once. in either of the stacks

class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack();
        out = new Stack();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }

        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return (in.isEmpty() && out.isEmpty());
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
