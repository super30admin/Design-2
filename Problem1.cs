// Time Complexity : O(n) ammortized time complexity
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintian two stacks - an in-stack which is solely used for pushing elements into the queue and an out-stack which is solely used for
removing elements from the queue. Every insert operation into the queue is performed by pushing the element to the in-stack.
Before performing any pop/peek operation, we check if out-stack is empty, if so then we transfer all the elements from in stack to out stack.
Every peek and pop operation is performed on the out stack.
*/

public class MyQueue
{
    Stack<int> inStack;
    Stack<int> outStack;

    public MyQueue()
    {
        inStack = new();
        outStack = new();
    }

    public void Push(int x)
    {
        inStack.Push(x);
    }

    public int Pop()
    {
        if (outStack.Count == 0)
        {
            Transfer();
        }

        return outStack.Pop();
    }

    public int Peek()
    {
        if (outStack.Count == 0)
        {
            Transfer();
        }

        return outStack.Peek();
    }

    public bool Empty()
    {
        return inStack.Count == 0 && outStack.Count == 0;
    }

    private void Transfer()
    {
        while (inStack.Count != 0)
        {
            outStack.Push(inStack.Pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Peek();
 * bool param_4 = obj.Empty();
 */