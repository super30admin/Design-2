'''
1. First, we need to create two stacks, stack1 and stack2. Our queue is stack1
2. To push an element into the queue, move all the elements of stack1 into stack2, insert the element into stack1, and then move all the elements of stack2 back into stack1
3. To pop an element from the queue, simply pop the top element from stack1. Peek is similar to pop, but we don't pop the element from stack1
'''
# Time Complexity : O(N) for push, O(1) for pop, O(1) for peek
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def empty(self) -> bool:
        return len(self.stack1)==0
    
    def push(self, x: int) -> None:
        while(len(self.stack1)>0):
            self.stack2.append(self.stack1.pop())
        self.stack1.append(x)
        while(len(self.stack2)>0):
            self.stack1.append(self.stack2.pop())

    def pop(self) -> int:
        return self.stack1.pop()

    def peek(self) -> int:
        return self.stack1[-1]