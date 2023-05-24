// Time Complexity : O(1)

// Space Complexity : Amortized O(1)
    //Worst case : O(n). Average case : O(1)

// Did this code successfully run on Leetcode :
    //Yes. It beats 100% of all Java submissions in terms of Time Complexity and 46.87% of them in terms of Space Complexity

// Any problem you faced while coding this :
    //No

// Your code here along with comments explaining your approach
    //We maintain two stacks, stack1 for pushing, stack2 for popping and peeking. 
    //When numbers in stack1 are pushed into stack2, the order of their removal is reversed again.
    //We only transfer the numbers from one stack to another when it is needed, that is when stack2 is empty and we need to pop or peek the Queue.
    //To check if the Queue is empty, we just check if there are any elements left in any of the stacks.

class MyQueue {

    private MyStack stack1;
    private MyStack stack2;

    public MyQueue() {
        stack1 = new MyStack();
        stack2 = new MyStack();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if (stack2.isEmpty())
        {
            while(stack1.isEmpty()==false)
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {
        if (stack2.isEmpty())
        {
            while(stack1.isEmpty()==false)
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return (stack1.isEmpty()&&stack2.isEmpty());
    }
}

class MyStack
{
    StackNode head;

    MyStack()
    {
        head = null;
    }

    public void push(int val)
    {
        StackNode temp = new StackNode(val);
        temp.next = head;
        head = temp;
    }

    public int pop()
    {
        int x = head.val;
        head = head.next;
        return x;
    }

    public int peek()
    {
        return head.val;
    }

    public boolean isEmpty()
    {
        return head==null;
    }
}

class StackNode
{
    int val;
    StackNode next;

    StackNode(int val)
    {
        this.val = val;
        this.next = null;
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