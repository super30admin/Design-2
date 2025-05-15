// Time Complexity :  push ( O(1)) pop ((O(1))  peek ( O(1)) empty O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : syntax error
//Add numbers into stackIn. While performing pop or peek, check if stackOut is empty. If it is, then while stackIn is not empty, pop from stackIn and push into stackOut. After that, pop from stackOut for pop, or return the top of stackOut for peek. For empty, just check if both stacks are empty.
class MyQueue {
    private Stack<Integer>in;
    private Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out= new Stack<>();

    }

    public void push(int x) {
        in.push(x);

    }

    public int pop() {
        peek();
        return out.pop();

    }

    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();

    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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