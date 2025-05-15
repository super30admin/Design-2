/*
  Time complexity: Push O(1); Pop O(1); Peek O(1)
  Space complexity: O(n) to store the elements being pushed into the stack

  Code ran successfully on Leetcode: Yes

  Approach: Two stack inStack and outStack are created. Since stack is LIFO and the queue to be implemented is FIFO, we always push into the inStack. Pop and Peek are done from the outStack. if outStack is empty all elements from inStack are moved to the outStack if inStack is not empty.


*/

public class MyQueue {
    private Stack<int> inStack = null,
                       outStack = null;
    
    public MyQueue() {
        inStack = new Stack<int>();
        outStack = new Stack<int>();
    }
    
    public void Push(int x) {
        inStack.Push(x);
    }
    
    public int Pop() {
        if (outStack.Count == 0) {
            while (inStack.Count > 0) {
                outStack.Push(inStack.Pop());
            }
        }
        return outStack.Pop();
    }
    
    public int Peek() {
        if (outStack.Count==0)
        {
            while(inStack.Count>0)
            {
                outStack.Push(inStack.Pop());
            }
        }
        return outStack.Peek();
    }

    public bool Empty()
    {
        return inStack.Count==0 && outStack.Count==0;
    }
}
