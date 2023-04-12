"""
LC 232: Implement stacks using queues
-Time Complexity : 
    push = O(1)
    pop = amortized O(1) 
    peek = amortized O(1) 
    empty = O(1)
-Space Complexity : 
    O(N) where N = number of elements in the queue
-Did this code successfully run on Leetcode : Yes
-Any problem you faced while coding this : No
-Your code here along with comments explaining your approach
1. Code in python
2. Datastructure used to implement queue = stack, DS used to act as stack = List
3. 2 stacks used named "in" and "out"
4. For push = simply append the element into "in" stack
5. For peek = It is always the top element of the "out" stack.
check if "out" stack is empty. If yes, then empty all contents of 
"in" into "out" and then return the top element of the "out" stack.
6. For pop = Perform the peek operation to avoid repeated code. Remove and return 
the top element of "out" stack.
7. Note -> Since it is mentioned in the question that peek and pop are performed 
when valid, so we don't check for the empty stack condition.
"""

class MyQueue:

    def __init__(self):
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        self.inStack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outStack.pop()

    def peek(self) -> int:
        if len(self.outStack) == 0:
            while len(self.inStack) > 0:
                elem = self.inStack.pop()
                self.outStack.append(elem)
        return self.outStack[-1]
        
    def empty(self) -> bool:
        return len(self.inStack) == 0 and len(self.outStack) == 0