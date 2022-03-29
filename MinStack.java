import java.util.*;

/*
    Implementation is done using Stack. 
    A variable min is used to keep track of minimum value whenever a number is 
    pushed into the stack.

    Time Complexity of push,pop,top,getMin = O(1)
    

*/
public class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        if(val<min)
        {
            min = val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty())
        {
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("The element "+stack.peek()+" is popped.");
            stack.pop();
        }
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String args[])
    {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.getMin());
        stack.pop();
    }
}
