import java.util.Stack;
// Time Complexity :
// push(): O(1) as we're pushing to the top of the stack
//pop(): O(1) as we're popping from the top of the stack
//peek(): O(1) as we're reading from the top of the stack
//empty(): O(1) again reading the top of the stack
// Space Complexity : O(n): where n is total number of inputs possible as we're using an auxiliary array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class MyQueue
{

    //this is created with an initial size of 10, which should suffice for our input range
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    private int[] previousElementMap;

    public MyQueue()
    {
        pushStack = new Stack<>();
        popStack = new Stack<>();  //we really only need one element in this stack
        previousElementMap = new int[10]; // for range 1 to 9; will be initialized with 0s

    }

    public void push(int x)
    {
        //this will only be empty
        if(popStack.empty())
        {
            //push on both the stacks
            pushStack.push(x);
            popStack.push(x);
            previousElementMap[x] = -1; // this is the only element in the queue and has no previous
        }
        else
        {
            int currentLastValue = pushStack.peek();
            previousElementMap[currentLastValue] = x;
            previousElementMap[x] = -1;
            pushStack.push(x);
        }
    }

    public int pop()
    {
        int firstElement = popStack.pop();
        //push the next element from the queue onto the
        if(previousElementMap[firstElement] != -1)
        {
            popStack.push(previousElementMap[firstElement]);
        }

        return firstElement;
    }

    public int peek()
    {
        return popStack.peek();
    }

    public boolean empty()
    {
        return popStack.empty();
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
