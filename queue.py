# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We use two stacks: one (stack1) for incoming elements and another (stack2)
# to reverse order and simulate FIFO. Elements are only transferred from stack1 to stack2 when needed.

class MyQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []
        
    def push(self, x: int) -> None:
        self.stack1.append(x)
        

    def pop(self) -> int:
        if self.stack2:
            return self.stack2.pop()

        while self.stack1:
            self.stack2.append(self.stack1.pop())
        
        return self.stack2.pop()

    def peek(self) -> int:
        if self.stack2:
            return self.stack2[-1]

        while self.stack1:
            self.stack2.append(self.stack1.pop())
        
        return self.stack2[-1]
        

    def empty(self) -> bool:
        return self.stack1 == [] and self.stack2 == []
        
