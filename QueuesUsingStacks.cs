public class MyQueue
    {

        // Time Complexity : Push - O(1), Pop - O(1), Peek - O(1) and Empty - O(1)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        /* Approach
         * Use 2 stacks one for pushing incoming elements and one to pop from
         * Keep pushing elements to instack until we get a pop or a peek
         * once we get pop or peek, we then move all elements from instack to outstack and pop the top or peek the top
         * */

        Stack<int> inStack;
        Stack<int> outStack;


        public MyQueue()
        {
            inStack = new Stack<int>();
            outStack = new Stack<int>();
        }

        public void Push(int x)
        {
            inStack.Push(x);
        }

        public int Pop()
        {
            Peek();
            return outStack.Pop();
        }

        public int Peek()
        {
            if(outStack.Count == 0)
            {
                while(inStack.Count > 0)
                {
                    outStack.Push(inStack.Pop());
                }
            }
            return outStack.Peek();
        }

        public bool Empty()
        {
            return inStack.Count == 0 && outStack.Count == 0;
        }
    }
