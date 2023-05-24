import java.util.Stack;
// Time Complexity :
// push(): O(1) as we're pushing to the top of the stack
//pop(): O(1) amortized as we need to rebuild if the second stack becomes empty or a series of pop() calls happen and that will take O(n)
//peek(): O(1) as we're reading from the top of the stack
//empty(): O(1) as we're checking if the stack is empty
// Space Complexity : O(n): where n is total number of inputs possible as we're using an auxiliary array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class MyQueue
{
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    private int frontValue;

    public MyQueue()
    {
        pushStack = new Stack<>();
        popStack = new Stack<>();
        frontValue = -1;

    }

    public void push(int x)
    {
        if(popStack.empty() && pushStack.empty())
        {
            frontValue = x;
        }
        pushStack.push(x);
    }

    public int pop()
    {
        if(popStack.empty())
        {
            //if the popStack becomes empty rebuild from pushStack
            //pop from the pushStack and push to the popStack
            while(!pushStack.empty())
            {
                popStack.push(pushStack.pop());
            }
        }

        //pop
        int poppedValue = ! popStack.empty() ? popStack.pop() : -1;
        //rebuild again if empty
        if(popStack.empty())
        {
            while(!pushStack.empty())
            {
                popStack.push(pushStack.pop());
            }
        }

        frontValue = ! popStack.empty() ? popStack.peek() : -1;

        return poppedValue;
    }

    public int peek()
    {
        return frontValue;
    }

    public boolean empty()
    {
        return (pushStack.empty() && popStack.empty());
    }

    public static void main(String[] args)
    {
         MyQueue obj = new MyQueue();
         obj.push(1);
         obj.push(2);
         System.out.println(obj.peek());
         System.out.println(obj.pop());
         System.out.println(obj.peek());
         System.out.println(obj.pop());
         System.out.println(obj.empty());

    }
}
