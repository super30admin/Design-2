import java.util.Stack;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int val){
        if(min.isEmpty() || val < min.peek()){
            min.push(val);
        }
        stack.push(val);
    }

    public void pop(){
        if(stack.peek().equals(min.peek())){
            min.pop();
        }
        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
    }
}